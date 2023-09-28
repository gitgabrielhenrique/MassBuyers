package br.com.MassBuyers.MassBuyers.repository.fornecedor;

import br.com.MassBuyers.MassBuyers.filter.Cidadefilter;
import br.com.MassBuyers.MassBuyers.filter.Fornecedorfilter;
import br.com.MassBuyers.MassBuyers.model.Cidade;
import br.com.MassBuyers.MassBuyers.model.Fornecedor;
import br.com.MassBuyers.MassBuyers.repository.projections.CidadeDto;
import br.com.MassBuyers.MassBuyers.repository.projections.FornecedorDto;
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

public class FornecedorRepositoryImpl {


  @Autowired
  private EntityManager manager;

  @Override
  public Page<FornecedorDto> Filtrar(Fornecedorfilter fornecedorfilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<FornecedorDto> criteria = builder.createQuery(FornecedorDto.class);
    Root<Fornecedor> root = criteria.from(Fornecedor.class);

    criteria.select(builder.construct(FornecedorDto.class,
      root.get("id"),
      root.get("nome"),
      root.get("descricao"),
      root.get("nomecidade"),
      root.get("cidade").get("estado").get("nome"),
      root.get("cnpj"),
      root.get("email"),
      root.get("senha")
    ));

    Predicate[] predicates = criarRestricoes(builder, fornecedorfilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomefornecedor")));

    TypedQuery<FornecedorDto> query = manager.createQuery(criteria);
    adicionarRestricoesDaPaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(),pageable, total(fornecedorfilter));
  }
  private void adicionarRestricoesDaPaginacao(TypedQuery<?> query, Pageable pageable)
  {
    int paginaatual = pageable.getPageNumber();
    int totalRegistroPorPagina = pageable.getPageSize();
    int primeiroRegistroDaPagina = paginaatual * totalRegistroPorPagina;

    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalRegistroPorPagina);
  }
  private Long total(Fornecedorfilter fornecedorfilter)
  {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Fornecedor> root = criteria.from(Fornecedor.class);

    Predicate[] predicates = criarRestricoes(builder, fornecedorfilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomefornecedor")));
    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }

  private Predicate[] criarRestricoes(CriteriaBuilder builder, Fornecedorfilter fornecedorfilter, Root<Fornecedor> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(fornecedorfilter.getNomefornecedor()))
    {
      predicates.add(builder.like(builder.lower(root.get("nomefornecedor")),
        "%" + fornecedorfilter.getNomefornecedor().toLowerCase() + "%"
      ));
    }

    if (!StringUtils.isEmpty(fornecedorfilter.getNomecidade()))
    {
      predicates.add(builder.like(builder.lower(root.get("cidade").get("nomecidade")),
        "%" + fornecedorfilter.getNomecidade().toLowerCase() + "%"
      ));
    }
    if (!StringUtils.isEmpty(fornecedorfilter.getNomeestado()))
    {
      predicates.add(builder.like(builder.lower(root.get("cidade").get("estado").get("nome")),
        "%" + fornecedorfilter.getNomefornecedor().toLowerCase() + "%"
      ));
    }
    if (!StringUtils.isEmpty(fornecedorfilter.getDescricao()))
    {
      predicates.add(builder.like(builder.lower(root.get("descricao")),
        "%" + fornecedorfilter.getDescricao().toLowerCase() + "%"
      ));
    }
    if ((fornecedorfilter.getCnpj()!=null))
    {
      //continuar aqui
      predicates.add(builder.like(builder.greaterThanOrEqualTo(root.get("cnpj")),
        "%" + fornecedorfilter.getDescricao().toLowerCase() + "%"
      ));
    }


    return predicates.toArray(new Predicate[predicates.size()]);

  }

}
