package za.co.capitec.repo;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.capitec.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByFlaggedTrue();

	long countBySourceAccountAndTimestampAfter(String sourceAccount, LocalDateTime after);

	@Query("select t from Transaction t where t.sourceAccount = :sourceAccount and t.timestamp >= :after order by t.timestamp desc")
	List<Transaction> findRecentBySourceAccount(String sourceAccount, LocalDateTime after);

}
