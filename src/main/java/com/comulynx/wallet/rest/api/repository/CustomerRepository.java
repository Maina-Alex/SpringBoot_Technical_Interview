package com.comulynx.wallet.rest.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comulynx.wallet.rest.api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerId(String customerId);

	// FIXED : Implement the query and function below to delete a customer using Customer Id
	@Modifying
	@Query("DELETE from Customer c WHERE c.id=?1")
	int deleteCustomerByCustomerId(String customer_id);

	// FIXED : Implement the query and function below to update customer firstName using Customer Id
	@Modifying
	 @Query("UPDATE Customer c SET c.firstName=?1 WHERE c.id=?2")
	 int updateCustomerByCustomerId(String firstName, String customer_id);
	
	//FIXED : Implement the query and function below and to return all customers whose Email contains  'gmail'
	@Query("SELECT c from Customer c where c.email like '%gmail%'")
	List<Customer> findAllCustomersWhoseEmailContainsGmail();
}
