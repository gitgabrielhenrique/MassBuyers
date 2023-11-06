package br.com.MassBuyers.MassBuyers.service;

import br.com.MassBuyers.MassBuyers.model.Fornecedor;
import br.com.MassBuyers.MassBuyers.model.Produto;
import br.com.MassBuyers.MassBuyers.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProdutoService {
  @Autowired
  private ProdutoRepository produtoRepository;

  public Produto salvar(Produto produto){
    return produtoRepository.save(produto);


  }
  public Produto atualizar(Long id,Produto produto){
    Produto produtosalvo = buscarprodutoexistente(id);
    return produtoRepository.save(produto);
  }

  private Produto buscarprodutoexistente(Long id) {
    Optional<Produto> produtosalvo=produtoRepository.findById(id);
    if(!produtosalvo.isPresent()){
      throw new IllegalArgumentException();
    }
    return produtosalvo.get();
  }


}
