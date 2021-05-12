CREATE TABLE author (
    id int primary key auto_increment,
    name varchar(255) not null
);

CREATE TABLE book (
    issn varchar(50) primary key ,
    name varchar(255) not null ,
    author_id int references author
);