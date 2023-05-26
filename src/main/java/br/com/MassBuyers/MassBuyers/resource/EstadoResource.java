package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.model.Cliente;
import br.com.MassBuyers.MassBuyers.model.Estado;
import br.com.MassBuyers.MassBuyers.repository.ClienteRepository;
import br.com.MassBuyers.MassBuyers.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoResource {


  @Autowired
  private EstadoRepository estadoRepository;


  @GetMapping("/todos")
  public List<Estado> ListarTodosEstados(){
    return estadoRepository.findAll();
  }
}
