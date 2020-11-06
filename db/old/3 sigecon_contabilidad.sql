-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:7733
-- Generation Time: Sep 30, 2020 at 05:52 AM
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
-- Database: `sigecon_contabilidad`
--

-- --------------------------------------------------------

--
-- Table structure for table `cuadre`
--

CREATE TABLE `cuadre` (
  `id_cuadre` int(11) NOT NULL,
  `operacion_contable_fk` int(11) NOT NULL,
  `operacion_contable_cuadre_fk` int(11) NOT NULL,
  `liquidada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cuadre`
--

INSERT INTO `cuadre` (`id_cuadre`, `operacion_contable_fk`, `operacion_contable_cuadre_fk`, `liquidada`) VALUES
(155, 319, 318, 0),
(157, 322, 323, 1),
(158, 325, 324, 1),
(159, 327, 326, 0);

-- --------------------------------------------------------

--
-- Table structure for table `cuenta_bancaria`
--

CREATE TABLE `cuenta_bancaria` (
  `id_cuenta_bancaria` int(11) NOT NULL,
  `nombre_cuenta` varchar(100) NOT NULL,
  `numero_cuenta` varchar(16) NOT NULL,
  `numero_tarjeta` varchar(16) NOT NULL,
  `pin` varchar(4) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `debito` decimal(19,4) NOT NULL,
  `credito` decimal(19,4) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `moneda_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cuenta_bancaria`
--

INSERT INTO `cuenta_bancaria` (`id_cuenta_bancaria`, `nombre_cuenta`, `numero_cuenta`, `numero_tarjeta`, `pin`, `codigo`, `debito`, `credito`, `descripcion`, `moneda_fk`) VALUES
(16, 'Banco CUP', '0598712105645312', '922495987018', '1064', '110-1', '123.4700', '123.4700', 'Tarjeta en moneda nacional\n	- Se cobra la CUJAE', 10),
(17, 'Banco MLC', '0598743017587531', '9225959871865041', '1064', '110-2', '5.0000', '5.0000', 'Tarjeta en MLC.', 12);

-- --------------------------------------------------------

--
-- Table structure for table `cuenta_contable`
--

CREATE TABLE `cuenta_contable` (
  `id_cuenta_contable` int(11) NOT NULL,
  `nombre_cuenta` varchar(100) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `debito` decimal(19,4) NOT NULL,
  `credito` decimal(19,4) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `tipo_cuenta_fk` int(11) NOT NULL,
  `moneda_fk` int(11) NOT NULL,
  `titular_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cuenta_contable`
--

INSERT INTO `cuenta_contable` (`id_cuenta_contable`, `nombre_cuenta`, `codigo`, `debito`, `credito`, `descripcion`, `tipo_cuenta_fk`, `moneda_fk`, `titular_fk`) VALUES
(30, 'Billetera MN', '101 - 1', '21.0000', '0.0000', 'Dinero que tengo arriba en la billetera', 17, 10, 28),
(31, 'Inversiones MN', '102 - 1', '250.0000', '0.0000', 'Dinero por concepto de inversiones', 17, 10, 28),
(32, 'Ingresos MN', '950 - 1', '0.0000', '394.4700', 'Cuenta de ingresos para cuadre', 14, 10, 28),
(33, 'Gastos MN', '865 - 1', '0.0000', '0.0000', 'Cuenta de gastos para cuadres', 15, 10, 28),
(34, 'Cuenta por cobrar MLC', '340 - 2', '0.0000', '0.0000', 'Cuenta por cobrar en MLC, para cuadre con ingresos y demás', 12, 12, 29),
(35, 'Ingresos MLC', '950 - 2', '0.0000', '5.0000', 'Ingresos en MLC', 14, 12, 28),
(36, 'Gastos MLC', '865 - 2', '0.0000', '0.0000', 'Gastos en MLC', 15, 12, 28),
(37, 'Cuenta por cobrar MN', '340 - 1', '0.0000', '0.0000', '', 12, 10, 28),
(39, 'Billetera MLC', '101 - 2', '0.0000', '0.0000', '', 17, 12, 28),
(40, 'Inversiones MLC', '102 - 2', '0.0000', '0.0000', '', 17, 12, 28),
(41, 'Cuenta por pagar MN', '406 - 1', '0.0000', '0.0000', '', 13, 10, 28),
(42, 'Cuenta por pagar MLC', '406 - 2', '0.0000', '0.0000', '', 13, 12, 28),
(43, 'Gastos Admin MN', '823 - 1', '0.0000', '0.0000', '', 16, 10, 28),
(44, 'Gastos Admin MLC', '823 - 2', '0.0000', '0.0000', '', 16, 12, 28);

-- --------------------------------------------------------

--
-- Table structure for table `forma_pago`
--

CREATE TABLE `forma_pago` (
  `id_forma_pago` int(11) NOT NULL,
  `nombre_forma_pago` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `forma_pago`
--

INSERT INTO `forma_pago` (`id_forma_pago`, `nombre_forma_pago`, `descripcion`) VALUES
(6, 'Efectivo', ''),
(7, 'Cheque', ''),
(8, 'Transferencia', '');

-- --------------------------------------------------------

--
-- Table structure for table `info_operacion_contable`
--

CREATE TABLE `info_operacion_contable` (
  `id_info_operacion_contable` int(11) NOT NULL,
  `documento` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fecha` date NOT NULL DEFAULT current_timestamp(),
  `descripcion` varchar(500) NOT NULL,
  `forma_pago_fk` int(11) NOT NULL,
  `tipo_operacion_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `info_operacion_contable`
--

INSERT INTO `info_operacion_contable` (`id_info_operacion_contable`, `documento`, `nombre`, `fecha`, `descripcion`, `forma_pago_fk`, `tipo_operacion_fk`) VALUES
(166, '-', 'Saldo inicial Inversiones', '2020-09-29', 'Digitalización de la cuenta de inversiones, con un saldo inicial de 250MN. De los cuales 100$ estan destinados para los llaveros de harry potter de YK, pero momentaneamente estan aqui', 6, 17),
(168, '-', 'Saldo inicial MLC', '2020-09-29', '', 7, 17),
(169, '-', 'Saldo inicial Tarjeta', '2020-09-29', '', 8, 18),
(170, '-', 'Saldo inicial Billetera', '2020-09-29', '', 6, 17);

-- --------------------------------------------------------

--
-- Table structure for table `liquidacion`
--

CREATE TABLE `liquidacion` (
  `id_liquidacion` int(11) NOT NULL,
  `documento` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `debito` decimal(19,4) NOT NULL,
  `credito` decimal(19,4) NOT NULL,
  `fecha` date NOT NULL DEFAULT current_timestamp(),
  `descripcion` varchar(500) NOT NULL,
  `cuenta_fk` int(11) NOT NULL,
  `cuadre_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `liquidacion`
--

INSERT INTO `liquidacion` (`id_liquidacion`, `documento`, `nombre`, `debito`, `credito`, `fecha`, `descripcion`, `cuenta_fk`, `cuadre_fk`) VALUES
(45, '-', 'Saldo inicial Tarjeta', '123.4700', '0.0000', '2020-09-29', '', 16, 158),
(46, '-', 'Saldo inicial MLC', '5.0000', '0.0000', '2020-09-29', '', 17, 157);

-- --------------------------------------------------------

--
-- Table structure for table `moneda`
--

CREATE TABLE `moneda` (
  `id_moneda` int(11) NOT NULL,
  `nombre_moneda` varchar(5) NOT NULL,
  `compra` decimal(19,9) NOT NULL,
  `venta` decimal(19,9) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `moneda`
--

INSERT INTO `moneda` (`id_moneda`, `nombre_moneda`, `compra`, `venta`, `descripcion`) VALUES
(10, 'MN', '1.000000000', '1.000000000', 'Moneda nacional'),
(11, 'CUC', '25.000000000', '24.000000000', ''),
(12, 'USD', '33.750000000', '25.000000000', 'Compra a 1.35');

-- --------------------------------------------------------

--
-- Table structure for table `operacion_contable`
--

CREATE TABLE `operacion_contable` (
  `id_operacion_contable` int(11) NOT NULL,
  `debito` decimal(19,4) NOT NULL,
  `credito` decimal(19,4) NOT NULL,
  `cuenta_fk` int(11) NOT NULL,
  `info_operacion_contable_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `operacion_contable`
--

INSERT INTO `operacion_contable` (`id_operacion_contable`, `debito`, `credito`, `cuenta_fk`, `info_operacion_contable_fk`) VALUES
(318, '250.0000', '0.0000', 31, 166),
(319, '0.0000', '250.0000', 32, 166),
(322, '0.0000', '5.0000', 35, 168),
(323, '5.0000', '0.0000', 34, 168),
(324, '123.4700', '0.0000', 37, 169),
(325, '0.0000', '123.4700', 32, 169),
(326, '21.0000', '0.0000', 30, 170),
(327, '0.0000', '21.0000', 32, 170);

-- --------------------------------------------------------

--
-- Table structure for table `subcuenta`
--

CREATE TABLE `subcuenta` (
  `id_subcuenta` int(11) NOT NULL,
  `pociento` float NOT NULL,
  `cuenta_padre_fk` int(11) NOT NULL,
  `cuenta_hijo_fk` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_cuenta`
--

CREATE TABLE `tipo_cuenta` (
  `id_tipo_cuenta` int(11) NOT NULL,
  `nombre_tipo_cuenta` varchar(100) NOT NULL,
  `debito_credito` tinyint(1) NOT NULL,
  `liquidable` tinyint(1) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tipo_cuenta`
--

INSERT INTO `tipo_cuenta` (`id_tipo_cuenta`, `nombre_tipo_cuenta`, `debito_credito`, `liquidable`, `descripcion`) VALUES
(12, 'Cuenta por cobrar', 1, 1, ''),
(13, 'Cuenta por pagar', 0, 1, ''),
(14, 'Ingreso', 0, 0, ''),
(15, 'Gasto', 1, 0, ''),
(16, 'Gasto Admin', 0, 1, ''),
(17, 'Caja', 1, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_operacion_contable`
--

CREATE TABLE `tipo_operacion_contable` (
  `id_tipo_operacion` int(11) NOT NULL,
  `nombre_operacion` varchar(100) NOT NULL,
  `key_enum` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `tipo_cuenta_defecto_fk` int(11) NOT NULL,
  `tipo_cuenta_cuadre_defecto_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tipo_operacion_contable`
--

INSERT INTO `tipo_operacion_contable` (`id_tipo_operacion`, `nombre_operacion`, `key_enum`, `descripcion`, `tipo_cuenta_defecto_fk`, `tipo_cuenta_cuadre_defecto_fk`) VALUES
(14, 'Gasto Admin', 'caf10f7599bebed08560555aabb8a1dcb70223e93a2aa842a3f1a4b503fd9a52', '', 15, 16),
(16, 'Movimiento Interno', 'e48f19be94045d68fe59b9b8020d35e40b27f211ba05ae190870634a3efed0fd', '', 14, 17),
(17, 'Ingreso Neto', '073dd2fe9f3b6a20121173f688c576f6abfbd408d10c40170c3476096253b104', '', 14, 17),
(18, 'Ingreso por cobrar', 'a61cf1869c90e36427308c4d02d4faf4ebdf7034b43b6b63e5b08eddd8b185d6', '', 14, 12),
(19, 'Gasto por pagar', 'e6339e14f8a61fa16e3eb1b6835d7b5be650e1ddb285c597f967818f550cea8e', '', 15, 16);

-- --------------------------------------------------------

--
-- Table structure for table `titular`
--

CREATE TABLE `titular` (
  `id_titular` int(11) NOT NULL,
  `nombre_titular` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `titular`
--

INSERT INTO `titular` (`id_titular`, `nombre_titular`, `descripcion`) VALUES
(28, 'Interna', 'Cuentas que me pertenecen'),
(29, 'Noemí', 'Cuentas que le pertenecen a noemi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cuadre`
--
ALTER TABLE `cuadre`
  ADD PRIMARY KEY (`id_cuadre`),
  ADD UNIQUE KEY `operacion_contable_fk` (`operacion_contable_fk`),
  ADD UNIQUE KEY `operacion_contable_cuadre_fk` (`operacion_contable_cuadre_fk`);

--
-- Indexes for table `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  ADD PRIMARY KEY (`id_cuenta_bancaria`),
  ADD UNIQUE KEY `numero_cuenta` (`numero_cuenta`),
  ADD UNIQUE KEY `UNIQUE_cuenta_bancaria_codigo` (`codigo`),
  ADD UNIQUE KEY `UNIQUE_cuenta_bancaria_nombre` (`nombre_cuenta`),
  ADD UNIQUE KEY `numero_tarjeta` (`numero_tarjeta`),
  ADD KEY `FK_cuenta_bancaria_moneda` (`moneda_fk`);

--
-- Indexes for table `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  ADD PRIMARY KEY (`id_cuenta_contable`),
  ADD UNIQUE KEY `nombre_cuenta` (`nombre_cuenta`),
  ADD UNIQUE KEY `UNIQUE_codigo_cuenta_titular` (`codigo`,`tipo_cuenta_fk`,`titular_fk`),
  ADD KEY `FK_cuenta_contable_tipo_cuenta` (`tipo_cuenta_fk`),
  ADD KEY `FK_cuenta_contable_moneda` (`moneda_fk`) USING BTREE,
  ADD KEY `FK_cuenta_contable_titular` (`titular_fk`);

--
-- Indexes for table `forma_pago`
--
ALTER TABLE `forma_pago`
  ADD PRIMARY KEY (`id_forma_pago`),
  ADD UNIQUE KEY `nombre_metodo_pago` (`nombre_forma_pago`);

--
-- Indexes for table `info_operacion_contable`
--
ALTER TABLE `info_operacion_contable`
  ADD PRIMARY KEY (`id_info_operacion_contable`),
  ADD KEY `FK_info_op_tipo_operacion` (`tipo_operacion_fk`),
  ADD KEY `FK_info_op_tipo_pago` (`forma_pago_fk`);

--
-- Indexes for table `liquidacion`
--
ALTER TABLE `liquidacion`
  ADD PRIMARY KEY (`id_liquidacion`),
  ADD UNIQUE KEY `cuadre_fk` (`cuadre_fk`),
  ADD KEY `FK_liquidacion_cuenta_bancaria` (`cuenta_fk`);

--
-- Indexes for table `moneda`
--
ALTER TABLE `moneda`
  ADD PRIMARY KEY (`id_moneda`),
  ADD UNIQUE KEY `nombre_moneda` (`nombre_moneda`);

--
-- Indexes for table `operacion_contable`
--
ALTER TABLE `operacion_contable`
  ADD PRIMARY KEY (`id_operacion_contable`),
  ADD KEY `FK_operacion_contable_cuenta_contable` (`cuenta_fk`),
  ADD KEY `FK_operacion_contable_info_operacion_contable` (`info_operacion_contable_fk`);

--
-- Indexes for table `subcuenta`
--
ALTER TABLE `subcuenta`
  ADD PRIMARY KEY (`id_subcuenta`),
  ADD UNIQUE KEY `UNK_subcuenta_padre_hijo` (`cuenta_padre_fk`,`cuenta_hijo_fk`),
  ADD KEY `FK_subcuenta_cuenta_hijo` (`cuenta_hijo_fk`);

--
-- Indexes for table `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  ADD PRIMARY KEY (`id_tipo_cuenta`),
  ADD UNIQUE KEY `nombre_tipo_cuenta` (`nombre_tipo_cuenta`);

--
-- Indexes for table `tipo_operacion_contable`
--
ALTER TABLE `tipo_operacion_contable`
  ADD PRIMARY KEY (`id_tipo_operacion`),
  ADD UNIQUE KEY `nombre_operacion` (`nombre_operacion`),
  ADD UNIQUE KEY `key_enum` (`key_enum`),
  ADD KEY `FK_tipo_op_tipo_cuenta_cuadre_def` (`tipo_cuenta_cuadre_defecto_fk`),
  ADD KEY `FK_tipo_op_tipo_cuenta_def` (`tipo_cuenta_defecto_fk`);

--
-- Indexes for table `titular`
--
ALTER TABLE `titular`
  ADD PRIMARY KEY (`id_titular`),
  ADD UNIQUE KEY `nombre_titular` (`nombre_titular`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cuadre`
--
ALTER TABLE `cuadre`
  MODIFY `id_cuadre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=160;

--
-- AUTO_INCREMENT for table `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  MODIFY `id_cuenta_bancaria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  MODIFY `id_cuenta_contable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `forma_pago`
--
ALTER TABLE `forma_pago`
  MODIFY `id_forma_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `info_operacion_contable`
--
ALTER TABLE `info_operacion_contable`
  MODIFY `id_info_operacion_contable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=171;

--
-- AUTO_INCREMENT for table `liquidacion`
--
ALTER TABLE `liquidacion`
  MODIFY `id_liquidacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `moneda`
--
ALTER TABLE `moneda`
  MODIFY `id_moneda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `operacion_contable`
--
ALTER TABLE `operacion_contable`
  MODIFY `id_operacion_contable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=328;

--
-- AUTO_INCREMENT for table `subcuenta`
--
ALTER TABLE `subcuenta`
  MODIFY `id_subcuenta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  MODIFY `id_tipo_cuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `tipo_operacion_contable`
--
ALTER TABLE `tipo_operacion_contable`
  MODIFY `id_tipo_operacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `titular`
--
ALTER TABLE `titular`
  MODIFY `id_titular` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cuadre`
--
ALTER TABLE `cuadre`
  ADD CONSTRAINT `FK_cuadre_operacion` FOREIGN KEY (`operacion_contable_cuadre_fk`) REFERENCES `operacion_contable` (`id_operacion_contable`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_cuadre_operacion_cuadre` FOREIGN KEY (`operacion_contable_fk`) REFERENCES `operacion_contable` (`id_operacion_contable`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  ADD CONSTRAINT `FK_cuenta_bancaria_moneda` FOREIGN KEY (`moneda_fk`) REFERENCES `moneda` (`id_moneda`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  ADD CONSTRAINT `FK_cuenta_contable_tipo_cuenta` FOREIGN KEY (`tipo_cuenta_fk`) REFERENCES `tipo_cuenta` (`id_tipo_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_cuenta_contable_titular` FOREIGN KEY (`titular_fk`) REFERENCES `titular` (`id_titular`),
  ADD CONSTRAINT `FK_cuetna_contable_moneda` FOREIGN KEY (`moneda_fk`) REFERENCES `moneda` (`id_moneda`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `info_operacion_contable`
--
ALTER TABLE `info_operacion_contable`
  ADD CONSTRAINT `FK_info_op_tipo_operacion` FOREIGN KEY (`tipo_operacion_fk`) REFERENCES `tipo_operacion_contable` (`id_tipo_operacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_info_op_tipo_pago` FOREIGN KEY (`forma_pago_fk`) REFERENCES `forma_pago` (`id_forma_pago`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `liquidacion`
--
ALTER TABLE `liquidacion`
  ADD CONSTRAINT `FK_liquidacion_cuadre` FOREIGN KEY (`cuadre_fk`) REFERENCES `cuadre` (`id_cuadre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_liquidacion_cuenta_bancaria` FOREIGN KEY (`cuenta_fk`) REFERENCES `cuenta_bancaria` (`id_cuenta_bancaria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `operacion_contable`
--
ALTER TABLE `operacion_contable`
  ADD CONSTRAINT `FK_operacion_contable_cuenta_contable` FOREIGN KEY (`cuenta_fk`) REFERENCES `cuenta_contable` (`id_cuenta_contable`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_operacion_contable_info_operacion_contable` FOREIGN KEY (`info_operacion_contable_fk`) REFERENCES `info_operacion_contable` (`id_info_operacion_contable`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subcuenta`
--
ALTER TABLE `subcuenta`
  ADD CONSTRAINT `FK_subcuenta_cuenta_hijo` FOREIGN KEY (`cuenta_hijo_fk`) REFERENCES `cuenta_contable` (`id_cuenta_contable`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_subcuenta_cuenta_padre` FOREIGN KEY (`cuenta_padre_fk`) REFERENCES `cuenta_contable` (`id_cuenta_contable`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tipo_operacion_contable`
--
ALTER TABLE `tipo_operacion_contable`
  ADD CONSTRAINT `FK_tipo_op_tipo_cuenta_cuadre_def` FOREIGN KEY (`tipo_cuenta_cuadre_defecto_fk`) REFERENCES `tipo_cuenta` (`id_tipo_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tipo_op_tipo_cuenta_def` FOREIGN KEY (`tipo_cuenta_defecto_fk`) REFERENCES `tipo_cuenta` (`id_tipo_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
