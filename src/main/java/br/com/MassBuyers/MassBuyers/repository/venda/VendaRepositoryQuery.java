package br.com.MassBuyers.MassBuyers.repository.venda;

import br.com.MassBuyers.MassBuyers.filter.Produtofilter;
import br.com.MassBuyers.MassBuyers.filter.Vendafilter;
import br.com.MassBuyers.MassBuyers.repository.projections.ProdutoDto;
import br.com.MassBuyers.MassBuyers.repository.projections.VendaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VendaRepositoryQuery {
  public Page<VendaDto> Filtrar(Vendafilter vendafilter, Pageable pageable);
}
