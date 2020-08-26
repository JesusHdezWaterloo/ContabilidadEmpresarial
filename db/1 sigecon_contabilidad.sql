-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:7733
-- Generation Time: Aug 26, 2020 at 06:27 AM
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
(128, 264, 265, 0),
(129, 267, 266, 0),
(130, 268, 269, 0);

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
  `codigo` varchar(5) NOT NULL,
  `debito` decimal(19,4) NOT NULL,
  `credito` decimal(19,4) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `moneda_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cuenta_bancaria`
--

INSERT INTO `cuenta_bancaria` (`id_cuenta_bancaria`, `nombre_cuenta`, `numero_cuenta`, `numero_tarjeta`, `pin`, `codigo`, `debito`, `credito`, `descripcion`, `moneda_fk`) VALUES
(9, 'Efectivo en banco MN', '1111111111111111', '1111111111111111', '1111', '110', '0.0000', '0.0000', '', 5),
(11, 'Efectivo en banco USD', '1111111111111112', '1111111111111112', '2222', '111', '0.0000', '0.0000', '', 6);

-- --------------------------------------------------------

--
-- Table structure for table `cuenta_contable`
--

CREATE TABLE `cuenta_contable` (
  `id_cuenta_contable` int(11) NOT NULL,
  `nombre_cuenta` varchar(100) NOT NULL,
  `codigo` varchar(5) NOT NULL,
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
(15, 'Ingresos MN', '920', '0.0000', '50.0000', '', 6, 5, 3),
(16, 'Gastos Admin - telefono MN', '823-2', '0.0000', '0.0000', '', 5, 5, 4),
(17, 'cuentas por pagar MN', '406', '0.0000', '250.0000', '', 7, 5, 4),
(18, 'cuenta por cobrar MN', '136', '50.0000', '0.0000', '', 8, 5, 3),
(19, 'nominas por pagar MN', '455', '0.0000', '0.0000', '', 10, 5, 3),
(20, 'Gastos Admin - salario MN', '823-1', '0.0000', '0.0000', '', 5, 5, 4),
(21, 'Gastos Admi Generales MN', '823-0', '250.0000', '0.0000', '', 5, 5, 4),
(22, 'Efectivo en caja MN', '101', '0.0000', '0.0000', '', 9, 5, 4);

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
(4, 'efectivo', ''),
(5, 'cheque', '');

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
(139, '123', '23', '2020-08-24', '', 5, 6),
(140, 'sdsad', 'Pago de agua', '2020-08-24', '', 4, 10),
(141, 'F-123456', 'Pago de electricidad', '2020-08-25', '', 5, 10);

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
(5, 'MN', '1.000000000', '1.000000000', ''),
(6, 'USD', '30.000000000', '21.750000000', '');

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
(264, '0.0000', '50.0000', 15, 139),
(265, '50.0000', '0.0000', 18, 139),
(266, '0.0000', '100.0000', 17, 140),
(267, '100.0000', '0.0000', 21, 140),
(268, '150.0000', '0.0000', 21, 141),
(269, '0.0000', '150.0000', 17, 141);

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
(5, 'gastos administrativos', 1, 0, ''),
(6, 'ingresos', 0, 0, ''),
(7, 'cuenta por pagar', 0, 1, ''),
(8, 'cuenta por cobrar', 1, 1, ''),
(9, 'efectivo en caja', 1, 1, ''),
(10, 'nominas por pagar', 0, 1, '');

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
(6, 'Mov interno', 'tipo_operacion_contable.key.movimiento_interno', '', 6, 8),
(10, 'Gasto Administrativo', 'Gasto Administrativo', '', 5, 7),
(11, 'pago caja', '123', '', 9, 7);

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
(3, 'noemi', ''),
(4, 'jesus', '');

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
  ADD KEY `FK_liquidacion_cuenta_bancaria` (`cuenta_fk`),
  ADD KEY `FK_liquidacion_cuadre` (`cuadre_fk`);

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
  MODIFY `id_cuadre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;

--
-- AUTO_INCREMENT for table `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  MODIFY `id_cuenta_bancaria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  MODIFY `id_cuenta_contable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `forma_pago`
--
ALTER TABLE `forma_pago`
  MODIFY `id_forma_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `info_operacion_contable`
--
ALTER TABLE `info_operacion_contable`
  MODIFY `id_info_operacion_contable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=142;

--
-- AUTO_INCREMENT for table `liquidacion`
--
ALTER TABLE `liquidacion`
  MODIFY `id_liquidacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `moneda`
--
ALTER TABLE `moneda`
  MODIFY `id_moneda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `operacion_contable`
--
ALTER TABLE `operacion_contable`
  MODIFY `id_operacion_contable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=270;

--
-- AUTO_INCREMENT for table `subcuenta`
--
ALTER TABLE `subcuenta`
  MODIFY `id_subcuenta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  MODIFY `id_tipo_cuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tipo_operacion_contable`
--
ALTER TABLE `tipo_operacion_contable`
  MODIFY `id_tipo_operacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `titular`
--
ALTER TABLE `titular`
  MODIFY `id_titular` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

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
