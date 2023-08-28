\c
postgres

\ create database heiclub;

\c
heiclub

create table etudiant
(
    id     serial PRIMARY KEY,
    nom    VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL
);

create table adhesion
(
    id          serial PRIMARY KEY,
    "date"      DATE,
    id_etudiant int references etudiant (id)
);

create table salle
(
    id       serial PRIMARY KEY,
    nom      VARCHAR(50) NOT NULL,
    capacite INT         NOT NULL
);

create table materiel
(
    id  serial PRIMARY KEY,
    nom VARCHAR(50) NOT NULL
);

create table club
(
    id        serial PRIMARY KEY,
    nom       VARCHAR(50) NOT NULL,
    president VARCHAR(50) NOT NULL
);

create table evenement
(
    id      serial PRIMARY KEY,
    nom     VARCHAR(50) NOT NULL,
    "date"  DATE,
    id_club int references club (id)
);


-- relations
create table appartient
(
    id          serial PRIMARY KEY,
    id_club     int references club (id),
    id_etudiant int references etudiant (id)
);

create table utilise
(
    id_club  int references club (id),
    id_salle int references salle (id)
);

create table requiert
(
    id_evenement int references evenement (id),
    id_materiel  int references materiel (id)
);


INSERT INTO etudiant (nom, prenom)
VALUES ('Dupont', 'Sophie'),
       ('Martin', 'Pierre'),
       ('Lefebvre', 'Julie'),
       ('Garcia', 'Antoine'),
       ('Rizzo', 'Maria');

INSERT INTO adhesion ("date", id_etudiant)
VALUES ('2023-08-28', 1),
       ('2023-08-29', 2),
       ('2023-08-30', 3),
       ('2023-08-31', 4),
       ('2023-09-01', 5);

INSERT INTO salle (nom, capacite)
VALUES ('Salle A', 50),
       ('Salle B', 30),
       ('Salle C', 20),
       ('Salle D', 40),
       ('Salle E', 25);


INSERT INTO materiel (nom)
VALUES ('Ordinateur portable'),
       ('Projecteur'),
       ('Microphone'),
       ('Tablette graphique'),
       ('Caméra');

INSERT INTO club (nom, president)
VALUES ('Club de Musique', 'Alice Smith'),
       ('Club de Théâtre', 'Robert Johnson'),
       ('Club de Photographie', 'Emily Brown'),
       ('Club de Science', 'David Lee'),
       ('Club de Danse', 'Sophia Wilson');


