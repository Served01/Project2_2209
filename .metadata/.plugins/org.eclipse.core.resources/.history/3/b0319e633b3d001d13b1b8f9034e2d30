create table Review_info(
RV_number number(10) primary key,
RV_bknumber number(8) not null,
RV_id varchar2(20) not null,
RV_date date not null,
RV_score number(1) not null,
RV_content varchar2(1000) null
);

select * from review_info;

create sequence review_num
	start with 1
	increment by 1
	minvalue 1
	maxvalue 1000000000
	cycle;

insert into review_info values(review_num.nextval, 20220001, 'hyun', sysdate, 3, '리뷰1');
insert into review_info values(review_num.nextval, 20220001, 'hyun', sysdate, 4, '리뷰2');
insert into review_info values(review_num.nextval, 20220001, 'hyun2', sysdate, 5,'리뷰3');