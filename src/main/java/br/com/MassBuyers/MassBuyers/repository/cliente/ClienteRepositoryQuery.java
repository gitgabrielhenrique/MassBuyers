package br.com.MassBuyers.MassBuyers.repository.cliente;

import br.com.MassBuyers.MassBuyers.filter.Clientefilter;
import br.com.MassBuyers.MassBuyers.filter.Fornecedorfilter;
import br.com.MassBuyers.MassBuyers.repository.projections.ClienteDto;
import br.com.MassBuyers.MassBuyers.repository.projections.FornecedorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
  public Page<ClienteDto> Filtrar(Clientefilter clientefilter, Pageable pageable);
}
