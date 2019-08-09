insert into usr (password, username, role_id) values
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'sadmin', 1),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'admin', 2),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'doc', 3),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'pat1', 4),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'pat2', 4),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'pat3', 4),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'pat4', 4),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'pat5', 4);

insert into admin (department_id, user_id) values
(1, 1), (1, 2);

insert into degree (name) values
('test');

insert into position (name) values
('test');

insert into specialization (name) values
('test');

insert into doctor (first_name, last_name, degree_id, department_id, position_id, specialization_id, user_id) values
('doc', 'doc', 1, 1, 1, 1, 3);

insert into patient (last_name, first_name, date_of_birth, is_male, is_work, user_id) values
('test1', 'test1', '2019-01-01', 1, 1, (3+1)),
('test2', 'test2', '2019-01-01', 1, 1, (3+2)),
('test3', 'test3', '2019-01-01', 1, 1, (3+3)),
('test4', 'test4', '2019-01-01', 1, 1, (3+4)),
('test5', 'test5', '2019-01-01', 1, 1, (3+5));

insert into cardio_medical_info (basic_diagnosis, patient_id) values
('test1', 1),
('test2', 2),
('test3', 3),
('test4', 4),
('test5', 5);