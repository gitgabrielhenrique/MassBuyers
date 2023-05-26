package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.model.Cidade;
import br.com.MassBuyers.MassBuyers.model.Cliente;
import br.com.MassBuyers.MassBuyers.repository.CidadeRepository;
import br.com.MassBuyers.MassBuyers.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

  @Autowired
  private ClienteRepository clienteRepository;


  @GetMapping("/todos")
public List<Cliente> ListarTodosClientes(){
    return clienteRepository.findAll();
  }

}
