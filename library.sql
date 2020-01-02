create table books(id int, book_name varchar2 (20),isbn int)
create table members(id NUMBER(4), name varchar2(20), email VARCHAR(20),join_date date)
show tables;
desc books
desc members;
insert INTO books values(100,'Harry Potter',1234);
insert INTO books values(101,'Chronicles',1412);
select * from books;
insert into members values(123,'Raj','chinma@h.com',sysdate);
select * from members;
create table lendings(id number(4), member varchar2(20), book varchar2(20), lended_on date);
alter table books modify id int NOT NULL
alter table books add constraint pk_bookid primary key(id)
desc books
alter table members add constraint pk_memberid primary key(id)
alter table lendings add constraint pk_lendid primary key(id)
desc lendings;
desc members;
select * from members;
delete from members

alter table lendings add  CONSTRAINT fk_member FOREIGN KEY (member)
    REFERENCES members(id)
    
    desc lendings
    
    