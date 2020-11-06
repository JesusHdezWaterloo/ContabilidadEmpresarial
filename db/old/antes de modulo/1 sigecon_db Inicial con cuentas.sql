-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:7733
-- Generation Time: Aug 12, 2020 at 05:51 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sigecon_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `cuenta_bancaria`
--

CREATE TABLE `cuenta_bancaria` (
  `id_cuenta_bancaria` int(11) NOT NULL,
  `nombre_cuenta` varchar(100) NOT NULL,
  `numero_cuenta` varchar(16) NOT NULL,
  `pin` varchar(4) NOT NULL,
  `debito` double NOT NULL,
  `credito` double NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `moneda_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cuenta_contable`
--

CREATE TABLE `cuenta_contable` (
  `id_cuenta_contable` int(11) NOT NULL,
  `nombre_cuenta` varchar(100) NOT NULL,
  `debito` double NOT NULL,
  `credito` double NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `tipo_cuenta_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `metodo_pago`
--

CREATE TABLE `metodo_pago` (
  `id_metodo_pago` int(11) NOT NULL,
  `nombre_metodo_pago` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `moneda`
--

CREATE TABLE `moneda` (
  `id_moneda` int(11) NOT NULL,
  `nombre_moneda` varchar(5) NOT NULL,
  `compra` double NOT NULL,
  `venta` double NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subcuenta`
--

CREATE TABLE `subcuenta` (
  `id_subcuenta` int(11) NOT NULL,
  `pociento` float NOT NULL,
  `cuenta_padre_fk` int(11) NOT NULL,
  `cuenta_hijo_fk` int(11) NOT NULL,
  `descripcion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_cuenta`
--

CREATE TABLE `tipo_cuenta` (
  `id_tipo_cuenta` int(11) NOT NULL,
  `nombre_tipo_cuenta` varchar(100) NOT NULL,
  `codigo` varchar(5) NOT NULL,
  `debito_credito` tinyint(1) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_operacion_cuenta`
--

CREATE TABLE `tipo_operacion_cuenta` (
  `id_tipo_operacion` int(11) NOT NULL,
  `nombre_operacion` varchar(100) NOT NULL,
  `key_enum` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  ADD PRIMARY KEY (`id_cuenta_bancaria`),
  ADD UNIQUE KEY `numero_cuenta` (`numero_cuenta`),
  ADD KEY `FK_cuenta_bancaria_moneda` (`moneda_fk`);

--
-- Indexes for table `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  ADD PRIMARY KEY (`id_cuenta_contable`),
  ADD UNIQUE KEY `nombre_cuenta` (`nombre_cuenta`),
  ADD KEY `FK_cuenta_contable_tipo_cuenta` (`tipo_cuenta_fk`);

--
-- Indexes for table `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD PRIMARY KEY (`id_metodo_pago`),
  ADD UNIQUE KEY `nombre_metodo_pago` (`nombre_metodo_pago`);

--
-- Indexes for table `moneda`
--
ALTER TABLE `moneda`
  ADD PRIMARY KEY (`id_moneda`),
  ADD UNIQUE KEY `nombre_moneda` (`nombre_moneda`);

--
-- Indexes for table `subcuenta`
--
ALTER TABLE `subcuenta`
  ADD UNIQUE KEY `UNK_subcuenta_padre_hijo` (`cuenta_padre_fk`,`cuenta_hijo_fk`),
  ADD KEY `FK_subcuenta_cuenta_hijo` (`cuenta_hijo_fk`);

--
-- Indexes for table `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  ADD PRIMARY KEY (`id_tipo_cuenta`),
  ADD UNIQUE KEY `nombre_tipo_cuenta` (`nombre_tipo_cuenta`),
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- Indexes for table `tipo_operacion_cuenta`
--
ALTER TABLE `tipo_operacion_cuenta`
  ADD PRIMARY KEY (`id_tipo_operacion`),
  ADD UNIQUE KEY `nombre_operacion` (`nombre_operacion`),
  ADD UNIQUE KEY `key_enum` (`key_enum`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  MODIFY `id_cuenta_bancaria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  MODIFY `id_cuenta_contable` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `metodo_pago`
--
ALTER TABLE `metodo_pago`
  MODIFY `id_metodo_pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `moneda`
--
ALTER TABLE `moneda`
  MODIFY `id_moneda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  MODIFY `id_tipo_cuenta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tipo_operacion_cuenta`
--
ALTER TABLE `tipo_operacion_cuenta`
  MODIFY `id_tipo_operacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  ADD CONSTRAINT `FK_cuenta_bancaria_moneda` FOREIGN KEY (`moneda_fk`) REFERENCES `moneda` (`id_moneda`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  ADD CONSTRAINT `FK_cuenta_contable_tipo_cuenta` FOREIGN KEY (`tipo_cuenta_fk`) REFERENCES `tipo_cuenta` (`id_tipo_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subcuenta`
--
ALTER TABLE `subcuenta`
  ADD CONSTRAINT `FK_subcuenta_cuenta_hijo` FOREIGN KEY (`cuenta_hijo_fk`) REFERENCES `cuenta_contable` (`id_cuenta_contable`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_subcuenta_cuenta_padre` FOREIGN KEY (`cuenta_padre_fk`) REFERENCES `cuenta_contable` (`id_cuenta_contable`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
