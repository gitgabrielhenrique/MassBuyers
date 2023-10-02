package br.com.MassBuyers.MassBuyers.resource;

import br.com.MassBuyers.MassBuyers.filter.Cidadefilter;
import br.com.MassBuyers.MassBuyers.filter.Fornecedorfilter;
import br.com.MassBuyers.MassBuyers.model.Estado;
import br.com.MassBuyers.MassBuyers.model.Fornecedor;
import br.com.MassBuyers.MassBuyers.repository.EstadoRepository;
import br.com.MassBuyers.MassBuyers.repository.FornecedorRepository;
import br.com.MassBuyers.MassBuyers.repository.projections.CidadeDto;
import br.com.MassBuyers.MassBuyers.repository.projections.FornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forcedores")
public class FornecedorResource {


  @Autowired
  private FornecedorRepository fornecedorRepository;


  @GetMapping("/todos")
  public List<Fornecedor> ListarTodosFornecedores(){
    return fornecedorRepository.findAll();
  }

  @GetMapping()
  public Page<FornecedorDto> pesquisar(Fornecedorfilter fornecedorfilter, Pageable pageable){
    return  fornecedorRepository.Filtrar(fornecedorfilter,pageable);
  }
}
