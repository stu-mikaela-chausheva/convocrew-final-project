package com.convo_crew_project.convocrewproject.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="td_directmessages")
public class DirectMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false) // This is the foreign key
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false) // This is the foreign key
    private User receiver;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public DirectMessage() {
        this.createdAt = LocalDateTime.now(); // Set default creation time
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }




}
