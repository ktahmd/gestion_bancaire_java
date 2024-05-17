## Getting Started


## Database

create database banque;
use banque;
create table Clients(
id int auto_increment primary key,
nom varchar(50),
prenom varchar(50),
tel varchar(50) ,
email varchar(50),
adress varchar(50),
gender varchar(50),
date_naissance varchar(50) NULL,
pass varchar(50)
);


create table ClientAcc (
Acc_num varchar(50) primary key unique,
client_id int,
balance int,
foreign key (client_id) references Clients(id)
);

create table transfert(
id int auto_increment primary key,
trans_id varchar(50),
fromWho varchar(50),
toWho varchar(50),
date_trans timestamp,
montant int
);


create table admin (
id int auto_increment primary key,
user_name varchar(50),
pass varchar(50),
tel int
);

insert into admin(user_name,pass,tel) values
("admin1","1234",27000032),
("admin2","1212",27000033);

## Sqljar

