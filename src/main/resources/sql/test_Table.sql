use mokaim;

create table test_write(
bno int primary key,
title varchar(30),
story varchar(512)
)

select * from test_image;
select * from test_write with(index(test_idx));

select * from test_write order by bno desc;

delete from test_write;

insert into test_write values(1,'test','test story');

ALTER TABLE test_image ADD bno int; 
ALTER TABLE test_image
   ADD CONSTRAINT fk FOREIGN KEY (bno)
      REFERENCES test_write (bno)
      ON DELETE CASCADE
      ON UPDATE CASCADE;


create index test_idx on test_write(bno desc); 

sp_helpindex test_write;
