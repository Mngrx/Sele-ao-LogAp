package br.com.logap.eolica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logap.eolica.dao.ComplexoEolicoDAO;
import br.com.logap.eolica.domain.ComplexoEolico;


@Service
public class ComplexoEolicoService {

	@Autowired
	ComplexoEolicoDAO complexoEolicoDAO;
	
	public List<ComplexoEolico> listarTodos() {
		return complexoEolicoDAO.findAll();
	}
	
	public Optional<ComplexoEolico> listarPeloId(Long id) {
		
		if (id == null || id < 0 || !complexoEolicoDAO.existsById(id)) {
			System.out.println("ID inválido");
			return null;
		}
		
		return complexoEolicoDAO.findById(id);
	}

	public boolean removerPeloId(Long id) {
		
		if (id == null || id < 0 || !complexoEolicoDAO.existsById(id)) {
			System.out.println("ID inválido");
			return false;
		}
		
		complexoEolicoDAO.deleteById(id);
		
		return true;
	}
	

	public boolean cadastrar(ComplexoEolico complexo) {
		if (!this.validar(complexo)) {
			return false;
		}
		complexoEolicoDAO.save(complexo);
		
		return true;
	}
	
	
	public boolean validar(ComplexoEolico complexo) {
		return true;
	}
	
	
	public ComplexoEolico atualizarPeloId(Long id, ComplexoEolico complexo) {
		if (id == null || id < 0 || !complexoEolicoDAO.existsById(id)) {
			System.out.println("ID inválido");
			return null;
		}
		
		
	}
	
}
