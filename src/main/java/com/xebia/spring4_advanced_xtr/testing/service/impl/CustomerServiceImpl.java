package com.xebia.spring4_advanced_xtr.testing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.spring4_advanced_xtr.testing.business.CustomerBusiness;
import com.xebia.spring4_advanced_xtr.testing.model.Customer;
import com.xebia.spring4_advanced_xtr.testing.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerBusiness customerBusiness;
	
    public Customer getCustomer(String customerId) throws Exception {
    	try{
    		return customerBusiness.getCustomer(customerId);
    	} catch(Exception e){
    		throw new Exception("Not able to get customer with customerId = "+customerId);
    	}
    }
	
    public Customer saveCustomer(Customer customer) throws Exception {
    	try{
    		return customerBusiness.saveCustomer(customer);
    	} catch(Exception e){
    		throw new Exception("Not able to save customer with name = "+customer.getFirstName());
    	}
    }
	
    public Customer updateCustomer(String customerId, Customer customer) throws Exception {
    	try{
    		return customerBusiness.updateCustomer(customerId, customer);
    	} catch(Exception e){
    		throw new Exception("Not able to update customer with customerId = "+customerId);
    	}
    }
	
    public void deleteCustomer(String customerId) throws Exception {
    	try{
    		customerBusiness.deleteCustomer(customerId);
    	} catch(Exception e){
    		throw new Exception("Uable to delte customer with customerId = "+customerId);
    	}
    }
    
	public List<Customer> findByCustomerName(String firstName) throws Exception {
		return customerBusiness.findByCustomerName(firstName);
	}
	
	public List<Customer> findAllCustomer()  throws Exception {
		return customerBusiness.findAllCustomer();
	}
	
}
