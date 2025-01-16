CREATE TABLE IF NOT EXISTS td_friends (
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          user_id INT NOT NULL,
                                          friend_id INT NOT NULL,
                                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                          FOREIGN KEY (user_id) REFERENCES td_users(id) ON DELETE CASCADE,
    FOREIGN KEY (friend_id) REFERENCES td_users(id) ON DELETE CASCADE
    );
