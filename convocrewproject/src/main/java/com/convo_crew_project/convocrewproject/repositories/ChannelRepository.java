package com.convo_crew_project.convocrewproject.repositories;

import com.convo_crew_project.convocrewproject.entites.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

//    private JdbcTemplate db;
//
//    public ChannelRepository(JdbcTemplate jdbcTemplate) {
//
//        this.db = jdbcTemplate;
//    }
//
//    public boolean create(Channel channel) {
//        StringBuilder sql = new StringBuilder();
//        sql.append("INSERT INTO td_channels")
//                .append("(name)")
//                .append("VALUES")
//                .append("('")
//                .append(channel.getName())
//                .append("')");
//
//        this.db.execute(sql.toString());
//        return true;
//    }
    List<Channel> findAllByIsPrivateFalse();
//
//    public List<Channel> fetchAll() {
//        StringBuilder sql = new StringBuilder();
//
//        sql.append("SELECT * FROM td_channels where is_private = FALSE");
//
//        return this.db.query(sql.toString(), (RowMapper<Channel>) (rs, rowNum) -> {
//            Channel channel = new Channel();
//            channel.setName(rs.getString("name"));
//
//            return channel;
//        });
//    }
}
