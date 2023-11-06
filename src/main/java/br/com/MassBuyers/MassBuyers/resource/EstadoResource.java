package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.filter.Estadofilter;
import br.com.MassBuyers.MassBuyers.filter.Tipoprodfilter;
import br.com.MassBuyers.MassBuyers.model.Cidade;
import br.com.MassBuyers.MassBuyers.model.Cliente;
import br.com.MassBuyers.MassBuyers.model.Estado;
import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import br.com.MassBuyers.MassBuyers.repository.ClienteRepository;
import br.com.MassBuyers.MassBuyers.repository.EstadoRepository;
import br.com.MassBuyers.MassBuyers.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoResource {


  @Autowired
  private EstadoRepository estadoRepository;
private EstadoService estadoService;

  @GetMapping("/todos")
  public List<Estado> ListarTodosEstados(){
    return estadoRepository.findAll();
  }
  @GetMapping()
  public Page<Estado> pesquisar(Estadofilter estadofilter, Pageable pageable){
    return estadoRepository.Filtrar(estadofilter,pageable);
  }



  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long id){estadoRepository.deleteById(id);}



  @PutMapping("/mudar-estado/{id}")
  public HttpStatus mudarestado(@PathVariable Long id, @RequestBody Estado estadoRequest){
    return  estadoRepository.findById(id).map(
      estado -> {
        estado.setNome(estadoRequest.getNome());
        estado.setCidadeestado(estadoRequest.getCidadeestado());
        estadoRepository.save(estado);
        return  HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });


  }




  @PostMapping()
  public ResponseEntity<Estado> criar(@RequestBody Estado estado){

    return new ResponseEntity<>(estadoRepository.save(estado),HttpStatus.CREATED);

  }

}
