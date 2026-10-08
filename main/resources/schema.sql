DROP TABLE IF EXISTS student_record;

CREATE TABLE student_record(
    id int auto_increment PRIMARY KEY,
    name varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
    class varchar(2) not null,
    attendance_count int not null,
    ask_leave_count int not null
);