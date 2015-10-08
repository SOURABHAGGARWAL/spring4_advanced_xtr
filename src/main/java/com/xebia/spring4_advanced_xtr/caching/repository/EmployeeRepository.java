package com.xebia.spring4_advanced_xtr.caching.repository;

import com.xebia.spring4_advanced_xtr.caching.model.Employee;

public interface EmployeeRepository {
	Employee getByEmployeeId(String employeeId);
	
	Employee getByEmployeeIdWithoutCaching(String employeeId);
}
