-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-12-2014 a las 23:07:19
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dbasesoriastyt`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asesorias`
--

CREATE TABLE IF NOT EXISTS `asesorias` (
  `Id_Asesoria` varchar(5) NOT NULL,
  `Docente_Asesoria` varchar(15) NOT NULL,
  `Asignatura_Asesoria` varchar(10) NOT NULL,
  `Fecha_Asesoria` varchar(50) NOT NULL,
  `HoraInicio_Asesoria` varchar(10) NOT NULL,
  `HoraFin_Asesoria` varchar(10) NOT NULL,
  `Lugar_Asesoria` varchar(50) NOT NULL,
  `Cupos_Asesoria` varchar(3) NOT NULL,
  `CuposDisp_Asesoria` varchar(3) NOT NULL,
  `Observaciones_Asesoria` varchar(255) NOT NULL,
  `Estado_Asesoria` varchar(20) NOT NULL,
  PRIMARY KEY (`Id_Asesoria`),
  KEY `Asesorias_Personas_FK` (`Docente_Asesoria`),
  KEY `Asignatura_Asesoria_FK` (`Asignatura_Asesoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `asesorias`:
--   `Asignatura_Asesoria`
--       `asignaturas` -> `Codigo_Asignatura`
--   `Docente_Asesoria`
--       `personas` -> `NumDoc_Persona`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE IF NOT EXISTS `asignaturas` (
  `Codigo_Asignatura` varchar(10) NOT NULL,
  `Nombre_Asignatura` varchar(255) NOT NULL,
  PRIMARY KEY (`Codigo_Asignatura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE IF NOT EXISTS `aulas` (
  `Id_Aula` varchar(10) NOT NULL,
  `Id_Bloque_Aula` varchar(4) NOT NULL,
  PRIMARY KEY (`Id_Aula`),
  KEY `Aulas_Bloques_FK` (`Id_Bloque_Aula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `aulas`:
--   `Id_Bloque_Aula`
--       `bloques` -> `Id_Bloque`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bloques`
--

CREATE TABLE IF NOT EXISTS `bloques` (
  `Id_Bloque` varchar(4) NOT NULL,
  `Encargado_Bloque` varchar(3) NOT NULL,
  PRIMARY KEY (`Id_Bloque`),
  KEY `Encargados_Bloques_FK` (`Encargado_Bloque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `bloques`:
--   `Encargado_Bloque`
--       `encargados_bloques` -> `Id_Encargado_Bloque`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encargados_bloques`
--

CREATE TABLE IF NOT EXISTS `encargados_bloques` (
  `Id_Encargado_Bloque` varchar(3) NOT NULL,
  `Correo_Encargado_Bloque` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Encargado_Bloque`),
  UNIQUE KEY `Encargados_Bloques_UN` (`Correo_Encargado_Bloque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes_asesoria`
--

CREATE TABLE IF NOT EXISTS `estudiantes_asesoria` (
  `Id_Estudiante` varchar(15) NOT NULL,
  `Id_Asesoria` varchar(5) NOT NULL,
  PRIMARY KEY (`Id_Estudiante`,`Id_Asesoria`),
  KEY `Estudiantes_Asesoria_Ase_FK` (`Id_Asesoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `estudiantes_asesoria`:
--   `Id_Asesoria`
--       `asesorias` -> `Id_Asesoria`
--   `Id_Estudiante`
--       `personas` -> `NumDoc_Persona`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE IF NOT EXISTS `perfiles` (
  `Id_Perfil` int(11) NOT NULL,
  `Nombre_Perfil` varchar(20) NOT NULL,
  PRIMARY KEY (`Id_Perfil`),
  UNIQUE KEY `Perfiles__UN` (`Nombre_Perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE IF NOT EXISTS `personas` (
  `NumDoc_Persona` varchar(15) NOT NULL,
  `Tipo_Identificacion` varchar(3) NOT NULL,
  `Nombres_Persona` varchar(255) NOT NULL,
  `PApellido_Persona` varchar(255) NOT NULL,
  `SApellido_Persona` varchar(255) DEFAULT NULL,
  `Genero_Persona` varchar(10) NOT NULL,
  `FechaNac_Persona` varchar(15) NOT NULL,
  `Direccion_Persona` varchar(255) NOT NULL,
  `Telefono_Persona` varchar(15) NOT NULL,
  `Celular_Persona` varchar(15) DEFAULT NULL,
  `Correo_Persona` varchar(255) NOT NULL,
  `PlanEstudios_Persona` varchar(255) DEFAULT NULL,
  `Semestre_Persona` varchar(1) DEFAULT NULL,
  `Estado_Persona` varchar(10) NOT NULL,
  `Perfil_Persona` int(11) NOT NULL,
  PRIMARY KEY (`NumDoc_Persona`),
  UNIQUE KEY `Personas__UN` (`Correo_Persona`),
  KEY `Personas_Perfiles_FK` (`Perfil_Persona`),
  KEY `Personas_Tipos_Id_FK` (`Tipo_Identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `personas`:
--   `Tipo_Identificacion`
--       `tipos_identificacion` -> `Id_Identificacion`
--   `Perfil_Persona`
--       `perfiles` -> `Id_Perfil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programaciones_academicas`
--

CREATE TABLE IF NOT EXISTS `programaciones_academicas` (
  `Id_ProgAcademica` varchar(4) NOT NULL,
  `Docente_ProgAcademica` varchar(15) NOT NULL,
  `Asignatura` varchar(10) NOT NULL,
  `Grupo_Asignatura` varchar(3) NOT NULL,
  `Nro_Estudiantes_Asignatura` varchar(3) NOT NULL,
  `Dias_Asignatura` varchar(255) NOT NULL,
  `HoraInicio_Asignatura` varchar(10) NOT NULL,
  `HoraFin_Asignatura` varchar(10) NOT NULL,
  `Aula_Clase` varchar(10) NOT NULL,
  PRIMARY KEY (`Id_ProgAcademica`),
  KEY `AsignaturaPA_FK` (`Asignatura`),
  KEY `Aula_Clase_FK` (`Aula_Clase`),
  KEY `Programaciones_Aca_Pers_FK` (`Docente_ProgAcademica`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `programaciones_academicas`:
--   `Docente_ProgAcademica`
--       `personas` -> `NumDoc_Persona`
--   `Asignatura`
--       `asignaturas` -> `Codigo_Asignatura`
--   `Aula_Clase`
--       `aulas` -> `Id_Aula`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_identificacion`
--

CREATE TABLE IF NOT EXISTS `tipos_identificacion` (
  `Id_Identificacion` varchar(3) NOT NULL,
  `Nombre_Identificacion` varchar(25) NOT NULL,
  PRIMARY KEY (`Id_Identificacion`),
  UNIQUE KEY `Tipos_Identificacion__UN` (`Nombre_Identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipos_identificacion`
--

INSERT INTO `tipos_identificacion` (`Id_Identificacion`, `Nombre_Identificacion`) VALUES
('CC', 'Cédula de Ciudadanía'),
('CE', 'Cédula de Extranjería'),
('TI', 'Tarjeta de Identidad');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asesorias`
--
ALTER TABLE `asesorias`
  ADD CONSTRAINT `Asignatura_Asesoria_FK` FOREIGN KEY (`Asignatura_Asesoria`) REFERENCES `asignaturas` (`Codigo_Asignatura`),
  ADD CONSTRAINT `Asesorias_Personas_FK` FOREIGN KEY (`Docente_Asesoria`) REFERENCES `personas` (`NumDoc_Persona`);

--
-- Filtros para la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD CONSTRAINT `Aulas_Bloques_FK` FOREIGN KEY (`Id_Bloque_Aula`) REFERENCES `bloques` (`Id_Bloque`);

--
-- Filtros para la tabla `bloques`
--
ALTER TABLE `bloques`
  ADD CONSTRAINT `Encargados_Bloques_FK` FOREIGN KEY (`Encargado_Bloque`) REFERENCES `encargados_bloques` (`Id_Encargado_Bloque`);

--
-- Filtros para la tabla `estudiantes_asesoria`
--
ALTER TABLE `estudiantes_asesoria`
  ADD CONSTRAINT `Estudiantes_Asesoria_Ase_FK` FOREIGN KEY (`Id_Asesoria`) REFERENCES `asesorias` (`Id_Asesoria`),
  ADD CONSTRAINT `Estudiantes_Asesoria_Est_FK` FOREIGN KEY (`Id_Estudiante`) REFERENCES `personas` (`NumDoc_Persona`);

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `Personas_Tipos_Id_FK` FOREIGN KEY (`Tipo_Identificacion`) REFERENCES `tipos_identificacion` (`Id_Identificacion`),
  ADD CONSTRAINT `Personas_Perfiles_FK` FOREIGN KEY (`Perfil_Persona`) REFERENCES `perfiles` (`Id_Perfil`);

--
-- Filtros para la tabla `programaciones_academicas`
--
ALTER TABLE `programaciones_academicas`
  ADD CONSTRAINT `Programaciones_Aca_Pers_FK` FOREIGN KEY (`Docente_ProgAcademica`) REFERENCES `personas` (`NumDoc_Persona`),
  ADD CONSTRAINT `AsignaturaPA_FK` FOREIGN KEY (`Asignatura`) REFERENCES `asignaturas` (`Codigo_Asignatura`),
  ADD CONSTRAINT `Aula_Clase_FK` FOREIGN KEY (`Aula_Clase`) REFERENCES `aulas` (`Id_Aula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
