package com.xebia.spring4_advanced_xtr.caching.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.spring4_advanced_xtr.caching.repository.EmployeeRepository;
import com.xebia.spring4_advanced_xtr.caching.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
    @Autowired
    private EmployeeRepository employeeRepository;

    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public void fetchEmployee() throws Exception {
        System.out.println(".... Fetching Employee");
        System.out.println(dateFormatter.format(new Date()) + ":::::::::::: XI265 -->" + employeeRepository.getByEmployeeId("XI265"));
        System.out.println(dateFormatter.format(new Date()) + ":::::::::::: XI265 -->" + employeeRepository.getByEmployeeId("XI265"));
        System.out.println(dateFormatter.format(new Date()) + ":::::::::::: XI265 -->" + employeeRepository.getByEmployeeId("XI265"));
    }
    
    public void fetchEmployeeWithoutCaching() throws Exception {
        System.out.println(".... Fetching Employee");
        System.out.println(dateFormatter.format(new Date()) + ":::::::::::: XI789 -->" + employeeRepository.getByEmployeeIdWithoutCaching("XI789"));
        System.out.println(dateFormatter.format(new Date()) + ":::::::::::: XI789 -->" + employeeRepository.getByEmployeeIdWithoutCaching("XI789"));
        System.out.println(dateFormatter.format(new Date()) + ":::::::::::: XI789 -->" + employeeRepository.getByEmployeeIdWithoutCaching("XI789"));
    }
}
