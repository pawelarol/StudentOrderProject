INSERT INTO jc_street(street_code, street_name) VALUES
(1, 'Main Street'),
(2, 'Oak Avenue'),
(3, 'Maple Lane'),
(4, 'Broadway'),
(5, 'Chestnut Street');

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