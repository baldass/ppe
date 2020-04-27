create table if not exists user
(
    user_id        int not null primary key auto_increment,
    user_name      varchar(100),
    user_sex       varchar(4),
    user_age       integer(3),
    user_phone     VARCHAR(11),
    user_email      VARCHAR(100),
    create_date    TIMESTAMP,
    update_date    TIMESTAMP,
    state      VARCHAR(1)
);