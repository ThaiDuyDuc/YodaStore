package com.example.demo.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
@RequestMapping("/test")
public class DatabaseTestController {
    private final DataSource dataSource;

    public DatabaseTestController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/db")
    public String checkDatabaseConnection() {
        try (Connection conn = dataSource.getConnection()) {
            return "✅ Kết nối thành công tới MySQL!";
        } catch (Exception e) {
            return "❌ Lỗi kết nối MySQL: " + e.getMessage();
        }
    }
}
