create database `Company`;
USE `Company`;

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
	`phone` VARCHAR(20) NOT NULL ,
    PRIMARY KEY (`idcan`)
);
CREATE TABLE `Company`.Employer (
	`idemp` INT AUTO_INCREMENT NOT NULL,
	`lastnameemp` VARCHAR(20) NOT NULL,
    `firstnameemp` VARCHAR(20) NOT NULL,
	`email` VARCHAR(40) NOT NULL,
    `motdepasse` VARCHAR(20) NOT NULL,
	`phone` VARCHAR(20) NOT NULL ,
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
	`phone` VARCHAR(20) NOT NULL ,
	`job` VARCHAR( 30 ) NOT NULL,
    PRIMARY KEY (`idrec`)
);
CREATE TABLE `Company`.DemandeEmploi (
	`id` INT AUTO_INCREMENT NOT NULL,
	`idcan` INT NOT NULL,
	`metier` VARCHAR(40) NOT NULL,
    `statut` VARCHAR(20) NOT NULL,
	`datedebut` VARCHAR(40) NOT NULL,
    `selectionne` VARCHAR(40) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en robotique');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en domotique');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en drone');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur en electromagnetisme');
INSERT INTO `Company`.Job ( namejob ) VALUES ('Ingénieur');

INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone ) VALUES ('Granier', 'Geoffroy', 'geoffroy.granier@edu.ece.fr', 'dyjs', '0721564966');
INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone ) VALUES ('Boucher', 'Thomas', 'thomas.boucher@edu.ece.fr', 'dyjs', '0615468557');
INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone ) VALUES ('Pelletier', 'Geo', 'geo.granier@edu.ece.fr', 'dyjs', '0679545685');
INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone ) VALUES ('Bidaud', 'Duncan', 'duncan.bidaud@edu.ece.fr', 'dyjs', '0678659655');
INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone ) VALUES ('Abbey', 'Alexander', 'alexanderCAG@edu.ece.fr', 'dyjs', '0678619856');

INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Gagnon', 'Benoit', 'benoit@edu.ece.fr', 'dyjs', '0645326848', 'Ingénieur en robotique', 'micro', 1);
INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Duval', 'Henry', 'henry@edu.ece.fr', 'dyjs', '0645186248', 'Ingénieur en domotique', 'micro', 3);
INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Martin', 'Thomas', 'thomas@edu.ece.fr', 'dyjs', '074522252', 'Ingénieur en robotique', 'grande', 4);
INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Archet', 'Alexandre', 'alexanderabbey98@gmail.com', 'dyjs', '0642226155', 'Ingénieur en robotique', 'micro', 8);
INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('Tuby', 'Aurélien', 'aurelien@edu.ece.fr', 'dyjs', '067621661', 'Ingénieur en drone', 'grande', 5);

INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Nivet', 'Benjamin', 'benjamin@edu.ece.fr', 'dyjs', '0648475265', 'Recruteur');
INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Lux', 'Tom', 'tom@edu.ece.fr', 'dyjs', '0648475265', 'Recruteur');
INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Gaudet', 'Dorone', 'dorone@edu.ece.fr', 'dyjs', '0648475265', 'Recruteur');
INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Duval', 'Stan', 'stanislas@edu.ece.fr', 'dyjs', '0648475265', 'Recruteur');
INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('Gauthier', 'Jacques', 'jacques@edu.ece.fr', 'dyjs', '0648475265', 'Recruteur');

INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut, selectionne ) VALUES (1, 'Ingenieur', 'Etudiant', '13 déc. 2020', 2);
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut, selectionne ) VALUES (2, 'Ingénieur en domotique', 'Etudiant', '20 aout. 2020', '');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut, selectionne ) VALUES (2, 'Ingénieur en robotique', 'Etudiant', '1 févr. 2020', '');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut, selectionne ) VALUES (3, 'Ingenieur', 'Etudiant', '12 janv. 2020', '');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut, selectionne ) VALUES (3, 'Ingenieur', 'Etudiant', '13 déc. 2020', '');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut, selectionne ) VALUES (5, 'Ingenieur en domotique', 'Etudiant', '14 déc. 2020', '');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut, selectionne ) VALUES (5, 'Ingenieur en electromagnetisme', 'Etudiant', '14 déc. 2020', '');
INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut, selectionne ) VALUES (5, 'Ingénieur en drone', 'Etudiant', '16 déc. 2020', '');
