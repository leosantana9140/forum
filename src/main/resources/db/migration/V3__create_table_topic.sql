CREATE TABLE topic(
    id INTEGER NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    message VARCHAR(300) NOT NULL,
    creation_date DATETIME NOT NULL,
    change_date DATETIME,
    course_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    status VARCHAR(50) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(course_id) REFERENCES course(id),
    FOREIGN KEY(user_id) REFERENCES course(id)
);
