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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
