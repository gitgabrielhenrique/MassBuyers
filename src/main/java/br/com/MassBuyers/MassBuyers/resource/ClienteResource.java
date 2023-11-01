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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long id){clienteRepository.deleteById(id);}



  @PutMapping("/mudar-cliente/{id}")
  public HttpStatus mudarciade(@PathVariable Long id, @RequestBody Cliente clienteRequest){
    return  clienteRepository.findById(id).map(
      cliente -> {
        cliente.setNome(clienteRequest.getNome());
        cliente.setEmail(clienteRequest.getEmail());
        cliente.setNascimento(clienteRequest.getNascimento());
        cliente.setSenha(clienteRequest.getSenha());
        cliente.setTelefone(clienteRequest.getTelefone());
        cliente.setCidade(clienteRequest.getCidade());





        clienteRepository.save(cliente);
        return  HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });


  }




  @PostMapping()
  public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente){

    return new ResponseEntity<>(clienteRepository.save(cliente),HttpStatus.CREATED);

  }



}
