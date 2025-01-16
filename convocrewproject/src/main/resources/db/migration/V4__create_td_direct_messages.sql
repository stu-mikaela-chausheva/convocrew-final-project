CREATE TABLE IF NOT EXISTS td_directMessages (
                                                 id INT AUTO_INCREMENT PRIMARY KEY, -- Unique ID for each direct message
                                                 sender_id INT NOT NULL, -- ID of the user sending the message
                                                 receiver_id INT NOT NULL, -- ID of the user receiving the message
                                                 content TEXT NOT NULL, -- The actual message content
                                                 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the message was created
                                                 FOREIGN KEY (sender_id) REFERENCES td_users(id) ON DELETE CASCADE, -- Links sender to users table
    FOREIGN KEY (receiver_id) REFERENCES td_users(id) ON DELETE CASCADE -- Links receiver to users table
    )