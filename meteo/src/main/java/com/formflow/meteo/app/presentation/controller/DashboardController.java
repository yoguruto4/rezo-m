package com.formflow.meteo.app.presentation.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.formflow.meteo.app.domain.model.Employee;

@Controller
public class DashboardController {
    
    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication) {
        Employee employee = (Employee) authentication.getPrincipal();
        
        // 管理者権限をチェック
        if (employee.isAdmin()) {
            return "redirect:/admin/dashboard";
        } else {
            return "redirect:/user/dashboard";
        }
    }
    
    @GetMapping("/")
    public String root() {
        return "redirect:/dashboard";
    }
} 