package br.com.MassBuyers.MassBuyers.resource;


import br.com.MassBuyers.MassBuyers.filter.Subtipofilter;
import br.com.MassBuyers.MassBuyers.model.Produto;
import br.com.MassBuyers.MassBuyers.model.Subtipoprod;
import br.com.MassBuyers.MassBuyers.repository.ProdutoRepository;
import br.com.MassBuyers.MassBuyers.repository.SubtipoprodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subtipos")
public class SubtipoprodResource {


  @Autowired
  private SubtipoprodRepository subtipoprodRepository;

  @GetMapping()
  public Page<Subtipoprod> pesquisar(Subtipofilter subtipofilter, Pageable pageable){
    return subtipoprodRepository.Filtrar(subtipofilter,pageable);
  }

  @GetMapping("/todos")
  public List<Subtipoprod> ListarTodosSubtipos(){
    return subtipoprodRepository.findAll();
  }
}
