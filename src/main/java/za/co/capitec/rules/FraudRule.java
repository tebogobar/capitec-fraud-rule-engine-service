package za.co.capitec.rules;

import za.co.capitec.model.Transaction;

public interface FraudRule {
	void apply(Transaction tx);
}
