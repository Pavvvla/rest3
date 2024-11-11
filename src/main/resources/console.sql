Create DATABASE sales;

Create table PRODUCTS (
ARTICLE int not null primary key,
PRODUCTS varchar (10)  not null);
Insert into PRODUCTS (ARTICLE, PRODUCTS) VALUES
 (1,'DRESSES'),
 (2,'SKIRTS');

CREATE table ARTICLE(
ARTICLE int not null primary key,
NAME varchar (15) not null);
Insert into ARTICLE (ARTICLE,NAME) VALUES
(1,'Платье 1'),
(1,'Платье 2'),
(1,'Платье 3'),
(2,'Юбка 1'),
(2,'Юбка 2'),
(2,'Юбка 3');

Create table DRESSES (
NAME varchar (15) not null primary key,
BRAND varchar (50) not null);
Insert into DRESSES (NAME, BRAND) VALUES
('Платье 1',  'Vittoria Vici'),
('Платья 2', 'M.Reason'),
('Платья 3','Vittoria Vici');

Create table SKIRTS (
NAME varchar (15) not null primary key,
BRAND varchar (50) not null);
Insert into SKIRTS (NAME, BRAND) VALUES
('Юбка 1', 'Mira Rico'),
('Юбка 2', 'M.Reason'),
('Юбка 3', 'Vittoria Vici');

Create table SALES (
NAME varchar (50) not null primary key,
MANY int not null);
Insert into SALES (NAME, MANY) VALUES
('Платье 1',6500),
('Платье 2',12000),
('Платье 3',9000),
('Юбка 1',4200),
('Юбка 2',3100),
('Юбка 3',5000);

Create table SALES10000 (
NAME varchar (50) not null primary key,
MANY int not null check (MANY<10000));

