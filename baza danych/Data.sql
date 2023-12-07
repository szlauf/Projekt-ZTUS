 INSERT INTO user (login, haslo, dane_user_id)
VALUES
  ('user1', '$2a$12$ChN7crcxj3IJq6shn34PQ.Cr1pdmzQaOCLsqZchM3YRE7fzn4GJAW', 1),
  ('user2', '$2a$12$B/x7oKPhbzZ0rd8aDDYPFuHxxdUTAe7Qs9oCqvfOAlwgKCQRIzoOy', 2);

  INSERT INTO dane_user (dane_user_id, imie, nazwisko, nr_telefonu, miasto, kod_pocztowy, ulica, nr_mieszkania, email)
VALUES
  (1, 'Jan', 'Kowalski', 123456789, 'Warszawa', '00-001', 'ul. Prosta', '1A', 'jan.kowalski@example.com'),
  (2, 'Anna', 'Nowak', 987654321, 'Kraków', '30-002', 'ul. Krakowska', '2B', 'anna.nowak@example.com');


  -- Populate marka table
INSERT INTO marka (id, nazwa_marki) VALUES
(1, 'Toyota'),
(2, 'Ford'),
(3, 'Honda');

-- Populate model table
INSERT INTO model (id, nazwa_modelu, generacja, id_marki) VALUES
(1, 'Corolla', 'X', 1),
(2, 'Camry', 'V', 1),
(3, 'Mustang', 'VI', 2),
(4, 'Fusion', 'II', 2),
(5, 'Civic', 'X', 3),
(6, 'Accord', 'X', 3);
