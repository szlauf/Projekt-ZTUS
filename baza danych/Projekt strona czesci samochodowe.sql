CREATE TABLE `dane_user` (
  `dane_user_id` integer PRIMARY KEY,
  `imie` varchar(255),
  `nazwisko` varchar(255),
  `nr_telefonu` integer,
  `miasto` varchar(255),
  `kod_pocztowy` varchar(255),
  `ulica` varchar(255),
  `nr_mieszkania` varchar(255),
  `email` varchar(255)
);

CREATE TABLE `user` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `login` varchar(255),
  `haslo` varchar(255),
  `dane_user_id` integer UNIQUE
);

CREATE TABLE `ogloszenie` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `tytul` varchar(255),
  `opis` text COMMENT 'opis ogloszenia',
  `user_id` integer UNIQUE,
  `id_modelu` integer,
  `rok_produkcji_samochodu` integer,
  `producent` varchar(255),
  `cena` integer,
  `ilosc` integer
);

CREATE TABLE `zdjecie` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `zdjecie` mediumblob,
  `id_ogloszenia` integer
);

CREATE TABLE `marka` (
  `id` integer PRIMARY KEY,
  `nazwa_marki` varchar(255)
);

CREATE TABLE `model` (
  `id` integer PRIMARY KEY,
  `nazwa_modelu` varchar(255),
  `generacja` varchar(255),
  `id_marki` integer
);

CREATE TABLE `koszyk` (
  `id_user` integer UNIQUE,
  `id_produkty` integer UNIQUE
);

ALTER TABLE `dane_user` ADD FOREIGN KEY (`dane_user_id`) REFERENCES `user` (`dane_user_id`);

ALTER TABLE `ogloszenie` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `model` ADD FOREIGN KEY (`id_marki`) REFERENCES `marka` (`id`);

ALTER TABLE `ogloszenie` ADD FOREIGN KEY (`id_modelu`) REFERENCES `model` (`id`);

ALTER TABLE `zdjecie` ADD FOREIGN KEY (`id_ogloszenia`) REFERENCES `ogloszenie` (`id`);

CREATE TABLE `koszyk_ogloszenie` (
  `koszyk_id_produkty` integer,
  `ogloszenie_id` integer,
  PRIMARY KEY (`koszyk_id_produkty`, `ogloszenie_id`)
);

ALTER TABLE `koszyk_ogloszenie` ADD FOREIGN KEY (`koszyk_id_produkty`) REFERENCES `koszyk` (`id_produkty`);

ALTER TABLE `koszyk_ogloszenie` ADD FOREIGN KEY (`ogloszenie_id`) REFERENCES `ogloszenie` (`id`);


ALTER TABLE `koszyk` ADD FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
