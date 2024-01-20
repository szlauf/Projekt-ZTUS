-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 20, 2024 at 04:59 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baza_projekt`
--

-- --------------------------------------------------------

--
-- Table structure for table `dane_user`
--

CREATE TABLE `dane_user` (
  `dane_user_id` int(11) NOT NULL,
  `imie` varchar(255) DEFAULT NULL,
  `nazwisko` varchar(255) DEFAULT NULL,
  `nr_telefonu` int(11) DEFAULT NULL,
  `miasto` varchar(255) DEFAULT NULL,
  `kod_pocztowy` varchar(255) DEFAULT NULL,
  `ulica` varchar(255) DEFAULT NULL,
  `nr_mieszkania` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `dane_user`
--

INSERT INTO `dane_user` (`dane_user_id`, `imie`, `nazwisko`, `nr_telefonu`, `miasto`, `kod_pocztowy`, `ulica`, `nr_mieszkania`, `email`) VALUES
(1, 'Jan', 'Maj', 123123123, 'miasto', '21-3769', 'asd', 'asd', 'asd@asd.asd'),
(3, 'test', 'test', 123, 'test', 'tset', 'tse', '12', 'test@test.test'),
(5, 'asdf', 'asdf', 123, 'asdf', 'asdf', 'asdf', 'asdf', 'asdasdasdas@dasd.dasdas');

-- --------------------------------------------------------

--
-- Table structure for table `koszyk`
--

CREATE TABLE `koszyk` (
  `id_user` int(11) NOT NULL,
  `id_produkty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `koszyk`
--

INSERT INTO `koszyk` (`id_user`, `id_produkty`) VALUES
(1, 1),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `koszyk_ogloszenie`
--

CREATE TABLE `koszyk_ogloszenie` (
  `koszyk_id_produkty` int(11) NOT NULL,
  `ogloszenie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `marka`
--

CREATE TABLE `marka` (
  `id` int(11) NOT NULL,
  `nazwa_marki` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `marka`
--

INSERT INTO `marka` (`id`, `nazwa_marki`) VALUES
(1, 'Toyota'),
(2, 'Ford'),
(3, 'Honda');

-- --------------------------------------------------------

--
-- Table structure for table `model`
--

CREATE TABLE `model` (
  `id` int(11) NOT NULL,
  `nazwa_modelu` varchar(255) DEFAULT NULL,
  `generacja` varchar(255) DEFAULT NULL,
  `id_marki` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `model`
--

INSERT INTO `model` (`id`, `nazwa_modelu`, `generacja`, `id_marki`) VALUES
(1, 'Corolla', 'X', 1),
(2, 'Camry', 'V', 1),
(3, 'Mustang', 'VI', 2),
(4, 'Fusion', 'II', 2),
(5, 'Civic', 'X', 3),
(6, 'Accord', 'X', 3);

-- --------------------------------------------------------

--
-- Table structure for table `oceny`
--

CREATE TABLE `oceny` (
  `oceny_id` int(11) NOT NULL,
  `ocena` int(1) NOT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `oceny`
--

INSERT INTO `oceny` (`oceny_id`, `ocena`, `opis`, `id_user`) VALUES
(1, 4, 'sfsd', 1),
(2, 2, 'sff', 3),
(3, 3, 'ddf', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ogloszenie`
--

CREATE TABLE `ogloszenie` (
  `id` int(11) NOT NULL,
  `tytul` varchar(255) DEFAULT NULL,
  `opis` text DEFAULT NULL COMMENT 'opis ogloszenia',
  `user_id` int(11) DEFAULT NULL,
  `id_modelu` int(11) DEFAULT NULL,
  `rok_produkcji_samochodu` int(11) DEFAULT NULL,
  `producent` varchar(255) DEFAULT NULL,
  `cena` int(11) DEFAULT NULL,
  `ilosc` int(11) DEFAULT NULL,
  `is_archived` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `haslo` varchar(255) DEFAULT NULL,
  `dane_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `login`, `haslo`, `dane_user_id`) VALUES
(1, 'user1', '$2a$10$zP6OgLQehCwmpGyIKoA8aOF/FMHW5mvcG0UvMCaHk1RUmGsbV5q5G', 1),
(3, 'test', '$2a$10$DDwtuZ.7mASqQ5JG/fU4XeL6UAIjaMbuNMqTCfNX7nI2hm/Dv2g7S', 3),
(5, 'asdf', '$2a$10$MhTfVnhEC3X5tab9/wGvyeeTIt/u5rHp88pJBDxrHeEn24jSzsTTO', 5);

-- --------------------------------------------------------

--
-- Table structure for table `user_orders`
--

CREATE TABLE `user_orders` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_ogloszenie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `zdjecie`
--

CREATE TABLE `zdjecie` (
  `id` int(11) NOT NULL,
  `zdjecie` mediumblob DEFAULT NULL,
  `id_ogloszenia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dane_user`
--
ALTER TABLE `dane_user`
  ADD PRIMARY KEY (`dane_user_id`);

--
-- Indexes for table `koszyk`
--
ALTER TABLE `koszyk`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_produkty` (`id_produkty`);

--
-- Indexes for table `koszyk_ogloszenie`
--
ALTER TABLE `koszyk_ogloszenie`
  ADD PRIMARY KEY (`koszyk_id_produkty`,`ogloszenie_id`),
  ADD KEY `ogloszenie_id` (`ogloszenie_id`);

--
-- Indexes for table `marka`
--
ALTER TABLE `marka`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `model`
--
ALTER TABLE `model`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_marki` (`id_marki`);

--
-- Indexes for table `oceny`
--
ALTER TABLE `oceny`
  ADD PRIMARY KEY (`oceny_id`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `ogloszenie`
--
ALTER TABLE `ogloszenie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_modelu` (`id_modelu`),
  ADD KEY `user_id` (`user_id`) USING BTREE;

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dane_user_id` (`dane_user_id`);

--
-- Indexes for table `user_orders`
--
ALTER TABLE `user_orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`,`id_ogloszenie`),
  ADD KEY `id_ogloszenie` (`id_ogloszenie`);

--
-- Indexes for table `zdjecie`
--
ALTER TABLE `zdjecie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ogloszenia` (`id_ogloszenia`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `oceny`
--
ALTER TABLE `oceny`
  MODIFY `oceny_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `ogloszenie`
--
ALTER TABLE `ogloszenie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_orders`
--
ALTER TABLE `user_orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `zdjecie`
--
ALTER TABLE `zdjecie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dane_user`
--
ALTER TABLE `dane_user`
  ADD CONSTRAINT `dane_user_ibfk_1` FOREIGN KEY (`dane_user_id`) REFERENCES `user` (`dane_user_id`);

--
-- Constraints for table `koszyk`
--
ALTER TABLE `koszyk`
  ADD CONSTRAINT `koszyk_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Constraints for table `koszyk_ogloszenie`
--
ALTER TABLE `koszyk_ogloszenie`
  ADD CONSTRAINT `koszyk_ogloszenie_ibfk_1` FOREIGN KEY (`koszyk_id_produkty`) REFERENCES `koszyk` (`id_produkty`),
  ADD CONSTRAINT `koszyk_ogloszenie_ibfk_2` FOREIGN KEY (`ogloszenie_id`) REFERENCES `ogloszenie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `model`
--
ALTER TABLE `model`
  ADD CONSTRAINT `model_ibfk_1` FOREIGN KEY (`id_marki`) REFERENCES `marka` (`id`);

--
-- Constraints for table `oceny`
--
ALTER TABLE `oceny`
  ADD CONSTRAINT `oceny_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ogloszenie`
--
ALTER TABLE `ogloszenie`
  ADD CONSTRAINT `ogloszenie_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `ogloszenie_ibfk_2` FOREIGN KEY (`id_modelu`) REFERENCES `model` (`id`);

--
-- Constraints for table `user_orders`
--
ALTER TABLE `user_orders`
  ADD CONSTRAINT `user_orders_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_orders_ibfk_2` FOREIGN KEY (`id_ogloszenie`) REFERENCES `ogloszenie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `zdjecie`
--
ALTER TABLE `zdjecie`
  ADD CONSTRAINT `zdjecie_ibfk_1` FOREIGN KEY (`id_ogloszenia`) REFERENCES `ogloszenie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
