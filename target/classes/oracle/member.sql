create table member (
  mid varchar(20) primary key,
  mname varchar(20) not null,
  mpassword varchar(200) not null,
  menabled number(1) not null, /*spring security?��?�� ?��?��*/
  mrole varchar(50) not null /*spring security?��?�� ?��?��*/
);

insert into member values ('admin', '�Ѱ�����', '12345', 1, 'ROLE_ADMIN');
insert into member values ('manager', '������', '$2a$10$vI7tC2h4pDre.YqStwOl5uiT.H2bE/T5IkiZ0bDsWGw9wTgcDdUOa', 1, 'ROLE_MANAGER');
insert into member values ('user', '�����', '64c8cb002682d8136b5aca3e780651023a669c79046616f27659297bb0346027e70ee4ecf0670d21', 1, 'ROLE_USER');
commit;

