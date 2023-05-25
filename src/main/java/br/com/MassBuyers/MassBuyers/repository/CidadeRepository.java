package br.com.MassBuyers.MassBuyers.repository;


import br.com.MassBuyers.MassBuyers.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}
