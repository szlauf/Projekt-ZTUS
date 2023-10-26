CREATE TABLE `dane_users` (
  `dane_users_id` integer,
  `imie` varchar(255),
  `nazwisko` varchar(255),
  `nr_telefonu` integer,
  `miasto` varchar(255),
  `kod_pocztowy` varchar(255),
  `ulica` varchar(255),
  `nr_mieszkania` varchar(255),
  `email` varchar(255)
);

CREATE TABLE `users` (
  `id` integer PRIMARY KEY,
  `login` varchar(255),
  `haslo` varchar(255),
  `dane_users_id` integer
);

CREATE TABLE `ogloszenia` (
  `id` integer PRIMARY KEY,
  `tytul` varchar(255),
  `opis` text COMMENT 'opis ogloszenia',
  `user_id` integer,
  `id_modelu` integer,
  `rok_produkcji_samochodu` integer,
  `producent` varchar(255),
  `cena` integer,
  `ilosc` integer
);

CREATE TABLE `zdjecia` (
  `id` integer PRIMARY KEY,
  `zdjecie` filestream,
  `id_ogloszenia` integer
);

CREATE TABLE `marki` (
  `id` integer PRIMARY KEY,
  `nazwa_marki` varchar(255)
);

CREATE TABLE `modele` (
  `id` integer PRIMARY KEY,
  `nazwa_modelu` varchar(255),
  `generacja` varchar(255),
  `id_marki` integer
);

CREATE TABLE `koszyk` (
  `id_user` integer PRIMARY KEY,
  `id_produkty` integer
);

ALTER TABLE `dane_users` ADD FOREIGN KEY (`dane_users_id`) REFERENCES `users` (`dane_users_id`);

ALTER TABLE `ogloszenia` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `marki` ADD FOREIGN KEY (`id`) REFERENCES `modele` (`id_marki`);

ALTER TABLE `modele` ADD FOREIGN KEY (`id`) REFERENCES `ogloszenia` (`id_modelu`);

ALTER TABLE `zdjecia` ADD FOREIGN KEY (`id_ogloszenia`) REFERENCES `ogloszenia` (`id`);

CREATE TABLE `koszyk_ogloszenia` (
  `koszyk_id_produkty` integer,
  `ogloszenia_id` integer,
  PRIMARY KEY (`koszyk_id_produkty`, `ogloszenia_id`)
);

ALTER TABLE `koszyk_ogloszenia` ADD FOREIGN KEY (`koszyk_id_produkty`) REFERENCES `koszyk` (`id_produkty`);

ALTER TABLE `koszyk_ogloszenia` ADD FOREIGN KEY (`ogloszenia_id`) REFERENCES `ogloszenia` (`id`);


ALTER TABLE `users` ADD FOREIGN KEY (`id`) REFERENCES `koszyk` (`id_user`);
