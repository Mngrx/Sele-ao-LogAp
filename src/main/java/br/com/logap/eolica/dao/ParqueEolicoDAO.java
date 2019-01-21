package br.com.logap.eolica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logap.eolica.domain.ParqueEolico;

public interface ParqueEolicoDAO extends JpaRepository<ParqueEolico, Long>{

}
