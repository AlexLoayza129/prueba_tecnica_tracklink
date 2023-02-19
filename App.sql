CREATE DATABASE tracking_db;
USE tracking_db;

-- Creación de tablas
CREATE TABLE dbo.envelope(
	id int, 
	user_id int
);

CREATE TABLE dbo.docs(
	idnum int, 
	pageseq int, 
	doctext varchar(100)
);

CREATE TABLE dbo.users(
	id int IDENTITY (1,1)
,	username varchar(150) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE dbo.training_details(
	user_training_id int PRIMARY KEY IDENTITY (1,1),
	user_id int NOT NULL,
	training_id int NOT NULL,
	training_date date NOT NULL
);

-- Inserción de datos
INSERT INTO dbo.envelope VALUES
  (1,1),
  (2,2),
  (3,3);

INSERT INTO dbo.docs(idnum,pageseq) VALUES
  (1,5),
  (2,6),
  (null,0);

INSERT INTO dbo.users(username) VALUES 
	('John Doe'),
	('Jane Don'), 
	('Alice Jones'), 
	('Lisa Romero');

INSERT INTO dbo.training_details (user_id, training_id, training_Date) VALUES
	(1, 1, '2015-08-02'),
	(2, 1, '2015-08-03'),
	(3, 2, '2015-08-02'),
	(4, 2, '2015-08-04'),
	(2, 2, '2015-08-03'),
	(1, 1, '2015-08-02'),
	(3, 2, '2015-08-04'),
	(4, 3, '2015-08-03'),
	(1, 4, '2015-08-03'),
	(3, 1, '2015-08-02'),
	(4, 2, '2015-08-04'),
	(3, 2, '2015-08-02'),
	(1, 1, '2015-08-02'),
	(4, 3, '2015-08-03');


UPDATE docs SET doctext=pageseq FROM docs INNER JOIN envelope ON envelope.id=docs.idnum
WHERE EXISTS (
  SELECT 1 FROM dbo.docs
  WHERE id=envelope.id);


SELECT user_id, training_id, training_date FROM dbo.training_details GROUP BY user_id, training_id, training_date HAVING COUNT(user_id) >1;