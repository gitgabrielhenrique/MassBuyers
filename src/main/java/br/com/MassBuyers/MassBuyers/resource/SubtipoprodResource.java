package br.com.MassBuyers.MassBuyers.resource;


import br.com.MassBuyers.MassBuyers.filter.Subtipofilter;
import br.com.MassBuyers.MassBuyers.model.Produto;
import br.com.MassBuyers.MassBuyers.model.Subtipoprod;
import br.com.MassBuyers.MassBuyers.repository.ProdutoRepository;
import br.com.MassBuyers.MassBuyers.repository.SubtipoprodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subtipos")
public class SubtipoprodResource {


  @Autowired
  private SubtipoprodRepository subtipoprodRepository;

  @GetMapping()
  public Page<Subtipoprod> pesquisar(Subtipofilter subtipofilter, Pageable pageable) {
    return subtipoprodRepository.Filtrar(subtipofilter, pageable);
  }

  @GetMapping("/todos")
  public List<Subtipoprod> ListarTodosSubtipos() {
    return subtipoprodRepository.findAll();
  }


  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long id) {
    subtipoprodRepository.deleteById(id);
  }


  @PutMapping("/mudar-subtipo/{id}")
  public HttpStatus mudarsubtipo(@PathVariable Long id, @RequestBody Subtipoprod subtiporequest) {
    return subtipoprodRepository.findById(id).map(
      subtipo -> {
        subtipo.setNome(subtiporequest.getNome());
        subtipo.setTipoprod(subtiporequest.getTipoprod());
        subtipoprodRepository.save(subtipo);
        return HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });


  }
  @PostMapping()
  public ResponseEntity<Subtipoprod> criar(@RequestBody Subtipoprod subtipoprod){

    return new ResponseEntity<>(subtipoprodRepository.save(subtipoprod),HttpStatus.CREATED);

  }

}
