package br.com.MassBuyers.MassBuyers.repository;

import br.com.MassBuyers.MassBuyers.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
