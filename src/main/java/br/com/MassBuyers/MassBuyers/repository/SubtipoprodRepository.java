package br.com.MassBuyers.MassBuyers.repository;

import br.com.MassBuyers.MassBuyers.model.Subtipoprod;
import br.com.MassBuyers.MassBuyers.repository.subtipoprod.SubtipoprodRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtipoprodRepository extends JpaRepository<Subtipoprod,Long>, SubtipoprodRepositoryQuery {
}
