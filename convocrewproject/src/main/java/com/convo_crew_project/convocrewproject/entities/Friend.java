package com.convo_crew_project.convocrewproject.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="td_friends")
public class Friend {
//    CREATE TABLE IF NOT EXISTS td_friends (
//            id INT AUTO_INCREMENT PRIMARY KEY,
//            user_id INT NOT NULL,
//            friend_id INT NOT NULL,
//            created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
//            FOREIGN KEY (user_id) REFERENCES td_users(id) ON DELETE CASCADE,
//    FOREIGN KEY (friend_id) REFERENCES td_users(id) ON DELETE CASCADE
//    );
//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // This is the foreign key
    private User loggedUser;

    @ManyToOne
    @JoinColumn(name = "friend_id", nullable = false) // This is the foreign key
    private User friendUser;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Friend() {
        this.createdAt = LocalDateTime.now(); // Set default creation time
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User getFriendUser() {
        return friendUser;
    }

    public void setFriendUser(User friendUser) {
        this.friendUser = friendUser;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
