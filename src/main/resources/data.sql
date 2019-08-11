insert into usr (password, username, role_id) values
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'sadmin', 1),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'admin', 2),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'doctor', 3),
('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'patient', 4);


insert into admin (department_id, user_id) values
(1, 1), (1, 2);

insert into degree (name) values
('Доктор медицинских наук'),
('Кандидат медицинских наук');

insert into position (name) values
('Заместитель директора по научной работе'),
('Старший научный сотрудник'),
('Научный сотрудник');

insert into specialization (name) values
('Кардиология');

insert into doctor (first_name, last_name, middle_name, degree_id, department_id, position_id, specialization_id, user_id) values
('Петрова', 'Надежда', 'Андреевна', 1, 1, 1, 1, 3);

insert into patient (last_name, first_name, middle_name, date_of_birth, is_male, is_work, user_id) values
('Либес', 'Лев', 'Наумович','2019-01-01', 1, 1, (3+1));


-- insert into cardio_medical_info (basic_diagnosis, patient_id) values
-- ('test1', 1);

insert into education(name)
     values
           ('Высшее'),
           ('Среднее техническое'),
           ('Среднее');

insert into cardio_medical_info 
           (created_date,last_modified_date, alt, ast,basic_diagnosis,concomitant_diagnosis,diast_disf,ekg_ritm,fv,glyu ,imm,kag,kdo_lzh ,khm_ekg,kr,kso_lp,kso_lzh
           ,kso_pp
           ,lokaln_sokr
           ,lpnp
           ,lpvp
           ,medikamenty_gruppy
           ,nar_ritma
           ,narprovodimosti
           ,nzha_nzhtzha_zht
           ,okh
           ,operations
           ,oslozhneniye
           ,osn_ritm
           ,anognocy
           ,apathetic
           ,disturbing
           ,dysphoric
           ,ergopatial
           ,harmonious
           ,hypochondriacal
           ,melancholy
           ,neurasthenic
           ,paranoid
           ,personality_type
           ,self_centered
           ,sentimental
           ,type_relationship
           ,prichina_prekrashch
           ,prodolzh_nagruzki
           ,sdla
           ,st
           ,sum_ishemiya
           ,tg
           ,tolerantnost
           ,zha_zht
           ,created_by_id
           ,last_modified_by_id
           ,patient_id)
     VALUES
           (null
           ,null
           ,'17.0000'
           ,'36.0000'
           ,'ИМ.1990, 2016, АГ3 р4'
           ,'СД 2, ХР лимфолейкоз, ожирение, Подагра , ХБП'
           ,'релакс'
           ,'синус'
           ,62
           ,'10.7000'
           ,104
           ,'нет'
           ,120
           ,'2016-04-27'
           ,'118.0000'
           ,80
           ,46
           ,42
           ,'дискинез'
           ,'2.0000'
           ,'0.9800'
           ,'аспирин, статины, БАБ, клопидогрель,ИАПФ, АК, мочегонные'
           ,'0'
           ,'внутр предс'
           ,'907/0'
           ,'4.6000'
           ,'нет'
           ,'ХСН2А ф.к1'
           ,'сиус'
           ,12
           ,0
           ,0
           ,0
           ,27
           ,28
           ,6
           ,0
           ,2
           ,0
           ,'чистый'
           ,4
           ,7
           ,'Эр'
           ,null
           ,null
           ,28
           ,'1/0'
           ,'2'
           ,'3.6100'
           ,null
           ,'35/0'
           ,null
           ,null
           ,1);


insert into reading ( patient_id, growth, weight, created_date, last_modified_date, load_id, statement_id, body_position_id, duration) values
( 1, 167, 77, '2019-08-11 15:58:02', '2019-08-11 15:58:02', 12, 3, 3, 37),
( 1, 163, 84, '2019-08-10 15:34:43', '2019-08-10 15:34:43', 9, 5, 3, 45),
( 1, 171, 77, '2019-08-09 00:00:00', '2019-08-09 00:00:00', 24, 1, 3, 39),
( 1, 160, 82, '2019-08-08 08:12:23', '2019-08-08 08:12:23', 15, 5, 1, 43),
( 1, 166, 66, '2019-08-08 20:19:45', '2019-08-08 20:19:45', 13, 3, 3, 24),
( 1, 162, 63, '2019-08-06 08:13:22', '2019-08-06 08:13:22', 44, 3, 3, 21),
( 1, 172, 80, '2019-08-05 13:17:43', '2019-08-05 13:17:43', 2, 3, 2, 43),
( 1, 176, 84, '2019-08-04 14:34:59', '2019-08-04 14:34:59', 10, 3, 1, 29),
( 1, 165, 70, '2019-08-03 13:26:23', '2019-08-03 13:26:23', 42, 4, 2, 19),
( 1, 169, 72, '2019-08-02 08:27:37', '2019-08-02 08:27:37', 3, 5, 1, 20),
( 1, 173, 66, '2019-08-01 01:31:12', '2019-08-01 01:31:12', 20, 2, 3, 39),
( 1, 165, 67, '2019-07-30 15:58:48', '2019-07-30 15:58:48', 16, 6, 1, 45),
( 1, 168, 76, '2019-07-20 06:18:06', '2019-07-20 06:18:06', 17, 3, 3, 38),
( 1, 165, 81, '2019-07-15 19:34:31', '2019-07-15 19:34:31', 6, 6, 2, 38),
( 1, 171, 76, '2019-07-01 21:20:40', '2019-07-01 21:20:40', 5, 3, 1, 35),
( 1, 173, 70, '2019-07-12 11:05:51', '2019-07-12 11:05:51', 19, 2, 3, 40),
( 1, 178, 69, '2019-07-10 08:17:46', '2019-07-10 08:17:46', 14, 2, 2, 40),
( 1, 174, 73, '2019-06-30 18:20:20', '2019-06-30 18:20:20', 3, 4, 2, 41),
( 1, 162, 70, '2019-06-19 22:53:50', '2019-06-19 22:53:50', 35, 6, 3, 18),
( 1, 176, 65, '2019-06-11 15:38:37', '2019-06-11 15:38:37', 4, 3, 2, 21),
( 1, 172, 85, '2019-06-26 02:17:48', '2019-06-26 02:17:48', 32, 4, 1, 24),
( 1, 160, 65, '2019-06-18 16:38:53', '2019-06-18 16:38:53', 26, 4, 1, 20),
( 1, 164, 83, '2019-06-29 13:24:11', '2019-06-29 13:24:11', 4, 3, 3, 44),
( 1, 164, 87, '2019-06-22 05:34:27', '2019-06-22 05:34:27', 13, 5, 1, 19),
( 1, 160, 64, '2019-06-04 13:18:33', '2019-06-04 13:18:33', 39, 4, 1, 21),
( 1, 168, 74, '2019-06-16 05:49:17', '2019-06-16 05:49:17', 12, 2, 3, 27),
( 1, 179, 75, '2019-06-07 01:55:40', '2019-06-07 01:55:40', 3, 2, 1, 41),
( 1, 163, 84, '2019-06-21 05:07:51', '2019-06-21 05:07:51', 41, 4, 3, 25),
( 1, 168, 82, '2019-06-17 11:38:25', '2019-06-17 11:38:25', 24, 5, 2, 25),
( 1, 164, 79, '2019-06-28 13:23:29', '2019-06-28 13:23:29', 21, 2, 1, 28);
