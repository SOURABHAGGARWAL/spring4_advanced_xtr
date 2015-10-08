package com.xebia.spring4_advanced_xtr.caching.service;


public interface EmployeeService {

	void fetchEmployee() throws Exception;
	void fetchEmployeeWithoutCaching() throws Exception;

}
