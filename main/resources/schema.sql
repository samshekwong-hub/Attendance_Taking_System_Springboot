DROP TABLE IF EXISTS student_record;

CREATE TABLE student_record(
    id int auto_increment PRIMARY KEY,
    name varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
    class varchar(2) not null,
    attendance_count int not null,
    ask_leave_count int not null
);

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       username VARCHAR(50) NOT NULL PRIMARY KEY,
                       password VARCHAR(100) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             CONSTRAINT fk_user FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (username, password, enabled)
VALUES ('lui', '$2b$12$wTw07dWwIA2gfXAzrjUFzumgBd9HvEYnvNLetqlPdRQiUNu/Lcozi
$2b$12$hqUe8MW8Ni6uomTiFv5YGuoylJaevmQyYYTGva5YuJfXc.pkPPIA2', true), ('miku', '$2b$12$hqUe8MW8Ni6uomTiFv5YGuoylJaevmQyYYTGva5YuJfXc.pkPPIA2', true);

INSERT INTO authorities (username, authority)
VALUES ('lui', 'ADMIN'),
       ('lui', 'ADMIN'),
       ('miku', 'USER');