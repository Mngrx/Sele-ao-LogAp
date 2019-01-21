package br.com.logap.eolica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logap.eolica.domain.GenericEntity;

public interface GenericDAO<T extends GenericEntity> extends JpaRepository<T, Long> {

}
