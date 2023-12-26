
DROP TABLE IF EXISTS jc_child;
DROP TABLE IF EXISTS jc_student_order;
DROP TABLE IF EXISTS jc_register_office;
DROP TABLE IF EXISTS jc_passport_office;
DROP TABLE IF EXISTS jc_street;
DROP TABLE IF EXISTS jc_country_struct;

CREATE TABLE jc_street(
 street_code integer not null,
	street_name varchar(20),
	street_area varchar(20)
	PRIMARY KEY (street_code)
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
 h_first_name varchar(12),
 h_second_name varchar(12),
 h_patronymic varchar(12),
 h_passport_number varchar(12),
 h_passport_serial varchar(12),
 h_issue_data_passport date not null,
 h_issue_department integer not null,
h_student_number varchar(12),
h_university varchar(12),
h_city varchar(12),
h_area varchar(12),
h_street varchar(100),
h_building varchar(12),
h_apartment varchar(12),
h_post_code integer not null,
h_index_street integer not null,
w_first_name varchar(12),
 w_second_name varchar(12),
 w_patronymic varchar(12),
 w_passport_number varchar(12),
 w_passport_serial varchar(12),
 w_issue_data_passport date not null,
 w_issue_department integer not null,
w_student_number varchar(12),
w_university varchar(100),
w_city varchar(12),
w_area varchar(12),
w_street varchar(100),
w_building varchar(12),
w_apartment varchar(12),
w_post_code integer not null,
w_index_street integer not null,
marriage_certificate_id varchar(12),
marriage_date date not null,
department_marriage integer not null,
PRIMARY KEY(student_order_id),
FOREIGN KEY(h_index_street) REFERENCES jc_street(street_code) ON DELETE RESTRICT,
FOREIGN KEY(w_index_street) REFERENCES jc_street(street_code) ON DELETE RESTRICT,
FOREIGN KEY(h_issue_department) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT,
FOREIGN KEY(w_issue_department) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT,
FOREIGN KEY(department_marriage) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT
);

    CREATE TABLE jc_child(
student_child_id SERIAL,
 c_first_name varchar(12),
 c_second_name varchar(12),
 c_patronymic varchar(12),
 c_passport_number varchar(12),
 c_passport_serial varchar(12),
 c_issue_data_passport date not null,
 c_city varchar(100),
 c_area varchar(100),
 c_street varchar(100),
 c_building varchar(100),
 c_apartment varchar (100),
 c_post_code integer not null,
 c_certificate_number integer not null,
 c_issue_date_certificate date not null,
 c_issue_department integer not null,

PRIMARY KEY(student_child_id),
FOREIGN KEY(c_post_code) REFERENCES jc_street(street_code) ON DELETE RESTRICT,
FOREIGN KEY(c_issue_department) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT
);