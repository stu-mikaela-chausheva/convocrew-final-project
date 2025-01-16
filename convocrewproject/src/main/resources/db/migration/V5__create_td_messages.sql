CREATE TABLE IF NOT EXISTS td_messages (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           text_message TEXT NOT NULL,
                                           channel_id INT NOT NULL,
                                           user_id INT NOT NULL,
                                           FOREIGN KEY (channel_id) REFERENCES td_channels(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES td_users(id) ON DELETE CASCADE
    );
