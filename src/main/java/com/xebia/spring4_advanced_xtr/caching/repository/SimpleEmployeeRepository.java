package com.xebia.spring4_advanced_xtr.caching.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.xebia.spring4_advanced_xtr.caching.model.Employee;

@Component
public class SimpleEmployeeRepository implements EmployeeRepository {

	long time = 5000L;
	
	private void simulateSlowService() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
	
	@Cacheable("Employees")
    public Employee getByEmployeeId(String employeeId) {
        simulateSlowService();
        return new Employee("ABCD", "XI265");
	}
	
    public Employee getByEmployeeIdWithoutCaching(String employeeId) {
        simulateSlowService();
        return new Employee("FGHJ", "XI789");
	}
}
