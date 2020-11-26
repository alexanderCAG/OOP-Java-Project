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
<<<<<<< HEAD
	`idnew` VARCHAR(20) NOT NULL,
	`lastnamenew` VARCHAR(20) NOT NULL,
    `firstnamenew` VARCHAR(20) NOT NULL,
=======
	`namenew` VARCHAR(20) NOT NULL,
>>>>>>> affichage
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` INT(30) NOT NULL ,
	`job` VARCHAR( 30 ) NOT NULL,
<<<<<<< HEAD
    PRIMARY KEY (`idnew`)
);
CREATE TABLE `Company`.MemberEmployer (
	`idmem` VARCHAR(20) NOT NULL,
	`lastnamemem` VARCHAR(20) NOT NULL,
    `firstnamemem` VARCHAR(20) NOT NULL,
=======
    PRIMARY KEY (`namenew`)
);
CREATE TABLE `Company`.MemberEmployer (
	`namemem` VARCHAR(20) NOT NULL,
>>>>>>> affichage
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` INT(30) NOT NULL ,
	`job` VARCHAR( 30 ) NOT NULL,
<<<<<<< HEAD
    PRIMARY KEY (`idmem`)
);
CREATE TABLE `Company`.JobSeeker (
	`idsee` VARCHAR(20) NOT NULL,
	`lastnamesee` VARCHAR(20) NOT NULL,
    `firstnamesee` VARCHAR(20) NOT NULL,
=======
    PRIMARY KEY (`namemem`)
);
CREATE TABLE `Company`.JobSeeker (
	`namesee` VARCHAR(20) NOT NULL,
>>>>>>> affichage
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` INT(30) NOT NULL ,
	`job` VARCHAR( 30 ) NOT NULL,
<<<<<<< HEAD
    PRIMARY KEY (`idsee`)
=======
    PRIMARY KEY (`namesee`)
>>>>>>> affichage
);
-- , 1965, '75006 Paris'
INSERT INTO `Company`.Agency ( nameag ) VALUES ('Agence DAG');

INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en robotique');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en domotique');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en drone');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en electromagnetisme');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur');

<<<<<<< HEAD
INSERT INTO `Company`.NewEmployer ( idnew, lastnamenew, firstnamenew, email, motdepasse, phone, job ) VALUES ('N1', 'Granier', 'Geoffroy', 'geoffroy.granier@edu.ece.fr', 'dyjs', 0721564966, 'Ingénieur en robotique');
INSERT INTO `Company`.NewEmployer ( idnew, lastnamenew, firstnamenew, email, motdepasse, phone, job ) VALUES ('N2', 'Boucher', 'Thomas', 'geoffroy.granier@edu.ece.fr', 'dyjs', 0615468557, 'Ingénieur en drone');
INSERT INTO `Company`.NewEmployer ( idnew, lastnamenew, firstnamenew, email, motdepasse, phone, job ) VALUES ('N3', 'Pelletier', 'Geo', 'geo.granier@edu.ece.fr', 'dyjs', 0679545685, 'Ingénieur en domotique');
INSERT INTO `Company`.NewEmployer ( idnew, lastnamenew, firstnamenew, email, motdepasse, phone, job ) VALUES ('N4', 'Bidaud', 'Duncan', 'duncan.bidaud@edu.ece.fr', 'dyjs', 0678659655, 'Ingénieur en robotique');
INSERT INTO `Company`.NewEmployer ( idnew, lastnamenew, firstnamenew, email, motdepasse, phone, job ) VALUES ('N5', 'Colle-Abbey', 'Alexander', 'alexanderCAG@edu.ece.fr;', 'dyjs', 0678619856, 'Ingénieur en domotique');

INSERT INTO `Company`.MemberEmployer ( idmem, lastnamemem, firstnamemem, email, motdepasse, phone, job ) VALUES ('M1', 'Gagnon', 'Benoit', 'benoit@edu.ece.fr', 'dyjs', 0645326848, 'Ingénieur en robotique');
INSERT INTO `Company`.MemberEmployer ( idmem, lastnamemem, firstnamemem, email, motdepasse, phone, job ) VALUES ('M2', 'Duval', 'Henry', 'henry@edu.ece.fr', 'dyjs', 0645186248, 'Ingénieur en domotique');
INSERT INTO `Company`.MemberEmployer ( idmem, lastnamemem, firstnamemem, email, motdepasse, phone, job ) VALUES ('M3', 'Martin', 'Thomas', 'thomas@edu.ece.fr', 'dyjs', 074522252, 'Ingénieur en robotique');
INSERT INTO `Company`.MemberEmployer ( idmem, lastnamemem, firstnamemem, email, motdepasse, phone, job ) VALUES ('M4', 'Archambault', 'Alexandre', 'alexandre@edu.ece.fr', 'dyjs', 0642226155, 'Ingénieur en robotique');
INSERT INTO `Company`.MemberEmployer ( idmem, lastnamemem, firstnamemem, email, motdepasse, phone, job ) VALUES ('M5', 'Tuby', 'Aurélien', 'aurelien@edu.ece.fr;', 'dyjs', 067621661, 'Ingénieur en drone');

INSERT INTO `Company`.JobSeeker ( idsee, lastnamesee, firstnamesee, email, motdepasse, phone, job ) VALUES ('S1', 'Nivet', 'Benjamin', 'benjamin@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en domotique');
INSERT INTO `Company`.JobSeeker ( idsee, lastnamesee, firstnamesee, email, motdepasse, phone, job ) VALUES ('S2', 'Lux', 'Tom', 'tom@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en drone');
INSERT INTO `Company`.JobSeeker ( idsee, lastnamesee, firstnamesee, email, motdepasse, phone, job ) VALUES ('S3', 'Gaudet', 'Dorone', 'dorone@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en robotique');
INSERT INTO `Company`.JobSeeker ( idsee, lastnamesee, firstnamesee, email, motdepasse, phone, job ) VALUES ('S4', 'Duval', 'Stanislas', 'stanislas@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en robotique');
INSERT INTO `Company`.JobSeeker ( idsee, lastnamesee, firstnamesee, email, motdepasse, phone, job ) VALUES ('S5', 'Gauthier', 'Jacques', 'jacques@edu.ece.fr;', 'dyjs', 0648475265, 'Ingénieur en electromagnetisme');
=======
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
>>>>>>> affichage
