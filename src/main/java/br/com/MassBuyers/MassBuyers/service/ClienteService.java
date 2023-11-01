package br.com.MassBuyers.MassBuyers.service;

import br.com.MassBuyers.MassBuyers.model.Cidade;
import br.com.MassBuyers.MassBuyers.model.Cliente;
import br.com.MassBuyers.MassBuyers.repository.CidadeRepository;
import br.com.MassBuyers.MassBuyers.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  public Cliente salvar(Cliente cliente){
    return clienteRepository.save(cliente);


  }
  public Cliente atualizar(Long id,Cliente cliente){
    Cliente clientesalvo = busclienteexistente(id);
    return clienteRepository.save(clientesalvo);
  }

  private Cliente busclienteexistente(Long id) {
    Optional<Cliente> clientesalvo=clienteRepository.findById(id);
    if(!clientesalvo.isPresent()){
      throw new IllegalArgumentException();
    }
    return clientesalvo.get();
  }



}
