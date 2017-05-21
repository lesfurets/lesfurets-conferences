DROP TABLE IF EXISTS FICHES_AUTO;
CREATE TABLE FICHES_AUTO (
  id                   INT(11)     NOT NULL AUTO_INCREMENT,
  offre_uid            VARCHAR(32) NOT NULL,
  creation_date        DATE NOT NULL,
  creation_time        VARCHAR(32) NOT NULL,
  code_postal          CHAR(5),
  telephone            VARCHAR(50),
  prenom               VARCHAR(100),
  nom                  VARCHAR(150),
  email                VARCHAR(150),
  sexe                 INT(4),
  age                  INT(4),
  csp                  INT(4),
  crm                  INT(6),
  code_sra             VARCHAR(7),
  code_postal_vehicule CHAR(5),
  date_achat           VARCHAR(32),
  provider             VARCHAR(32),
  statut               INT,
  xml                  VARCHAR(1024),
  PRIMARY KEY (id)
);

INSERT INTO FICHES_AUTO (offre_uid, creation_date, creation_time, code_postal, telephone, prenom, nom, email, sexe, age, csp, crm, code_sra, code_postal_vehicule, date_achat, provider, statut, xml)
VALUES ('0001495183264276b2c00000e6b55262', '2017-05-19', '11:43:12', '75011', '0987654321', 'Alex', 'Dub', 'monmail@example.com', 1, 25, 5, 50, 'BMW1000', '75020', '2016-04-18', 'assureur', 100, '<xml>');

INSERT INTO FICHES_AUTO (offre_uid, creation_date, creation_time, code_postal, telephone, prenom, nom, email, sexe, age, csp, crm, code_sra, code_postal_vehicule, date_achat, provider, statut, xml)
VALUES ('0001495183264276b2c00000e6b55262', '2017-05-19', '11:43:12', '75011', '0987654321', 'Alex', 'Dub', 'monmail@example.com', 1, 25, 5, 50, 'BMW1000', '75020', '2016-04-18', 'assureur', 110, '<xml>');

INSERT INTO FICHES_AUTO (offre_uid, creation_date, creation_time, code_postal, telephone, prenom, nom, email, sexe, age, csp, crm, code_sra, code_postal_vehicule, date_achat, provider, statut, xml)
VALUES ('0001495183264276b2c00000e6b55262', '2017-05-19', '11:43:12', '75011', '0987654321', 'Alex', 'Dub', 'monmail@example.com', 1, 25, 5, 50, 'BMW1000', '75020', '2016-04-18', 'assureur', 111, '<xml>');
