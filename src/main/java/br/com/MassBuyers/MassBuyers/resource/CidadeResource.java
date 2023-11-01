package br.com.MassBuyers.MassBuyers.resource;


import br.com.MassBuyers.MassBuyers.filter.Cidadefilter;
import br.com.MassBuyers.MassBuyers.model.Cidade;
import br.com.MassBuyers.MassBuyers.repository.CidadeRepository;
import br.com.MassBuyers.MassBuyers.repository.projections.CidadeDto;
import br.com.MassBuyers.MassBuyers.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.PSource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

  @Autowired
  private CidadeRepository cidadeRepository;
private CidadeService cidadeService;

  @GetMapping("/todos")
  public List<Cidade> ListarTodasAsCidades(){
return cidadeRepository.findAll();
  }

  @GetMapping()
  public Page<CidadeDto> pesquisar(Cidadefilter cidadefilter, Pageable pageable){
    return  cidadeRepository.Filtrar(cidadefilter,pageable);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long id){cidadeRepository.deleteById(id);}



  @PutMapping("/mudar-cidade/{id}")
  public HttpStatus mudarciade(@PathVariable Long id, @RequestBody Cidade cidadeRequest){
    return  cidadeRepository.findById(id).map(
      cidade -> {
        cidade.setNomecidade(cidadeRequest.getNomecidade());
        cidade.setEstado(cidadeRequest.getEstado());
        cidadeRepository.save(cidade);
        return  HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });


  }




  @PostMapping()
  public ResponseEntity<Cidade> criar( @RequestBody Cidade cidade){

     return new ResponseEntity<>(cidadeRepository.save(cidade),HttpStatus.CREATED);

  }

}
