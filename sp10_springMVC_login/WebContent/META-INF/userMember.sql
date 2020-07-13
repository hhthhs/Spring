select * from emp;
select * from emp where ename='FORD';
desc emp;

drop table guest;
CREATE TABLE guest(
 no NUMBER,  
 name VARCHAR2(20), 
 pwd VARCHAR2(20), 
 email VARCHAR2(30), 
 home VARCHAR2(50), 
 content VARCHAR2(2000), 
 regdate DATE
);
drop SEQUENCE guest_Seq;
CREATE SEQUENCE guest_Seq;



create table UserMember(
		id varchar2(20),
		name varchar2(20),
		pwd varchar2(20),
		email varchar2(30),
		age number
);

select * from usermember;

insert into userMember values('kingsmile','이도연', '1','doyeon@bit.co.kr', 33);
insert into userMember values('kang','강감찬', '1','kang@bit.co.kr', 22);
commit;