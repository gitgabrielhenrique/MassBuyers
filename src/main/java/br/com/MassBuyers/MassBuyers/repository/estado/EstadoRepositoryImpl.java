package br.com.MassBuyers.MassBuyers.repository.estado;

import br.com.MassBuyers.MassBuyers.filter.Estadofilter;
import br.com.MassBuyers.MassBuyers.model.Estado;

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

public class EstadoRepositoryImpl implements EstadoRepositoryQuery{





  @Autowired
  private EntityManager manager;

  @Override
  public Page<Estado> Filtrar(Estadofilter estadofilter, Pageable pageable) {

    CriteriaBuilder builder = manager.getCriteriaBuilder();

    CriteriaQuery<Estado> criteria = builder.createQuery(Estado.class);
    Root<Estado> root = criteria.from(Estado.class);

    Predicate[] predicates = criarRestricoes(estadofilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));

    TypedQuery<Estado> query= manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query,pageable);
    return new PageImpl<>(query.getResultList(),pageable,total(estadofilter));
  }

  private Long total(Estadofilter estadofilter) {

    CriteriaBuilder builder = manager.getCriteriaBuilder();

    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Estado> root = criteria.from(Estado.class);

    Predicate[] predicates = criarRestricoes(estadofilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));
    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<Estado> query, Pageable pageable) {

    int paginaAtual=pageable.getPageNumber();
    int totalDeregistrosPorPagina=pageable.getPageSize();
    int primeiroRegistroDaPagina=paginaAtual*totalDeregistrosPorPagina;
    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalDeregistrosPorPagina);
  }

  private Predicate[] criarRestricoes(Estadofilter estadofilter, CriteriaBuilder builder, Root<Estado> root) {

    List<Predicate> predicates = new ArrayList<>();
    if (!StringUtils.isAllEmpty(estadofilter.getNome())) {

      predicates.add(builder.like(builder.lower(root.get("nome")),
        "%"+ estadofilter.getNome().toLowerCase()+"%"));
    }
    return  predicates.toArray(new Predicate[predicates.size()]);
  }


}
