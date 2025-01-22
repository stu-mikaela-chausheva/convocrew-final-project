CREATE TABLE IF NOT EXISTS tr_user_channel_roles (
                                                     id INT AUTO_INCREMENT PRIMARY KEY, -- Unique ID for the relationship
                                                     user_id INT NOT NULL, -- User ID (foreign key)
                                                     channel_id INT NOT NULL, -- Channel ID (foreign key)
                                                     role ENUM('owner', 'admin', 'member') DEFAULT 'member',
    FOREIGN KEY (user_id) REFERENCES td_users(id) ON DELETE CASCADE,
    FOREIGN KEY (channel_id) REFERENCES td_channels(id) ON DELETE CASCADE
    )