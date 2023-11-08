package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.filter.Clientefilter;
import br.com.MassBuyers.MassBuyers.filter.Produtofilter;
import br.com.MassBuyers.MassBuyers.model.Fornecedor;
import br.com.MassBuyers.MassBuyers.model.Produto;
import br.com.MassBuyers.MassBuyers.repository.FornecedorRepository;
import br.com.MassBuyers.MassBuyers.repository.ProdutoRepository;
import br.com.MassBuyers.MassBuyers.repository.projections.ClienteDto;
import br.com.MassBuyers.MassBuyers.repository.projections.ProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping()
  public Page<ProdutoDto> pesquisar(Produtofilter produtofilter, Pageable pageable){
    return  produtoRepository.Filtrar(produtofilter,pageable);
  }


  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long id){produtoRepository.deleteById(id);}



  @PutMapping("/mudar-produto/{id}")
  public HttpStatus mudarproduto(@PathVariable Long id, @RequestBody Produto produtoRequest){
    return  produtoRepository.findById(id).map(
      produto -> {
        produto.setNome(produtoRequest.getNome());
        produto.setPrecovenda(produtoRequest.getPrecovenda());
        produto.setPrecorevenda(produtoRequest.getPrecorevenda());
        produto.setQuantidade(produtoRequest.getQuantidade());
        produto.setSubtipoprod(produtoRequest.getSubtipoprod());
        produto.setFornecedor(produtoRequest.getFornecedor());
        produtoRepository.save(produto);
        return  HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });


  }




  @PostMapping()
  public ResponseEntity<Produto> criar(@RequestBody Produto produto){

    return new ResponseEntity<>(produtoRepository.save(produto),HttpStatus.CREATED);

  }



}
