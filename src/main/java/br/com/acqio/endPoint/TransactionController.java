package br.com.acqio.endPoint;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acqio.document.Transaction;
import br.com.acqio.service.TransactionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, path = "/transaction")
public class TransactionController {
	@Autowired
	private TransactionService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		Mono<Transaction> transaction = service.findById(id);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<?> findAll() {
		Flux<Transaction> traFlux = service.findAll();
		return new ResponseEntity<>(traFlux, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Transaction transaction) {
		Mono<Transaction> transaction2 = service.save(transaction);
		return new ResponseEntity<>(transaction2, HttpStatus.CREATED);
	}

}
