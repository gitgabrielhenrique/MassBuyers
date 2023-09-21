package br.com.MassBuyers.MassBuyers.repository.cidade;

import br.com.MassBuyers.MassBuyers.filter.Cidadefilter;
import br.com.MassBuyers.MassBuyers.repository.projections.CidadeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CidadeRepositoryQuery  {
  public Page<CidadeDto> Filtrar(Cidadefilter cidadefilter, Pageable pageable);
}
