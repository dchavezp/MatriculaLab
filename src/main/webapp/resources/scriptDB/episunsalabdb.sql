-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 02-01-2018 a las 01:06:19
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
('1701108', 'fundamentos de programación 1', 1),
('1701215', 'fudamentos de programación 2', 1),
('1703133', 'ingenieria de software y procesos', 1),
('1703236', 'construcción de software ', 1),
('1703238', 'tecnologia de objetos', 1),
('1704146', 'diseño y arquitecura de software', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `course_student`
--

DROP TABLE IF EXISTS `course_student`;
CREATE TABLE IF NOT EXISTS `course_student` (
  `courseID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `evaluationN1` tinyint(2) NOT NULL,
  `evaluationN2` tinyint(2) NOT NULL,
  `evaluationN3` tinyint(2) NOT NULL,
  `studentState` tinyint(1) NOT NULL COMMENT '''1'' aprobado ''0'' desaprobadp'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registration`
--

DROP TABLE IF EXISTS `registration`;
CREATE TABLE IF NOT EXISTS `registration` (
  `studentID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  `groupRegistration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `student`
--

INSERT INTO `student` (`studentID`, `studentName`, `studentLastName`, `studentCUI`, `username`, `enabled`, `password`, `third`) VALUES
(1, 'juan', 'garcia', '20131516', 'jgarcia@gmail.com', 1, '123789', 1),
(2, 'pedro', 'valencia', '20145685', 'pvalencia@gmail.com', 1, '456789', 1),
(3, 'carlos', 'gonzales', '20154685', 'cgonzales@gmail.com', 1, '123456', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `syllabus`
--

DROP TABLE IF EXISTS `syllabus`;
CREATE TABLE IF NOT EXISTS `syllabus` (
  `courseID` varchar(7) NOT NULL,
  `coursePrerequisite` varchar(7) NOT NULL,
  `semester` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `syllabus`
--

INSERT INTO `syllabus` (`courseID`, `coursePrerequisite`, `semester`) VALUES
('1701108', '', 1),
('1701215', '1701108', 2),
('1703133', '', 1),
('1703238', '1703133', 2),
('1703134', '', 1),
('1704146', '1703134', 1),
('1704146', '1703238', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user_roles`
--

INSERT INTO `user_roles` (`roleID`, `username`, `role`) VALUES
(1, 'jgarcia@gmail.com', 'ROLE_STUDENT'),
(2, 'pvalencia@gmail.com', 'ROLE_STUDENT'),
(3, 'cgonzales@gmail.com', 'ROLE_STUDENT');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
