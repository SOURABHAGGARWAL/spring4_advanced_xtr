package com.xebia.spring4_advanced_xtr.testing.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.spring4_advanced_xtr.testing.business.CustomerBusiness;
import com.xebia.spring4_advanced_xtr.testing.model.Customer;
import com.xebia.spring4_advanced_xtr.testing.repository.CustomerRepository;

@Service("customerBusiness")
public class CustomerBusinessImpl implements CustomerBusiness {
	
	@Autowired
	private CustomerRepository customerRepository;
	
    public Customer getCustomer(String customerId) {
        Customer customer=customerRepository.findOne(customerId);
        return customer;
    }
	
    public Customer saveCustomer(Customer customer) {
    	customer.setCreatedOn(new Date());
    	customer.setModifiedOn(new Date());
		return customerRepository.save(customer);
    }

    public Customer updateCustomer(String customerId, Customer customer)  {
    	Customer updateCustomer = customerRepository.findOne(customerId);
    	if(customer.getFirstName()!=null){
    		updateCustomer.setFirstName(customer.getFirstName());
    	}
    	if(customer.getLastName()!=null){
    		updateCustomer.setLastName(customer.getLastName());
    	}
    	if(customer.getOrders().size()>0){
    		updateCustomer.setOrders(customer.getOrders());
    	}
    	updateCustomer.setModifiedOn(new Date());
		return customerRepository.save(updateCustomer);
    }
	
    public void deleteCustomer(String customerId) {
    	customerRepository.delete(customerId);
    }
	
	public List<Customer> findByCustomerName(String firstName) throws Exception{
		List<Customer> customers = customerRepository.findByCustomerName(firstName);
		System.out.println(customers);
		return customers;
	}
	
	public List<Customer> findAllCustomer() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}
}
