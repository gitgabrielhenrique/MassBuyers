package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.model.Subtipoprod;
import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import br.com.MassBuyers.MassBuyers.repository.SubtipoprodRepository;
import br.com.MassBuyers.MassBuyers.repository.TipoprodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoprodResource {


  @Autowired
  private TipoprodRepository tipoprodRepository;


  @GetMapping("/todos")
  public List<Tipoprod> ListarTodostipos(){
    return tipoprodRepository.findAll();
  }
}
