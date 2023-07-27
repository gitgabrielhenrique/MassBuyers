package br.com.MassBuyers.MassBuyers.repository.tipoprod;

import br.com.MassBuyers.MassBuyers.filter.Tipoprodfilter;
import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TipoprodRepositoryImpl implements TipoprodRepositoryQuery {


  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Tipoprod> Filtrar(Tipoprodfilter tipoprodfilter, Pageable pageable) {

    CriteriaBuilder builder = manager.getCriteriaBuilder();

    CriteriaQuery<Tipoprod> criteria = builder.createQuery(Tipoprod.class);
    Root<Tipoprod> root = criteria.from(Tipoprod.class);

    Predicate[] predicates = criarRestricoes(tipoprodfilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));

    TypedQuery<Tipoprod> query= manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query,pageable);
    return new PageImpl<>(query.getResultList(),pageable,total(tipoprodfilter));
  }

  private Long total(Tipoprodfilter tipoprodfilter) {

    CriteriaBuilder builder = manager.getCriteriaBuilder();

    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Tipoprod> root = criteria.from(Tipoprod.class);

    Predicate[] predicates = criarRestricoes(tipoprodfilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));
    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<Tipoprod> query, Pageable pageable) {

    int paginaAtual=pageable.getPageNumber();
    int totalDeregistrosPorPagina=pageable.getPageSize();
    int primeiroRegistroDaPagina=paginaAtual*totalDeregistrosPorPagina;
    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalDeregistrosPorPagina);
  }

  private Predicate[] criarRestricoes(Tipoprodfilter tipoprodfilter, CriteriaBuilder builder, Root<Tipoprod> root) {

    List<Predicate> predicates = new ArrayList<>();
    if (!StringUtils.isAllEmpty(tipoprodfilter.getNome())) {

      predicates.add(builder.like(builder.lower(root.get("nome")),
        "%"+ tipoprodfilter.getNome().toLowerCase()+"%"));
    }
    return  predicates.toArray(new Predicate[predicates.size()]);
  }


}
