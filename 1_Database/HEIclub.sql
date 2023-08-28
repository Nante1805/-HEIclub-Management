\c postgres

\ create database heiclub;

\c heiclub

create table etudiant (
                          id serial PRIMARY KEY ,
                          nom VARCHAR(50) NOT NULL ,
                          prenom VARCHAR(50) NOT NULL
);

create table adhesion (
                          id serial PRIMARY KEY ,
                          "date" DATE ,
                          id_etudiant int references  etudiant(id)
);

create  table salle (
                        id serial PRIMARY KEY ,
                        nom VARCHAR(50) NOT NULL ,
                        capacite INT NOT NULL
);

create table materiel (
                          id serial PRIMARY KEY ,
                          nom VARCHAR(50) NOT NULL
);

create table club (
                      id serial PRIMARY KEY ,
                      nom VARCHAR(50) NOT NULL ,
                      president VARCHAR(50) NOT NULL
);

create table evenement (
                           id serial PRIMARY KEY ,
                           nom VARCHAR(50) NOT NULL ,
                           "date" DATE ,
                           id_club int references club(id)
);


-- relations
create table appartient (
                            id serial PRIMARY KEY ,
                            id_club int references club(id),
                            id_etudiant int references etudiant(id)
);

create table utilise (
                         id_club int references club(id),
                         id_salle int references salle(id)
);

create table requiert (
                          id_evenement int references evenement(id),
                          id_materiel int references materiel(id)
);


ChatGPT
Voici cinq exemples fictifs de données (mock data) pour chaque entité de votre schéma de base de données :

Table: etudiant

id	nom	prenom
1	Dupont	Jean
2	Martin	Emma
3	Garcia	Lucas
4	Smith	Olivia
5	Nguyen	Liam
Table: adhesion

id	date	id_etudiant
1	2023-01-15	1
2	2023-02-20	2
3	2023-03-10	3
4	2023-04-05	4
5	2023-05-12	5
Table: salle

id	nom	capacite
1	Salle A	50
2	Salle B	30
3	Salle C	80
4	Salle D	20
5	Salle E	100
Table: materiel
| id | nom |
|----|




User
je veux dire en sql
ChatGPT
Je m'excuse pour la confusion. Voici les exemples fictifs de données (mock data) au format SQL pour chaque entité :

Table: etudiant

sql
Copy code
INSERT INTO etudiant (nom, prenom) VALUES
('Dupont', 'Jean'),
('Martin', 'Emma'),
('Garcia', 'Lucas'),
('Smith', 'Olivia'),
('Nguyen', 'Liam');
Table: adhesion

sql
Copy code
INSERT INTO adhesion ("date", id_etudiant) VALUES
('2023-01-15', 1),
('2023-02-20', 2),
('2023-03-10', 3),
('2023-04-05', 4),
('2023-05-12', 5);
Table: salle

sql
Copy code
INSERT INTO salle (nom, capacite) VALUES
('Salle A', 50),
('Salle B', 30),
('Salle C', 80),
('Salle D', 20),
('Salle E', 100);
Table: materiel

sql
Copy code
INSERT INTO materiel (nom) VALUES
('Projecteur'),
('Microphone'),
('Tablette');
Table: club

sql
Copy code
INSERT INTO club (nom, president) VALUES
('Club A', 'Alex'),
('Club B', 'Sophia'),
('Club C', 'Michael'),
('Club D', 'Olivia'),
('Club E', 'William');
Table: evenement

sql
Copy code
INSERT INTO evenement (nom, "date", id_club) VALUES
('Événement 1', '2023-09-01', 1),
('Événement 2', '2023-09-15', 2),
('Événement 3', '2023-10-05', 3),
('Événement 4', '2023-10-20', 4),
('Événement 5', '2023-11-10', 5);
Table: appartient

sql
Copy code
INSERT INTO appartient (id_club, id_etudiant) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
Table: utilise

sql
Copy code
INSERT INTO utilise (id_club, id_salle) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
Table: requiert

sql
Copy code
INSERT INTO requiert (id_evenement, id_materiel) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1),
(5, 2);




