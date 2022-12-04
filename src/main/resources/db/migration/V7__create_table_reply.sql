CREATE TABLE reply(
    id INTEGER NOT NULL AUTO_INCREMENT,
    message VARCHAR(300) NOT NULL,
    creation_date DATETIME NOT NULL,
    topic_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    is_solved BOOLEAN,
    PRIMARY KEY(id),
    FOREIGN KEY(topic_id) REFERENCES topic(id),
    FOREIGN KEY(user_id) REFERENCES user(id)
);
