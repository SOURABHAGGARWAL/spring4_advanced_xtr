package com.xebia.spring4_advanced_xtr.testing.business;

import java.util.List;

import com.xebia.spring4_advanced_xtr.testing.model.Customer;

public interface CustomerBusiness {
	
    public Customer getCustomer(String customerId);
	
    public Customer saveCustomer(Customer customer);
	
    public Customer updateCustomer(String customerId, Customer customer) ;
	
    public void deleteCustomer(String customerId) ;

	public List<Customer> findByCustomerName(String firstName) throws Exception;

	List<Customer> findAllCustomer();
	
}
