package com.formflow.meteo.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formflow.meteo.app.domain.model.Employee;
import com.formflow.meteo.app.infra.repository.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByMailAddress(username)
                .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません: " + username));
        
        return employee;
    }
} 