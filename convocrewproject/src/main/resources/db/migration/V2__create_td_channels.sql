CREATE TABLE IF NOT EXISTS td_channels (
                                           id INT AUTO_INCREMENT PRIMARY KEY, -- Unique channel ID
                                           name VARCHAR(100) NOT NULL, -- Channel or server name
    is_private BOOLEAN DEFAULT FALSE
    );