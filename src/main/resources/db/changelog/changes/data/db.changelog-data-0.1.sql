--liquibase formatted sql

--changeset munozy:1
insert into ml_book_service.book (id, title, author) values (1000, 'Normal', 'Warren Ellis');
insert into ml_book_service.book (id, title, author) values (1001, 'Planetary 1', 'Warren Ellis');
insert into ml_book_service.book (id, title, author) values (1002, 'Planetary 2', 'Warren Ellis');

--changeset munozy:2
insert into ml_book_service.book (id, title, author) values (1003, 'The Planets 1', 'Andrew Cohen');
insert into ml_book_service.book (id, title, author) values (1004, 'The Planets 2', 'Andrew Cohen');