package br.com.MassBuyers.MassBuyers.resource;


import br.com.MassBuyers.MassBuyers.filter.Cidadefilter;
import br.com.MassBuyers.MassBuyers.model.Cidade;
import br.com.MassBuyers.MassBuyers.repository.CidadeRepository;
import br.com.MassBuyers.MassBuyers.repository.projections.CidadeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

  @Autowired
  private CidadeRepository cidadeRepository;

  @GetMapping("/todos")
  public List<Cidade> ListarTodasAsCidades(){
return cidadeRepository.findAll();
  }
  @GetMapping()
  public Page<CidadeDto> pesquisar(Cidadefilter cidadefilter, Pageable pageable){
    return  cidadeRepository.Filtrar(cidadefilter,pageable);
  }
}
