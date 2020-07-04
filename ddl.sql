CREATE TABLE
    user_info
    (
        user_id VARCHAR(32) NOT NULL,
        pass_word VARCHAR(32) NOT NULL,
        tel VARCHAR(32),
        email VARCHAR(128),
        name VARCHAR(32),
        sex VARCHAR(2),
        input_Date VARCHAR(16),
        user_type VARCHAR(10),
        PRIMARY KEY (user_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_c