insert into role (name, description) values 
('Administrador', 'Este rol podra crear un pasanaku designar moderadores. '),
('Moderador', 'Este rol podra controlar los juegos de pasanaku. '),
('Jugador', 'Este rol manda solicitudes de union a los pasanakus. ');

insert into rule (amount_of_people, amount, total_amount, description, duration, type_of_draw) values 
(7, 1000, 6000, 'no se puede cambiar los turnos en el sorteo', 'duracion de 7 meses', true),
(10, 800, 7200, 'el ganador debe estar presente', 'duracion de 5 meses', true),
(12, 500, 5500, 'solo se permite una participacion por persona', 'duracion de 12 meses', true);

insert into date_pasanaku (start_date, finish_date) values
('2024-07-01', '2025-01-05'),
('2024-07-01', '2024-11-20'),
('2024-07-01', '2025-06-05');

insert into type_notification (name, description) values 
('Alerta', 'Sera para mandar a los jugadores que no realicen los pagos en el tiempo limite. '),
('Recordatorio', 'Avisa sobre eventos o tareas pendientes para asegurar que no se olviden. '),
('Informativa', 'Proporciona informacion relevante al usuario. '),
('Aceptacion', 'Indica que una accion se ha completado correctamente y se ha aceptado. '),
('Rechazo', 'Indica que una accion no se puede realizar o que se ha denegado. '),
('Seguridad', 'Alerta sobre actividades sospechosas o cambios importantes en la cuenta.');

insert into user (role_id, name, last_name, status, email, password) values 
(1, 'javier', 'inoa', 1, 'javierinoa@gmail.com', 'password123'),
(2, 'jane', 'doe', 1, 'jane.doe@example.com', 'password123'),
(2, 'alice', 'smith', 1, 'alice.smith@example.com', 'password123'),
(2, 'bob', 'smith', 1, 'bob.smith@example.com', 'password123'),
(3, 'charlie', 'brown', 3, 'charlie.brown@example.com', 'password123'),
(3, 'diana', 'prince', 1, 'diana.prince@example.com', 'password123'),
(3, 'eve', 'johnson', 1, 'eve.johnson@example.com', 'password123'),
(3, 'frank', 'wright', 1, 'frank.wright@example.com', 'password123'),
(3, 'george', 'harris', 1, 'george.harris@example.com', 'password123'),
(3, 'helen', 'moore', 1, 'helen.moore@example.com', 'password123'),
(3, 'ian', 'taylor', 1, 'ian.taylor@example.com', 'password123'),
(3, 'jack', 'white', 1, 'jack.white@example.com', 'password123'),
(3, 'kate', 'hall', 1, 'kate.hall@example.com', 'password123'),
(3, 'leo', 'young', 1, 'leo.young@example.com', 'password123'),
(3, 'mary', 'king', 1, 'mary.king@example.com', 'password123'),
(3, 'nick', 'lee', 1, 'nick.lee@example.com', 'password123'),
(3, 'oliver', 'clark', 1, 'oliver.clark@example.com', 'password123'),
(3, 'paul', 'martin', 1, 'paul.martin@example.com', 'password123'),
(3, 'quincy', 'thompson', 1, 'quincy.thompson@example.com', 'password123'),
(3, 'rachel', 'walker', 1, 'rachel.walker@example.com', 'password123'),
(3, 'steve', 'harris', 1, 'steve.harris@example.com', 'password123'),
(3, 'tina', 'young', 1, 'tina.young@example.com', 'password123'),
(3, 'uma', 'scott', 1, 'uma.scott@example.com', 'password123'),
(3, 'vince', 'green', 1, 'vince.green@example.com', 'password123'),
(3, 'wendy', 'adams', 1, 'wendy.adams@example.com', 'password123'),
(3, 'xavier', 'morris', 1, 'xavier.morris@example.com', 'password123'),
(3, 'yara', 'edwards', 1, 'yara.edwards@example.com', 'password123'),
(3, 'zach', 'brooks', 1, 'zach.brooks@example.com', 'password123'),
(3, 'amy', 'baker', 1, 'amy.baker@example.com', 'password123'),
(3, 'jhon', 'morris', 1, 'jhon.morris@example.com', 'password123'),
(3, 'sebastian', 'edwards', 1, 'sebastian.edwards@example.com', 'password123'),
(3, 'carlos', 'brooks', 1, 'carlos.brooks@example.com', 'password123'),
(3, 'melany', 'baker', 1, 'melany.baker@example.com', 'password123');

insert into bank_account (user_id, account_number, bank) values 
(1, 100001, 'FIE'),
(2, 100002, 'SOL'),
(3, 100003, 'BNB'),
(4, 100004, 'FIE'),
(5, 100005, 'SOL'),
(6, 100006, 'BNB'),
(7, 100007, 'FIE'),
(8, 100008, 'SOL'),
(9, 100009, 'BNB'),
(10, 100010, 'FIE'),
(11, 100011, 'SOL'),
(12, 100012, 'BNB'),
(13, 100013, 'FIE'),
(14, 100014, 'SOL'),
(15, 100015, 'BNB'),
(16, 100016, 'FIE'),
(17, 100017, 'SOL'),
(18, 100018, 'BNB'),
(19, 100019, 'FIE'),
(20, 100020, 'SOL'),
(21, 100021, 'BNB'),
(22, 100022, 'FIE'),
(23, 100023, 'SOL'),
(24, 100024, 'BNB'),
(25, 100025, 'FIE'),
(26, 100026, 'SOL'),
(27, 100027, 'BNB'),
(28, 100028, 'FIE'),
(29, 100029, 'SOL'),
(30, 100030, 'SOL'),
(31, 100031, 'BNB'),
(32, 100032, 'FIE'),
(33, 100033, 'SOL');

insert into pasanaku (user_id, date_id, rule_id, name, description, account_number, balance, status) values
(2, 1, 1, 'pasanaku 1', 'pasanku de 7 meses', 1234567, 0, true),
(3, 2, 2, 'pasanaku 2', 'pasanku de 5 meses', 1234568, 0,true),
(4, 3, 3, 'pasanaku 3', 'pasanku de 12 meses', 1234569, 0,true);

insert into notification (user_id, type_id, description, date, sender) values 
(5, 6, 'Alerta sobre actividades sospechosas o cambios importantes en la cuenta.', '2024-06-15', 'jane'),
(6, 2, 'Avisa sobre eventos o tareas pendientes para asegurar que no se olviden.', '2024-06-14', 'jane'),
(6, 4, 'Indica que una accion se ha completado correctamente y se ha aceptado.', '2024-06-12', 'jane'),
(7, 3, 'Proporciona informacion relevante al usuario.', '2024-06-10', 'jane'),
(8, 1, 'Sera para mandar a los jugadores que no realicen los pagos en el tiempo limite.', '2024-06-09', 'jane'),
(8, 5, 'Indica que una accion no se puede realizar o que se ha denegado.', '2024-06-08', 'jane'),
(9, 2, 'Avisa sobre eventos o tareas pendientes para asegurar que no se olviden.', '2024-06-06', 'jane'),
(9, 6, 'Alerta sobre actividades sospechosas o cambios importantes en la cuenta.', '2024-06-05', 'jane'),
(10, 4, 'Indica que una accion se ha completado correctamente y se ha aceptado.', '2024-06-03', 'jane'),
(11, 3, 'Proporciona informacion relevante al usuario.', '2024-06-01', 'jane'),
(12, 1, 'Sera para mandar a los jugadores que no realicen los pagos en el tiempo limite.', '2024-05-30', 'alice'),
(12, 5, 'Indica que una accion no se puede realizar o que se ha denegado.', '2024-05-28', 'alice'),
(13, 2, 'Avisa sobre eventos o tareas pendientes para asegurar que no se olviden.', '2024-05-26', 'alice'),
(14, 6, 'Alerta sobre actividades sospechosas o cambios importantes en la cuenta.', '2024-05-25', 'alice'),
(15, 4, 'Indica que una accion se ha completado correctamente y se ha aceptado.', '2024-05-23', 'alice'),
(16, 3, 'Proporciona informacion relevante al usuario.', '2024-05-21', 'alice'),
(16, 1, 'Sera para mandar a los jugadores que no realicen los pagos en el tiempo limite.', '2024-05-19', 'alice'),
(17, 5, 'Indica que una accion no se puede realizar o que se ha denegado.', '2024-05-17', 'alice'),
(18, 2, 'Avisa sobre eventos o tareas pendientes para asegurar que no se olviden.', '2024-05-15', 'alice'),
(18, 6, 'Alerta sobre actividades sospechosas o cambios importantes en la cuenta.', '2024-05-14', 'alice'),
(19, 4, 'Indica que una accion se ha completado correctamente y se ha aceptado.', '2024-05-12', 'alice'),
(20, 3, 'Proporciona informacion relevante al usuario.', '2024-05-10', 'alice'),
(20, 1, 'Sera para mandar a los jugadores que no realicen los pagos en el tiempo limite.', '2024-05-08', 'alice'),
(21, 5, 'Indica que una accion no se puede realizar o que se ha denegado.', '2024-05-06', 'alice'),
(22, 2, 'Avisa sobre eventos o tareas pendientes para asegurar que no se olviden.', '2024-05-04', 'bob'),
(22, 6, 'Alerta sobre actividades sospechosas o cambios importantes en la cuenta.', '2024-05-03', 'bob'),
(23, 4, 'Indica que una accion se ha completado correctamente y se ha aceptado.', '2024-05-01', 'bob'),
(24, 3, 'Proporciona informacion relevante al usuario.', '2024-04-29', 'bob'),
(24, 1, 'Sera para mandar a los jugadores que no realicen los pagos en el tiempo limite.', '2024-04-27', 'bob'),
(25, 5, 'Indica que una accion no se puede realizar o que se ha denegado.', '2024-04-25', 'bob'),
(26, 2, 'Avisa sobre eventos o tareas pendientes para asegurar que no se olviden.', '2024-04-23', 'bob'),
(26, 6, 'Alerta sobre actividades sospechosas o cambios importantes en la cuenta.', '2024-04-22', 'bob'),
(27, 4, 'Indica que una accion se ha completado correctamente y se ha aceptado.', '2024-04-20', 'bob'),
(28, 3, 'Proporciona informacion relevante al usuario.', '2024-04-18', 'bob'),
(28, 1, 'Sera para mandar a los jugadores que no realicen los pagos en el tiempo limite.', '2024-04-16', 'bob'),
(29, 5, 'Indica que una accion no se puede realizar o que se ha denegado.', '2024-04-14', 'bob'),
(30, 2, 'Avisa sobre eventos o tareas pendientes para asegurar que no se olviden.', '2024-04-23', 'bob'),
(30, 6, 'Alerta sobre actividades sospechosas o cambios importantes en la cuenta.', '2024-04-22', 'bob'),
(31, 4, 'Indica que una accion se ha completado correctamente y se ha aceptado.', '2024-04-20', 'bob'),
(32, 3, 'Proporciona informacion relevante al usuario.', '2024-04-18', 'bob'),
(32, 1, 'Sera para mandar a los jugadores que no realicen los pagos en el tiempo limite.', '2024-04-16', 'bob'),
(33, 5, 'Indica que una accion no se puede realizar o que se ha denegado.', '2024-04-14', 'bob');

insert into user_pasanaku (user_id, pasanaku_id, turn, date, status) values
(5,1,1,'2024-07-05',false),
(6,1,2,'2024-08-05',false),
(7,1,3,'2024-09-05',false),
(8,1,4,'2024-10-05',false),
(9,1,5,'2024-11-05',false),
(10,1,6,'2024-12-05',false),
(11,1,7,'2025-01-05',false),
(12,2,1,'2024-07-05',false),
(13,2,2,'2024-07-20',false),
(14,2,3,'2024-08-05',false),
(15,2,4,'2024-08-20',false),
(16,2,5,'2024-09-05',false),
(17,2,6,'2024-09-20',false),
(18,2,7,'2024-10-05',false),
(19,2,8,'2024-10-20',false),
(20,2,9,'2024-11-05',false),
(21,2,10,'2024-11-20',false),
(22,3,1,'2024-07-05',false),
(23,3,2,'2024-08-05',false),
(24,3,3,'2024-09-05',false),
(25,3,4,'2024-10-05',false),
(26,3,5,'2024-11-05',false),
(27,3,6,'2024-12-05',false),
(28,3,7,'2025-01-05',false),
(29,3,8,'2025-02-05',false),
(30,3,9,'2025-03-05',false),
(31,3,10,'2025-04-05',false),
(32,3,11,'2025-05-05',false),
(33,3,12,'2025-06-05',false);

insert into calendar (user_id, pasanaku_id, payment_date, maximum_payment_date, amount) values
(5,1,'2024-08-01','2024-08-05',1000),(5,1,'2024-09-01','2024-09-05',1000),
(5,1,'2024-10-01','2024-10-05',1000),(5,1,'2024-11-01','2024-11-05',1000),
(5,1,'2024-12-01','2024-12-05',1000),(5,1,'2025-01-01','2025-01-05',1000),
(6,1,'2024-07-01','2024-07-05',1000),(6,1,'2024-09-01','2024-09-05',1000),
(6,1,'2024-10-01','2024-10-05',1000),(6,1,'2024-11-01','2024-11-05',1000),
(6,1,'2024-12-01','2024-12-05',1000),(6,1,'2025-01-01','2025-01-05',1000),
(7,1,'2024-07-01','2024-07-05',1000),(7,1,'2024-08-01','2024-08-05',1000),
(7,1,'2024-10-01','2024-10-05',1000),(7,1,'2024-11-01','2024-11-05',1000),
(7,1,'2024-12-01','2024-12-05',1000),(7,1,'2025-01-01','2025-01-05',1000),
(8,1,'2024-07-01','2024-07-05',1000),(8,1,'2024-08-01','2024-08-05',1000),
(8,1,'2024-09-01','2024-09-05',1000),(8,1,'2024-11-01','2024-11-05',1000),
(8,1,'2024-12-01','2024-12-05',1000),(8,1,'2025-01-01','2025-01-05',1000),
(9,1,'2024-07-01','2024-07-05',1000),(9,1,'2024-08-01','2024-08-05',1000),
(9,1,'2024-09-01','2024-09-05',1000),(9,1,'2024-10-01','2024-10-05',1000),
(9,1,'2024-12-01','2024-12-05',1000),(9,1,'2025-01-01','2025-01-05',1000),
(10,1,'2024-07-01','2024-07-05',1000),(10,1,'2024-08-01','2024-08-05',1000),
(10,1,'2024-09-01','2024-09-05',1000),(10,1,'2024-10-01','2024-10-05',1000),
(10,1,'2024-11-01','2024-11-05',1000),(10,1,'2025-01-01','2025-01-05',1000),
(11,1,'2024-07-01','2024-07-05',1000),(11,1,'2024-08-01','2024-08-05',1000),
(11,1,'2024-09-01','2024-09-05',1000),(11,1,'2024-10-01','2024-10-05',1000),
(11,1,'2024-11-01','2024-11-05',1000),(11,1,'2024-12-01','2024-12-05',1000),

(12,2,'2024-07-15','2024-07-20',800),(12,2,'2024-08-01','2024-08-05',800),
(12,2,'2024-08-15','2024-08-20',800),(12,2,'2024-09-01','2024-09-05',800),
(12,2,'2024-09-15','2024-09-20',800),(12,2,'2024-10-01','2024-10-05',800),
(12,2,'2024-10-15','2024-10-20',800),(12,2,'2024-11-01','2024-11-05',800),
(12,2,'2024-11-15','2024-11-20',800),
(13,2,'2024-07-01','2024-07-05',800),(13,2,'2024-08-01','2024-08-05',800),
(13,2,'2024-08-15','2024-08-20',800),(13,2,'2024-09-01','2024-09-05',800),
(13,2,'2024-09-15','2024-09-20',800),(13,2,'2024-10-01','2024-10-05',800),
(13,2,'2024-10-15','2024-10-20',800),(13,2,'2024-11-01','2024-11-05',800),
(13,2,'2024-11-15','2024-11-20',800),
(14,2,'2024-07-01','2024-07-05',800),(14,2,'2024-07-15','2024-07-20',800),
(14,2,'2024-08-15','2024-08-20',800),(14,2,'2024-09-01','2024-09-05',800),
(14,2,'2024-09-15','2024-09-20',800),(14,2,'2024-10-01','2024-10-05',800),
(14,2,'2024-10-15','2024-10-20',800),(14,2,'2024-11-01','2024-11-05',800),
(14,2,'2024-11-15','2024-11-20',800),
(15,2,'2024-07-01','2024-07-05',800),(15,2,'2024-07-15','2024-07-20',800),
(15,2,'2024-08-01','2024-08-05',800),(15,2,'2024-09-01','2024-09-05',800),
(15,2,'2024-09-15','2024-09-20',800),(15,2,'2024-10-01','2024-10-05',800),
(15,2,'2024-10-15','2024-10-20',800),(15,2,'2024-11-01','2024-11-05',800),
(15,2,'2024-11-15','2024-11-20',800),
(16,2,'2024-07-01','2024-07-05',800),(16,2,'2024-07-15','2024-07-20',800),
(16,2,'2024-08-01','2024-08-05',800),(16,2,'2024-08-15','2024-08-20',800),
(16,2,'2024-09-15','2024-09-20',800),(16,2,'2024-10-01','2024-10-05',800),
(16,2,'2024-10-15','2024-10-20',800),(16,2,'2024-11-01','2024-11-05',800),
(16,2,'2024-11-15','2024-11-20',800),
(17,2,'2024-07-01','2024-07-05',800),(17,2,'2024-07-15','2024-07-20',800),
(17,2,'2024-08-01','2024-08-05',800),(17,2,'2024-08-15','2024-08-20',800),
(17,2,'2024-09-01','2024-09-05',800),(17,2,'2024-10-01','2024-10-05',800),
(17,2,'2024-10-15','2024-10-20',800),(17,2,'2024-11-01','2024-11-05',800),
(17,2,'2024-11-15','2024-11-20',800),
(18,2,'2024-07-01','2024-07-05',800),(18,2,'2024-07-15','2024-07-20',800),
(18,2,'2024-08-01','2024-08-05',800),(18,2,'2024-08-15','2024-08-20',800),
(18,2,'2024-09-01','2024-09-05',800),(18,2,'2024-09-15','2024-09-20',800),
(18,2,'2024-10-15','2024-10-20',800),(18,2,'2024-11-01','2024-11-05',800),
(18,2,'2024-11-15','2024-11-20',800),
(19,2,'2024-07-01','2024-07-05',800),(19,2,'2024-07-15','2024-07-20',800),
(19,2,'2024-08-01','2024-08-05',800),(19,2,'2024-08-15','2024-08-20',800),
(19,2,'2024-09-01','2024-09-05',800),(19,2,'2024-09-15','2024-09-20',800),
(19,2,'2024-10-01','2024-10-05',800),(19,2,'2024-11-01','2024-11-05',800),
(19,2,'2024-11-15','2024-11-20',800),
(20,2,'2024-07-01','2024-07-05',800),(20,2,'2024-07-15','2024-07-20',800),
(20,2,'2024-08-01','2024-08-05',800),(20,2,'2024-08-15','2024-08-20',800),
(20,2,'2024-09-01','2024-09-05',800),(20,2,'2024-09-15','2024-09-20',800),
(20,2,'2024-10-01','2024-10-05',800),(20,2,'2024-10-15','2024-10-20',800),
(20,2,'2024-11-15','2024-11-20',800),
(21,2,'2024-07-01','2024-07-05',800),(21,2,'2024-07-15','2024-07-20',800),
(21,2,'2024-08-01','2024-08-05',800),(21,2,'2024-08-15','2024-08-20',800),
(21,2,'2024-09-01','2024-09-05',800),(21,2,'2024-09-15','2024-09-20',800),
(21,2,'2024-10-01','2024-10-05',800),(21,2,'2024-10-20','2024-10-20',800),
(21,2,'2024-11-01','2024-11-05',800),

(22,3,'2024-08-01','2024-08-05',500),(22,3,'2024-09-01','2024-09-05',500),
(22,3,'2024-10-01','2024-10-05',500),(22,3,'2024-11-01','2024-11-05',500),
(22,3,'2024-12-01','2024-12-05',500),(22,3,'2025-01-01','2025-01-05',500),
(22,3,'2025-02-01','2025-02-05',500),(22,3,'2025-03-01','2025-03-05',500),
(22,3,'2025-04-01','2025-04-05',500),(22,3,'2025-05-01','2025-05-05',500),
(22,3,'2025-06-01','2025-06-05',500),
(23,3,'2024-07-01','2024-07-05',500),(23,3,'2024-09-01','2024-09-05',500),
(23,3,'2024-10-01','2024-10-05',500),(23,3,'2024-11-01','2024-11-05',500),
(23,3,'2024-12-01','2024-12-05',500),(23,3,'2025-01-01','2025-01-05',500),
(23,3,'2025-02-01','2025-02-05',500),(23,3,'2025-03-01','2025-03-05',500),
(23,3,'2025-04-01','2025-04-05',500),(23,3,'2025-05-01','2025-05-05',500),
(23,3,'2025-06-01','2025-06-05',500),
(24,3,'2024-07-01','2024-07-05',500),(24,3,'2024-08-01','2024-08-05',500),
(24,3,'2024-10-01','2024-10-05',500),(24,3,'2024-11-01','2024-11-05',500),
(24,3,'2024-12-01','2024-12-05',500),(24,3,'2025-01-01','2025-01-05',500),
(24,3,'2025-02-01','2025-02-05',500),(24,3,'2025-03-01','2025-03-05',500),
(24,3,'2025-04-01','2025-04-05',500),(24,3,'2025-05-01','2025-05-05',500),
(24,3,'2025-06-01','2025-06-05',500),
(25,3,'2024-07-01','2024-07-05',500),(25,3,'2024-08-01','2024-08-05',500),
(25,3,'2024-09-01','2024-09-05',500),(25,3,'2024-11-01','2024-11-05',500),
(25,3,'2024-12-01','2024-12-05',500),(25,3,'2025-01-01','2025-01-05',500),
(25,3,'2025-02-01','2025-02-05',500),(25,3,'2025-03-01','2025-03-05',500),
(25,3,'2025-04-01','2025-04-05',500),(25,3,'2025-05-01','2025-05-05',500),
(25,3,'2025-06-01','2025-06-05',500),
(26,3,'2024-07-01','2024-07-05',500),(26,3,'2024-08-01','2024-08-05',500),
(26,3,'2024-09-01','2024-09-05',500),(26,3,'2024-10-01','2024-10-05',500),
(26,3,'2024-12-01','2024-12-05',500),(26,3,'2025-01-01','2025-01-05',500),
(26,3,'2025-02-01','2025-02-05',500),(26,3,'2025-03-01','2025-03-05',500),
(26,3,'2025-04-01','2025-04-05',500),(26,3,'2025-05-01','2025-05-05',500),
(26,3,'2025-06-01','2025-06-05',500),
(27,3,'2024-07-01','2024-07-05',500),(27,3,'2024-08-01','2024-08-05',500),
(27,3,'2024-09-01','2024-09-05',500),(27,3,'2024-10-01','2024-10-05',500),
(27,3,'2024-11-01','2024-11-05',500),(27,3,'2025-01-01','2025-01-05',500),
(27,3,'2025-02-01','2025-02-05',500),(27,3,'2025-03-01','2025-03-05',500),
(27,3,'2025-04-01','2025-04-05',500),(27,3,'2025-05-01','2025-05-05',500),
(27,3,'2025-06-01','2025-06-05',500),
(28,3,'2024-07-01','2024-07-05',500),(28,3,'2024-08-01','2024-08-05',500),
(28,3,'2024-09-01','2024-09-05',500),(28,3,'2024-10-01','2024-10-05',500),
(28,3,'2024-11-01','2024-11-05',500),(28,3,'2024-12-01','2024-12-05',500),
(28,3,'2025-02-01','2025-02-05',500),(28,3,'2025-03-01','2025-03-05',500),
(28,3,'2025-04-01','2025-04-05',500),(28,3,'2025-05-01','2025-05-05',500),
(28,3,'2025-06-01','2025-06-05',500),
(29,3,'2024-07-01','2024-07-05',500),(29,3,'2024-08-01','2024-08-05',500),
(29,3,'2024-09-01','2024-09-05',500),(29,3,'2024-10-01','2024-10-05',500),
(29,3,'2024-11-01','2024-11-05',500),(29,3,'2024-12-01','2024-12-05',500),
(29,3,'2025-01-01','2025-01-05',500),(29,3,'2025-03-01','2025-03-05',500),
(29,3,'2025-04-01','2025-04-05',500),(29,3,'2025-05-01','2025-05-05',500),
(29,3,'2025-06-01','2025-06-05',500),
(30,3,'2024-07-01','2024-07-05',500),(30,3,'2024-08-01','2024-08-05',500),
(30,3,'2024-09-01','2024-09-05',500),(30,3,'2024-10-01','2024-10-05',500),
(30,3,'2024-11-01','2024-11-05',500),(30,3,'2024-12-01','2024-12-05',500),
(30,3,'2025-01-01','2025-01-05',500),(30,3,'2025-02-01','2025-02-05',500),
(30,3,'2025-04-01','2025-04-05',500),(30,3,'2025-05-01','2025-05-05',500),
(30,3,'2025-06-01','2025-06-05',500),
(31,3,'2024-07-01','2024-07-05',500),(31,3,'2024-08-01','2024-08-05',500),
(31,3,'2024-09-01','2024-09-05',500),(31,3,'2024-10-01','2024-10-05',500),
(31,3,'2024-11-01','2024-11-05',500),(31,3,'2024-12-01','2024-12-05',500),
(31,3,'2025-01-01','2025-01-05',500),(31,3,'2025-02-01','2025-02-05',500),
(31,3,'2025-03-01','2025-03-05',500),(31,3,'2025-05-01','2025-05-05',500),
(31,3,'2025-06-01','2025-06-05',500),
(32,3,'2024-07-01','2024-07-05',500),(32,3,'2024-08-01','2024-08-05',500),
(32,3,'2024-09-01','2024-09-05',500),(32,3,'2024-10-01','2024-10-05',500),
(32,3,'2024-11-01','2024-11-05',500),(32,3,'2024-12-01','2024-12-05',500),
(32,3,'2025-01-01','2025-01-05',500),(32,3,'2025-02-01','2025-02-05',500),
(32,3,'2025-03-01','2025-03-05',500),(32,3,'2025-04-01','2025-04-05',500),
(32,3,'2025-06-01','2025-06-05',500),
(33,3,'2024-07-01','2024-07-05',500),(33,3,'2024-08-01','2024-08-05',500),
(33,3,'2024-09-01','2024-09-05',500),(33,3,'2024-10-01','2024-10-05',500),
(33,3,'2024-11-01','2024-11-05',500),(33,3,'2024-12-01','2024-12-05',500),
(33,3,'2025-01-01','2025-01-05',500),(33,3,'2025-02-01','2025-02-05',500),
(33,3,'2025-03-01','2025-03-05',500),(33,3,'2025-04-01','2025-04-05',500),
(33,3,'2025-05-01','2025-05-05',500);
