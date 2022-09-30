create table Member_info(
    mb_id varchar2(20) not null,
    mb_pw varchar2(20) not null,
    mb_name varchar2 (12) not null,
   
    mb_email varchar2(30) not null,
    mb_tel varchar2(15) not null,
    mb_date date not null,
    mb_gender number(1) not null,
    constraint mb_id primary key(mb_id)
);

select * from member_info;

drop table member_info;

insert into member_info values ('admin', '1234', 'admin', 'hyun@naver.com', '02-1234-5678', sysdate , 1);
insert into member_info values ('hyun', 'a1234', 'hyun1', 'hyun@naver.com', '02-1234-5678', sysdate , 1);

