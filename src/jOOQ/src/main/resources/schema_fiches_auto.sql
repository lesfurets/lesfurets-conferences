DROP TABLE IF EXISTS FICHES_AUTO;
CREATE TABLE FICHES_AUTO (
  id int(11) NOT NULL AUTO_INCREMENT,
  offre_uid varchar(32) NOT NULL,
  creation_date varchar(32) NOT NULL,
  creation_time varchar(32) NOT NULL,
  code_postal char(5),
  telephone varchar(50),
  prenom varchar(100),
  nom varchar(150),
  email varchar(150),
  sexe int(4),
  age int(4),
  csp int(4),
  crm int(6),
  code_sra varchar(7),
  code_postal_vehicule char(5),
  date_achat varchar(32),
  provider varchar(32),
  statut int,
  xml varchar(1024),
  PRIMARY KEY (id)
);

INSERT INTO FICHES_AUTO (offre_uid, creation_date, creation_time, code_postal, telephone, prenom, nom, email, sexe, age, csp, crm, code_sra, code_postal_vehicule, date_achat, provider, statut, xml)
  VALUES ('0001495183264276b2c00000e6b55262', '2017-05-19', '11:43:12', '75011', '0987654321', 'Alex', 'Dub', 'monmail@example.com', 1, 25, 5, 50, 'BMW1000', '75020', '2016-04-18', 'assureur', 100, '<xml>');
