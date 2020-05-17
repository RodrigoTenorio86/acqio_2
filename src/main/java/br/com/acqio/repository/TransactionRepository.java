package br.com.acqio.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.acqio.document.Transaction;


@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String>{


}
