package br.com.MassBuyers.MassBuyers.repository.produto;

import br.com.MassBuyers.MassBuyers.filter.Clientefilter;
import br.com.MassBuyers.MassBuyers.filter.Produtofilter;
import br.com.MassBuyers.MassBuyers.model.Cliente;
import br.com.MassBuyers.MassBuyers.model.Produto;
import br.com.MassBuyers.MassBuyers.repository.projections.ClienteDto;
import br.com.MassBuyers.MassBuyers.repository.projections.ProdutoDto;
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

public class ProdutoRepositoryImpl implements  ProdutoRepositoryQuery {


  @Autowired
  private EntityManager manager;

  @Override
  public Page<ProdutoDto> Filtrar(Produtofilter produtofilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<ProdutoDto> criteria = builder.createQuery(ProdutoDto.class);
    Root<Produto> root = criteria.from(Produto.class);

    criteria.select(builder.construct(ProdutoDto.class,
      root.get("id"),
      root.get("nome"),
      root.get("precovenda"),
      root.get("precorevenda"),
      root.get("quantidade"),
      root.get("fornecedor").get("nome"),
      root.get("subtipoprod").get("nome")

    ));

    Predicate[] predicates = criarRestricoes(builder, produtofilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));

    TypedQuery<ProdutoDto> query = manager.createQuery(criteria);
    adicionarRestricoesDaPaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, total(produtofilter));
  }

  private void adicionarRestricoesDaPaginacao(TypedQuery<?> query, Pageable pageable) {
    int paginaatual = pageable.getPageNumber();
    int totalRegistroPorPagina = pageable.getPageSize();
    int primeiroRegistroDaPagina = paginaatual * totalRegistroPorPagina;

    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalRegistroPorPagina);
  }

  private Long total(Produtofilter produtofilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Produto> root = criteria.from(Produto.class);

    Predicate[] predicates = criarRestricoes(builder, produtofilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));
    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }

  private Predicate[] criarRestricoes(CriteriaBuilder builder, Produtofilter produtofilter, Root<Produto> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(produtofilter.getNome())) {
      predicates.add(builder.like(builder.lower(root.get("nome")),
        "%" + produtofilter.getNome().toLowerCase() + "%"
      ));
    }

    if ((produtofilter.getPrecovenda() != null)) {

      predicates.add(builder.greaterThanOrEqualTo(root.get("precovenda"),
        produtofilter.getPrecovenda()
      ));
    }
    if ((produtofilter.getPrecorevenda() != null)) {

      predicates.add(builder.greaterThanOrEqualTo(root.get("precorevenda"),
        produtofilter.getPrecorevenda()
      ));
    }

    if ((produtofilter.getQuantidade() != null)) {

      predicates.add(builder.greaterThanOrEqualTo(root.get("quantidade"),
        produtofilter.getQuantidade()
      ));
    }

    if (!StringUtils.isEmpty(produtofilter.getNomefornecedor())) {
      predicates.add(builder.like(builder.lower(root.get("fornecedor").get("nome")),
        "%" + produtofilter.getNomefornecedor().toLowerCase() + "%"
      ));
    }


    if (!StringUtils.isEmpty(produtofilter.getSubtipoprod())) {
      predicates.add(builder.like(builder.lower(root.get("subtipoprod").get("nome")),
        "%" + produtofilter.getSubtipoprod().toLowerCase() + "%"
      ));
    }


    return predicates.toArray(new Predicate[predicates.size()]);


  }
}
