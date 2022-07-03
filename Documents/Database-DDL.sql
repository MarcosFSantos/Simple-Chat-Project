create table user(
	id int auto_increment primary key,
    username varchar(20) not null unique,
    password varchar(20) not null
);

create table message(
	id int auto_increment primary key,
    time DateTime not null,
    text varchar(1000) not null,
    user_id int,
    constraint message_user
    foreign key (user_id) references user(id)
)