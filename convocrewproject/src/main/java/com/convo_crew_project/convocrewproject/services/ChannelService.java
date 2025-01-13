package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entites.Channel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    private JdbcTemplate db;

    public ChannelService(JdbcTemplate jdbcTemplate) {
        this.db = jdbcTemplate;
    }

    public boolean createChannel(Channel channel) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO td_channels")
                .append("(name)")
                .append("VALUES")
                .append("('")
                .append(channel.getName())
                .append("')");

        this.db.execute(sql.toString());
        return true;
    }

    public List<Channel> getAllChannels() {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM td_channels where is_active = TRUE");

        return this.db.query(sql.toString(), (RowMapper<Channel>)  (rs, rowNum) -> {
            Channel channel = new Channel();
            channel.setName(rs.getString("name"));

            return channel;
        });
    }

}
