package com.formflow.meteo.app.domain.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer idEmployee;
    
    @Column(name = "nm_employee", length = 50, nullable = false)
    private String nmEmployee;
    
    @Column(name = "kn_employee", length = 50, nullable = false)
    private String knEmployee;
    
    @Column(name = "mail_address", length = 100, nullable = false, unique = true)
    private String mailAddress;
    
    @Column(name = "password", length = 10, nullable = false)
    private String password;
    
    @Column(name = "admin_auth", nullable = false)
    private Integer adminAuth;
    
    @Column(name = "id_department", nullable = false)
    private Integer idDepartment;
    
    @Column(name = "employee_created_at", nullable = false)
    private LocalDateTime employeeCreatedAt;
    
    // UserDetails interface implementation
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (adminAuth == 1) {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }
    
    @Override
    public String getUsername() {
        return mailAddress;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    // Helper methods
    public boolean isAdmin() {
        return adminAuth == 1;
    }
    
    public boolean isUser() {
        return adminAuth == 0;
    }
} 