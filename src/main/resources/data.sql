insert into usr (password, username, role_id) values
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'sadmin', 1),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'admin', 2),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'doc', 3),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'pat', 4);

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

insert into cardio_medical_info (basic_diagnosis) values
('test');

insert into patient (last_name, first_name, date_of_birth, is_male, is_work, cardio_medical_info_id, user_id) values
('test', 'test', '2019-01-01', 1, 1, 1, 4)