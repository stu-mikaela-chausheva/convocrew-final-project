package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entites.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private JdbcTemplate db;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.db = jdbcTemplate;
    }

    public boolean createUser(User user) {


        StringBuilder sql = new StringBuilder();


        sql.append("INSERT INTO td_users")
                .append("(username, email, password_hash)")
                .append("VALUES")
                .append("('")
                .append(user.getUsername())
                .append("', '")
                .append(user.getEmail())
                .append("', '")
                .append(user.getPassword())
                .append("')");

        this.db.execute(sql.toString());
        return true;
    }
}
