package com.convo_crew_project.convocrewproject.repositories;

import com.convo_crew_project.convocrewproject.entites.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    List<Channel> findAllByIsPrivateFalse();
}
