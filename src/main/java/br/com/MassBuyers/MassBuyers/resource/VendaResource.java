package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.filter.Produtofilter;
import br.com.MassBuyers.MassBuyers.filter.Vendafilter;
import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import br.com.MassBuyers.MassBuyers.model.Venda;
import br.com.MassBuyers.MassBuyers.repository.TipoprodRepository;
import br.com.MassBuyers.MassBuyers.repository.VendaRepository;
import br.com.MassBuyers.MassBuyers.repository.projections.ProdutoDto;
import br.com.MassBuyers.MassBuyers.repository.projections.VendaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaResource {



  @Autowired
  private VendaRepository vendaRepository;


  @GetMapping("/todos")
  public List<Venda> ListarTodasVendas(){
    return vendaRepository.findAll();
  }


  @GetMapping()
  public Page<VendaDto> pesquisar(Vendafilter vendafilter, Pageable pageable){
    return  vendaRepository.Filtrar(vendafilter,pageable);
  }



  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long id) {
    vendaRepository.deleteById(id);
  }


  @PutMapping("/mudar-venda/{id}")
  public HttpStatus mudartipo(@PathVariable Long id, @RequestBody Venda vendarequest) {
    return vendaRepository.findById(id).map(
      venda -> {
        venda.setDatavenda(vendarequest.getDatavenda());
        venda.setProduto(vendarequest.getProduto());
        venda.setFornecedor(vendarequest.getFornecedor());
        venda.setCliente(vendarequest.getCliente());
        vendaRepository.save(venda);
        return HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });


  }
  @PostMapping()
  public ResponseEntity<Venda> criar(@RequestBody Venda venda){

    return new ResponseEntity<>(vendaRepository.save(venda),HttpStatus.CREATED);

  }



}
