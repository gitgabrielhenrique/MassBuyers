package br.com.MassBuyers.MassBuyers.repository.cidade;

import br.com.MassBuyers.MassBuyers.filter.Cidadefilter;
import br.com.MassBuyers.MassBuyers.model.Cidade;
import br.com.MassBuyers.MassBuyers.repository.projections.CidadeDto;
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

public class CidadeRepositoryImpl implements CidadeRepositoryQuery {

  @Autowired
  private EntityManager manager;

  @Override
  public Page<CidadeDto> Filtrar(Cidadefilter cidadefilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<CidadeDto> criteria = builder.createQuery(CidadeDto.class);
    Root<Cidade> root = criteria.from(Cidade.class);

    criteria.select(builder.construct(CidadeDto.class,
      root.get("id")
      ,root.get("nomecidade")
      ,root.get("estado").get("nome")
    ));

    Predicate[] predicates = criarRestricoes(builder, cidadefilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomecidade")));

    TypedQuery<CidadeDto> query = manager.createQuery(criteria);
    adicionarRestricoesDaPaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(),pageable, total(cidadefilter));
  }
  private void adicionarRestricoesDaPaginacao(TypedQuery<?> query, Pageable pageable)
  {
    int paginaatual = pageable.getPageNumber();
    int totalRegistroPorPagina = pageable.getPageSize();
    int primeiroRegistroDaPagina = paginaatual * totalRegistroPorPagina;

    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalRegistroPorPagina);
  }
  private Long total(Cidadefilter cidadefilter)
  {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Cidade> root = criteria.from(Cidade.class);

    Predicate[] predicates = criarRestricoes(builder, cidadefilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomecidade")));
    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }

  private Predicate[] criarRestricoes(CriteriaBuilder builder, Cidadefilter cidadefilter, Root<Cidade> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(cidadefilter.getNomecidade()))
    {
      predicates.add(builder.like(builder.lower(root.get("nomecidade")),
        "%" + cidadefilter.getNomecidade().toLowerCase() + "%"
      ));
    }

    if (!StringUtils.isEmpty(cidadefilter.getNomecidade()))
    {
      predicates.add(builder.like(builder.lower(root.get("estado").get("nome")),
        "%" + cidadefilter.getNomecidade().toLowerCase() + "%"
      ));
    }


    return predicates.toArray(new Predicate[predicates.size()]);

  }
}
