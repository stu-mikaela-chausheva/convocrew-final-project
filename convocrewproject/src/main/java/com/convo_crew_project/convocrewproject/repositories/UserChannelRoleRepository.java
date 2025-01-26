package com.convo_crew_project.convocrewproject.repositories;

import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.entities.UserChannelRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserChannelRoleRepository extends JpaRepository<UserChannelRole, Long> {

    List<UserChannelRole> findByChannel(Channel channel);

    Optional<UserChannelRole> findByUserAndChannel(User user, Channel channel);

//    Optional<UserChannelRole> findAllByChannel(Channel channel);
}

