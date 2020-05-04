INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 12, 40, true,'Airbus A320 neo', 1000, 600);
INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 6,  50, true,'Airbus A340', 1500, 770);
INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 4,  80, true,'Airbus A350', 2000, 600);
INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 12, 120, true,'Airbus A380', 1500, 750);
INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 8,  40, true,'Boeing 717 ', 3000, 920);
INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 6,  60, true,'Boeing 747-8', 1500, 800);
INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 8,  40, true,'Boeing 787 Dreamliner', 2500, 660);
INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 8,  30, true,'Bombardier Cseries', 1100, 510);
INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 4,  400, true,'Bombardier CRJ 700', 2200, 570);
INSERT INTO public.aviones( cantidad_motores, cantidad_pasajeros, disponible, modelo, peso_maximo, velocidad_maxima)	VALUES ( 14, 50, true,'Boeing Dreamliner', 3100, 876);

INSERT INTO public.categorias_vuelos(categoria,costo) VALUES ( 'Clase económica',0);
INSERT INTO public.categorias_vuelos(categoria,costo) VALUES ( 'Primera clase',1000);
INSERT INTO public.categorias_vuelos(categoria,costo) VALUES ( 'Clase empresarial',800);


INSERT INTO public.clientes( nombre, ap_paterno, ap_materno, edad, correo, sexo, telefono, peso)    VALUES ( 'Jose','Hernandez', 'Hernandez', 12,'joseluis@gmail.com', 'Masculino', 722223121, 79);
    INSERT INTO public.equipaje(alto_y, ancho_z, largo_x, peso, resistencia, id_cliente)VALUES (23,22,22, 42, 4, 1);
    INSERT INTO public.equipaje(alto_y, ancho_z, largo_x, peso, resistencia, id_cliente)VALUES (43,22,12, 34, 4, 1);
    INSERT INTO public.equipaje(alto_y, ancho_z, largo_x, peso, resistencia, id_cliente)VALUES (31,25,21, 12, 4, 1);
    
INSERT INTO public.clientes( nombre, ap_paterno, ap_materno, edad, correo, sexo, telefono, peso)    VALUES ( 'Luis','Hernandez', 'Victoria', 12,'luis@gmail.com', 'Masculino', 721321311, 81);
    INSERT INTO public.equipaje(alto_y, ancho_z, largo_x, peso, resistencia, id_cliente)VALUES (31,22,18, 24, 4, 2);
    INSERT INTO public.equipaje(alto_y, ancho_z, largo_x, peso, resistencia, id_cliente)VALUES (12,23,12, 43, 4, 2);

INSERT INTO public.clientes( nombre, ap_paterno, ap_materno, edad, correo, sexo, telefono, peso)    VALUES ( 'Luis','Victoria', 'Victoria', 12,'luis@gmail.com', 'Masculino', 721321311, 81);

INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Micronesia','Palikir',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Moldavia','Chisináu',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Mónaco','Mónaco',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Mongolia','UlánBator',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Montenegro','Podgorica',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Mozambique','Maputo',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Namibia','Windhoek',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Nauru','Yaren',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Nepal','Katmandú',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Nicaragua','Managua',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Níger','Niamey',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Nigeria','Abuya',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Noruega','Oslo',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('NuevaZelanda','Wellington',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Omán','Mascate',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('PaísesBajos','Ámsterdam',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Pakistán','Islamabad',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Palaos','Melekeok',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Panamá','Panamá',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('PapúaNuevaGuinea','PortMoresby',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Paraguay','Asunción',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Perú','Lima',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Polonia','Varsovia',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Portugal','Lisboa',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('ReinoUnidodeGranBretañaeIrlandadelNorte','Londres',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('RepúblicaCentroafricana','Bangui',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('RepúblicaCheca','Praga',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('RepúblicadelCongo','Brazzaville',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('RepúblicaDemocráticadelCongo','Kinsasa',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('RepúblicaDominicana','SantoDomingo',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('RepúblicaSudafricana','Bloemfontein,CiudadDelCaboyPretoria',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Ruanda','Kigali',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Rumanía','Bucarest',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Rusia','Moscú',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Samoa','Apia',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('SanCristóbalyNieves','Basseterre',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('SanMarino','SanMarino',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('SanVicenteylasGranadinas','Kingstown',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('SantaLucía','Castries',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('SantoToméyPríncipe','SantoTomé',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Senegal','Dakar',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Serbia','Belgrado',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Seychelles','Victoria',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('SierraLeona','Freetown',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Singapur','Singapur',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Siria','Damasco',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Somalia','Mogadiscio',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('SriLanka','SriJayewardenepura(capitaladministrativa)yColombo(capitalcomercial)',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Suazilandia','BabaneyLobamba',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Sudán','Jartum',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('SudándelSur','Yuba',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Suecia','Estocolmo',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Suiza','Berna',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Surinam','Paramaribo',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Tailandia','Bangkok',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Tanzania','Dodoma',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Tayikistán','Dusambé',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('TimorOriental','Dili',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Togo','Lomé',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Tonga','Nukualofa',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('TrinidadyTobago','PuertoEspaña',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Túnez','Túnez',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Turkmenistán','Asjabad',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Turquía','Ankara',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Tuvalu','Fongafale',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Ucrania','Kiev',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Uganda','Kampala',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Uruguay','Montevideo',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Uzbekistán','Taskent',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Vanuatu','PortVila',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Venezuela','Caracas',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Vietnam','Hanói',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Yemen','Saná',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Yibuti','Yibuti',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Zambia','Lusaka',true);
INSERT INTO public.destinos(ciudad,pais,disponible)VALUES('Zimbabue','Harare',true);    
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Afganistán','Kabul',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Albania','Tirana',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Austria','Graz',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Austria','Linz',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Azerbaiyán','Bakú',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Italia','Roma',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Jamaica','Kingston',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Japón','Tokio',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Japón','Kioto',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Japón','Osaka',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Kenia','Nairobi',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Kenia','Kisumu',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('Kenia','Nakuru',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('México','Ciudad de México',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('México','Monterrey',true);
INSERT INTO public.destinos(pais,ciudad,disponible)VALUES('México','Yucatan',true);

	
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Piloto', 50000, 1);
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Técnico ', 40000, 1);
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Azafata ', 35000, 1);
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Auxiliar de Tierra', 20000, 1);
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Empleado de Salón VIP', 30000, 1);
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Piloto', 50000, 2);
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Técnico ', 40000, 2);
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Azafata ', 35000, 2);
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Auxiliar de Tierra', 20000, 2);
INSERT INTO public.puestos(puesto, salario, turno) VALUES ( 'Empleado de Salón VIP', 30000, 2);

INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)	VALUES ('Luis', 'Hernandez', 'Victoria', 'luis@gmail.com', 21, true, 'Masculino', 7220101010, 1);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)	VALUES ('Jose', 'Hernandez', 'Victoria', 'Jose@gmail.com', 22, true, 'Masculino', 7220202020, 2);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('ANTONIO','GARCIA','ALARCON'         ,'ANTONIO65@gmail.com',32,true, 'Masculino',7224400088,10);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JOSE','MARTINEZ','ALFARO'           ,'JOSE24@gmail.com',21,true, 'Femenino',7225885203,10);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('FRANCISCO','LOPEZ','ARENAS'         ,'FRANCISCO66@gmail.com',22,true, 'Masculino',7221416148,5);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JUAN','SANCHEZ','BALLESTEROS'       ,'JUAN88@gmail.com',26,true, 'Femenino',7223174148,8);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('MANUEL','GONZALEZ','BLAZQUEZ'       ,'MANUEL29@gmail.com',25,true, 'Masculino',7225385071,5);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('PEDRO','GOMEZ','CALERO'             ,'PEDRO69@gmail.com',30,true, 'Femenino',7224192824,1);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JESUS','FERNANDEZ','CANO'           ,'JESUS19@gmail.com',43,true, 'Masculino',7223217465,8);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('ANGEL','MORENO','CASTILLO'          ,'ANGEL95@gmail.com',46,true, 'Femenino',7223805063,5);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('MIGUEL','JIMENEZ','CEBRIAN'         ,'MIGUEL77@gmail.com',39,true, 'Masculino',7224635540,2);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JAVIER','PEREZ','COLLADO'           ,'JAVIER34@gmail.com',35,true, 'Femenino',7221513831,10);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JOSE ANTONIO','RODRIGUEZ','CORCOLES','JOSEANTONIO54@gmail.com',39,true, 'Masculino',7224857176,5);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('DAVID','NAVARRO','CUENCA'           ,'DAVID48@gmail.com',49,true, 'Femenino',7226462368,7);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('CARLOS','RUIZ','DIAZ'               ,'CARLOS56@gmail.com',36,true, 'Masculino',7224382393,9);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JOSE LUIS','DIAZ','FERNANDEZ'       ,'JOSELUIS97@gmail.com',23,true, 'Femenino',7229961379,8);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('ALEJANDRO','SERRANO','GARCIA'       ,'ALEJANDRO82@gmail.com',50,true, 'Masculino',7224973233,5);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('MIGUEL ANGEL','HERNANDEZ','GARRIDO' ,'MIGUELANGEL14@gmail.com',26,true, 'Femenino',7223318696,8);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('FRANCISCO JAVIER','MUÑOZ','GIL'     ,'FRANCISCOJAVIER47@gmail.com',44,true, 'Masculino',7227120259,3);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('RAFAEL','SAEZ','GOMEZ'              ,'RAFAEL12@gmail.com',46,true, 'Femenino',7222698968,7);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('DANIEL','ROMERO','GONZALEZ'         ,'DANIEL85@gmail.com',44,true, 'Masculino',7223803290,5);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JUAN JOSE','RUBIO','HERNANDEZ'      ,'JUANJOSE35@gmail.com',46,true, 'Femenino',7229226556,5);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('LUIS','ALFARO','JIMENEZ'            ,'LUIS30@gmail.com',29,true, 'Masculino',7222654097,7);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('PABLO','MOLINA','LOPEZ'             ,'PABLO99@gmail.com',28,true, 'Femenino',7224641860,3);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JUAN ANTONIO','LOZANO','LOZANO'     ,'JUANANTONIO38@gmail.com',33,true, 'Masculino',7221737426,6);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JOAQUIN','CASTILLO','MARIN'         ,'JOAQUIN17@gmail.com',40,true, 'Femenino',7227539029,9);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('SERGIO','PICAZO','MARTINEZ'         ,'SERGIO83@gmail.com',24,true, 'Masculino',7223028406,9);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('FERNANDO','ORTEGA','MOLINA'         ,'FERNANDO60@gmail.com',43,true, 'Femenino',7226017205,10);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JUAN CARLOS','MORCILLO','MORCILLO'  ,'JUANCARLOS64@gmail.com',30,true, 'Masculino',7226524016,9);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('ANDRES','CANO','MORENO'             ,'ANDRES57@gmail.com',23,true, 'Femenino',7225485678,6);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JOSE MANUEL','MARIN','MOYA'         ,'JOSEMANUEL87@gmail.com',45,true, 'Masculino',7224491293,3);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JOSE MARIA','CUENCA','MUÑOZ'        ,'JOSEMARIA93@gmail.com',42,true, 'Femenino',7226809132,7);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('RAMON','GARRIDO','NAVARRO'          ,'RAMON56@gmail.com',23,true, 'Masculino',7224968524,4);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('RAUL','TORRES','NUÑEZ'              ,'RAUL69@gmail.com',32,true, 'Femenino',7226552083,6);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('ALBERTO','CORCOLES','ORTEGA'        ,'ALBERTO99@gmail.com',42,true, 'Masculino',7228123473,2);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('ENRIQUE','GIL','ORTIZ'              ,'ENRIQUE39@gmail.com',22,true, 'Femenino',7228892824,5);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('ALVARO','ORTIZ','PARDO'             ,'ALVARO99@gmail.com',44,true, 'Masculino',7224578067,1);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('VICENTE','CALERO','PEREZ'           ,'VICENTE76@gmail.com',23,true, 'Femenino',7228530327,5);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('EMILIO','VALERO','PICAZO'           ,'EMILIO30@gmail.com',44,true, 'Masculino',7227484697,2);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('FRANCISCO JOSE','CEBRIAN','RAMIREZ' ,'FRANCISCOJOSE62@gmail.com',38,true, 'Femenino',7223990071,1);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('DIEGO','RODENAS','REQUENA '         ,'DIEGO81@gmail.com',45,true, 'Masculino',7227578394,10);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JULIAN','ALARCON','RODENAS'         ,'JULIAN45@gmail.com',29,true, 'Femenino',7226485806,3);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JORGE','BLAZQUEZ','RODRIGUEZ'       ,'JORGE14@gmail.com',25,true, 'Masculino',7229770977,6);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('ALFONSO','NUÑEZ','ROMERO'           ,'ALFONSO99@gmail.com',21,true, 'Femenino',7224952306,7);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('ADRIAN','PARDO','RUBIO'             ,'ADRIAN20@gmail.com',23,true, 'Masculino',7221597716,7);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('RUBEN','MOYA','RUIZ'                ,'RUBEN29@gmail.com',41,true, 'Femenino',7229863920,8);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('SANTIAGO','TEBAR','SAEZ'            ,'SANTIAGO79@gmail.com',26,true, 'Masculino',7223205475,3);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('IVAN','REQUENA','SANCHEZ'           ,'IVAN60@gmail.com',43,true, 'Femenino',7221761244,3);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JUAN MANUEL','ARENAS','SERRANO'     ,'JUANMANUEL73@gmail.com',28,true, 'Masculino',7225052885,1);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('PASCUAL','BALLESTEROS','TEBAR'      ,'PASCUAL52@gmail.com',43,true, 'Femenino',7228759251,7);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('JOSE MIGUEL','COLLADO','TORRES'     ,'JOSEMIGUEL88@gmail.com',46,true, 'Masculino',7225073302,1);
INSERT INTO public.empleados(nombre,ap_materno, ap_paterno, correo, edad, ocupado, sexo, telefono, id_puesto)VALUES('MARIO','RAMIREZ','VALERO'           ,'MARIO31@gmail.com',41,true, 'Femenino',7224614622,2);

INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (108757,'12/12/2019','03:00','03:00',46,9,20);
INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (51812,'12/12/2019','04:00','04:00',44,3,9);
INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (59264,'11/12/2019','05:00','05:00',48,7,37);
INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (52475,'10/12/2019','06:00','06:00',20,6,1);
INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (71545,'12/12/2019','07:00','07:00',42,9,31);
INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (81192,'13/12/2019','08:00','08:00',8,9,9);
INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (43906,'01/10/2019','09:00','09:00',8,5,29);
INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (119781,'30/04/2019','10:00','10:00',34,2,30);
INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (58762,'12/07/2019','11:00','11:00',24,1,9);
INSERT INTO public.vuelos(costo, fecha, hora_llegada, hora_salida, reservados, id_avion, id_destino)VALUES (71529,'12/12/2019','12:00','12:00',22,6,6);										

	
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('A9',1,4,1);
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('B12',2,9,2);
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('C5',3,9,3);
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('D15',1,8,1);
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('E17',2,3,2);
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('F3',3,9,3);
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('A20',1,2,1);
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('B8',2,8,2);
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('C15',3,6,3);
INSERT INTO public.reservas_vuelos( numero_asiento, id_categoriavuelo, id_vuelo,id_cliente)VALUES ('D2',1,1,1);


INSERT INTO public.personal_vuelo(id_vuelo,id_empleado)VALUES (1,1);
INSERT INTO public.personal_vuelo(id_vuelo,id_empleado)VALUES (1,2);
INSERT INTO public.personal_vuelo(id_vuelo,id_empleado)VALUES (2,1);
INSERT INTO public.personal_vuelo(id_vuelo,id_empleado)VALUES (2,2);