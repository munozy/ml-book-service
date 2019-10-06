--liquibase formatted sql

--changeset munozy:1
create sequence ml_book_service.seq_book start 1000 increment 1;
create table ml_book_service.book (
    id int8 not null,
    title varchar(255) not null,
    author varchar(255) not null
);
ALTER TABLE ml_book_service.book ADD CONSTRAINT constraint_unique_book_title_author UNIQUE (title, author);
insert into ml_book_service.book (id, title, author) values (1000, 'Normal', 'Warren Ellis');
--rollback DROP SEQUENCE ml_book_service.seq_book ;
--rollback DROP TABLE ml_book_service.book;