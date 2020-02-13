--liquibase formatted sql

--changeset munozy:1
create sequence ml_book_service.sequence_book_generator start 1000 increment 1;
create table ml_book_service.book (
    id int8 not null,
    title varchar(255) not null,
    author varchar(255) not null
);
ALTER TABLE ml_book_service.book ADD CONSTRAINT constraint_unique_book_title_author UNIQUE (title, author);
--rollback DROP SEQUENCE ml_book_service.sequence_book_generator     ;
--rollback DROP TABLE ml_book_service.book;