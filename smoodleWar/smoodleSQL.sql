DROP TABLE users;

DROP TABLE prompts;



CREATE TABLE users
(
    username varchar(50),
    password varbinary(50),
    win int
);

CREATE TABLE prompts
(
    prompt varchar(50)
);

alter table users
add constraint users_username_pk primary key (username);

alter table prompts
add constraint prompts_prompt_pk primary key (prompt);


insert into prompts values ("chicken");
insert into prompts values ("ball");
insert into prompts values ("dog");
insert into prompts values ("elephant");
insert into prompts values ("tree");
insert into prompts values ("tiger");
insert into prompts values ("city");
insert into prompts values ("flower");
insert into prompts values ("alligator");
insert into prompts values ("dolphin");
insert into prompts values ("fish");
insert into prompts values ("shark");
insert into prompts values ("snowman");
insert into prompts values ("santa");
insert into prompts values ("pumpkin");

