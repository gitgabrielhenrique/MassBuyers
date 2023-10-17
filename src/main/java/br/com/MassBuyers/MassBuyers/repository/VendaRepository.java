package br.com.MassBuyers.MassBuyers.repository;

import br.com.MassBuyers.MassBuyers.model.Venda;
import br.com.MassBuyers.MassBuyers.repository.venda.VendaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda,Long>, VendaRepositoryQuery {
}
