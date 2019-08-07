delete from bankrising.client;
delete from bankrising.employee;
delete from bankrising.`user`;

INSERT INTO bankrising.user (id ,username, password, email, `role`)
VALUES(1, 'filipe.amaral', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'filipe.amaral@bankrising.com', 'CLIENT');
INSERT INTO bankrising.client (id, full_name, nif, birthdate, phone_number, mobile_number, address, zip_code, county, country, nationality, status, notification, transaction_password, created_at, user_id, client_cc)
VALUES(1, 'Filipe Amaral', 111111111, '1993-01-06', 111111111, 351111111111, 'Rua da Liberdade', '1111-11', 'Lisboa', 'Portugal', 'Portuguesa', 'ACTIVE', 'TRUE', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', curdate(), 1, 111111111);

INSERT INTO bankrising.user (id ,username, password, email, `role`) 
VALUES(2, 'rui.santos', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'rui.santos@bankrising.com', 'CLIENT');
INSERT INTO bankrising.client (id, full_name, nif, birthdate, phone_number, mobile_number, address, zip_code, county, country, nationality, status, notification, transaction_password, created_at, user_id, client_cc)
VALUES(2, 'Rui Santos', 222222222, '1993-01-06', 222222222, 351222222222, 'Rua dos Bombeiros', '2222-22', 'Lisboa', 'Portugal', 'Portuguesa', 'ACTIVE', 'TRUE', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', curdate(), 2, 222222222);

INSERT INTO bankrising.user (id ,username, password, email, `role`)
VALUES(3, 'bernardo.nunes', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'bernardo.nunes@bankrising.com', 'EMPLOYEE');
INSERT INTO bankrising.employee (full_name, user_id) 
VALUES('Bernardo Nunes', 3);

INSERT INTO bankrising.user (id ,username, password, email, `role`)
VALUES(4, 'André Mendonça', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'andre.mendonca@bankrising.com', 'ADMIN');
INSERT INTO bankrising.employee (full_name, user_id) 
VALUES('André Mendonça', 4);