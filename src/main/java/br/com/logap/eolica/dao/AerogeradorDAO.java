package br.com.logap.eolica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.logap.eolica.domain.Aerogerador;

@Repository
public interface AerogeradorDAO extends JpaRepository<Aerogerador, Long>{

}
