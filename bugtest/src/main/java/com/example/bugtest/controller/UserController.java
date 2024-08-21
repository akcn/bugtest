package com.example.bugtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

// GET /users/find?username=' OR '1'='1
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/find")
    public List<Map<String, Object>> findUser(@RequestParam String username) {
        // 存在SQL注入风险
        String sql = "SELECT * FROM users WHERE username = '" + username + "'";

        return jdbcTemplate.queryForList(sql);
    }
}
