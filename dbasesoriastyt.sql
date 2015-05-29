CREATE TABLE IF NOT EXISTS `asesorias` (
`Id_Asesoria` int(11) NOT NULL,
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
  `Estado_Asesoria` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `BackupAsesorias` (
`Id_Asesoria` int(11) NOT NULL,
  `Nombre_Asesoria_BK` varchar(50) DEFAULT NULL,
  `Docente_Asesoria_BK` varchar(15) NOT NULL,
  `Nombre_Docente_Asesoria_BK` varchar(200) NOT NULL,
  `Apellidos_Asesoria_BK` varchar(200) NOT NULL,
  `Asignatura_Asesoria_BK` varchar(10) NOT NULL,
  `Asignatura_Nombre_BK` varchar(10) NOT NULL,
  `Fecha_Asesoria_BK` varchar(50) NOT NULL,
  `HoraInicio_Asesoria_BK` varchar(10) NOT NULL,
  `HoraFin_Asesoria_BK` varchar(10) NOT NULL,
  `Lugar_Asesoria_BK` varchar(50) NOT NULL,
  `Cupos_Asesoria_BK` varchar(3) NOT NULL,
  `CuposDisp_Asesoria_BK` varchar(3) DEFAULT NULL,
  `RecursosApoyo_Asesoria_BK` varchar(255) DEFAULT NULL,
  `Observaciones_Asesoria_BK` varchar(255) DEFAULT NULL,
  `Estado_Asesoria_BK` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asesorias`
--

INSERT INTO `asesorias` (`Id_Asesoria`, `Nombre_Asesoria`, `Docente_Asesoria`, `Asignatura_Asesoria`, `Fecha_Asesoria`, `HoraInicio_Asesoria`, `HoraFin_Asesoria`, `Lugar_Asesoria`, `Cupos_Asesoria`, `CuposDisp_Asesoria`, `RecursosApoyo_Asesoria`, `Observaciones_Asesoria`, `Estado_Asesoria`) VALUES
(1, 'Fracionarios', '97091800296', 'ING00816', '2015-03-23', '10:00am', '11:00am', 'Seleccione...', '15', '15', 'Taller', ' Buena Asistencia', 'Confirmada'),
(2, 'Taller civica', '97091800296', 'ING00816', '2015-04-23', '10:00am', '11:00am', 'almedros', '15', '15', 'Taller', 'Buena Asistencia', 'Confirmada'),
(3, 'Tabla de la verdad', '2128478289', 'ING00816', '2015-03-23', '10:00am', '11:00am', 'almedros', '15', '15', 'Taller', 'Traer taller', 'Confirmada'),
(4, 'Ciclo de Vida de sw', '1234567', 'ING00816', '2015-05-23', '10:00am', '11:00am', 'almedros', '15', '15', 'Taller', 'Traer taller', 'Confirmada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE IF NOT EXISTS `asignaturas` (
  `Codigo_Asignatura` varchar(10) NOT NULL,
  `Nombre_Asignatura` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asignaturas`
--

INSERT INTO `asignaturas` (`Codigo_Asignatura`, `Nombre_Asignatura`) VALUES
('ING00812', 'Identificación del Ciclo de Vida del Software'),
('ING00813', 'Comprensión y respeto del entorno'),
('ING00814', 'Desarrollo de actitudes ciudadanas'),
('ING00816', 'Desarrollo del pensamiento lógico y matemático 1 (A)'),
('ING00818', 'Desarrollo del pensamiento lógico y matemático 1 (B)'),
('ING00819', 'Definición de Requerimientos'),
('ING00824', 'Construcción de informes utilizando herramientas Ofimáticas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE IF NOT EXISTS `aulas` (
  `Id_Aula` varchar(10) NOT NULL,
  `Id_Bloque_Aula` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`Id_Aula`, `Id_Bloque_Aula`) VALUES
('202', 'P17'),
('303', 'P17'),
('201', 'P31'),
('208', 'P38');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bloques`
--

CREATE TABLE IF NOT EXISTS `bloques` (
  `Id_Bloque` varchar(4) NOT NULL,
  `Encargado_Bloque` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bloques`
--

INSERT INTO `bloques` (`Id_Bloque`, `Encargado_Bloque`) VALUES
('P17', '123'),
('P31', '456'),
('P38', '789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encargados_bloques`
--

CREATE TABLE IF NOT EXISTS `encargados_bloques` (
  `Id_Encargado_Bloque` varchar(15) NOT NULL,
  `Correo_Encargado_Bloque` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `encargados_bloques`
--

INSERT INTO `encargados_bloques` (`Id_Encargado_Bloque`, `Correo_Encargado_Bloque`) VALUES
('970918002956', 'natalia.970918@gmail.com'),
('123', 'natavelez17@gmail.com'),
('789', 'nathalia_gaviria24111@elpoli.edu.co'),
('456', 'paola_vargas24111@elpoli.edu.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes_asesoria`
--

CREATE TABLE IF NOT EXISTS `estudiantes_asesoria` (
  `Id_Estudiante` varchar(15) NOT NULL,
  `Id_Asesoria` int(11) NOT NULL DEFAULT '0',
  `Asistencia_Asesoria` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiantes_asesoria`
--

INSERT INTO `estudiantes_asesoria` (`Id_Estudiante`, `Id_Asesoria`, `Asistencia_Asesoria`) VALUES
('1017130175', 4, 'Si'),
('1017130748', 2, 'Si'),
('1017132325', 1, 'Si'),
('1017134328', 3, 'Si'),
('1017134941', 2, 'Si'),
('1017135998', 4, 'Si'),
('1017161823', 1, 'Si'),
('1214719040', 1, NULL),
('1214719040', 2, 'Si'),
('1214719040', 3, 'Si'),
('1214719040', 4, 'No'),
('123456789', 1, 'Si'),
('123456789', 2, 'Si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE IF NOT EXISTS `perfiles` (
`Id_Perfil` int(11) NOT NULL,
  `Nombre_Perfil` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`Id_Perfil`, `Nombre_Perfil`) VALUES
(1, 'Administrador'),
(2, 'Docente'),
(3, 'Estudiante'),
(4, 'Prueba');

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
  `Perfil_Persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`NumDoc_Persona`, `Tipo_Identificacion`, `Nombres_Persona`, `PApellido_Persona`, `SApellido_Persona`, `Genero_Persona`, `FechaNac_Persona`, `Direccion_Persona`, `Telefono_Persona`, `Celular_Persona`, `Correo_Persona`, `PlanEstudios_Persona`, `Semestre_Persona`, `Estado_Persona`, `Perfil_Persona`) VALUES
('1017129708', 'CC', 'ADRIANA', 'DUQUE', 'N/A', 'Femenino', '20/10/1988', 'CRA 80  #50 A 19', '2651682', '2147483647', 'paola_vargas22111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017130081', 'CC', 'ALEJANDRO DE JESUS', 'RESTREPO ', 'VELEZ', 'Femenino', '21/10/1989', 'CRA 80 C  #32 EE 26', '2651968', '2147483647', 'Alejandro _Restrepo 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017130175', 'CC', 'ANA MARIA', 'MOLINA ', 'LONDOÑO', 'Femenino', '22/10/1988', 'CRA 80# 37- 24 APT 801', '2652536', '2147483647', 'Ana _Molina 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017130748', 'CC', 'ANDRES FELIPE', 'OSORIO ', 'ALZATE', 'Masculino', '14/12/1988', 'CRA 80# 80-03', '2654580', '2147483647', 'Andres _Osorio 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017132325', 'CC', 'CARLOS ALBERTO', 'TABORDA', ' GIRALDO', 'Masculino', '23/10/1988', 'CRA 80A # 33AA - 43', '2654610', '2147483647', 'Carlos _Taborda24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017132592', 'CC', 'CARLOS HUMBERTO', 'CASTAÑO', '', 'Masculino', '24/10/1988', 'CRA 80C # 30A - 67', '2655268', '2147483647', 'Carlos _Castaño24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017132604', 'CC', 'CARMEN LUCIA', 'RESTREPO', ' CIFUENTES', 'Femenino', '25/10/1988', 'CRA 81 # 32-56', '2655865', '2147483647', 'Carmen _Restrepo24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017133200', 'CC', 'CATALINA', 'SALDARRIAGA', '', 'Femenino', '26/10/1988', 'CRA 81 # 48B -03', '2657439', '2147483647', 'Catalina_Saldarriaga24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017133281', 'CC', 'DIANA MILENA', 'ARCILA ', 'SANCHEZ', 'Femenino', '27/10/1988', 'CRA 81 #88B- 03', '2659706', '2147483647', 'Diana _Arcila 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017134328', 'CC', 'ILDA HELLEN', 'GALEANO', '', 'Femenino', '28/10/1988', 'CRA 81 #7- 101 ', '2660622', '2147483647', 'Ilda_Galeano24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017134941', 'CC', 'JAIME ALBERTO', 'GIL ', 'MEJIA', 'Masculino', '29/10/1988', 'CRA 81 B # 48 - 56', '2660630', '2147483647', 'Jaimea_Gil 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017135998', 'CC', 'JASON EDWIN', 'MOLINA ', 'VARGAS', 'Masculino', '30/10/1988', 'CRA 81 B #7 19 APT 1403', '2660650', '2147483647', 'Jason_Molina 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017137351', 'CC', 'JUAN SEBASTIAN', 'CHILABACK', '', 'Masculino', '23/12/1988', 'CRA 81A # 32 C - 53 APT 202', '2660808', '2147483647', 'Juan _Chilaback24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017137457', 'CC', 'JULIO HUMBERTO', 'FERNANDEZ ', 'TRUJILLO', 'Masculino', '24/12/1988', 'CRA 81A # 47 - 97', '2661302', '2147483647', 'Julio _Fernandez 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017139500', 'CC', 'MARTA', 'CARDONA ', '', 'Femenino', '25/12/1988', 'CRA 81B # 54 - 84', '2661910', '2147483647', 'Marta_Cardona 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017139771', 'CC', 'NATALI YOHANA', 'TABORDA', '', 'Femenino', '26/12/1988', 'CRA 81C # 49DD - 19', '2661947', '2147483647', 'Natali _Taborda24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('1017140270', 'CC', 'PAOLO ANDREA', 'QUIROZ', ' OSPINA', 'Femenino', '27/12/1988', 'CRA 82 # 33AA - 66', '2662976', '2147483647', 'Paolo _Quiroz24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017142963', 'CC', 'SANDRA LORENA', 'DUQUE ', 'HENAO', 'Femenino', '28/12/1988', 'CRA 82 A # 26 37 APTO 605', '2663155', '2147483647', 'Sandra_Duque 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017144265', 'CC', 'WIMAR', 'GOMEZ ', '', 'Masculino', '29/12/1988', 'CRA 82 # 48-85', '2663198', '2147483647', 'Wimar_Gomez 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017144610', 'CC', 'ABELARDO', 'SALAZAR', ' MEJIA', 'Masculino', '30/12/1988', 'CRA 82A #32B -147', '2663436', '2147483647', 'Abelardo_Salazar24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017146818', 'CC', 'ABRAHAN', 'CESPEDES', '', 'Masculino', '31/12/1988', 'CRA 82A #33AA - 9', '2663506', '2147483647', 'Abrahan_Cespedes24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017147520', 'CC', 'ADEL IVAN', 'GOURMET', '', 'Masculino', '01/01/1989', 'CRA 82C  # 30A - 105', '2663895', '2147483647', 'Adel ivan_Gourmet24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017148145', 'CC', 'ADELAIDA', 'MENDIETA', '', 'Femenino', '02/01/1989', 'CRA 82C # 17-13', '2664731', '2147483647', 'Adelaida_Mendieta24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017148267', 'CC', 'ADIELA MARIA', 'TOBON', '', 'Femenino', '03/01/1989', 'CRA 82C # 30A-105 APT 909', '2665153', '2147483647', 'Adiela_Tobon24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017149504', 'CC', 'ADOLFO', 'MUNOZ ', 'BETANCUR', 'Masculino', '04/01/1989', 'CRA 83 # 50A - 55', '2665687', '2147483647', 'Adolfo_Munoz 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017150230', 'CC', 'ADOLFO LEON', 'CARMONA ', 'SERNA', 'Masculino', '05/01/1989', 'CRA 83 35 20', '2666255', '2147483647', 'Adolfo _Carmona 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017150463', 'CC', 'ADONAI', 'LONDONO', 'MUNOZ', 'Masculino', '06/01/1989', 'CRA 83 A # 37B - 17 APT 208', '2666415', '2147483647', 'Adonai_Londono24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017150983', 'CC', 'ADRIAN', 'OSSA ', 'BOTERO', 'Masculino', '31/10/1988', 'CRA 83A # 27A -36', '2666768', '2147483647', 'Adrian_Ossa 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017152331', 'CC', 'ADRIAN ALEXIS', 'MORALES', ' AYAZO', 'Masculino', '01/11/1988', 'CRA 83A # 34B 60 APTO401', '2666841', '2147483647', 'Adrian _Morales24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017152783', 'CC', 'ADRIAN MARCELA', 'LOPEZ ', 'CALLE', 'Femenino', '02/11/1988', 'CRA 83A # 37D - 29', '2666882', '2147483647', 'Adrian_Lopez 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017152878', 'CC', 'ADRIANA', 'CORREA ', 'OCHOA', 'Femenino', '03/11/1988', 'CRA 83A # 42- 28', '2668353', '2147483647', 'Adriana_Correa 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017153683', 'CC', 'ADRIANA CECILIA', 'ROJAS', ' GIL', 'Femenino', '04/11/1988', 'CRA 84B # 15A - 71', '2679718', '2147483647', 'Adriana _Rojas24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017153808', 'CC', 'ADRIANA ELENA', 'ZAPATA ', 'ARCILA', 'Femenino', '05/11/1988', 'CRA 84B # 4A-75', '2680820', '2147483647', 'Adriana _Zapata 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '4', 'Activo', 3),
('1017155228', 'CC', 'ADRIANA LUCIA', 'MARIN', ' ZAPATA', 'Femenino', '06/11/1988', 'CRA 84E # 9 -  12', '2680820', '2147483647', 'Adriana _Marin24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017155398', 'CC', 'ADRIANA MARIA', 'GIRALDO', '', 'Femenino', '07/11/1988', 'CRA 85 # 66 - 35', '2681330', '2147483647', 'Adriana_Giraldo24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017156764', 'CC', 'ADRIANA MILENA', 'RESTREPO ', 'ALVAREZ', 'Femenino', '08/11/1988', 'CRA 86 # 32-27', '2682055', '2147483647', 'Adriana _Restrepo 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017157563', 'CC', 'ADRIANA PATRICIA', 'WOLFF', '', 'Femenino', '09/11/1988', 'CRA 89 # 32C 99 - 602', '2682442', '2147483647', 'Adriana _Wolff24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017157697', 'CC', 'ADRIANA RENDON', 'RUIZ', '', 'Femenino', '10/11/1988', 'CRA 89# 40 APT 203', '2683022', '2147483647', 'Adriana _Ruiz24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017158002', 'CC', 'ADRIEN', 'VANEGAS', ' SANCHEZ', 'Masculino', '11/11/1988', 'CRA 90A# 95-102', '2683218', '2147483647', 'Adrien_Vanegas24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017158793', 'CC', 'AEXANDRA', 'RENDON ', 'ZAPATA', 'Femenino', '12/11/1988', 'CRA25 B # 18A SUR -62', '2683431', '2147483647', 'Aexandra_Rendon 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017160310', 'CC', 'AGUSTN', 'GARCIA', ' TANGARIFE', 'Masculino', '13/11/1988', 'CRA27 # 23 SUR 145 APTO 203', '2683778', '2147483647', 'Agustn_Garcia24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017160420', 'CC', 'AIRRIGAR', 'CARDONA', '', 'Masculino', '14/11/1988', 'CRA34#18AASUR142', '2683874', '2147483647', 'Airrigar_Cardona24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017160735', 'CC', 'ALBA', 'CARDONA ', 'MOLINA', 'Femenino', '15/11/1988', 'CRA35 # 10B - 50', '2683977', '2147483647', 'Alba_Cardona 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017161823', 'CC', 'ALBA EUGENIA', 'TAMAYO ', 'CARVAJAL', 'Femenino', '24/01/1989', 'CRA35 #5SUR 350 APTO 350', '2684600', '2147483647', 'Alba _Tamayo 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('1017162507', 'CC', 'ALBA LUCIA', 'TORO', 'LONDOÑO', 'Femenino', '25/01/1989', 'CRA38 # 10 - 36 ', '2684748', '2147483647', 'Alba_Toro24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '5', 'Activo', 3),
('10366289656', 'CC', 'Paola Andrea ', 'Vargas ', 'López', 'F', '1990-03-27', 'cl 41 53 24', '37754841', '37754841', 'paola_vargas24111@elpoli.edu.co', 'N/A', 'N', 'Activo', 1),
('1214719040', 'CC', 'Nathalia', 'Velez', 'Gaviria', 'Femenino', '1993-07-17', 'Cll 77 #45-85', '20456776', 'N/A', 'nathalia_gaviria24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '3', 'Activa', 3),
('123456', 'CC', 'Julian', 'Gomez', 'Restrepo', 'M', '1980-09-18', 'Cll 1', '2333323', 'N/A', 'juliangomez@elpoli.edu.co', 'Tecnología en Sistematización de Datos', 'N', 'Activo', 2),
('1234567', 'CC', 'Mateo', 'Lopez', 'Velez', 'Masculino', '1980-12-30', 'Cll 1', '123454', 'N/A', 'mateo_lopez24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', 'N', 'Activo', 2),
('123456789', 'CC', 'Pablo', 'Montes', 'Gaviria', 'Masculion', '1983-2-1', 'Cll 77 #45-85', '20456776', 'N/A', 'pablo_montes24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '7', 'Activa', 3),
('2017130081', 'CC', 'ALEJANDRO DE JESUS', 'RESTREPO ', 'VELEZ', 'Femenino', '21/10/1988', 'CRA 80 C  #32 EE 26', '2651968', '2147483647', 'A _Restrepo 24111@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('2017130175', 'CC', 'ANA MARIA', 'MOLINA ', 'LONDOÑO', 'Femenino', '22/10/1988', 'CRA 80# 37- 24 APT 801', '2652536', '2147483647', 'Ana _Molina 24112@elpoli.edu.co', 'Tecnología en Sistematización de Datos', '1', 'Activo', 3),
('2128469285', 'CC', 'GLORIA MARIA', 'YEPEZ ', 'N/A', 'Femenino', '16/03/1989', 'CLL 29 # 81 - 19', '3134349', '2147483647', 'Gloria_Yepez 24112@elpoli.edu.co', 'N/A', 'N', 'Activo', 2),
('2128471811', 'CC', 'MARTA', 'SIERRA', 'N/A', 'Femenino', '17/03/1989', 'CLL 29 37 A 38', '3134454', '2147483647', 'marta _Sierra24112@elpoli.edu.co', 'N/A', 'N', 'Activo', 2),
('2128477871', 'CC', 'CARLA', 'SANCHEZ ', 'GOMEZ', 'Femenino', '18/03/1989', 'CLL 29 70 24', '3135233', '2147483647', 'carla_Sanchez 24112@elpoli.edu.co', 'N/A', 'N', 'Activo', 2),
('2128478289', 'CC', 'MARINA', 'ZAPATA ', 'MOLINA', 'Femenino', '19/03/1989', 'CLL 29 71 68', '3137019', '2147483647', 'marina _Zapata 24112@elpoli.edu.co', 'N/A', 'N', 'Activo', 2),
('2128478639', 'CC', 'DIANA', 'COSSIO', ' TORO', 'Femenino', '20/03/1989', 'CLL 29 82 51', '3137290', '2147483647', 'diana _Cossio24112@elpoli.edu.co', 'N/A', 'N', 'Activo', 2),
('97091800296', 'TI', 'Natalia Juliette', 'Díaz', 'Padilla', 'Femenino', '1997-08-7', 'Cll 49 AC #93-47', '2000009', 'N/A', 'natalia_diaz24131@elpoli.edu.co', 'Tecnología en Sistematización de Datos', 'N', 'Activa', 2),
('987', 'CC', 'Julian', 'Gomez', 'Restrepo', 'M', '1980-09-18', 'Cll 1', '2333323', '2333323', 'juliangomez4@elpoli.edu.co', 'N/A', 'N', 'Tecnologia', 2),
('123', 'CC', 'Maryem', 'Ruiz', 'Velez', 'Femenino', '1980-12-30', 'Cll 1', '123454', '', 'mruiz@elpoli.edu.co', NULL, NULL, 'Activo', 1);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programaciones_academicas`
--

CREATE TABLE IF NOT EXISTS `programaciones_academicas` (
`Id_ProgAcademica` int(11) NOT NULL,
  `Docente_ProgAcademica` varchar(15) NOT NULL,
  `Asignatura` varchar(10) NOT NULL,
  `Grupo_Asignatura` varchar(3) NOT NULL,
  `Nro_Estudiantes_Asignatura` varchar(3) NOT NULL,
  `Dias_Asignatura` varchar(255) NOT NULL,
  `HoraInicio_Asignatura` varchar(10) NOT NULL,
  `HoraFin_Asignatura` varchar(10) NOT NULL,
  `Aula_Clase` varchar(10) NOT NULL,
  `Semestre_ProgAcademica` varchar(2) NOT NULL,
  `Ano_ProgAcademica` varchar(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `programaciones_academicas`
--

INSERT INTO `programaciones_academicas` (`Id_ProgAcademica`, `Docente_ProgAcademica`, `Asignatura`, `Grupo_Asignatura`, `Nro_Estudiantes_Asignatura`, `Dias_Asignatura`, `HoraInicio_Asignatura`, `HoraFin_Asignatura`, `Aula_Clase`, `Semestre_ProgAcademica`, `Ano_ProgAcademica`) VALUES
(1, '1234567', 'ING00812', '01', '30', '2', '6:00pm', '8:00pm', '201', '1', '2015'),
(2, '1234567', 'ING00813', '02', '56', '1', '6:00am', '8:00am', '208', '1', '2015'),
(3, '1234567', 'ING00818', '02', '30', '2', '8:00am', '10:00am', '202', '1', '2015');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_identificacion`
--

CREATE TABLE IF NOT EXISTS `tipos_identificacion` (
  `Id_Identificacion` varchar(3) NOT NULL,
  `Nombre_Identificacion` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipos_identificacion`
--

INSERT INTO `tipos_identificacion` (`Id_Identificacion`, `Nombre_Identificacion`) VALUES
('CC', 'Cédula de Ciudadanía'),
('CE', 'Cédula de Extranjería'),
('TI', 'Tarjeta de Identidad');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asesorias`
--
ALTER TABLE `asesorias`
 ADD PRIMARY KEY (`Id_Asesoria`), ADD KEY `Asesorias_Personas_FK` (`Docente_Asesoria`), ADD KEY `Asignatura_Asesoria_FK` (`Asignatura_Asesoria`);

--
-- Indices de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
 ADD PRIMARY KEY (`Codigo_Asignatura`);

--
-- Indices de la tabla `aulas`
--
ALTER TABLE `aulas`
 ADD PRIMARY KEY (`Id_Aula`,`Id_Bloque_Aula`), ADD KEY `Aulas_Bloques_FK` (`Id_Bloque_Aula`);

--
-- Indices de la tabla `bloques`
--
ALTER TABLE `bloques`
 ADD PRIMARY KEY (`Id_Bloque`), ADD KEY `Encargados_Bloques_FK` (`Encargado_Bloque`);

--
-- Indices de la tabla `encargados_bloques`
--
ALTER TABLE `encargados_bloques`
 ADD PRIMARY KEY (`Id_Encargado_Bloque`), ADD UNIQUE KEY `Encargados_Bloques_UN` (`Correo_Encargado_Bloque`);

--
-- Indices de la tabla `estudiantes_asesoria`
--
ALTER TABLE `estudiantes_asesoria`
 ADD PRIMARY KEY (`Id_Estudiante`,`Id_Asesoria`), ADD KEY `Estudiantes_Asesoria_Ase_FK` (`Id_Asesoria`);

--
-- Indices de la tabla `perfiles`
--
ALTER TABLE `perfiles`
 ADD PRIMARY KEY (`Id_Perfil`), ADD UNIQUE KEY `Perfiles__UN` (`Nombre_Perfil`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
 ADD PRIMARY KEY (`NumDoc_Persona`), ADD UNIQUE KEY `Personas__UN` (`Correo_Persona`), ADD KEY `Personas_Perfiles_FK` (`Perfil_Persona`), ADD KEY `Personas_Tipos_Id_FK` (`Tipo_Identificacion`);

--
-- Indices de la tabla `programaciones_academicas`
--
ALTER TABLE `programaciones_academicas`
 ADD PRIMARY KEY (`Id_ProgAcademica`), ADD KEY `AsignaturaPA_FK` (`Asignatura`), ADD KEY `Programaciones_Aca_Pers_FK` (`Docente_ProgAcademica`);

--
-- Indices de la tabla `tipos_identificacion`
--
ALTER TABLE `tipos_identificacion`
 ADD PRIMARY KEY (`Id_Identificacion`), ADD UNIQUE KEY `Tipos_Identificacion__UN` (`Nombre_Identificacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asesorias`
--
ALTER TABLE `asesorias`
MODIFY `Id_Asesoria` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `perfiles`
--
ALTER TABLE `perfiles`
MODIFY `Id_Perfil` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `programaciones_academicas`
--
ALTER TABLE `programaciones_academicas`
MODIFY `Id_ProgAcademica` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asesorias`
--
ALTER TABLE `asesorias`
ADD CONSTRAINT `Asesorias_Personas_FK` FOREIGN KEY (`Docente_Asesoria`) REFERENCES `personas` (`NumDoc_Persona`),
ADD CONSTRAINT `Asignatura_Asesoria_FK` FOREIGN KEY (`Asignatura_Asesoria`) REFERENCES `asignaturas` (`Codigo_Asignatura`);

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
ADD CONSTRAINT `Personas_Perfiles_FK` FOREIGN KEY (`Perfil_Persona`) REFERENCES `perfiles` (`Id_Perfil`),
ADD CONSTRAINT `Personas_Tipos_Id_FK` FOREIGN KEY (`Tipo_Identificacion`) REFERENCES `tipos_identificacion` (`Id_Identificacion`);

--
-- Filtros para la tabla `programaciones_academicas`
--
ALTER TABLE `programaciones_academicas`
ADD CONSTRAINT `AsignaturaPA_FK` FOREIGN KEY (`Asignatura`) REFERENCES `asignaturas` (`Codigo_Asignatura`),
ADD CONSTRAINT `Programaciones_Aca_Pers_FK` FOREIGN KEY (`Docente_ProgAcademica`) REFERENCES `personas` (`NumDoc_Persona`);