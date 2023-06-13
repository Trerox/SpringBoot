-- liquibase formatted sql
-- changeset liquibase:1
CREATE TABLE klient (
  id serial not null PRIMARY KEY,
  imie_i_nazwisko VARCHAR(255),
  email VARCHAR(255)
);
-- changeset liquibase:2
CREATE TABLE koszyk (
  id serial not null PRIMARY KEY,
  nazwa_koszyka VARCHAR(255),
  klient_id int not null,
  FOREIGN KEY (klient_id) REFERENCES klient(id)
);
-- changeset liquibase:3
CREATE TABLE produkt (
  id serial not null PRIMARY KEY,
  nazwa_produktu VARCHAR(255),
  jednostka_miary VARCHAR(255)
);
-- changeset liquibase:4
CREATE TABLE produktwkoszyku (
  id serial not null PRIMARY KEY,
  produkt_id int not null,
  koszyk_id int not null,
  FOREIGN KEY (produkt_id) REFERENCES produkt(id),
  FOREIGN KEY (koszyk_id) REFERENCES koszyk(id)
);
-- changeset liquibase:5
ALTER TABLE produkt ADD opis VARCHAR(255)

-- changeset liquibase:6
CREATE TABLE komentarz (
 id serial not null PRIMARY KEY,
 autor VARCHAR(255) NOT NULL,
 tresc TEXT NOT NULL,
 produkt_id int,
 FOREIGN KEY (produkt_id) REFERENCES produkt(id)
);