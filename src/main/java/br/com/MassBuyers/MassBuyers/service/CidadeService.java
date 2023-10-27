package br.com.MassBuyers.MassBuyers.service;

import br.com.MassBuyers.MassBuyers.model.Cidade;
import br.com.MassBuyers.MassBuyers.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CidadeService {
  @Autowired
  private CidadeRepository cidadeRepository;

  public Cidade salvar(Cidade cidade){
    return cidadeRepository.save(cidade);


  }
  public Cidade atualizar(Long id,Cidade cidade){
    Cidade cidadeSalva = buscarcidadeexistente(id);
return cidadeRepository.save(cidadeSalva);
  }

  private Cidade buscarcidadeexistente(Long id) {
    Optional<Cidade> cidadesalva=cidadeRepository.findById(id);
    if(!cidadesalva.isPresent()){
      throw new IllegalArgumentException();
    }
    return cidadesalva.get();
  }


}
