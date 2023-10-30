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
//continua aqui viado
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long id){cidadeRepository.deleteById(id);}



  @PutMapping("/{id}")
  public  ResponseEntity<Cidade> atualizar(@PathVariable Long id,@Valid @RequestBody Cidade cidade ){
    Cidade cidadesalva=cidadeService.atualizar(id,cidade);
    return  ResponseEntity.ok(cidadesalva);
  }




  @PostMapping()
  public ResponseEntity<Cidade> criar(@Valid @RequestBody Cidade cidade, HttpServletResponse response){
     Cidade cidadesalva= cidadeService.salvar(cidade);
     return ResponseEntity.status(HttpStatus.CREATED).body(cidadesalva);

  }

}
