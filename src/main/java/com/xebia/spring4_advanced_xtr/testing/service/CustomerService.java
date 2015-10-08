package com.xebia.spring4_advanced_xtr.testing.service;

import java.util.List;

import com.xebia.spring4_advanced_xtr.testing.model.Customer;

public interface CustomerService {
	
    public Customer getCustomer(String customerId) throws Exception;
	
    public Customer saveCustomer(Customer customer) throws Exception;
	
    public Customer updateCustomer(String customerId, Customer customer) throws Exception ;
	
    public void deleteCustomer(String customerId) throws Exception ;

	public List<Customer> findByCustomerName(String firstName) throws Exception;
	
	public List<Customer> findAllCustomer() throws Exception;
}
