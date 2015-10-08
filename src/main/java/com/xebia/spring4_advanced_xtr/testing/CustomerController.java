package com.xebia.spring4_advanced_xtr.testing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_advanced_xtr.testing.model.Customer;
import com.xebia.spring4_advanced_xtr.testing.service.CustomerService;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Customer> getAllCustomer() throws Exception {
		return customerService.findAllCustomer();
    }

}
