package com.formflow.meteo.app.presentation.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formflow.meteo.app.domain.model.Employee;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    
    @GetMapping("/dashboard")
    public String adminDashboard(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "管理者ダッシュボード");
        return "admin/dashboard";
    }
    
    @GetMapping("/applications")
    public String applicationsList(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "申請一覧管理");
        return "admin/applications";
    }
    
    @GetMapping("/users")
    public String usersList(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "ユーザー管理");
        return "admin/users";
    }
} 