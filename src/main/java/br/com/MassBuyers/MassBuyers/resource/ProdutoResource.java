package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.model.Fornecedor;
import br.com.MassBuyers.MassBuyers.model.Produto;
import br.com.MassBuyers.MassBuyers.repository.FornecedorRepository;
import br.com.MassBuyers.MassBuyers.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {


  @Autowired
  private ProdutoRepository produtoRepository;


  @GetMapping("/todos")
  public List<Produto> ListarTodosProdutos(){
    return produtoRepository.findAll();
  }
}
