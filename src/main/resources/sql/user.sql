create table usr(
	_usr_num int primary key,
	_usr_email varchar(128) unique,
	_usr_pw varchar(128)
)

create table post(
	_post_num int primary key,
	_post_title varchar(128),
	_post_content varchar(1024),
	_post_usr varchar(128),
	
	foreign key (_post_usr) references usr(_usr_email)
)

create table img(
	_img_num int primary key,
	_img_name varchar(512),
	_img_location varchar(512),
	_img_source int,

	foreign key (_img_source) references post(_post_num)
)


CREATE SEQUENCE seq
AS int     
START WITH 1 
INCREMENT BY 1       
MINVALUE 1 
MAXVALUE 2147483647  
CACHE
GO


select next value for seq;

INSERT Test.Orders (OrderID, Name, Qty)  
    VALUES (NEXT VALUE FOR Test.CountBy1, 'Tire', 2) ;  

    https://docs.microsoft.com/ko-kr/sql/relational-databases/sequence-numbers/sequence-numbers?view=sql-server-ver15



create table comments(
	comments_id int primary key default(next value for s1),
	usr_id varchar(20),
	comments_content varchar(128),
	reg_date date,
	
	foreign key (usr_id) references usr(usr_id) on delete cascade on update cascade
	
);

create table reply(
	reply_id int,
	usr_id varchar(20),
	comments_id int,
	reply_content varchar(128),
	reply_date date,
	
	foreign key (usr_id) references usr(usr_id) on delete cascade on update cascade,
	foreign key (comments_id) references comments(comments_id) on delete cascade on update cascade
);

create sequence s1 start with 1 minvalue 1 maxvalue 1000 increment by 1 cache 1000 nocycle engine=Aria;

insert into comments (usr_id,comments_content,reg_date) values("admin","test","2020-07-22");




==========================================================================================








CREATE SEQUENCE usr_seq
AS int
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 2147483647
CACHE
GO

CREATE SEQUENCE post_seq
AS int
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 2147483647
CACHE
GO

CREATE SEQUENCE img_seq
AS int
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 2147483647
CACHE
GO


CREATE SEQUENCE comments_seq
AS int
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 2147483647
CACHE
GO



CREATE SEQUENCE reply_seq
AS int
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 2147483647
CACHE
GO


ALTER SEQUENCE Samples.IDLabel
RESTART WITH 1 ;





create table usr(
	_usr_num int primary key,
	_usr_email varchar(128) unique,
	_usr_pw varchar(128)
)


create table post(
	_post_num int primary key,
	_post_title varchar(128),
	_post_content varchar(1024),
	_post_usr varchar(128),

	foreign key (_post_usr) references usr(_usr_email) on delete cascade on update cascade
)


create table img(
	_img_num int primary key,
	_img_name varchar(512),
	_img_location varchar(512),
	_img_source int,

	foreign key (_img_source) references post(_post_num) on delete cascade on update cascade
)

INSERT usr(_usr_num, _usr_email, _usr_pw)
    VALUES (NEXT VALUE FOR usr_seq, 'admin', 'temp123');


select * from usr;




create table comments(
	comments_id int primary key,
	comments_content varchar(128),
	_usr_email varchar(128),
	_post_num int,
	reg_date date,

	foreign key (_post_num) references post(_post_num) on delete cascade on update cascade,
);


create table reply(

    _reply_num int primary key,
	_usr_email varchar(128),
	comments_id int,
	_post_num int,
	reply_content varchar(128),
	reply_date date

	foreign key (_usr_email) references usr(_usr_email) on delete cascade on update cascade,
	foreign key (_post_num) references post(_post_num) on delete cascade on update cascade,
    foreign key (comments_id) references comments(comments_id) on delete cascade on update cascade

);



//https://stackoverflow.com/questions/851625/foreign-key-constraint-may-cause-cycles-or-multiple-cascade-paths?rq=1
SQL 서버는 cascade 경로를 계산할 때 최악의 경로는 에러 메시지를 띄운다.

drop table reply;




//http://blog.naver.com/PostView.nhn?blogId=gmrdud2gh&logNo=221348900456&parentCategoryNo=&categoryNo=13&viewDate=&isShowPopularPosts=false&from=postView
트리거를 이용하여 ROW 삭제


CREATE TRIGGER test
	ON comments AFTER DELETE
	AS
	BEGIN
		DECLARE @comments_id int

		SELECT @comments_id = comments_id FROM deleted

		DELETE FROM reply WHERE comments_id = @comments_id
END
GO


https://lefigaro.tistory.com/7

MSSQL TransactSQL 을 이용한 DML DELETE 트리거 설정
