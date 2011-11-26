CREATE DATABASE booklibrarynew

CREATE TABLE booklibrarynew.AUTHORS (
    ID integer AUTO_INCREMENT primary key, 
    VERSION integer, 
    FIRST_NAME VARCHAR(50) not null, 
    LAST_NAME VARCHAR(50) not null, 
    unique(LAST_NAME, FIRST_NAME));
    
CREATE TABLE booklibrarynew.BOOKS (
    ID integer AUTO_INCREMENT primary key, 
    VERSION integer, 
    AUTHOR_ID integer, 
    TITLE VARCHAR(80) not null, 
    unique(AUTHOR_ID, TITLE));

CREATE TABLE booklibrarynew.USERBOOKS (
    USER_ID integer not null,
    BOOK_ID integer not null, 
    unique(USER_ID, BOOK_ID));

CREATE TABLE booklibrarynew.userdetails (
	id integer AUTO_INCREMENT primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    enabled boolean not null,
    unique (username));

create table booklibrarynew.authorities (
    id integer AUTO_INCREMENT primary key,
    username varchar(50) not null,
    authority varchar(50) not null,
    unique(username, authority),
    constraint fk_authorities_userdetails foreign key(username) references userdetails(username));
    
--create unique index ix_auth_username on booklibrarynew.authorities (username, authority);
    
