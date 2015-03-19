SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE TABLE IF NOT EXISTS `asesorias` (
  `Id_Asesoria` varchar(5) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `asesorias` (`Id_Asesoria`, `Docente_Asesoria`, `Asignatura_Asesoria`, `Fecha_Asesoria`, `HoraInicio_Asesoria`, `HoraFin_Asesoria`, `Lugar_Asesoria`, `Cupos_Asesoria`, `CuposDisp_Asesoria`, `RecursosApoyo_Asesoria`, `Observaciones_Asesoria`, `Estado_Asesoria`) VALUES
('1', '123456', 'ING003', '12/04/2015', '2:00 pm', '4:00 pm', 'Almendros', '10', '9', NULL, 'ninguna', 'activa');

CREATE TABLE IF NOT EXISTS `asignaturas` (
  `Codigo_Asignatura` varchar(10) NOT NULL,
  `Nombre_Asignatura` varchar(255) NOT NULL,
  PRIMARY KEY (`Codigo_Asignatura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `asignaturas` (`Codigo_Asignatura`, `Nombre_Asignatura`) VALUES
('ING003', 'Matemáticas 2B');

CREATE TABLE IF NOT EXISTS `aulas` (
  `Id_Aula` varchar(10) NOT NULL,
  `Id_Bloque_Aula` varchar(4) NOT NULL,
  PRIMARY KEY (`Id_Aula`),
  KEY `Aulas_Bloques_FK` (`Id_Bloque_Aula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `bloques` (
  `Id_Bloque` varchar(4) NOT NULL,
  `Encargado_Bloque` varchar(3) NOT NULL,
  PRIMARY KEY (`Id_Bloque`),
  KEY `Encargados_Bloques_FK` (`Encargado_Bloque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `encargados_bloques` (
  `Id_Encargado_Bloque` varchar(3) NOT NULL,
  `Correo_Encargado_Bloque` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Encargado_Bloque`),
  UNIQUE KEY `Encargados_Bloques_UN` (`Correo_Encargado_Bloque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `estudiantes_asesoria` (
  `Id_Estudiante` varchar(15) NOT NULL,
  `Id_Asesoria` varchar(5) NOT NULL,
  `Asistencia_Asesoria` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Id_Estudiante`,`Id_Asesoria`),
  KEY `Estudiantes_Asesoria_Ase_FK` (`Id_Asesoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `perfiles` (
  `Id_Perfil` int(11) NOT NULL,
  `Nombre_Perfil` varchar(20) NOT NULL,
  PRIMARY KEY (`Id_Perfil`),
  UNIQUE KEY `Perfiles__UN` (`Nombre_Perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `perfiles` (`Id_Perfil`, `Nombre_Perfil`) VALUES
(1, 'Administrador'),
(2, 'Docente'),
(3, 'Estudiante');

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
('123456', 'CC', 'Julian', 'Gomez', 'Restrepo', 'M', '18/09/1980', 'Cll 1', '2333323', NULL, 'juliangomez@elpoli.edu.co', NULL, NULL, 'Activo', 2),
('1234567', 'CC', 'Mateo', 'Lopez', 'Velez', 'Masculino', '1980-12-30', 'Cll 1', '123454', '', 'mateo@elpoli.edu.co', NULL, NULL, 'Activo', 2),
('97091800296', 'TI', 'Natalia Juliette', 'Díaz', 'Padilla', 'Femenino', '18/09/1997', 'Cll 49 AC #93-47', '2000009', NULL, 'natalia_diaz24131@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '6', 'Activa', 2);

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
  `Semestre_ProgAcademica` varchar(2) NOT NULL,
  `Ano_ProgAcademica` varchar(4) NOT NULL,
  PRIMARY KEY (`Id_ProgAcademica`),
  KEY `AsignaturaPA_FK` (`Asignatura`),
  KEY `Aula_Clase_FK` (`Aula_Clase`),
  KEY `Programaciones_Aca_Pers_FK` (`Docente_ProgAcademica`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD CONSTRAINT `Asignatura_Asesoria_FK` FOREIGN KEY (`Asignatura_Asesoria`) REFERENCES `asignaturas` (`Codigo_Asignatura`),
  ADD CONSTRAINT `Asesorias_Personas_FK` FOREIGN KEY (`Docente_Asesoria`) REFERENCES `personas` (`NumDoc_Persona`);

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
  ADD CONSTRAINT `AsignaturaPA_FK` FOREIGN KEY (`Asignatura`) REFERENCES `asignaturas` (`Codigo_Asignatura`),
  ADD CONSTRAINT `Aula_Clase_FK` FOREIGN KEY (`Aula_Clase`) REFERENCES `aulas` (`Id_Aula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
