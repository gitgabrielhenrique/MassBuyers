package br.com.MassBuyers.MassBuyers.service;

import br.com.MassBuyers.MassBuyers.model.Cliente;
import br.com.MassBuyers.MassBuyers.model.Estado;
import br.com.MassBuyers.MassBuyers.repository.ClienteRepository;
import br.com.MassBuyers.MassBuyers.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EstadoService {


  @Autowired
  private EstadoRepository estadoRepository;

  public Estado salvar(Estado estado){
    return estadoRepository.save(estado);


  }
  public Estado atualizar(Long id,Estado estado){
    Estado estadosalvo = buscarestadoexistente(id);
    return estadoRepository.save(estadosalvo);
  }

  private Estado buscarestadoexistente(Long id) {
    Optional<Estado> estadosalvo=estadoRepository.findById(id);
    if(!estadosalvo.isPresent()){
      throw new IllegalArgumentException();
    }
    return estadosalvo.get();
  }


}
