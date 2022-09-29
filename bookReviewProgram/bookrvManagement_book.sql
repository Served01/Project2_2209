create table Book_info(
BK_number number(8) primary key,
BK_title varchar2(100) not null,
BK_writer varchar2(100) not null,
BK_publisher varchar2(50) not null,
BK_pubdate date not null,
BK_image varchar2(500) not null,
BK_local number(1) not null,
BK_genre number(2) not null,
BK_ebook number(1) not null,
BK_infodate date not null,
BK_detail varchar2(1000) null,
BK_title_upper varchar2(100) not null
);

select * from book_info;

drop table book_info;

insert into book_info values(20220001, 'JSP교육', '임우성', '초록출판사', '2010-08-09', 'AAA', 0, 6, 0, sysdate, '교육용 책', upper('JSP교육'));
insert into book_info values(20220002, 'JAVA교육', '김남영', '파랑출판사', '2010-08-20', 'bbb', 0, 5, 1, sysdate, '교육용 책2', upper('JAVA교육'));
insert into book_info values(20220003, 'CSS교육', '김경빈', '빨강출판사', '2010-09-03', 'ccc', 0, 4, 0, sysdate, '교육용 책3', upper('CSS교육'));