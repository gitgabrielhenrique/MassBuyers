package br.com.MassBuyers.MassBuyers.repository;

import br.com.MassBuyers.MassBuyers.model.Tipoprod;
import br.com.MassBuyers.MassBuyers.repository.tipoprod.TipoprodRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoprodRepository extends JpaRepository<Tipoprod,Long>, TipoprodRepositoryQuery {
}
