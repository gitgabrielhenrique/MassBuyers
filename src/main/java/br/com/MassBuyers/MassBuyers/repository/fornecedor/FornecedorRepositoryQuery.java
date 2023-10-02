package br.com.MassBuyers.MassBuyers.repository.fornecedor;



import br.com.MassBuyers.MassBuyers.filter.Fornecedorfilter;
import br.com.MassBuyers.MassBuyers.repository.projections.FornecedorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FornecedorRepositoryQuery {
  public Page<FornecedorDto> Filtrar(Fornecedorfilter fornecedorfilter, Pageable pageable);
}

