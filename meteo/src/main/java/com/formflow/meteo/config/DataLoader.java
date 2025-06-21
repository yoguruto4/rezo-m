package com.formflow.meteo.config;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.formflow.meteo.app.domain.model.Employee;
import com.formflow.meteo.app.infra.repository.EmployeeRepository;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        // 既存データがある場合はスキップ
        if (employeeRepository.count() > 0) {
            return;
        }
        
        // 管理者ユーザーを作成
        Employee admin = new Employee();
        admin.setNmEmployee("管理者");
        admin.setKnEmployee("かんりしゃ");
        admin.setMailAddress("admin@example.com");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setAdminAuth(1); // 管理者権限
        admin.setIdDepartment(1);
        admin.setEmployeeCreatedAt(LocalDateTime.now());
        
        employeeRepository.save(admin);
        
        // 一般ユーザーを作成
        Employee user = new Employee();
        user.setNmEmployee("山田太郎");
        user.setKnEmployee("やまだたろう");
        user.setMailAddress("user@example.com");
        user.setPassword(passwordEncoder.encode("user123"));
        user.setAdminAuth(0); // 一般ユーザー権限
        user.setIdDepartment(1);
        user.setEmployeeCreatedAt(LocalDateTime.now());
        
        employeeRepository.save(user);
        
        System.out.println("テストデータを作成しました:");
        System.out.println("管理者: admin@example.com / admin123");
        System.out.println("一般ユーザー: user@example.com / user123");
    }
} 