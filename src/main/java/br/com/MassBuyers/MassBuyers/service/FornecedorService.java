package br.com.MassBuyers.MassBuyers.service;

import br.com.MassBuyers.MassBuyers.model.Estado;
import br.com.MassBuyers.MassBuyers.model.Fornecedor;
import br.com.MassBuyers.MassBuyers.repository.EstadoRepository;
import br.com.MassBuyers.MassBuyers.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FornecedorService {

  @Autowired
  private FornecedorRepository fornecedorRepository;

  public Fornecedor salvar(Fornecedor fornecedor){
    return fornecedorRepository.save(fornecedor);


  }
  public Fornecedor atualizar(Long id,Fornecedor fornecedor){
    Fornecedor fornecedorsalvo = buscarfornecedorexistente(id);
    return fornecedorRepository.save(fornecedorsalvo);
  }

  private Fornecedor buscarfornecedorexistente(Long id) {
    Optional<Fornecedor> fornecedorsalvo=fornecedorRepository.findById(id);
    if(!fornecedorsalvo.isPresent()){
      throw new IllegalArgumentException();
    }
    return fornecedorsalvo.get();
  }



}
