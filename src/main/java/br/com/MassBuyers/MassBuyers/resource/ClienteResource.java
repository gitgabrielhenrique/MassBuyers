package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.filter.Clientefilter;
import br.com.MassBuyers.MassBuyers.filter.Fornecedorfilter;
import br.com.MassBuyers.MassBuyers.model.Cidade;
import br.com.MassBuyers.MassBuyers.model.Cliente;
import br.com.MassBuyers.MassBuyers.repository.CidadeRepository;
import br.com.MassBuyers.MassBuyers.repository.ClienteRepository;
import br.com.MassBuyers.MassBuyers.repository.projections.ClienteDto;
import br.com.MassBuyers.MassBuyers.repository.projections.FornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  @GetMapping()
  public Page<ClienteDto> pesquisar(Clientefilter clientefilter, Pageable pageable){
    return  clienteRepository.Filtrar(clientefilter,pageable);
  }
}
