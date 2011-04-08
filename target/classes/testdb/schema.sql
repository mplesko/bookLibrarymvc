drop table AUTHOR if exists;
drop table BOOK if exists;
 
CREATE TABLE AUTHOR (ID integer identity primary key, VERSION integer, FIRST_NAME CHAR(80) not null, LAST_NAME CHAR(80) not null, unique(LAST_NAME, FIRST_NAME));
CREATE TABLE BOOK   (ID integer identity primary key, VERSION integer, AUTHOR_ID integer, TITLE CHAR(80) not null, unique(AUTHOR_ID, TITLE));