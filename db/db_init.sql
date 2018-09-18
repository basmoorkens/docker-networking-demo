create database greeting;
use greeting;
create table greeting (  
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  greetername varchar (50),
  greeting varchar (255)
);  
insert into greeting (greetername, greeting) values ('bas', 'Hello master');  
insert into greeting  (greetername, greeting) values ('Jack', 'Hello slave');  

