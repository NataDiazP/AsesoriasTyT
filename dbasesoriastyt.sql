CREATE TABLE Tipos_Identificacion (
    Id_Identificacion VARCHAR(3) NOT NULL,
    Nombre_Identificacion VARCHAR(25) NOT NULL
);

ALTER TABLE Tipos_Identificacion ADD CONSTRAINT Tipos_Identificacion_PK PRIMARY KEY ( Id_Identificacion ) ;

CREATE TABLE Perfiles (
    Id_Perfil INTEGER NOT NULL,
    Nombre_Perfil VARCHAR(20) NOT NULL
);
ALTER TABLE Perfiles ADD CONSTRAINT Perfiles_PK PRIMARY KEY ( Id_Perfil ) ;

CREATE TABLE Encargados_Bloques (
    Id_Encargado_Bloque VARCHAR(3) NOT NULL,
    Correo_Encargado_Bloque VARCHAR(255) NOT NULL
);
ALTER TABLE Encargados_Bloques ADD CONSTRAINT Encargados_Bloques_PK PRIMARY KEY ( Id_Encargado_Bloque ) ;
ALTER TABLE Encargados_Bloques ADD CONSTRAINT Encargados_Bloques_UN UNIQUE ( Correo_Encargado_Bloque ) ;

CREATE TABLE Planes_Estudio (
    Cod_PlanEstudio VARCHAR(15) NOT NULL,
    Nombre_PlanEstudio VARCHAR(255) NOT NULL
);
ALTER TABLE Planes_Estudio ADD CONSTRAINT Planes_Estudio_PK PRIMARY KEY ( Cod_PlanEstudio ) ;

CREATE TABLE Asignaturas (
    Codigo_Asignatura VARCHAR(10) NOT NULL,
    Nombre_Asignatura VARCHAR(255) NOT NULL,
    PlanEstudios_Asignatura VARCHAR(15) NOT NULL
);
ALTER TABLE Asignaturas ADD CONSTRAINT Asignaturas_PK PRIMARY KEY ( Codigo_Asignatura ) ;
ALTER TABLE Asignaturas ADD CONSTRAINT PlanEstudios_Asignatura_FK FOREIGN KEY ( PlanEstudios_Asignatura ) REFERENCES Planes_Estudio(Cod_PlanEstudio);

CREATE TABLE Bloques (
    Id_Bloque VARCHAR(4) NOT NULL,
    Encargado_Bloque VARCHAR(3) NOT NULL
);
ALTER TABLE Bloques ADD CONSTRAINT Bloques_PK PRIMARY KEY ( Id_Bloque ) ;
ALTER TABLE Bloques ADD CONSTRAINT Encargados_Bloques_FK FOREIGN KEY ( Encargado_Bloque ) REFERENCES Encargados_Bloques(Id_Encargado_Bloque);

CREATE TABLE Aulas (
    Id_Aula VARCHAR(10) NOT NULL,
    Id_Bloque_Aula VARCHAR(4) NOT NULL
);
ALTER TABLE Aulas ADD CONSTRAINT Aulas_PK PRIMARY KEY ( Id_Aula ) ;
ALTER TABLE Aulas ADD CONSTRAINT Aulas_Bloques_FK FOREIGN KEY ( Id_Bloque_Aula ) REFERENCES Bloques(Id_Bloque);

CREATE TABLE Docentes (
    NumDoc_Docente VARCHAR(15) NOT NULL,
    Tipo_Identificacion VARCHAR(3) NOT NULL,
    Nombres_Docente VARCHAR(255) NOT NULL,
    PApellido_Docente VARCHAR(255) NOT NULL,
    SApellido_Docente VARCHAR(255),
    Genero_Docente VARCHAR(1) NOT NULL,
    FechaNac_Docente VARCHAR(15) NOT NULL,
    Direccion_Docente VARCHAR(255) NOT NULL,
    Telefono_Docente VARCHAR(15) NOT NULL,
    Celular_Docente VARCHAR(15),
    Correo_Docente VARCHAR(255) NOT NULL,
    Estado_Docente VARCHAR(10) NOT NULL,
    Perfil_Docente INTEGER NOT NULL
);
ALTER TABLE Docentes ADD CONSTRAINT Docentes_PK PRIMARY KEY ( NumDoc_Docente ) ;
ALTER TABLE Docentes ADD CONSTRAINT Tipo_Identificacion_FK FOREIGN KEY ( Tipo_Identificacion ) REFERENCES Tipos_Identificacion(Id_Identificacion);
ALTER TABLE Docentes ADD CONSTRAINT Perfil_Docente_FK FOREIGN KEY ( Perfil_Docente ) REFERENCES Perfiles(Id_Perfil);

CREATE TABLE Estudiantes (
    NumDoc_Estudiante VARCHAR(15) NOT NULL,
    Tipo_Identificacion VARCHAR(3) NOT NULL,
    Nombres_Estudiante VARCHAR(255) NOT NULL,
    PApellido_Estudiante VARCHAR(255) NOT NULL,
    SApellido_Estudiante VARCHAR(255),
    Genero_Estudiante VARCHAR(1) NOT NULL,
    FechaNac_Estudiante VARCHAR(15) NOT NULL,
    Direccion_Estudiante VARCHAR(255) NOT NULL,
    Telefono_Estudiante VARCHAR(15) NOT NULL,
    Celular_Estudiante VARCHAR(15),
    Correo_Estudiante VARCHAR(255) NOT NULL,
    PlanEstudios_Estudiante VARCHAR(255) NOT NULL,
    Semestre_Estudiante VARCHAR(1) NOT NULL,
    Estado_Estudiantes VARCHAR(10) NOT NULL,
    Perfil_Estudiante INTEGER NOT NULL
);
ALTER TABLE Estudiantes ADD CONSTRAINT Estudiantes_PK PRIMARY KEY ( NumDoc_Estudiante ) ;
ALTER TABLE Estudiantes ADD CONSTRAINT Tipo_Identificacion_Est_FK FOREIGN KEY ( Tipo_Identificacion ) REFERENCES Tipos_Identificacion(Id_Identificacion);
ALTER TABLE Estudiantes ADD CONSTRAINT Perfil_Estudiante_FK FOREIGN KEY ( Perfil_Estudiante ) REFERENCES Perfiles(Id_Perfil);

CREATE TABLE Usuarios (
    DocId_Usuario VARCHAR(15) NOT NULL,
    Tipo_Identificacion VARCHAR(3) NOT NULL,
    Correo_Usuario VARCHAR(255) NOT NULL,
    Perfil_Usuario INTEGER NOT NULL
);

ALTER TABLE Usuarios ADD CONSTRAINT Usuarios_PK PRIMARY KEY ( DocId_Usuario ) ;
ALTER TABLE Usuarios ADD CONSTRAINT Tipo_Identificacion_Us_FK FOREIGN KEY ( Tipo_Identificacion ) REFERENCES Tipos_Identificacion(Id_Identificacion);
ALTER TABLE Usuarios ADD CONSTRAINT Perfil_Usuario_FK FOREIGN KEY ( Perfil_Usuario ) REFERENCES Perfiles(Id_Perfil);

CREATE TABLE Programaciones_Academicas (
    Id_ProgAcademica VARCHAR(4) NOT NULL,
    Docente_ProgAcademica VARCHAR(15) NOT NULL,
    Asignatura VARCHAR(10) NOT NULL,
    Grupo_Asignatura VARCHAR(3) NOT NULL,
    Nro_Estudiantes_Asignatura VARCHAR(3) NOT NULL,
    Dias_Asignatura VARCHAR(255) NOT NULL,
    HoraInicio_Asignatura VARCHAR(10),
    HoraFin_Asignatura VARCHAR(10) NOT NULL,
    Aula_Clase VARCHAR(10) NOT NULL
);
ALTER TABLE Programaciones_Academicas ADD CONSTRAINT Programaciones_Academicas_PK PRIMARY KEY ( Id_ProgAcademica ) ;
ALTER TABLE Programaciones_Academicas ADD CONSTRAINT Docente_ProgAcademica_FK FOREIGN KEY ( Docente_ProgAcademica ) REFERENCES Docentes(NumDoc_Docente);
ALTER TABLE Programaciones_Academicas ADD CONSTRAINT AsignaturaPA_FK FOREIGN KEY ( Asignatura ) REFERENCES Asignaturas(Codigo_Asignatura);
ALTER TABLE Programaciones_Academicas ADD CONSTRAINT Aula_Clase_FK FOREIGN KEY ( Aula_Clase ) REFERENCES Aulas(Id_Aula);

CREATE TABLE Asesorias (
    Id_Asesoria VARCHAR(5) NOT NULL,
    Docente_Asesoria VARCHAR(15) NOT NULL,
    Asignatura_Asesoria VARCHAR(10) NOT NULL,
    Fecha_Asesoria VARCHAR(50) NOT NULL,
    HoraInicio_Asesoria VARCHAR(10) NOT NULL,
    HoraFin_Asesoria VARCHAR(10) NOT NULL,
    Lugar_Asesoria VARCHAR(50) NOT NULL,
    Cupos_Asesoria VARCHAR(3) NOT NULL,
    CuposDisp_Asesoria VARCHAR(3) NOT NULL,
    Observaciones_Asesoria VARCHAR(255) NOT NULL,
    Estado_Asesoria VARCHAR(20) NOT NULL
);
ALTER TABLE Asesorias ADD CONSTRAINT Asesorias_PK PRIMARY KEY ( Id_Asesoria ) ;
ALTER TABLE Asesorias ADD CONSTRAINT Docente_Asesoria_FK FOREIGN KEY ( Docente_Asesoria ) REFERENCES Docentes(NumDoc_Docente);
ALTER TABLE Asesorias ADD CONSTRAINT Asignatura_Asesoria_FK FOREIGN KEY ( Asignatura_Asesoria ) REFERENCES Asignaturas(Codigo_Asignatura);

CREATE TABLE Estudiantes_Asesoria (
    Id_EstudianteInsAsesoria VARCHAR(5) NOT NULL,
    Id_Estudiante VARCHAR(15) NOT NULL,
    Id_Asesoria VARCHAR(5) NOT NULL
);
ALTER TABLE Estudiantes_Asesoria ADD CONSTRAINT Estudiantes_Asesoria_PK PRIMARY KEY ( Id_EstudianteInsAsesoria ) ;
ALTER TABLE Estudiantes_Asesoria ADD CONSTRAINT Id_Estudiante_FK FOREIGN KEY ( Id_Estudiante ) REFERENCES Estudiantes(NumDoc_Estudiante);
ALTER TABLE Estudiantes_Asesoria ADD CONSTRAINT Id_Asesoria_FK FOREIGN KEY ( Id_Asesoria ) REFERENCES Asesorias(Id_Asesoria);


CREATE TABLE IF NOT EXISTS `personas` (
  `NumDoc` varchar(15) NOT NULL,
  `Tipo_Identificacion` varchar(3) NOT NULL,
  `Nombres_Estudiante` varchar(255) NOT NULL,
  `PApellido` varchar(255) NOT NULL,
  `SApellido` varchar(255) DEFAULT NULL,
  `Genero` varchar(1) NOT NULL,
  `FechaNac` varchar(15) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Celular` varchar(15) DEFAULT NULL,
  `Correo` varchar(255) NOT NULL,
  `PlanEstudios_Estudiante` varchar(255) NOT NULL,
  `Semestre_Estudiante` varchar(1) NOT NULL,
  `Estado` varchar(10) NOT NULL,
  `Perfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
 ADD PRIMARY KEY (`NumDoc`), ADD KEY `Tipo_Identificacion_Est_FK` (`Tipo_Identificacion`), ADD KEY `Perfil_Estudiante_FK` (`Perfil`);
