package br.com.MassBuyers.MassBuyers.service;

import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import br.com.MassBuyers.MassBuyers.model.Venda;
import br.com.MassBuyers.MassBuyers.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class VendaService {
  @Autowired
  VendaRepository vendaRepository;


  public Venda salvar(Venda venda){
    return vendaRepository.save(venda);


  }
  public Venda atualizar(Long id,Venda venda){
    Venda vendasalvo = buscarvenda(id);
    return vendaRepository.save(venda);
  }

  private Venda buscarvenda(Long id) {
    Optional<Venda> vendasalva=vendaRepository.findById(id);
    if(!vendasalva.isPresent()){
      throw new IllegalArgumentException();
    }
    return vendasalva.get();
  }

}
