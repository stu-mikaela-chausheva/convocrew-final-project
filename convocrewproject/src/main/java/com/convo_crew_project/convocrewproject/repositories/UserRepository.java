package com.convo_crew_project.convocrewproject.repositories;

import com.convo_crew_project.convocrewproject.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//
//    private JdbcTemplate db;
//
//    // Dependecy injection
//    public UserRepository(JdbcTemplate db) {
//        this.db = db;
//    }
//
//    public boolean create(User user) {
//
//        StringBuilder sql = new StringBuilder();
//
//
//        sql.append("INSERT INTO td_users")
//                .append("(username, email, password_hash)")
//                .append("VALUES")
//                .append("('")
//                .append(user.getUsername())
//                .append("', '")
//                .append(user.getEmail())
//                .append("', '")
//                .append(user.getPassword())
//                .append("')");
//
//        this.db.execute(sql.toString());
//        return true;
//    }
}
