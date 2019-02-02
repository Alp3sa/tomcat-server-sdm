-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-02-2019 a las 16:36:42
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestor_datos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `classroom`
--

CREATE TABLE `classroom` (
  `ID` int(11) NOT NULL,
  `classroomName` varchar(50) NOT NULL,
  `details` varchar(50) NOT NULL,
  `image` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `classroom`
--

INSERT INTO `classroom` (`ID`, `classroomName`, `details`, `image`) VALUES
(1, '100', 'Matemáticas', 'false'),
(2, '201', 'Lengua', 'false'),
(10, '305', 'Ninguna', 'true'),
(13, '400', 'Plástica', 'false'),
(16, '500', 'Ed. Física', 'false');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enrollment`
--

CREATE TABLE `enrollment` (
  `ID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `subjectID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `enrollment`
--

INSERT INTO `enrollment` (`ID`, `userID`, `subjectID`) VALUES
(1, 1, 2),
(2, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subject`
--

CREATE TABLE `subject` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `teacher` varchar(50) NOT NULL,
  `classroom` varchar(50) NOT NULL,
  `startTime` varchar(5) NOT NULL,
  `endingTime` varchar(5) NOT NULL,
  `classroomID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `subject`
--

INSERT INTO `subject` (`ID`, `name`, `teacher`, `classroom`, `startTime`, `endingTime`, `classroomID`) VALUES
(1, 'Mates', 'Jose', '200', '1:00', '1:00', 1),
(3, 'Plástica', 'Andrés', '200', '08:00', '08:30', 1),
(7, 'Ed. Física', 'Ramón', 'Patio', '08:00', '08:30', 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutorship`
--

CREATE TABLE `tutorship` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `classroom` varchar(50) NOT NULL,
  `startTime` varchar(5) NOT NULL,
  `endingTime` varchar(5) NOT NULL,
  `classroomID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tutorship`
--

INSERT INTO `tutorship` (`ID`, `name`, `classroom`, `startTime`, `endingTime`, `classroomID`) VALUES
(2, 'Jose', '200', '01:00', '01:00', 1),
(6, 'Luis', '500', '08:00', '08:30', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `primerApellido` varchar(50) NOT NULL,
  `segundoApellido` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `genero` int(11) NOT NULL,
  `tipoDeMiembro` int(11) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `userID` (`userID`),
  ADD KEY `subjectID` (`subjectID`);

--
-- Indices de la tabla `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `classroomID` (`classroomID`);

--
-- Indices de la tabla `tutorship`
--
ALTER TABLE `tutorship`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `classroomID` (`classroomID`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `nombreUsuario` (`nombreUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `classroom`
--
ALTER TABLE `classroom`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `enrollment`
--
ALTER TABLE `enrollment`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `subject`
--
ALTER TABLE `subject`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `tutorship`
--
ALTER TABLE `tutorship`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`classroomID`) REFERENCES `classroom` (`ID`);

--
-- Filtros para la tabla `tutorship`
--
ALTER TABLE `tutorship`
  ADD CONSTRAINT `tutorship_ibfk_2` FOREIGN KEY (`classroomID`) REFERENCES `classroom` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
