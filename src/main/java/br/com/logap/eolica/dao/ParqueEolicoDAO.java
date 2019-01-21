package br.com.logap.eolica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.logap.eolica.domain.ParqueEolico;

@Repository
public interface ParqueEolicoDAO extends JpaRepository<ParqueEolico, Long>{

}
