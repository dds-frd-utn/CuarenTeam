-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-09-2020 a las 22:34:50
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dds`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bonos`
--

CREATE TABLE `bonos` (
  `id` int(11) NOT NULL,
  `num_cuenta` int(11) NOT NULL,
  `tipo` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `num_cuenta` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `edad` int(2) NOT NULL,
  `Balance` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`num_cuenta`, `nombre`, `direccion`, `edad`, `Balance`) VALUES
(1, 'Juan Perez', 'Mitre 1', 48, 0),
(2, 'Maria Gonzalez', 'San Martin 2', 37, 0),
(3, 'matias Delorensi', 'Mitre 345', 69, 0),
(4, 'Martin Gonzalez', 'Rivadavia 435', 34, 45000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transacciones`
--

CREATE TABLE `transacciones` (
  `id` int(11) NOT NULL,
  `cuenta_origen` int(11) NOT NULL,
  `monto` float NOT NULL,
  `cuenta_destino` int(11) NOT NULL,
  `fecha` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `transacciones`
--

INSERT INTO `transacciones` (`id`, `cuenta_origen`, `monto`, `cuenta_destino`, `fecha`) VALUES
(1, 1, 3000, 2, '2020-09-03'),
(2, 2, 3000, 3, '2020-09-03'),
(3, 3, 3000, 4, '2020-09-03'),
(4, 6, 45, 2, '2020-09-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `num_cuenta` int(11) NOT NULL,
  `usuario` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`num_cuenta`, `usuario`, `password`) VALUES
(1, 'juanperez', '123'),
(2, 'juanmartin', '456');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bonos`
--
ALTER TABLE `bonos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`num_cuenta`);

--
-- Indices de la tabla `transacciones`
--
ALTER TABLE `transacciones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`num_cuenta`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bonos`
--
ALTER TABLE `bonos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `num_cuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `transacciones`
--
ALTER TABLE `transacciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
