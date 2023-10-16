package br.com.MassBuyers.MassBuyers.repository;

import br.com.MassBuyers.MassBuyers.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
