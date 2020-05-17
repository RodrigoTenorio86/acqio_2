package br.com.acqio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acqio.document.Transaction;
import br.com.acqio.repository.TransactionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	private  TransactionRepository dao;
	
	
	@Autowired
	public TransactionServiceImpl(TransactionRepository dao) {
		this.dao = dao;
	}

	@Override
	public Mono<Transaction> findById(String id) {		
		return dao.findById(id);
	}

	@Override
	public Mono<Transaction> save(Transaction transaction) {		
		return dao.save(transaction);
	}

	@Override
	public Flux<Transaction> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteById(String id) {
		dao.deleteById(id);		
	}

	



}
