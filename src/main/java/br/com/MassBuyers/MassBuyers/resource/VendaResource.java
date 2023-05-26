package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import br.com.MassBuyers.MassBuyers.model.Venda;
import br.com.MassBuyers.MassBuyers.repository.TipoprodRepository;
import br.com.MassBuyers.MassBuyers.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaResource {



  @Autowired
  private VendaRepository vendaRepository;


  @GetMapping("/todos")
  public List<Venda> ListarTodasVendas(){
    return vendaRepository.findAll();
  }
}
