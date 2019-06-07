USE bd_votaciones;

INSERT INTO `bd_votaciones`.`administrador` (`cedula`, `apellido1`, `apellido2`, `nombre`, `usuario`, `clave`) VALUES ('8', 'RODRIGUEZ', 'HERNANDEZ', 'DJENANE', 'DJ', '123');
INSERT INTO `bd_votaciones`.`administrador` (`cedula`, `apellido1`, `apellido2`, `nombre`, `usuario`, `clave`) VALUES ('9', 'MONTERREY', 'BENAVIDES', 'DIEGO ', 'DG', '123');
INSERT INTO `bd_votaciones`.`administrador` (`cedula`, `apellido1`, `apellido2`, `nombre`, `usuario`, `clave`) VALUES ('402370159', 'Obando', 'Avendana', 'Carlos', 'notcharlie', '123');
INSERT INTO `bd_votaciones`.`administrador` (`cedula`, `apellido1`, `apellido2`, `nombre`, `usuario`, `clave`) VALUES ('1', 'Grande', 'Butera', 'Ariana', 'Ari', '123');

INSERT INTO `bd_votaciones`.`partido` (`siglas`, `nombre`, `observaciones`) VALUES ('PAC', 'Partido Accion Ciudadana', 'Gano Carlitox Alvarado ');
INSERT INTO `bd_votaciones`.`partido` (`siglas`, `nombre`, `observaciones`) VALUES ('PLN', 'Partido Liberacion Nacional', 'Oscar Arias presidente electo 2 veces');
INSERT INTO `bd_votaciones`.`partido` (`siglas`, `nombre`, `observaciones`) VALUES ('PUSC', 'Partido Unidad Social Cristiana', 'Es uno de los partidos tradicionales del país, heredero de la tradición política caudillista conocida como calderonismo que data de los años cuarenta y que surge en torno a la figura de Rafael Ángel Calderón Guardia.');
INSERT INTO `bd_votaciones`.`partido` (`siglas`, `nombre`, `observaciones`) VALUES ('PFA', 'Frente Amplio', 'El Frente Amplio es un partido de izquierda democrática costarricense fundado el 16 de octubre del 2004. Fue el octavo partido más votado en las elecciones de 2018');
INSERT INTO `bd_votaciones`.`partido` (`siglas`, `nombre`, `observaciones`) VALUES ('PML', 'Movimiento Libertario', '(1994): derecha liberal económica y liberalismo político');

INSERT INTO `bd_votaciones`.`usuario` (`cedula`, `apellido1`, `apellido2`, `nombre`, `clave`, `activo`) VALUES ('2', 'Minaj', 'Onika', 'Nicki', 'Nicki', '1');
INSERT INTO `bd_votaciones`.`usuario` (`cedula`, `apellido1`, `apellido2`, `nombre`, `clave`, `activo`) VALUES ('3', 'Alvarado', 'Quesada', 'Carlos', '2', '0');
INSERT INTO `bd_votaciones`.`usuario` (`cedula`, `apellido1`, `apellido2`, `nombre`, `clave`, `activo`) VALUES ('4', 'Solis', 'Zuniga', 'Paola', '3', '0');
INSERT INTO `bd_votaciones`.`usuario` (`cedula`, `apellido1`, `apellido2`, `nombre`, `clave`, `activo`) VALUES ('5', 'Bravo', 'Womanizer', 'Jonny', '4', '0');
INSERT INTO `bd_votaciones`.`usuario` (`cedula`, `apellido1`, `apellido2`, `nombre`, `clave`, `activo`) VALUES ('6', 'Spellman', 'Witch', 'Sabrina', '6', '0');
INSERT INTO `bd_votaciones`.`usuario` (`cedula`, `apellido1`, `apellido2`, `nombre`, `clave`, `activo`) VALUES ('7', 'Targaryen', 'Stark', 'John', '7', '0');

INSERT INTO `bd_votaciones`.`votacion` (`id`, `fecha_inicio`, `fecha_apertura`, `fecha_cierre`, `fecha_final`, `estado`) VALUES ('1', '2018-07-04 00:00:00', '2018-07-04 00:00:00', '2018-07-04 00:00:00', '2018-07-04 00:00:00', '0');
INSERT INTO `bd_votaciones`.`votacion` (`id`, `fecha_inicio`, `fecha_apertura`, `fecha_cierre`, `fecha_final`, `estado`) VALUES ('2', '2018-08-23 00:00:00', '2018-08-23 00:00:00', '2018-08-24 00:00:00', '2018-08-24 00:00:00', '0');
INSERT INTO `bd_votaciones`.`votacion` (`id`, `fecha_inicio`, `fecha_apertura`, `fecha_cierre`, `fecha_final`, `estado`) VALUES ('3', '2018-09-23 00:00:00', '2018-09-23 00:00:00', '2018-09-24 00:00:00', '2018-09-24 00:00:00', '0');
INSERT INTO `bd_votaciones`.`votacion` (`id`, `fecha_inicio`, `fecha_apertura`, `fecha_cierre`, `fecha_final`, `estado`) VALUES ('4', '2018-10-23 00:00:00', '2018-10-23 00:00:00', '2018-10-24 00:00:00', '2018-10-24 00:00:00', '0');
INSERT INTO `bd_votaciones`.`votacion` (`id`, `fecha_inicio`, `fecha_apertura`, `fecha_cierre`, `fecha_final`, `estado`) VALUES ('5', '2018-11-23 00:00:00', '2018-11-23 00:00:00', '2018-11-24 00:00:00', '2018-11-24 00:00:00', '0');

INSERT INTO `bd_votaciones`.`votacion_partido` (`votacion_id`, `partido_siglas`, `cedula_candidato`, `votos_obtenidos`) VALUES ('1', 'PFA', '3', '1');
INSERT INTO `bd_votaciones`.`votacion_partido` (`votacion_id`, `partido_siglas`, `cedula_candidato`, `votos_obtenidos`) VALUES ('2', 'PAC', '2', '2');
INSERT INTO `bd_votaciones`.`votacion_partido` (`votacion_id`, `partido_siglas`, `cedula_candidato`, `votos_obtenidos`) VALUES ('3', 'PFA', '5', '3');
INSERT INTO `bd_votaciones`.`votacion_partido` (`votacion_id`, `partido_siglas`, `cedula_candidato`, `votos_obtenidos`) VALUES ('4', 'PLN', '7', '1');

INSERT INTO `bd_votaciones`.`votacion_usuario` (`votacion_id`, `usuario_cedula`, `voto_completado`) VALUES ('1', '2', '1');
INSERT INTO `bd_votaciones`.`votacion_usuario` (`votacion_id`, `usuario_cedula`, `voto_completado`) VALUES ('2', '3', '1');
INSERT INTO `bd_votaciones`.`votacion_usuario` (`votacion_id`, `usuario_cedula`, `voto_completado`) VALUES ('3', '4', '1');
INSERT INTO `bd_votaciones`.`votacion_usuario` (`votacion_id`, `usuario_cedula`, `voto_completado`) VALUES ('4', '5', '1');

