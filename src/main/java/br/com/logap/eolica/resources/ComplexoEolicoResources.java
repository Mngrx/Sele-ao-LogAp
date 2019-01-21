package br.com.logap.eolica.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logap.eolica.domain.ComplexoEolico;
import br.com.logap.eolica.domain.ParqueEolico;
import br.com.logap.eolica.exceptions.FaltandoValoresException;
import br.com.logap.eolica.exceptions.IdInvalidoException;
import br.com.logap.eolica.services.ComplexoEolicoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/complexo-eolico")
@Api(tags = "Complexo Eolico", description = "Operações relacionadas a Complexo Eolico")
public class ComplexoEolicoResources {

	@Autowired
	ComplexoEolicoService complexoEolicoService;
	
	@GetMapping
	public ResponseEntity<List<ComplexoEolico>> listarTodos() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(complexoEolicoService.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<ComplexoEolico> cadastrarComplexoEolico(@RequestBody ComplexoEolico complexoEolico) {
		
		try {
			complexoEolicoService.cadastrar(complexoEolico);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(complexoEolico);
		} catch (FaltandoValoresException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(complexoEolico);
			
		}
	}
	
	@GetMapping("/{id}/parque-eolico")
	public ResponseEntity<Optional<ArrayList<ParqueEolico>>> obterParqueEolicoPeloIdComplexoEolico(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(complexoEolicoService.aerogeradoresPeloIdDoParqueEolico(id));
		} catch (IdInvalidoException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ComplexoEolico>> obterPeloId(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(complexoEolicoService.obterPeloId(id));
		} catch (IdInvalidoException e) {

			return ResponseEntity.badRequest().body(null);
		
		}
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<ComplexoEolico>> removerPeloId(@PathVariable Long id) {

		try {
			Optional<ComplexoEolico> removido = complexoEolicoService.obterPeloId(id);
			complexoEolicoService.removerPeloId(id);
			return ResponseEntity.accepted().body(removido);
		} catch (IdInvalidoException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<ComplexoEolico>> atualizarPeloId(@PathVariable Long id, @RequestBody ComplexoEolico complexo) {
				
		try {
			complexo.setId(id);
			complexoEolicoService.atualizarPeloId(id, complexo);
			return ResponseEntity.ok(complexoEolicoService.obterPeloId(id));
		} catch (IdInvalidoException e) {
			return ResponseEntity.badRequest().body(null);
		} catch (FaltandoValoresException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(Optional.of(complexo));
		}
		
	}
	
}
