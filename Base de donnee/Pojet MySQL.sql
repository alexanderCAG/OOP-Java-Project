create database `Company`;
USE `Company`;
CREATE TABLE `Company`.Agency (
	`nameag` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`nameag`)
);
CREATE TABLE `Company`.Job (
	`namejob` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`namejob`)
);
CREATE TABLE `Company`.NewEmployer (
	`namenew` VARCHAR(20) NOT NULL,
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` INT(30) NOT NULL ,
	`job` VARCHAR( 30 ) NOT NULL,
    PRIMARY KEY (`namenew`)
);
CREATE TABLE `Company`.MemberEmployer (
	`namemem` VARCHAR(20) NOT NULL,
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` INT(30) NOT NULL ,
	`job` VARCHAR( 30 ) NOT NULL,
    PRIMARY KEY (`namemem`)
);
CREATE TABLE `Company`.JobSeeker (
	`namesee` VARCHAR(20) NOT NULL,
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` INT(30) NOT NULL ,
	`job` VARCHAR( 30 ) NOT NULL,
    PRIMARY KEY (`namesee`)
);
-- , 1965, '75006 Paris'
INSERT INTO `Company`.Agency ( nameag ) VALUES ('Agence DAG');

INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en robotique');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en domotique');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en drone');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en electromagnetisme');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur');

INSERT INTO `Company`.NewEmployer ( namenew, email, motdepasse, phone, job ) VALUES ('Granier', 'geoffroy.granier@edu.ece.fr', 'dyjs', 0721564966, 'Ingénieur en robotique');
INSERT INTO `Company`.NewEmployer ( namenew, email, motdepasse, phone, job ) VALUES ('Geoffroy', 'geoffroy.granier@edu.ece.fr', 'dyjs', 0615468557, 'Ingénieur en drone');
INSERT INTO `Company`.NewEmployer ( namenew, email, motdepasse, phone, job ) VALUES ('Geo', 'geo.granier@edu.ece.fr', 'dyjs', 0679545685, 'Ingénieur en domotique');
INSERT INTO `Company`.NewEmployer ( namenew, email, motdepasse, phone, job ) VALUES ('Duncan', 'duncan.bidaud@edu.ece.fr', 'dyjs', 0678659655, 'Ingénieur en robotique');
INSERT INTO `Company`.NewEmployer ( namenew, email, motdepasse, phone, job ) VALUES ('Alexander', 'alexanderCAG@edu.ece.fr;', 'dyjs', 0678619856, 'Ingénieur en domotique');

INSERT INTO `Company`.MemberEmployer ( namemem, email, motdepasse, phone, job ) VALUES ('Benoit', 'benoit@edu.ece.fr', 'dyjs', 0645326848, 'Ingénieur en robotique');
INSERT INTO `Company`.MemberEmployer ( namemem, email, motdepasse, phone, job ) VALUES ('Henry', 'henry@edu.ece.fr', 'dyjs', 0645186248, 'Ingénieur en domotique');
INSERT INTO `Company`.MemberEmployer ( namemem, email, motdepasse, phone, job ) VALUES ('Thomas', 'thomas@edu.ece.fr', 'dyjs', 074522252, 'Ingénieur en robotique');
INSERT INTO `Company`.MemberEmployer ( namemem, email, motdepasse, phone, job ) VALUES ('Alexandre', 'alexandre@edu.ece.fr', 'dyjs', 0642226155, 'Ingénieur en robotique');
INSERT INTO `Company`.MemberEmployer ( namemem, email, motdepasse, phone, job ) VALUES ('Aurélien', 'aurelien@edu.ece.fr;', 'dyjs', 067621661, 'Ingénieur en drone');

INSERT INTO `Company`.JobSeeker ( namesee, email, motdepasse, phone, job ) VALUES ('Benjamin', 'benjamin@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en domotique');
INSERT INTO `Company`.JobSeeker ( namesee, email, motdepasse, phone, job ) VALUES ('Tom', 'tom@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en drone');
INSERT INTO `Company`.JobSeeker ( namesee, email, motdepasse, phone, job ) VALUES ('Dorone', 'dorone@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en robotique');
INSERT INTO `Company`.JobSeeker ( namesee, email, motdepasse, phone, job ) VALUES ('Stanislas', 'stanislas@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en robotique');
INSERT INTO `Company`.JobSeeker ( namesee, email, motdepasse, phone, job ) VALUES ('Jacques', 'jacques@edu.ece.fr;', 'dyjs', 0648475265, 'Ingénieur en electromagnetisme');