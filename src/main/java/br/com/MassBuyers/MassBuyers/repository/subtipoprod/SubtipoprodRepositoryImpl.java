package br.com.MassBuyers.MassBuyers.repository.subtipoprod;

import br.com.MassBuyers.MassBuyers.filter.Subtipofilter;
import br.com.MassBuyers.MassBuyers.filter.Tipoprodfilter;
import br.com.MassBuyers.MassBuyers.model.Subtipoprod;
import br.com.MassBuyers.MassBuyers.model.Tipoprod;
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

public class SubtipoprodRepositoryImpl implements SubtipoprodRepositoryQuery {


  @Autowired
  private EntityManager manager;

  @Override
  public Page<Subtipoprod> Filtrar(Subtipofilter subtipofilter, Pageable pageable) {

    CriteriaBuilder builder = manager.getCriteriaBuilder();

    CriteriaQuery<Subtipoprod> criteria = builder.createQuery(Subtipoprod.class);
    Root<Subtipoprod> root = criteria.from(Subtipoprod.class);

    Predicate[] predicates = criarRestricoes(subtipofilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));

    TypedQuery<Subtipoprod> query= manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query,pageable);
    return new PageImpl<>(query.getResultList(),pageable,total(subtipofilter));
  }

  private Long total(Subtipofilter subtipofilter) {

    CriteriaBuilder builder = manager.getCriteriaBuilder();

    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Subtipoprod> root = criteria.from(Subtipoprod.class);

    Predicate[] predicates = criarRestricoes(subtipofilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));
    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<Subtipoprod> query, Pageable pageable) {

    int paginaAtual=pageable.getPageNumber();
    int totalDeregistrosPorPagina=pageable.getPageSize();
    int primeiroRegistroDaPagina=paginaAtual*totalDeregistrosPorPagina;
    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalDeregistrosPorPagina);
  }

  private Predicate[] criarRestricoes(Subtipofilter subtipofilter, CriteriaBuilder builder, Root<Subtipoprod> root) {

    List<Predicate> predicates = new ArrayList<>();
    if (!StringUtils.isAllEmpty(subtipofilter.getNome())) {

      predicates.add(builder.like(builder.lower(root.get("nome")),
        "%"+ subtipofilter.getNome().toLowerCase()+"%"));
    }
    return  predicates.toArray(new Predicate[predicates.size()]);
  }

}
