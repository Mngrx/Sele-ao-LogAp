package br.com.logap.eolica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logap.eolica.exceptions.FaltandoValoresException;
import br.com.logap.eolica.exceptions.IdInvalidoException;

public abstract class GenericService<T, R extends JpaRepository<T, Long>> {
	@Autowired
	R dao;
	
	public List<T> listarTodos() {
		return dao.findAll();
	}
	
	public Optional<T> obterPeloId(Long id) throws IdInvalidoException {
		
		if (id == null || id < 0 || !dao.existsById(id)) {
			throw new IdInvalidoException();
		}
		
		return dao.findById(id);
	}

	public Optional<T> removerPeloId(Long id) throws IdInvalidoException {
		
		if (id == null || id < 0 || !dao.existsById(id)) {
			throw new IdInvalidoException();
		}
		
		Optional<T> removido = dao.findById(id);
		
		dao.deleteById(id);
		
		return removido;
	}
	

	public boolean cadastrar(T item) throws FaltandoValoresException {
		if (!this.validar(item)) {
			throw new FaltandoValoresException();
		}
		dao.save(item);
		
		return true;
	}
	
	
	public T atualizarPeloId(Long id, T item) throws IdInvalidoException, FaltandoValoresException {
		
		if (id == null || id < 0 || !dao.existsById(id)) {
			throw new IdInvalidoException();
		}
		
		if (!this.validar(item)) {
			throw new FaltandoValoresException();
		}
		
		return dao.save(item);
		
	}
	
	public abstract boolean validar(T item);
}
