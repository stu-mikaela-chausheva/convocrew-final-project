package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entities.Friend;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.repositories.FriendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    public final FriendRepository friendsRepository;

    public FriendService(FriendRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    public boolean addFriend(Friend friends) {
        friendsRepository.save(friends);
        return true;
    }

    public List<Friend> getAllFriendsByLoggedUser(User loggedUser) {
        return friendsRepository.findFriendsByLoggedUser(loggedUser);
    }

}
