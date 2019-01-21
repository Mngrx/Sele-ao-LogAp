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

import br.com.logap.eolica.domain.Aerogerador;
import br.com.logap.eolica.exceptions.FaltandoValoresException;
import br.com.logap.eolica.exceptions.IdInvalidoException;
import br.com.logap.eolica.services.AerogeradorService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/aerogerador")
@Api(tags = "Aerogerador", description = "Operações relacionadas a Aerogerador")
public class AerogeradorResources {

	@Autowired
	AerogeradorService aerogeradorService;
	
	@GetMapping
	public ResponseEntity<List<Aerogerador>> listarTodos() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(aerogeradorService.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Aerogerador> cadastrarAerogerador(@RequestBody Aerogerador aerogerador) {
		
		try {
			aerogeradorService.cadastrar(aerogerador);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(aerogerador);
		} catch (FaltandoValoresException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(aerogerador);
			
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Aerogerador>> obterPeloId(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(aerogeradorService.obterPeloId(id));
		} catch (IdInvalidoException e) {

			return ResponseEntity.badRequest().body(null);
		
		}
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Aerogerador>> removerPeloId(@PathVariable Long id) {

		try {
			Optional<Aerogerador> removido = aerogeradorService.obterPeloId(id);
			aerogeradorService.removerPeloId(id);
			return ResponseEntity.accepted().body(removido);
		} catch (IdInvalidoException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<Aerogerador>> atualizarPeloId(@PathVariable Long id, @RequestBody Aerogerador aerogerador) {
				
		try {
			aerogerador.setId(id);
			aerogeradorService.atualizarPeloId(id, aerogerador);
			return ResponseEntity.ok(aerogeradorService.obterPeloId(id));
		} catch (IdInvalidoException e) {
			return ResponseEntity.badRequest().body(null);
		} catch (FaltandoValoresException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(Optional.of(aerogerador));
		}
		
	}
	
}
