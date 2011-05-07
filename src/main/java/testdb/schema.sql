drop table AUTHORS if exists;
drop table BOOKS if exists;
drop table USERBOOKS if exists;
drop table users if exists;
drop table authorities if exists;
  
CREATE TABLE AUTHORS (
    ID integer identity primary key, 
    VERSION integer, 
    FIRST_NAME VARCHAR(50) not null, 
    LAST_NAME VARCHAR(50) not null, 
    unique(LAST_NAME, FIRST_NAME));
    
CREATE TABLE BOOKS (
    ID integer identity primary key, 
    VERSION integer, 
    AUTHOR_ID integer, 
    TITLE VARCHAR(80) not null, 
    unique(AUTHOR_ID, TITLE));

CREATE TABLE USERBOOKS (
    USERNAME VARCHAR(50) not null primary key,
    BOOK_ID integer not null, 
    unique(USERNAME, BOOK_ID));

CREATE TABLE users (
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled boolean not null);

  create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);