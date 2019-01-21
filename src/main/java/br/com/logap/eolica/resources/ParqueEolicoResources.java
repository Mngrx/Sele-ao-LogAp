package br.com.logap.eolica.resources;

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

import br.com.logap.eolica.domain.ParqueEolico;
import br.com.logap.eolica.exceptions.FaltandoValoresException;
import br.com.logap.eolica.exceptions.IdInvalidoException;
import br.com.logap.eolica.services.ParqueEolicoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/parque-eolico")
@Api(tags = "Parque Eolico", description = "Operações relacionadas a Parque Eolico")
public class ParqueEolicoResources {

	@Autowired
	ParqueEolicoService parqueEolicoService;
	
	@GetMapping
	public ResponseEntity<List<ParqueEolico>> listarTodos() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(parqueEolicoService.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<ParqueEolico> cadastrarParqueEolico(@RequestBody ParqueEolico parqueEolico) {
		
		try {
			parqueEolicoService.cadastrar(parqueEolico);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(parqueEolico);
		} catch (FaltandoValoresException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(parqueEolico);
			
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ParqueEolico>> obterPeloId(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(parqueEolicoService.obterPeloId(id));
		} catch (IdInvalidoException e) {

			return ResponseEntity.badRequest().body(null);
		
		}
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<ParqueEolico>> removerPeloId(@PathVariable Long id) {

		try {
			Optional<ParqueEolico> removido = parqueEolicoService.obterPeloId(id);
			parqueEolicoService.removerPeloId(id);
			return ResponseEntity.accepted().body(removido);
		} catch (IdInvalidoException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<ParqueEolico>> atualizarPeloId(@PathVariable Long id, @RequestBody ParqueEolico parque) {
				
		try {
			parque.setId(id);
			parqueEolicoService.atualizarPeloId(id, parque);
			return ResponseEntity.ok(parqueEolicoService.obterPeloId(id));
		} catch (IdInvalidoException e) {
			return ResponseEntity.badRequest().body(null);
		} catch (FaltandoValoresException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(Optional.of(parque));
		}
		
	}
	
}
