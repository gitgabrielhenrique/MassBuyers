package br.com.MassBuyers.MassBuyers.repository.estado;


import br.com.MassBuyers.MassBuyers.filter.Estadofilter;
import br.com.MassBuyers.MassBuyers.model.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstadoRepositoryQuery {
  public Page<Estado> Filtrar(Estadofilter estadofilter, Pageable pageable);
}
