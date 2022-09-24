create table member(
    mb_id varchar2(20) not null,
    mb_pw varchar2(20) not null,
    mb_name varchar2 (12) not null,
    mb_nick varchar2 (20) not null,
    mb_email varchar2(30) not null,
    mb_tel varchar2(15) not null,
    mb_gender varchar2(1) not null,
    constraint mb_id primary key(mb_id)
);

select * from member;

insert into member values ('hyun2', 'a1234', 'hyun', 'hyun', 'hyun@naver.com', '02-1234-5678', 'M');

drop table member;