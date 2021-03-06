package com.comulynx.wallet.rest.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comulynx.wallet.rest.api.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Optional<List<Transaction>> findTransactionsByCustomerId(String customerId);

	Optional<List<Transaction>> findTransactionsByTransactionId(String transactionId);

	Optional<List<Transaction>> findTransactionsByCustomerIdOrTransactionId(String transactionId, String customerId);

	// FIXED: Change below Query to return the last 5 transactions
	// FIXED : Change below Query to use Named Parameters instead of indexed
	// parameters
	// FIXED : Change below function to return Optional<List<Transaction>>
	@Query("SELECT t FROM Transaction t WHERE t.customerId =:id AND  t.accountNo =:accountNo ORDER BY t.id DESC ")
	Optional<List<Transaction> >getMiniStatementUsingCustomerIdAndAccountNo(@Param("id") String customer_id, @Param("accountNo") String account_no);

}
