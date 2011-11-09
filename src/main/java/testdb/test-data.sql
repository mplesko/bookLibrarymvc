insert into AUTHORS (VERSION, FIRST_NAME, LAST_NAME) values (0, 'Gerald', 'Weinberg');
insert into AUTHORS (VERSION, FIRST_NAME, LAST_NAME) values (0, 'Tom', 'DeMarco');
insert into AUTHORS (VERSION, FIRST_NAME, LAST_NAME) values (0, 'Robert', 'Martin');
insert into AUTHORS (VERSION, FIRST_NAME, LAST_NAME) values (0, 'Steve', 'McConnell');
 
insert into BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 0, 'Understanding the Professional Programmer');
insert into BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 0, 'Becoming a Technical Leader');
insert into BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 1, 'Peopleware');
insert into BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 1, 'Waltzing With Bears');
insert into BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 2, 'Clean Code');
insert into BOOKS (VERSION, AUTHOR_ID, TITLE) values (0, 3, 'Code Complete');

insert into userdetails (username, password, enabled) values ('logan', 'logan', true);
insert into userdetails (username, password, enabled) values ('x', 'x', true);
insert into authorities (username, authority) values ('logan', 'ROLE_USER');
insert into authorities (username, authority) values ('x', 'ROLE_USER');

insert into USERBOOKS (USER_ID, BOOK_ID) values (1, 0);