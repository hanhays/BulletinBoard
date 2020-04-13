create table comments( 
cno number(10) primary key,
bno number(10) references board(bno),
ment varchar2(1000),
menter varchar2(50),
regdate date default sysdate,
updatedate date default sysdate
);

create table attach(
id number(10) primary key,
filename varchar2(500),
bno number(10) references board(bno)
);

create table board(
bno number(10) primary key,
title varchar2(100),
content varchar2(3000),
writer varchar2(50),
regdate date default sysdate,
updatedate date default sysdate,
readcnt number(10) default 0,
root number(5) default 0,
step number(5) default 0,
indent number(5) default 0
);