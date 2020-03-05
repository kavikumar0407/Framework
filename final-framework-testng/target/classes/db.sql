create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("naveen", "testing@123"); 



create table userDetails(
firstname varchar(50) not null,
lastname varchar(50),
email varchar(50),
profile varchar(50),
username varchar(50) not null,
password varchar(50) not null,
passwordConfirm varchar(50) not null,
language varchar(50));

insert into userDetails values("manzoor" , "mehadi" , "manzoor@gmail.com", "Teacher", "manzoor_test016", "manzoor" , "manzoor" ,"English");

create table compareUserDetails(
firstname varchar(50) not null,
lastname varchar(50),
email varchar(50),
profile varchar(50),
username varchar(50) not null,
password varchar(50) not null,
passwordConfirm varchar(50) not null,
language varchar(50));

insert into compareUserDetails values("Kavita" , "Kumar" , "kavikumar@gmail.com", "Teacher", "kaviTestUser_001", "password" , "password" ,"English");

delete from userDetails where username = "manzoor_test009";