-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 03-01-2018 a las 08:54:17
-- Versión del servidor: 5.7.19
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `episunsalabdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `courseID` varchar(7) NOT NULL,
  `courseName` varchar(54) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`courseID`),
  UNIQUE KEY `courseName` (`courseName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `course`
--

INSERT INTO `course` (`courseID`, `courseName`, `enabled`) VALUES
('1701108', 'Fundamentos de Programación 1', 1),
('1701215', 'Fundamentos de Programación 2', 1),
('1703133', 'Ingenieria de Software y Procesos', 1),
('1703236', 'Construcción de Software ', 1),
('1703238', 'Tecnologia de Objetos', 1),
('1704146', 'Diseño y Arquitecura de Software', 1),
('1704250', 'Gestion de Proyectos de Software', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluations`
--

DROP TABLE IF EXISTS `evaluations`;
CREATE TABLE IF NOT EXISTS `evaluations` (
  `idEvaluations` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` varchar(7) NOT NULL,
  `studentID` int(11) NOT NULL,
  `evaluationN1` decimal(2,0) NOT NULL,
  `evaluationN2` decimal(2,0) NOT NULL,
  `evaluationN3` decimal(2,0) NOT NULL,
  PRIMARY KEY (`idEvaluations`),
  KEY `courseID` (`courseID`),
  KEY `studentID` (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `evaluations`
--

INSERT INTO `evaluations` (`idEvaluations`, `courseID`, `studentID`, `evaluationN1`, `evaluationN2`, `evaluationN3`) VALUES
(5, '1701108', 3, '2', '4', '5'),
(6, '1703133', 2, '4', '4', '5'),
(7, '1701108', 1, '1', '1', '5'),
(8, '1704146', 4, '6', '6', '6');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registration`
--

DROP TABLE IF EXISTS `registration`;
CREATE TABLE IF NOT EXISTS `registration` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` int(11) NOT NULL,
  `courseID` varchar(7) NOT NULL,
  `groupRegistration` varchar(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `studentID` (`studentID`),
  KEY `courseID` (`courseID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `registration`
--

INSERT INTO `registration` (`ID`, `studentID`, `courseID`, `groupRegistration`) VALUES
(1, 4, '1704250', 'A'),
(3, 2, '1703238', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `studentID` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(54) NOT NULL,
  `studentLastName` varchar(54) NOT NULL,
  `studentCUI` varchar(8) NOT NULL,
  `username` varchar(45) NOT NULL COMMENT 'here goes the email',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `password` varchar(60) NOT NULL,
  `third` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`studentID`),
  UNIQUE KEY `studentID` (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `student`
--

INSERT INTO `student` (`studentID`, `studentName`, `studentLastName`, `studentCUI`, `username`, `enabled`, `password`, `third`) VALUES
(1, 'juan', 'garcia', '20131516', 'jgarcia@gmail.com', 1, '123789', 3),
(2, 'pedro', 'valencia', '20145685', 'pvalencia@gmail.com', 1, '456789', 2),
(3, 'carlos', 'gonzales', '20154685', 'cgonzales@gmail.com', 1, '123456', 3),
(4, 'maria', 'zambrano', '20121617', 'mzambrano@gmail.com', 1, '456123', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `syllabus`
--

DROP TABLE IF EXISTS `syllabus`;
CREATE TABLE IF NOT EXISTS `syllabus` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` varchar(7) NOT NULL,
  `coursePrerequisite` varchar(7) NOT NULL,
  `semester` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `course` (`courseID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `syllabus`
--

INSERT INTO `syllabus` (`ID`, `courseID`, `coursePrerequisite`, `semester`) VALUES
(21, '1701108', '-', 1),
(22, '1701215', '1701108', 2),
(23, '1703133', '-', 5),
(24, '1703238', '1703133', 6),
(25, '1703236', '-', 6),
(26, '1704146', '1703136', 7),
(27, '1704146', '1703238', 7),
(28, '1704250', '1704146', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `roleID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL COMMENT 'here goes the email',
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`roleID`),
  UNIQUE KEY `roleID` (`roleID`),
  UNIQUE KEY `email` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user_roles`
--

INSERT INTO `user_roles` (`roleID`, `username`, `role`) VALUES
(1, 'jgarcia@gmail.com', 'ROLE_STUDENT'),
(2, 'pvalencia@gmail.com', 'ROLE_STUDENT'),
(3, 'cgonzales@gmail.com', 'ROLE_STUDENT'),
(4, 'mzambrano@gmail.com', 'ROLE_STUDENT');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `evaluations`
--
ALTER TABLE `evaluations`
  ADD CONSTRAINT `evaluations_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`),
  ADD CONSTRAINT `evaluations_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`);

--
-- Filtros para la tabla `registration`
--
ALTER TABLE `registration`
  ADD CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`),
  ADD CONSTRAINT `registration_ibfk_2` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`);

--
-- Filtros para la tabla `syllabus`
--
ALTER TABLE `syllabus`
  ADD CONSTRAINT `syllabus_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
