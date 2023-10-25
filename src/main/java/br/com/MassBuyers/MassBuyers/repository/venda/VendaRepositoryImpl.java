package br.com.MassBuyers.MassBuyers.repository.venda;

import br.com.MassBuyers.MassBuyers.filter.Clientefilter;
import br.com.MassBuyers.MassBuyers.filter.Vendafilter;
import br.com.MassBuyers.MassBuyers.model.Cliente;
import br.com.MassBuyers.MassBuyers.model.Venda;
import br.com.MassBuyers.MassBuyers.repository.projections.ClienteDto;
import br.com.MassBuyers.MassBuyers.repository.projections.VendaDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class VendaRepositoryImpl implements VendaRepositoryQuery {

  @Autowired
  private EntityManager manager;

  @Override
  public Page<VendaDto> Filtrar(Vendafilter vendafilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<VendaDto> criteria = builder.createQuery(VendaDto.class);
    Root<Venda> root = criteria.from(Venda.class);

    criteria.select(builder.construct(VendaDto.class,
      root.get("id"),
      root.get("datavenda"),
      root.get("fornecedor").get("nome"),
      root.get("cliente").get("nome"),
      root.get("produto").get("nome")
    ));

    Predicate[] predicates = criarRestricoes(builder, vendafilter, root);
    criteria.where(predicates);


    TypedQuery<VendaDto> query = manager.createQuery(criteria);
    adicionarRestricoesDaPaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, total(vendafilter));
  }

  private void adicionarRestricoesDaPaginacao(TypedQuery<?> query, Pageable pageable) {
    int paginaatual = pageable.getPageNumber();
    int totalRegistroPorPagina = pageable.getPageSize();
    int primeiroRegistroDaPagina = paginaatual * totalRegistroPorPagina;

    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalRegistroPorPagina);
  }

  private Long total(Vendafilter vendafilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Venda> root = criteria.from(Venda.class);

   Predicate[] predicates = criarRestricoes(builder, vendafilter, root);
    criteria.where(predicates);

    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }

  private Predicate[] criarRestricoes(CriteriaBuilder builder, Vendafilter vendafilter, Root<Venda> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (vendafilter.getDatavenda() != null) {

      predicates.add(builder.greaterThanOrEqualTo(root.get("datavenda"),
        vendafilter.getDatavenda()
      ));
    }

    if (!StringUtils.isEmpty(vendafilter.getNomefornecedor())) {
      predicates.add(builder.like(builder.lower(root.get("fornecedor").get("nome")),
        "%" + vendafilter.getNomefornecedor().toLowerCase() + "%"
      ));
    }
    if (!StringUtils.isEmpty(vendafilter.getNomecliente())) {
      predicates.add(builder.like(builder.lower(root.get("cliente").get("nome")),
        "%" + vendafilter.getNomecliente().toLowerCase() + "%"
      ));
    }

    if (!StringUtils.isEmpty(vendafilter.getNomeproduto())) {
      predicates.add(builder.like(builder.lower(root.get("produto").get("nome")),
        "%" + vendafilter.getNomeproduto().toLowerCase() + "%"
      ));
    }

    return predicates.toArray(new Predicate[predicates.size()]);

  }
}
