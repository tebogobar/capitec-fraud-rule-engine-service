package za.co.capitec.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import za.co.capitec.dto.TransactionDto;
import za.co.capitec.model.Transaction;
import za.co.capitec.repo.TransactionRepository;

@Service
public class TransactionService {

	 private final TransactionRepository repository;
	    private final FraudRuleEngine engine;

	    public TransactionService(TransactionRepository repository, FraudRuleEngine engine) {
	        this.repository = repository;
	        this.engine = engine;
	    }

	    @Transactional
	    public Transaction processEvent(TransactionDto dto) {
	        Transaction tx = new Transaction();
	        tx.setCategory(dto.getCategory());
	        tx.setAmount(dto.getAmount());
	        tx.setSourceAccount(dto.getSourceAccount());
	        tx.setDestinationAccount(dto.getDestinationAccount());
	        tx.setTimestamp(dto.getTimestamp() != null ? dto.getTimestamp() : LocalDateTime.now());

	        engine.applyAll(tx);

	        return repository.save(tx);
	    }

	    public List<Transaction> getAll() {
	        return repository.findAll();
	    }

	    public List<Transaction> getFlagged() {
	        return repository.findByFlaggedTrue();
	    }

	    public Transaction getById(Long id) {
	        return repository.findById(id).orElse(null);
	    }
}
