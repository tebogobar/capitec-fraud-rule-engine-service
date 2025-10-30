package za.co.capitec.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.capitec.dto.TransactionDto;
import za.co.capitec.model.Transaction;
import za.co.capitec.service.TransactionService;

@RestController
@RequestMapping("fraud")
public class FraudController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FraudController.class);
	private final TransactionService service;

    public FraudController(TransactionService service) {
        this.service = service;
    }
	
	@PostMapping("/createTransaction")
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDto dto) {
		LOGGER.info("Creating a new transaction");
		Transaction saved = service.processEvent(dto);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("/getTransactions")
	public ResponseEntity<List<Transaction>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/flagged")
	public ResponseEntity<List<Transaction>> getFlagged() {
		return ResponseEntity.ok(service.getFlagged());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaction> getById(@PathVariable Long id) {
		Transaction tx = service.getById(id);
		if (tx == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(tx);
	}
}
