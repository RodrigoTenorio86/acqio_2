package br.com.acqio.service;


import br.com.acqio.document.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
	Mono<Transaction> findById(String id);
	
	Mono<Transaction> save(Transaction transaction);
	
	Flux<Transaction> findAll();
	
	void deleteById(String id);
	
	
}
