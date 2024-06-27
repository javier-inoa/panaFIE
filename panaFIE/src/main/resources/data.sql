insert into role (id, name, description) values (NEXTVAL('hibernate_sequence'), 'Administrador', 'Este rol podra crear un pasanaku designar moderadores. ');
insert into role (id, name, description) values (NEXTVAL('hibernate_sequence'), 'Moderador', 'Este rol podra controlar los juegos de pasanaku. ');
insert into role (id, name, description) values (NEXTVAL('hibernate_sequence'), 'Jugador', 'Este rol manda solicitudes de union a los pasanakus. ');

insert into typenotification (id, name, description) values (NEXTVAL('hibernate_sequence'), 'Alerta', 'Sera para mandar a los jugadores que no realicen los pagos en el tiempo limite. ');
insert into typenotification (id, name, description) values (NEXTVAL('hibernate_sequence'), 'Informativa', 'Proporciona información relevante al usuario. ');
insert into typenotification (id, name, description) values (NEXTVAL('hibernate_sequence'), 'Aceptacion', 'Indica que una acción se ha completado correctamente y se ha aceptado. ');
insert into typenotification (id, name, description) values (NEXTVAL('hibernate_sequence'), 'Rechazo', 'Indica que una acción no se puede realizar o que se ha denegado. ');
insert into typenotification (id, name, description) values (NEXTVAL('hibernate_sequence'), 'Error', 'Se muestra cuando ocurre un problema o excepción. ');

insert into user (id, roleId, name, lastname, state, email, password) values (NEXTVAL('hibernate_sequence'), 1, 'javier', 'Inca Apaza', 1, 'javier@gmail.com' , '12345678');