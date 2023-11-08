package br.com.MassBuyers.MassBuyers.service;

import br.com.MassBuyers.MassBuyers.model.Subtipoprod;
import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import br.com.MassBuyers.MassBuyers.repository.TipoprodRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TipoService {
  @Autowired
  TipoprodRepository tipoprodRepository;

  public Tipoprod salvar(Tipoprod tipoprod){
    return tipoprodRepository.save(tipoprod);


  }
  public Tipoprod atualizar(Long id,Tipoprod tipoprod){
    Tipoprod subtiposalvo = buscartipo(id);
    return tipoprodRepository.save(tipoprod);
  }

  private Tipoprod buscartipo(Long id) {
    Optional<Tipoprod> tiposalvo=tipoprodRepository.findById(id);
    if(!tiposalvo.isPresent()){
      throw new IllegalArgumentException();
    }
    return tiposalvo.get();
  }


}
