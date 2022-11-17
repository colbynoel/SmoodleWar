CREATE TABLE users
(
    username varchar(50),
    password varbinary(50),
    win int
);

alter table users
add constraint users_username_pk primary key (username);