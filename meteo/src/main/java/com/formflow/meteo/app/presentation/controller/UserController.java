package com.formflow.meteo.app.presentation.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formflow.meteo.app.domain.model.Employee;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class UserController {
    
    @GetMapping("/dashboard")
    public String userDashboard(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "ダッシュボード");
        return "user/dashboard";
    }
    
    @GetMapping("/applications")
    public String myApplications(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "申請履歴");
        return "user/applications";
    }
    
    @GetMapping("/apply")
    public String applyForm(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "申請書作成");
        return "user/apply";
    }
} 