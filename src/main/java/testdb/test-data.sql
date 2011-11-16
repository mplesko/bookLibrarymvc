insert into booklibrarynew.AUTHORS (VERSION, FIRST_NAME, LAST_NAME) values (0, 'Gerald', 'Weinberg');
insert into booklibrarynew.AUTHORS (VERSION, FIRST_NAME, LAST_NAME) values (0, 'Tom', 'DeMarco');
insert into booklibrarynew.AUTHORS (VERSION, FIRST_NAME, LAST_NAME) values (0, 'Robert', 'Martin');
insert into booklibrarynew.AUTHORS (VERSION, FIRST_NAME, LAST_NAME) values (0, 'Steve', 'McConnell');
 
insert into booklibrarynew.BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 1, 'Understanding the Professional Programmer');
insert into booklibrarynew.BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 1, 'Becoming a Technical Leader');
insert into booklibrarynew.BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 2, 'Peopleware');
insert into booklibrarynew.BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 2, 'Waltzing With Bears');
insert into booklibrarynew.BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 3, 'Clean Code');
insert into booklibrarynew.BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 4, 'Code Complete');

insert into booklibrarynew.userdetails (username, password, enabled) values ('mark', 'mark', true);
insert into booklibrarynew.userdetails (username, password, enabled) values ('logan', 'logan', true);

insert into booklibrarynew.authorities (username, authority) values ('logan', 'ROLE_USER');
insert into booklibrarynew.authorities (username, authority) values ('mark', 'ROLE_USER');

insert into booklibrarynew.USERBOOKS (USER_ID, BOOK_ID) values (1, 1);
insert into booklibrarynew.USERBOOKS (USER_ID, BOOK_ID) values (1, 3);

--

/*
 * 
 */