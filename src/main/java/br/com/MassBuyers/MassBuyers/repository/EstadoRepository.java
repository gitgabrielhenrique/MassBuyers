package br.com.MassBuyers.MassBuyers.repository;

import br.com.MassBuyers.MassBuyers.model.Estado;
import br.com.MassBuyers.MassBuyers.model.Subtipoprod;
import br.com.MassBuyers.MassBuyers.repository.estado.EstadoRepositoryQuery;
import br.com.MassBuyers.MassBuyers.repository.subtipoprod.SubtipoprodRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado,Long>, EstadoRepositoryQuery {
}
