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
CREATE TABLE `Company`.Candidat (
	`idcan` INT AUTO_INCREMENT NOT NULL,
	`lastnamecan` VARCHAR(20) NOT NULL,
    `firstnamecan` VARCHAR(20) NOT NULL,
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` INT NOT NULL ,
	`selection` BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (`idcan`)
);
CREATE TABLE `Company`.Employer (
	`idemp` INT AUTO_INCREMENT NOT NULL,
	`lastnameemp` VARCHAR(20) NOT NULL,
    `firstnameemp` VARCHAR(20) NOT NULL,
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` INT NOT NULL ,
	`job` VARCHAR( 30 ) NOT NULL,
    `sizecompany` VARCHAR( 30 ) NOT NULL,
    `compteur` INT NOT NULL ,
    PRIMARY KEY (`idemp`)
);
CREATE TABLE `Company`.Recruiter (
	`idrec` INT AUTO_INCREMENT NOT NULL,
	`lastnamerec` VARCHAR(20) NOT NULL,
    `firstnamerec` VARCHAR(20) NOT NULL,
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` INT NOT NULL ,
	`job` VARCHAR( 30 ) NOT NULL,
    PRIMARY KEY (`idrec`)
);
CREATE TABLE `Company`.DemandeEmploi (
	`id` INT AUTO_INCREMENT NOT NULL,
	`idcan` INT NOT NULL,
	`metier` VARCHAR(40) NOT NULL,
    `statut` VARCHAR(20) NOT NULL,
	`datedebut` VARCHAR(40) NOT NULL,
    PRIMARY KEY (`id`)
);
-- , 1965, '75006 Paris'
INSERT INTO `Company`.Agency ( nameag ) VALUES ('Agence DAG');

INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en robotique');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en domotique');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en drone');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en electromagnetisme');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur');

INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone, selection ) VALUES ('Granier', 'Geoffroy', 'geoffroy.granier@edu.ece.fr', 'dyjs', 0721564966, true);
INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone, selection ) VALUES ('Boucher', 'Thomas', 'geoffroy.granier@edu.ece.fr', 'dyjs', 0615468557, false);
INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone, selection ) VALUES ('Pelletier', 'Geo', 'geo.granier@edu.ece.fr', 'dyjs', 0679545685, false);
INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone, selection ) VALUES ('Bidaud', 'Duncan', 'duncan.bidaud@edu.ece.fr', 'dyjs', 0678659655, false);
INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone, selection ) VALUES ('Colle-Abbey', 'Alexander', 'alexanderCAG@edu.ece.fr;', 'dyjs', 0678619856, false);

INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Gagnon', 'Benoit', 'benoit@edu.ece.fr', 'dyjs', 0645326848, 'Ingénieur en robotique', 'micro', 1);
INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Duval', 'Henry', 'henry@edu.ece.fr', 'dyjs', 0645186248, 'Ingénieur en domotique', 'micro', 3);
INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Martin', 'Thomas', 'thomas@edu.ece.fr', 'dyjs', 074522252, 'Ingénieur en robotique', 'grande', 4);
INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Archambault', 'Alexandre', 'alexandre@edu.ece.fr', 'dyjs', 0642226155, 'Ingénieur en robotique', 'micro', 8);
INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Tuby', 'Aurélien', 'aurelien@edu.ece.fr;', 'dyjs', 067621661, 'Ingénieur en drone', 'grande', 5);

INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Nivet', 'Benjamin', 'benjamin@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en domotique');
INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Lux', 'Tom', 'tom@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en drone');
INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Gaudet', 'Dorone', 'dorone@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en robotique');
INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Duval', 'Stanislas', 'stanislas@edu.ece.fr', 'dyjs', 0648475265, 'Ingénieur en robotique');
INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Gauthier', 'Jacques', 'jacques@edu.ece.fr;', 'dyjs', 0648475265, 'Ingénieur en electromagnetisme');

INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut ) VALUES (1, 'Ingenieur', 'Etudiant', '13 déc. 2020');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut ) VALUES (1, 'Ingénieur en robotique', 'Etudiant', '1 févr. 2020');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut ) VALUES (2, 'Ingenieur', 'Etudiant', '12 janv. 2020');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut ) VALUES (2, 'Ingenieur', 'Etudiant', '13 déc. 2020');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut ) VALUES (3, 'Ingenieur en domotique', 'Etudiant', '14 déc. 2020');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut ) VALUES (4, 'Ingenieur en electromagnetisme', 'Etudiant', '14 déc. 2020');
