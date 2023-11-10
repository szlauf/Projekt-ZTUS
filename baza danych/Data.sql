 INSERT INTO user (login, haslo, dane_user_id)
VALUES
  ('user1', 'password1', 1),
  ('user2', 'password2', 2);

  INSERT INTO dane_user (dane_user_id, imie, nazwisko, nr_telefonu, miasto, kod_pocztowy, ulica, nr_mieszkania, email)
VALUES
  (1, 'Jan', 'Kowalski', 123456789, 'Warszawa', '00-001', 'ul. Prosta', '1A', 'jan.kowalski@example.com'),
  (2, 'Anna', 'Nowak', 987654321, 'Kraków', '30-002', 'ul. Krakowska', '2B', 'anna.nowak@example.com');
