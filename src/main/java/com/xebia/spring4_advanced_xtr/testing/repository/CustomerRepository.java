package com.xebia.spring4_advanced_xtr.testing.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.xebia.spring4_advanced_xtr.testing.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	  @Query("{'_id': ?0}")
	  Customer findByCustomerID(String customerId);
	  
	  @Query("{'first_name': ?0}")
	  List<Customer> findByCustomerName(String firstName);
}
