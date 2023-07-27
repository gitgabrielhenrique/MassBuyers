package br.com.MassBuyers.MassBuyers.repository.tipoprod;

import br.com.MassBuyers.MassBuyers.filter.Tipoprodfilter;
import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TipoprodRepositoryQuery {
  public Page<Tipoprod> Filtrar(Tipoprodfilter tipoprodfilter, Pageable pageable);
}
