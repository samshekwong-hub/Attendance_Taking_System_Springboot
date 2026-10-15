DROP TABLE IF EXISTS student_record;

CREATE TABLE student_record(
    id int auto_increment PRIMARY KEY,
    name varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
    student_class varchar(2) not null,
    attendance_count int not null,
    ask_leave_count int not null
);

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       user_id int PRIMARY KEY NOT NULL,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(500) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             id int NOT NULL,
                             CONSTRAINT fk_user FOREIGN KEY (id) REFERENCES users(user_id)
);

ALTER TABLE authorities
ADD PRIMARY KEY (username, authority);

CREATE TABLE roles (
    id int NOT NULL PRIMARY KEY,
    role_name varchar(50) NOT NULL,
    CONSTRAINT fk_roles FOREIGN KEY (id) REFERENCES users(user_id)
);

INSERT INTO users (user_id, username, password, enabled)
VALUES (1,'lui', '$2b$12$wTw07dWwIA2gfXAzrjUFzumgBd9HvEYnvNLetqlPdRQiUNu/Lcozi', true),
       (2,'miku', '$2b$12$hqUe8MW8Ni6uomTiFv5YGuoylJaevmQyYYTGva5YuJfXc.pkPPIA2', true);

INSERT INTO authorities ( username, authority, id)
VALUES ('lui', 'ADMIN', 1),
       ('miku', 'USER', 2);

INSERT INTO roles (id, role_name)
VALUES (1, 'mentor'),
       (2, 'helper');