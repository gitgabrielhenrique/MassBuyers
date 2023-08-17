package br.com.MassBuyers.MassBuyers.repository.subtipoprod;


import br.com.MassBuyers.MassBuyers.filter.Subtipofilter;
import br.com.MassBuyers.MassBuyers.model.Subtipoprod;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubtipoprodRepositoryQuery {
  public Page<Subtipoprod> Filtrar(Subtipofilter subtipofilter, Pageable pageable);
}
