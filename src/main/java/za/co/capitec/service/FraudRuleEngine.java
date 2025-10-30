package za.co.capitec.service;

import java.util.List;

import org.springframework.stereotype.Component;
import za.co.capitec.model.Transaction;
import za.co.capitec.rules.FraudRule;

@Component
public class FraudRuleEngine {

	private final List<FraudRule> rules;

    public FraudRuleEngine(List<FraudRule> rules) {
        this.rules = rules;
    }

    public void applyAll(Transaction tx) {
        
        tx.setFlagged(false);
        tx.setFraudScore(0);
        tx.getReasons().clear();

        for (FraudRule r : rules) {
            try {
                r.apply(tx);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
