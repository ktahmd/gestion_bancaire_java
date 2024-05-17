# Projet de système bancaire - Projet Java Swing

## Description
Le système bancaire est une application Java Swing qui simule les opérations bancaires de base. Il offre une interface conviviale pour gérer les comptes, les transactions et autres fonctions bancaires essentielles.

## Fonctionnalités
- Connexion en tant qu'administrateur ou client
- Inscription de nouveaux clients
- Transactions de dépôt et de retrait
- Consultation du solde
- Historique des transactions
- Mise à jour des informations du compte
- Interface utilisateur conviviale pour l'administrateur/client avec Java Swing et AWT
- Base de données MYSQL

## Images
![img login](img/login.png)
![img inscrire](img/inscrire.png)
![img GUI_Admin](img/GUI_Admin.png)
![img GUI_client](img/GUI_client.png)
![img liste](img/liste.png)

## Pour commencer
Tout d'abord, vous devez créer les bases de données :

## Base de données

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


## Chemin vers le fichier SQLJAR
Ajoutez de nouveaux fichiers JAR externes sur le chemin de classe à partir de eclipse docier Propriétés > Chemin de construction Java > Bibliothèques > Chemin de classe > Ajouter des fichiers JAR externes.
Les fichiers JAR accompagnent le fichier projet vsbank dans :
vsbank\clanderjar\lib\jcalendar-1.4.jar
vsbank\sqljar\mysql-connector-j-8.4.0.jar

![img path](img/path.png)

## Exécuter l'application
Vous pouvez exécuter l'application sur la classe ApplicationRun.java dans le defaultpakage.
![img str](img/str.png)

