package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.filter.Cidadefilter;
import br.com.MassBuyers.MassBuyers.filter.Fornecedorfilter;
import br.com.MassBuyers.MassBuyers.model.Estado;
import br.com.MassBuyers.MassBuyers.model.Fornecedor;
import br.com.MassBuyers.MassBuyers.repository.EstadoRepository;
import br.com.MassBuyers.MassBuyers.repository.FornecedorRepository;
import br.com.MassBuyers.MassBuyers.repository.projections.CidadeDto;
import br.com.MassBuyers.MassBuyers.repository.projections.FornecedorDto;
import br.com.MassBuyers.MassBuyers.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forcedores")
public class FornecedorResource {


  @Autowired
  private FornecedorRepository fornecedorRepository;
private FornecedorService fornecedorService;

  @GetMapping("/todos")
  public List<Fornecedor> ListarTodosFornecedores(){
    return fornecedorRepository.findAll();
  }

  @GetMapping()
  public Page<FornecedorDto> pesquisar(Fornecedorfilter fornecedorfilter, Pageable pageable){
    return  fornecedorRepository.Filtrar(fornecedorfilter,pageable);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long id){fornecedorRepository.deleteById(id);}



  @PutMapping("/mudar-fornecedor/{id}")
  public HttpStatus mudarfornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedorRequest){
    return  fornecedorRepository.findById(id).map(
      fonrnecedor -> {
        fonrnecedor.setNome(fornecedorRequest.getNome());
        fonrnecedor.setCnpj(fornecedorRequest.getCnpj());
        fonrnecedor.setTelefone(fornecedorRequest.getTelefone());
        fonrnecedor.setDescricao(fornecedorRequest.getDescricao());
        fonrnecedor.setEmail(fornecedorRequest.getEmail());
        fonrnecedor.setSenha(fornecedorRequest.getSenha());
        fonrnecedor.setCidade(fornecedorRequest.getCidade());
        fornecedorRepository.save(fonrnecedor);
        return  HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });


  }




  @PostMapping()
  public ResponseEntity<Fornecedor> criar(@RequestBody Fornecedor fornecedor){

    return new ResponseEntity<>(fornecedorRepository.save(fornecedor),HttpStatus.CREATED);

  }



}
