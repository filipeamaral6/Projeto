delete from payment;
delete from withdraw;
delete from deposit;
delete from transfer;
delete from transaction;
delete from account_client;
delete from account;
delete from client;
delete from employee;
delete from user;

INSERT INTO user (id, username, password, email, role, status) VALUES('1', 'filipe.amaral', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'filipe.amaral@bankrising.com', 'CLIENT', 'ACTIVE');
INSERT INTO user (id, username, password, email, role, status) VALUES('2', 'rui.santos', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'rui.santos@bankrising.com', 'CLIENT', 'ACTIVE');
INSERT INTO user (id, username, password, email, role, status) VALUES('3', 'andre.mendonca', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'andre.mendonca@bankrising.com', 'CLIENT', 'ACTIVE');
INSERT INTO user (id, username, password, email, role, status) VALUES('4', 'goncalo.valentim', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'goncalo.valentim@bankrising.com', 'ADMIN', 'ACTIVE');
INSERT INTO user (id, username, password, email, role, status) VALUES('5', 'bernardo.nunes', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'bernardo.nunes@bankrising.com', 'EMPLOYEE', 'ACTIVE');
INSERT INTO user (id, username, password, email, role, status) VALUES('6', 'daniel.lambuca', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'daniel.lambuca@bankrising.com', 'CLIENT', 'INACTIVE');
INSERT INTO user (id, username, password, email, role, status) VALUES('7', 'hugo.pascoalinho', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', 'hugo.pascoalinho@bankrising.com', 'EMPLOYEE', 'INACTIVE');


INSERT INTO client (id, full_name, nif, client_cc, birthdate, phone_number, mobile_number, address, zip_code, county, country, nationality, notification, transaction_password, created_at, user_id) VALUES('1', 'Filipe Amaral', '111111111', '11111111', '1993/01/06', '351211111111', '351911111111', 'Avenida da Liberdade', '1111-11', 'Lisboa', 'Portugal', 'Portuguesa', 'TRUE', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', curdate(), '1');
INSERT INTO client (id, full_name, nif, client_cc, birthdate, phone_number, mobile_number, address, zip_code, county, country, nationality, notification, transaction_password, created_at, user_id) VALUES('2', 'Rui Santos', '222222222', '22222222', '1993/02/10', '351212222222', '351912222222', 'Avenida dos Bombeiros Voluntários', '2222-22', 'Lisboa', 'Portugal', 'Portuguesa', 'TRUE', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', curdate(), '2');
INSERT INTO client (id, full_name, nif, client_cc, birthdate, phone_number, mobile_number, address, zip_code, county, country, nationality, notification, transaction_password, created_at, user_id) VALUES('3', 'André Mendonça', '333333333', '33333333', '1993/03/20', '351213333333', '351913333333', 'Rua da Assunção', '3333-33', 'Porto', 'Portugal', 'Portuguesa', 'TRUE', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', curdate(), '3');
INSERT INTO client (id, full_name, nif, client_cc, birthdate, phone_number, mobile_number, address, zip_code, county, country, nationality, notification, transaction_password, created_at, user_id) VALUES('4', 'Daniel Lambuça', '444444444', '44444444', '1993/04/30', '351214444444', '351914444444', 'Avenida 1º de Maio', '4444-44', 'Caldas da Rainha', 'Portugal', 'Portuguesa', 'TRUE', '$2a$10$RtziP9cnVyUz/yhdPCiCPOoMO9qbu9a04akXoMxs85qrTH3gBHjQe', curdate(), '6');


INSERT INTO employee (id, full_name, user_id) VALUES('1', 'Gonçalo Valentim', '4');
INSERT INTO employee (id, full_name, user_id) VALUES('2', 'Bernardo Nunes', '5');
INSERT INTO employee (id, full_name, user_id) VALUES('3', 'Hugo Pascoalinho', '7');


INSERT INTO account (id, type, iban, account_number, balance, interest, status, created_at, employee_id) VALUES('1', 'ORDEM','PT50400065651111111111199', '11111111111', '1800', 0.02, 'ACTIVE', curdate(), '1');
INSERT INTO account (id, type, iban, account_number, balance, interest, status, created_at, employee_id) VALUES('2', 'ORDEM','PT50400065651212121212199', '12121212121', '5000', 0.02, 'ACTIVE', curdate(), '1');
INSERT INTO account (id, type, iban, account_number, balance, interest, status, created_at, employee_id) VALUES('3', 'POUPANÇA','PT50400065651313131313199', '13131313131', '15000', 0.05, 'ACTIVE', curdate(), '1');
INSERT INTO account (id, type, iban, account_number, balance, interest, status, created_at, employee_id) VALUES('4', 'ORDEM','PT50400065651414141414199', '14141414141', '800', 0.02, 'INACTIVE', curdate(), '2');
INSERT INTO account (id, type, iban, account_number, balance, interest, status, created_at, employee_id) VALUES('5', 'ORDEM','PT50400065651515151515199', '15151515151', '1200', 0.02, 'ACTIVE', curdate(), '1');
INSERT INTO account (id, type, iban, account_number, balance, interest, status, created_at, employee_id) VALUES('6', 'ORDEM','PT50400065651616161616199', '16161616161', '6000', 0.02, 'ACTIVE', curdate(), '2');

INSERT INTO account_client(account_id, user_id) VALUES('1', '1');
INSERT INTO account_client(account_id, user_id) VALUES('3', '1');
INSERT INTO account_client(account_id, user_id) VALUES('2', '2');
INSERT INTO account_client(account_id, user_id) VALUES('1', '2');
INSERT INTO account_client(account_id, user_id) VALUES('5', '3');
INSERT INTO account_client(account_id, user_id) VALUES('6', '3');
INSERT INTO account_client(account_id, user_id) VALUES('4', '6');


INSERT INTO transaction (id, value, account_iban, created_at, user_id, type, description, account_id) VALUES('1', '-120', 'PT50400065651111111111199', current_timestamp(), '1', 'PAGAMENTO', 'Pagamento da conta do gás/luz', '1');
INSERT INTO payment(id, entity, reference, transaction_id) VALUES('1', '12312', '987654321', '1');
INSERT INTO transaction (id, value, account_iban, created_at, user_id, type, description, account_id) VALUES('2', '-50', 'PT50400065651111111111199', current_timestamp(), '1', 'PAGAMENTO', 'Carregamento Pokerstars', '1');
INSERT INTO payment(id, entity, reference, transaction_id) VALUES('2', '18765', '123456789', '2');
INSERT INTO transaction (id, value, account_iban, created_at, user_id, type, description, account_id) VALUES('3', '300', 'PT50400065651111111111199', current_timestamp(), '1', 'DEPÓSITO', 'Depósito despesas', '1');
INSERT INTO deposit (id, employee_id, transaction_id, depositer_name, depositer_cc_number) VALUES('1', '1', '3', 'Filipe Amaral', '11111111');
INSERT INTO transaction (id, value, account_iban, created_at, user_id, type, description, account_id) VALUES('4', '-150', 'PT50400065651111111111199', current_timestamp(), '1', 'TRANSFERÊNCIA', 'Reforço conta poupança', '1');
INSERT INTO transfer (id, destination_iban, transaction_id) VALUES('1', 'PT50400065651313131313199', '4');
INSERT INTO transaction (id, value, account_iban, created_at, user_id, type, account_id) VALUES('5', '-40', 'PT50400065651111111111199', current_timestamp(), '1', 'LEVANTAMENTO', '1');
INSERT INTO withdraw (id, transaction_id, employee_id) VALUES('1', '5', '1');