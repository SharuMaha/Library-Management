BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Usagers" (
	"id_usager"	STRING,
	"prenom"	STRING,
	"nom"	STRING,
	"mail"	STRING,
	"id_categorie"	STRING,
	FOREIGN KEY("id_categorie") REFERENCES "Categories"("id_categorie"),
	PRIMARY KEY("id_usager")
);
CREATE TABLE IF NOT EXISTS "Auteurs-Oeuvres" (
	"id_auteur"	STRING,
	"id_oeuvre"	STRING,
	FOREIGN KEY("id_oeuvre") REFERENCES "Oeuvres"("id_oeuvre"),
	FOREIGN KEY("id_auteur") REFERENCES "Auteurs"("id_auteur")
);
CREATE TABLE IF NOT EXISTS "Emprunts" (
	"id_emprunt"	STRING,
	"titre_oeuvre"	STRING,
	"id_livre"	STRING,
	"ISBN"	INTEGER,
	"date_emprunt"	DATE,
	"id_usager"	STRING,
	FOREIGN KEY("id_usager") REFERENCES "Usagers"("id_usager"),
	FOREIGN KEY("id_livre") REFERENCES "LivresPhysiques"("id_livre"),
	PRIMARY KEY("id_emprunt")
);
CREATE TABLE IF NOT EXISTS "Blacklist" (
	"id_blacklist"	STRING,
	"id_usager"	STRING,
	FOREIGN KEY("id_usager") REFERENCES "Usagers"("id_usager"),
	PRIMARY KEY("id_blacklist")
);
CREATE TABLE IF NOT EXISTS "Categories" (
	"id_categorie"	STRING,
	"nb_emprunts_max"	INTEGER,
	"duree_max"	INTEGER,
	PRIMARY KEY("id_categorie")
);
CREATE TABLE IF NOT EXISTS "LivresPhysiques" (
	"id_livre"	STRING,
	"ISBN"	INTEGER,
	FOREIGN KEY("ISBN") REFERENCES "Editions"("ISBN"),
	PRIMARY KEY("id_livre")
);
CREATE TABLE IF NOT EXISTS "Editions" (
	"ISBN"	INTEGER,
	"nom_editeur"	STRING,
	"annee_edition"	INTEGER,
	"id_oeuvre"	STRING,
	FOREIGN KEY("id_oeuvre") REFERENCES "Oeuvres"("id_oeuvre"),
	PRIMARY KEY("ISBN")
);
CREATE TABLE IF NOT EXISTS "Oeuvres" (
	"id_oeuvre"	STRING,
	"titre"	STRING,
	"mots_clés"	STRING,
	PRIMARY KEY("id_oeuvre")
);
CREATE TABLE IF NOT EXISTS "Auteurs" (
	"id_auteur"	STRING,
	"prénom"	STRING,
	"nom"	STRING,
	"annee_naissance"	INTEGER,
	PRIMARY KEY("id_auteur")
);
INSERT INTO "Usagers" VALUES ('us1','Marco','Polo','Mpolo@hotmail.fr','cat1');
INSERT INTO "Usagers" VALUES ('us2','Laurent','Polo','Lp@yahoo.fr','cat2');
INSERT INTO "Auteurs-Oeuvres" VALUES ('aut2','GOT5');
INSERT INTO "Auteurs-Oeuvres" VALUES ('aut2','GOT4');
INSERT INTO "Auteurs-Oeuvres" VALUES ('aut2','GOT3');
INSERT INTO "Auteurs-Oeuvres" VALUES ('aut2','GOT2');
INSERT INTO "Auteurs-Oeuvres" VALUES ('aut2','GOT1');
INSERT INTO "Auteurs-Oeuvres" VALUES ('au1','HP7');
INSERT INTO "Auteurs-Oeuvres" VALUES ('au1','HP6');
INSERT INTO "Auteurs-Oeuvres" VALUES ('au1','HP5');
INSERT INTO "Auteurs-Oeuvres" VALUES ('au1','HP4');
INSERT INTO "Auteurs-Oeuvres" VALUES ('au1','HP3');
INSERT INTO "Auteurs-Oeuvres" VALUES ('au1','HP2');
INSERT INTO "Auteurs-Oeuvres" VALUES ('au1','HP1');
INSERT INTO "Emprunts" VALUES ('em1','L''ecole des sorciers','HP1E1L1',2111,'21/09/18','us1');
INSERT INTO "Categories" VALUES ('cat1',2,5);
INSERT INTO "Categories" VALUES ('cat2',3,6);
INSERT INTO "LivresPhysiques" VALUES ('HP1E1L1',2111);
INSERT INTO "LivresPhysiques" VALUES ('HP1E1L2',2111);
INSERT INTO "Editions" VALUES (2111,'Deviledition',1999,'HP1');
INSERT INTO "Oeuvres" VALUES ('HP1','L''ecole des sorciers','magicien sorcier');
INSERT INTO "Oeuvres" VALUES ('HP2','La chambre des secrets','sorcier magie');
INSERT INTO "Oeuvres" VALUES ('HP3','Le prisonnier d''azkaban','sorcier magicien prison');
INSERT INTO "Oeuvres" VALUES ('HP6','Le prince de sang-mele','HP sorcier magicien');
INSERT INTO "Oeuvres" VALUES ('HP5','L''ordre du phoenix','sorcier ordre');
INSERT INTO "Oeuvres" VALUES ('HP4','La coupe du feu','coupe sorcier');
INSERT INTO "Oeuvres" VALUES ('HP7','Les reliques de la mort','HP sorcier fin');
INSERT INTO "Oeuvres" VALUES ('GOT1','A game of Thrones','politique conspiration');
INSERT INTO "Oeuvres" VALUES ('GOT2','A clash of kings','politique got');
INSERT INTO "Oeuvres" VALUES ('GOT5','A dance with Dragons','GOT Politique');
INSERT INTO "Oeuvres" VALUES ('GOT4','A feast for Crows','GOT politique');
INSERT INTO "Oeuvres" VALUES ('GOT3','A storm of  Swords','GOT politique');
INSERT INTO "Auteurs" VALUES ('au1','JK','Rowling',1965);
INSERT INTO "Auteurs" VALUES ('aut2','George RR','Martin',1948);
COMMIT;
