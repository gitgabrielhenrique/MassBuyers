package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.filter.Tipoprodfilter;
import br.com.MassBuyers.MassBuyers.model.Subtipoprod;
import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import br.com.MassBuyers.MassBuyers.repository.SubtipoprodRepository;
import br.com.MassBuyers.MassBuyers.repository.TipoprodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoprodResource {


  @Autowired
  private TipoprodRepository tipoprodRepository;


  @GetMapping("/todos")
  public List<Tipoprod> ListarTodostipos(){
    return tipoprodRepository.findAll();
  }

  @GetMapping()
public Page<Tipoprod> pesquisar(Tipoprodfilter tipoprodfilter, Pageable pageable){
return tipoprodRepository.Filtrar(tipoprodfilter,pageable);
  }



  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long id) {
    tipoprodRepository.deleteById(id);
  }


  @PutMapping("/mudar-tipo/{id}")
  public HttpStatus mudartipo(@PathVariable Long id, @RequestBody Tipoprod tiporequest) {
    return tipoprodRepository.findById(id).map(
      tipo -> {
        tipo.setNome(tiporequest.getNome());
        tipoprodRepository.save(tipo);
        return HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });


  }
  @PostMapping()
  public ResponseEntity<Tipoprod> criar(@RequestBody Tipoprod tipoprod){

    return new ResponseEntity<>(tipoprodRepository.save(tipoprod),HttpStatus.CREATED);

  }

}
