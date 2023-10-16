package br.com.MassBuyers.MassBuyers.repository.cliente;

import br.com.MassBuyers.MassBuyers.filter.Clientefilter;
import br.com.MassBuyers.MassBuyers.filter.Fornecedorfilter;
import br.com.MassBuyers.MassBuyers.model.Cliente;
import br.com.MassBuyers.MassBuyers.model.Fornecedor;
import br.com.MassBuyers.MassBuyers.repository.projections.ClienteDto;
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

public class ClienteRepositoryImpl implements  ClienteRepositoryQuery {


  @Autowired
  private EntityManager manager;

  @Override
  public Page<ClienteDto> Filtrar(Clientefilter clientefilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<ClienteDto> criteria = builder.createQuery(ClienteDto.class);
    Root<Cliente> root = criteria.from(Cliente.class);

    criteria.select(builder.construct(ClienteDto.class,
      root.get("id"),
      root.get("nome"),
      root.get("nascimento"),
      root.get("email"),
      root.get("senha"),
      root.get("telefone"),
      root.get("cidade").get("nomecidade"),
      root.get("cidade").get("estado").get("nome")
    ));

    Predicate[] predicates = criarRestricoes(builder, clientefilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));

    TypedQuery<ClienteDto> query = manager.createQuery(criteria);
    adicionarRestricoesDaPaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, total(clientefilter));
  }

  private void adicionarRestricoesDaPaginacao(TypedQuery<?> query, Pageable pageable) {
    int paginaatual = pageable.getPageNumber();
    int totalRegistroPorPagina = pageable.getPageSize();
    int primeiroRegistroDaPagina = paginaatual * totalRegistroPorPagina;

    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalRegistroPorPagina);
  }

  private Long total(Clientefilter clientefilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Cliente> root = criteria.from(Cliente.class);

    Predicate[] predicates = criarRestricoes(builder, clientefilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));
    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }

  private Predicate[] criarRestricoes(CriteriaBuilder builder, Clientefilter clientefilter, Root<Cliente> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(clientefilter.getNome())) {
      predicates.add(builder.like(builder.lower(root.get("nome")),
        "%" + clientefilter.getNome().toLowerCase() + "%"
      ));
    }

    if (!StringUtils.isEmpty(clientefilter.getNomecidade())) {
      predicates.add(builder.like(builder.lower(root.get("cidade").get("nomecidade")),
        "%" + clientefilter.getNomecidade().toLowerCase() + "%"
      ));
    }
    if (!StringUtils.isEmpty(clientefilter.getNomeestado())) {
      predicates.add(builder.like(builder.lower(root.get("cidade").get("estado").get("nome")),
        "%" + clientefilter.getNomeestado().toLowerCase() + "%"
      ));
    }

    if ((clientefilter.getTelefone() != null)) {

      predicates.add(builder.greaterThanOrEqualTo(root.get("telefone"),
        clientefilter.getTelefone()
      ));
    }
    if ((clientefilter.getDatanascimento() != null)) {

      predicates.add(builder.greaterThanOrEqualTo(root.get("nascimento"),
        clientefilter.getDatanascimento()
      ));
    }
    if (!StringUtils.isEmpty(clientefilter.getEmail())) {
      predicates.add(builder.like(builder.lower(root.get("email")),
        "%" + clientefilter.getEmail().toLowerCase() + "%"
      ));
    }
    if (!StringUtils.isEmpty(clientefilter.getSenha())) {
      predicates.add(builder.like(builder.lower(root.get("senha")),
        "%" + clientefilter.getSenha().toLowerCase() + "%"
      ));
    }


    return predicates.toArray(new Predicate[predicates.size()]);

  }
}
