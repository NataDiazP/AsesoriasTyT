SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE TABLE IF NOT EXISTS `asesorias` (
  `Id_Asesoria` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_Asesoria` varchar(50) DEFAULT NULL,
  `Docente_Asesoria` varchar(15) NOT NULL,
  `Asignatura_Asesoria` varchar(10) NOT NULL,
  `Fecha_Asesoria` varchar(50) NOT NULL,
  `HoraInicio_Asesoria` varchar(10) NOT NULL,
  `HoraFin_Asesoria` varchar(10) NOT NULL,
  `Lugar_Asesoria` varchar(50) NOT NULL,
  `Cupos_Asesoria` varchar(3) NOT NULL,
  `CuposDisp_Asesoria` varchar(3) DEFAULT NULL,
  `RecursosApoyo_Asesoria` varchar(255) DEFAULT NULL,
  `Observaciones_Asesoria` varchar(255) DEFAULT NULL,
  `Estado_Asesoria` varchar(20) NOT NULL,
  PRIMARY KEY (`Id_Asesoria`),
  KEY `Asesorias_Personas_FK` (`Docente_Asesoria`),
  KEY `Asignatura_Asesoria_FK` (`Asignatura_Asesoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

INSERT INTO `asesorias` (`Id_Asesoria`, `Nombre_Asesoria`, `Docente_Asesoria`, `Asignatura_Asesoria`, `Fecha_Asesoria`, `HoraInicio_Asesoria`, `HoraFin_Asesoria`, `Lugar_Asesoria`, `Cupos_Asesoria`, `CuposDisp_Asesoria`, `RecursosApoyo_Asesoria`, `Observaciones_Asesoria`, `Estado_Asesoria`) VALUES
(1, 'Fracionarios', '1234567', 'ING00816', '2015-03-23', '10:00am', '11:00am', 'almedros', '15', '15', NULL, NULL, 'Activa'),
(2, 'Taller civica', '1234567', 'ING00816', '2015-04-23', '10:00am', '11:00am', 'almedros', '15', '15', NULL, NULL, 'Activa'),
(3, 'Tabla de la verdad', '1234567', 'ING00816', '2015-03-23', '10:00am', '11:00am', 'almedros', '15', '15', NULL, NULL, 'Activa'),
(4, 'Ciclo de Vida de sw', '1234567', 'ING00816', '2015-05-23', '10:00am', '11:00am', 'almedros', '15', '15', NULL, NULL, 'Activa');

CREATE TABLE IF NOT EXISTS `asignaturas` (
  `Codigo_Asignatura` varchar(10) NOT NULL,
  `Nombre_Asignatura` varchar(255) NOT NULL,
  PRIMARY KEY (`Codigo_Asignatura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `asignaturas` (`Codigo_Asignatura`, `Nombre_Asignatura`) VALUES
('ING00812', 'Identificación del Ciclo de Vida del Software'),
('ING00813', 'Comprensión y respeto del entorno'),
('ING00814', 'Desarrollo de actitudes ciudadanas'),
('ING00816', 'Desarrollo del pensamiento lógico y matemático 1 (A)'),
('ING00818', 'Desarrollo del pensamiento lógico y matemático 1 (B)'),
('ING00819', 'Definición de Requerimientos'),
('ING00824', 'Construcción de informes utilizando herramientas Ofimáticas');

CREATE TABLE IF NOT EXISTS `aulas` (
  `Id_Aula` varchar(10) NOT NULL,
  `Id_Bloque_Aula` varchar(4) NOT NULL,
  PRIMARY KEY (`Id_Aula`,`Id_Bloque_Aula`),
  KEY `Aulas_Bloques_FK` (`Id_Bloque_Aula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `aulas` (`Id_Aula`, `Id_Bloque_Aula`) VALUES
('202', 'P17'),
('303', 'P17'),
('201', 'P31'),
('208', 'P38');

CREATE TABLE IF NOT EXISTS `bloques` (
  `Id_Bloque` varchar(4) NOT NULL,
  `Encargado_Bloque` varchar(15) NOT NULL,
  PRIMARY KEY (`Id_Bloque`),
  KEY `Encargados_Bloques_FK` (`Encargado_Bloque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `bloques` (`Id_Bloque`, `Encargado_Bloque`) VALUES
('P17', '123'),
('P31', '456'),
('P38', '789');

CREATE TABLE IF NOT EXISTS `encargados_bloques` (
  `Id_Encargado_Bloque` varchar(15) NOT NULL,
  `Correo_Encargado_Bloque` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Encargado_Bloque`),
  UNIQUE KEY `Encargados_Bloques_UN` (`Correo_Encargado_Bloque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `encargados_bloques` (`Id_Encargado_Bloque`, `Correo_Encargado_Bloque`) VALUES
('970918002956', 'natalia.970918@gmail.com'),
('123', 'natavelez17@gmail.com'),
('789', 'nathalia_gaviria24111@elpoli.edu.co'),
('456', 'paola_vargas24111@elpoli.edu.com');

CREATE TABLE IF NOT EXISTS `estudiantes_asesoria` (
  `Id_Estudiante` varchar(15) NOT NULL,
  `Id_Asesoria` int(11) NOT NULL DEFAULT '0',
  `Asistencia_Asesoria` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Id_Estudiante`,`Id_Asesoria`),
  KEY `Estudiantes_Asesoria_Ase_FK` (`Id_Asesoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `estudiantes_asesoria` (`Id_Estudiante`, `Id_Asesoria`, `Asistencia_Asesoria`) VALUES
('123456789', 2, 'Si'),
('97091800296', 2, 'No'),
('97091800296', 3, NULL);

CREATE TABLE IF NOT EXISTS `perfiles` (
  `Id_Perfil` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_Perfil` varchar(20) NOT NULL,
  PRIMARY KEY (`Id_Perfil`),
  UNIQUE KEY `Perfiles__UN` (`Nombre_Perfil`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

INSERT INTO `perfiles` (`Id_Perfil`, `Nombre_Perfil`) VALUES
(1, 'Administrador'),
(2, 'Docente'),
(3, 'Estudiante'),
(4, 'Prueba');

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

INSERT INTO `personas` (`NumDoc_Persona`, `Tipo_Identificacion`, `Nombres_Persona`, `PApellido_Persona`, `SApellido_Persona`, `Genero_Persona`, `FechaNac_Persona`, `Direccion_Persona`, `Telefono_Persona`, `Celular_Persona`, `Correo_Persona`, `PlanEstudios_Persona`, `Semestre_Persona`, `Estado_Persona`, `Perfil_Persona`) VALUES
('1214719040', 'CC', 'Nathalia', 'Velez', 'Gaviria', 'Femenino', '1993-07-17', 'Cll 77 #45-85', '20456776', NULL, 'nathalia_gaviria24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '7', 'Activa', 3),
('123456', 'CC', 'Julian', 'Gomez', 'Restrepo', 'M', '1980-09-18', 'Cll 1', '2333323', NULL, 'juliangomez@elpoli.edu.co', NULL, NULL, 'Activo', 2),
('1234567', 'CC', 'Mateo', 'Lopez', 'Velez', 'Masculino', '1980-12-30', 'Cll 1', '123454', '', 'mateo@elpoli.edu.co', NULL, NULL, 'Activo', 2),
('123', 'CC', 'Maryem', 'Ruiz', 'Velez', 'Femenino', '1980-12-30', 'Cll 1', '123454', '', 'mruiz@elpoli.edu.co', NULL, NULL, 'Activo', 1),
('1234', 'CC', 'Paola', 'Vargas', 'López', 'Femenino', '1980-12-30', 'Cll 1', '123454', '', 'paola_vargas24111@elpoli.edu.co', NULL, NULL, 'Activo', 1),
('123456789', 'CC', 'Pablo', 'Montes', 'Gaviria', 'Masculion', '1983-2-1', 'Cll 77 #45-85', '20456776', NULL, 'pablo_montes24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '7', 'Activa', 3),
('97091800296', 'TI', 'Natalia Juliette', 'Díaz', 'Padilla', 'Femenino', '1997-08-7', 'Cll 49 AC #93-47', '2000009', NULL, 'natalia_diaz24131@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '6', 'Activa', 2);

CREATE TABLE IF NOT EXISTS `programaciones_academicas` (
  `Id_ProgAcademica` int(11) NOT NULL AUTO_INCREMENT,
  `Docente_ProgAcademica` varchar(15) NOT NULL,
  `Asignatura` varchar(10) NOT NULL,
  `Grupo_Asignatura` varchar(3) NOT NULL,
  `Nro_Estudiantes_Asignatura` varchar(3) NOT NULL,
  `Dias_Asignatura` varchar(255) NOT NULL,
  `HoraInicio_Asignatura` varchar(10) NOT NULL,
  `HoraFin_Asignatura` varchar(10) NOT NULL,
  `Aula_Clase` varchar(10) NOT NULL,
  `Semestre_ProgAcademica` varchar(2) NOT NULL,
  `Ano_ProgAcademica` varchar(4) NOT NULL,
  PRIMARY KEY (`Id_ProgAcademica`),
  KEY `AsignaturaPA_FK` (`Asignatura`),
  KEY `Programaciones_Aca_Pers_FK` (`Docente_ProgAcademica`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

INSERT INTO `programaciones_academicas` (`Id_ProgAcademica`, `Docente_ProgAcademica`, `Asignatura`, `Grupo_Asignatura`, `Nro_Estudiantes_Asignatura`, `Dias_Asignatura`, `HoraInicio_Asignatura`, `HoraFin_Asignatura`, `Aula_Clase`, `Semestre_ProgAcademica`, `Ano_ProgAcademica`) VALUES
(1, '1234567', 'ING00812', '01', '30', '2', '6:00pm', '8:00pm', '201', '1', '2015'),
(2, '1234567', 'ING00813', '02', '56', '1', '6:00am', '8:00am', '208', '1', '2015'),
(3, '1234567', 'ING00818', '02', '30', '2', '8:00am', '10:00am', '202', '1', '2015');

CREATE TABLE IF NOT EXISTS `tipos_identificacion` (
  `Id_Identificacion` varchar(3) NOT NULL,
  `Nombre_Identificacion` varchar(25) NOT NULL,
  PRIMARY KEY (`Id_Identificacion`),
  UNIQUE KEY `Tipos_Identificacion__UN` (`Nombre_Identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `tipos_identificacion` (`Id_Identificacion`, `Nombre_Identificacion`) VALUES
('CC', 'Cédula de Ciudadanía'),
('CE', 'Cédula de Extranjería'),
('TI', 'Tarjeta de Identidad');


ALTER TABLE `asesorias`
  ADD CONSTRAINT `Asesorias_Personas_FK` FOREIGN KEY (`Docente_Asesoria`) REFERENCES `personas` (`NumDoc_Persona`),
  ADD CONSTRAINT `Asignatura_Asesoria_FK` FOREIGN KEY (`Asignatura_Asesoria`) REFERENCES `asignaturas` (`Codigo_Asignatura`);

ALTER TABLE `aulas`
  ADD CONSTRAINT `Aulas_Bloques_FK` FOREIGN KEY (`Id_Bloque_Aula`) REFERENCES `bloques` (`Id_Bloque`);

ALTER TABLE `bloques`
  ADD CONSTRAINT `Encargados_Bloques_FK` FOREIGN KEY (`Encargado_Bloque`) REFERENCES `encargados_bloques` (`Id_Encargado_Bloque`);

ALTER TABLE `estudiantes_asesoria`
  ADD CONSTRAINT `Estudiantes_Asesoria_Ase_FK` FOREIGN KEY (`Id_Asesoria`) REFERENCES `asesorias` (`Id_Asesoria`),
  ADD CONSTRAINT `Estudiantes_Asesoria_Est_FK` FOREIGN KEY (`Id_Estudiante`) REFERENCES `personas` (`NumDoc_Persona`);

ALTER TABLE `personas`
  ADD CONSTRAINT `Personas_Tipos_Id_FK` FOREIGN KEY (`Tipo_Identificacion`) REFERENCES `tipos_identificacion` (`Id_Identificacion`),
  ADD CONSTRAINT `Personas_Perfiles_FK` FOREIGN KEY (`Perfil_Persona`) REFERENCES `perfiles` (`Id_Perfil`);

ALTER TABLE `programaciones_academicas`
  ADD CONSTRAINT `Programaciones_Aca_Pers_FK` FOREIGN KEY (`Docente_ProgAcademica`) REFERENCES `personas` (`NumDoc_Persona`),
  ADD CONSTRAINT `AsignaturaPA_FK` FOREIGN KEY (`Asignatura`) REFERENCES `asignaturas` (`Codigo_Asignatura`);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
