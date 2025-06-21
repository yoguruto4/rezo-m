package com.formflow.meteo.app.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formflow.meteo.app.domain.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    Optional<Employee> findByMailAddress(String mailAddress);
    
    boolean existsByMailAddress(String mailAddress);
} 