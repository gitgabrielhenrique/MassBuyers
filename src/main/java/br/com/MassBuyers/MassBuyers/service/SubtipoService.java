package br.com.MassBuyers.MassBuyers.service;

import br.com.MassBuyers.MassBuyers.model.Produto;
import br.com.MassBuyers.MassBuyers.model.Subtipoprod;
import br.com.MassBuyers.MassBuyers.repository.ProdutoRepository;
import br.com.MassBuyers.MassBuyers.repository.SubtipoprodRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SubtipoService {

  @Autowired
  private SubtipoprodRepository subtipoprodRepository;

  public Subtipoprod salvar(Subtipoprod subtipoprod){
    return subtipoprodRepository.save(subtipoprod);


  }
  public Subtipoprod atualizar(Long id,Subtipoprod subtipoprod){
    Subtipoprod subtiposalvo = buscarsubtipo(id);
    return subtipoprodRepository.save(subtipoprod);
  }

  private Subtipoprod buscarsubtipo(Long id) {
    Optional<Subtipoprod> subtiposalvo=subtipoprodRepository.findById(id);
    if(!subtiposalvo.isPresent()){
      throw new IllegalArgumentException();
    }
    return subtiposalvo.get();
  }
  //fazer o resource

}
