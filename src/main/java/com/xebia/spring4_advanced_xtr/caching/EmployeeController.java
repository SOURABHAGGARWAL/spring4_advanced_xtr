package com.xebia.spring4_advanced_xtr.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_advanced_xtr.caching.service.EmployeeService;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/all", method = RequestMethod.GET)
    public void getEmployee() throws Exception {
		employeeService.fetchEmployee();
    }
	
	@RequestMapping(value="/all/no-cache", method = RequestMethod.GET)
    public void getEmployeeWithoutCache() throws Exception {
		employeeService.fetchEmployeeWithoutCaching();
    }


}
