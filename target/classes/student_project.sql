
DROP TABLE IF EXISTS jc_child;
DROP TABLE IF EXISTS jc_student_order;
DROP TABLE IF EXISTS jc_register_office;
DROP TABLE IF EXISTS jc_passport_office;
DROP TABLE IF EXISTS jc_street;
DROP TABLE IF EXISTS jc_university;
DROP TABLE IF EXISTS jc_country_struct;

CREATE TABLE jc_street(
 street_code integer not null,
	street_name varchar(20),
	street_area varchar(20),
	PRIMARY KEY (street_code)
);

CREATE TABLE jc_university(
 university_id integer not null,
	university_name varchar(50),
	PRIMARY KEY (university_id)
);

CREATE TABLE jc_country_struct(
area_id char(12) not null,
	area_name varchar(50),
	PRIMARY KEY(area_id)
);

CREATE TABLE jc_passport_office(
p_office_id integer not null,
	p_office_area_id char(12) not null,
	p_office_name varchar(100),
	PRIMARY KEY (p_office_id),
	FOREIGN KEY(p_office_area_id) REFERENCES jc_country_struct(area_id) ON DELETE RESTRICT
);

CREATE TABLE jc_register_office(
r_office_id integer not null,
	r_office_area_id char(12) not null,
	r_office_name varchar(100),
	PRIMARY KEY(r_office_id),
	FOREIGN KEY(r_office_area_id)REFERENCES jc_country_struct(area_id) ON DELETE RESTRICT
);

CREATE TABLE jc_student_order(
 student_order_id SERIAL,
 student_order_status int not null,
 student_order_date timestamp not null,
 h_first_name varchar(12) not null,
 h_second_name varchar(12) not null,
 h_patronymic varchar(12) not null,
 h_date_of_birth date not null,
 h_passport_number varchar(12) not null,
 h_passport_serial varchar(12) not null,
 h_issue_data_passport date not null,
 h_issue_department integer not null,
h_student_number varchar(12) not null,
h_university_id integer not null,
h_city varchar(12) not null,
h_area varchar(12) not null,
h_street varchar(100) not null,
h_building varchar(12) not null,
h_apartment varchar(12) not null,
h_post_code varchar(12) not null,
h_index_street integer not null,
w_first_name varchar(12) not null,
 w_second_name varchar(12) not null,
 w_patronymic varchar(12) not null,
  w_date_of_birth date not null,
 w_passport_number varchar(12) not null,
 w_passport_serial varchar(12) not null,
 w_issue_data_passport date not null,
 w_issue_department integer not null,
w_student_number varchar(12) not null,
w_university_id integer not null,
w_city varchar(12) not null,
w_area varchar(12) not null,
w_street varchar(100) not null,
w_building varchar(12) not null,
w_apartment varchar(12) not null,
w_post_code varchar(12) not null,
w_index_street integer not null,
marriage_certificate_id varchar(12) not null,
marriage_date date not null,
department_marriage integer not null,
PRIMARY KEY(student_order_id),
FOREIGN KEY(h_index_street) REFERENCES jc_street(street_code) ON DELETE RESTRICT,
FOREIGN KEY(w_index_street) REFERENCES jc_street(street_code) ON DELETE RESTRICT,
FOREIGN KEY(h_issue_department) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT,
FOREIGN KEY(w_issue_department) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT,
FOREIGN KEY(h_university_id) REFERENCES jc_university(university_id) ON DELETE RESTRICT,
FOREIGN KEY(w_university_id) REFERENCES jc_university(university_id) ON DELETE RESTRICT,
FOREIGN KEY(department_marriage) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT
);

    CREATE TABLE jc_child(
student_child_id SERIAL,
student_order_id integer not null,
 c_first_name varchar(12) not null,
 c_second_name varchar(12) not null,
 c_patronymic varchar(12) not null,
  c_date_of_birth date not null,
 c_passport_number varchar(12) not null,
 c_passport_serial varchar(12) not null,
 c_issue_data_passport date not null,
 c_city varchar(100) not null,
 c_area varchar(100) not null,
 c_street varchar(100) not null,
 c_building varchar(100) not null,
 c_apartment varchar (100) not null,
 c_post_code varchar(12) not null,
 c_index_street integer not null,
 c_certificate_number varchar (12) not null,
 c_issue_date_certificate date not null,
 c_issue_department integer not null,
 c_register_office integer not null,

PRIMARY KEY(student_child_id),
FOREIGN KEY (c_register_office) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT,
FOREIGN KEY(student_order_id) REFERENCES jc_student_order(student_order_id) ON DELETE RESTRICT,
FOREIGN KEY(c_index_street) REFERENCES jc_street(street_code) ON DELETE RESTRICT,
FOREIGN KEY(c_issue_department) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT
);

CREATE INDEX idx_student_order_status ON jc_student_order(student_order_status);
CREATE INDEX idx_student_order_id ON jc_child(student_order_id);
INSERT INTO jc_street(street_code, street_name) VALUES
(1, 'Main Street'),
(2, 'Oak Avenue'),
(3, 'Maple Lane'),
(4, 'Broadway'),
(5, 'Chestnut Street');

INSERT INTO jc_university (university_id, university_name) VALUES
    (1, 'University of Warsaw'),
    (2, 'Warsaw University of Technology'),
    (3, 'Medical University of Warsaw');

INSERT INTO jc_country_struct(area_id, area_name) VALUES
('010000000000', 'Poland'),
('010010000000', 'Poland Region 1'),
('010020000000', 'Poland Region 2'),
('010030000000', 'Poland Region 3'),
('010040000000', 'Poland Region 4'),

('020000000000', 'Poland Voivodeship'),
('020010000000', 'Voivodeship 1'),
('020010010000', 'Voivodeship 1 District 1'),
('020010010001', 'Voivodeship 1 District 1 Settlement 1'),
('020010010002', 'Voivodeship 1 District 1 Settlement 2'),
('020010020000', 'Voivodeship 1 District 2'),
('020010020001', 'Voivodeship 1 District 2 Settlement 1'),
('020010020002', 'Voivodeship 1 District 2 Settlement 2'),
('020010020003', 'Voivodeship 1 District 2 Settlement 3'),
('020020000000', 'Voivodeship 2'),
('020020010000', 'Voivodeship 2 District 1'),
('020020010001', 'Voivodeship 2 District 1 Settlement 1'),
('020020010002', 'Voivodeship 2 District 1 Settlement 2'),
('020020010003', 'Voivodeship 2 District 1 Settlement 3'),
('020020020000', 'Voivodeship 2 District 2'),
('020020020001', 'Voivodeship 2 District 2 Settlement 1'),
('020020020002', 'Voivodeship 2 District 2 Settlement 2');

INSERT INTO jc_passport_office(p_office_id, p_office_area_id, p_office_name) VALUES
(1, '010010000000', 'Passport Office District 1 City'),
(2, '010020000000', 'Passport Office 1 District 2 City'),
(3, '010020000000', 'Passport Office 2 District 2 City'),
(4, '010010000000', 'Passport Office District 3 City'),
(5, '020010010001', 'Passport Office Voivodeship 1 Settlement 1'),
(6, '020010020002', 'Passport Office Voivodeship 1 Settlement 2'),
(7, '020020010000', 'Passport Office Voivodeship 2 District 1'),
(8, '020020020000', 'Passport Office Voivodeship 2 District 2');


INSERT INTO jc_register_office(r_office_id, r_office_area_id, r_office_name) VALUES
(1, '010010000000', 'Registry Office 1 District 1 City'),
(2, '010010000000', 'Registry Office 2 District 1 City'),
(3, '010020000000', 'Registry Office District 2 City'),
(4, '020010010001', 'Registry Office Voivodeship 1 Settlement 1'),
(5, '020010020002', 'Registry Office Voivodeship 1 Settlement 2'),
(6, '020020010000', 'Registry Office Voivodeship 2 District 1'),
(7, '020020020000', 'Registry Office Voivodeship 2 District 2');