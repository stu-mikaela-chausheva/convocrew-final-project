package com.convo_crew_project.convocrewproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "td_messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text_message", nullable = false)
    private String textMessage;

    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false) // This is the foreign key
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // This is the foreign key
    private User user;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
