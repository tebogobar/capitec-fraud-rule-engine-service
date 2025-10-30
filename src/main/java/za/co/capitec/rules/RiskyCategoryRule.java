package za.co.capitec.rules;

import java.util.Set;
import org.springframework.stereotype.Component;
import za.co.capitec.model.Transaction;

@Component
public class RiskyCategoryRule implements FraudRule {

	private static final Set<String> HIGH_RISK = Set.of("GAMBLING", "CRYPTO", "ADULT");

    private static final int SCORE = 20;

    @Override
    public void apply(Transaction tx) {
        if (tx.getCategory() != null && HIGH_RISK.contains(tx.getCategory().toUpperCase())) {
            tx.addReason("Category flagged high-risk: " + tx.getCategory(), SCORE);
        }
    }
}
