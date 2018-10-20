INSERT INTO person (name, cpf, email) VALUES ('Josimar', '123.456.789-12', 'josimar@gmail.com');
INSERT INTO person (name, cpf, email) VALUES ('João', '111.222.333-44', 'joao@gmail.com');
INSERT INTO person (name, cpf, email) VALUES ('maria', '222.333.555-99', 'maria@gmail.com');

INSERT INTO phone (ddd, number, id_person) VALUES ('88', '99999-9999', (SELECT id FROM person WHERE cpf = '123.456.789-12'));
INSERT INTO phone (ddd, number, id_person) VALUES ('85', '77777-7777', (SELECT id FROM person WHERE cpf = '111.222.333-44'));
INSERT INTO phone (ddd, number, id_person) VALUES ('81', '55555-5555', (SELECT id FROM person WHERE cpf = '222.333.555-99'));

INSERT INTO address (state, city, neighborhood, number, id_person) VALUES ('Ceará', 'Quixadá', 'Bairro quixadá', '123', (SELECT id FROM person WHERE cpf = '123.456.789-12'));
INSERT INTO address (state, city, neighborhood, number, id_person) VALUES ('Ceará', 'Fortaleza', 'Bairro fortaleza', '456', (SELECT id FROM person WHERE cpf = '111.222.333-44'));
INSERT INTO address (state, city, neighborhood, number, id_person) VALUES ('São Paulo', 'São Paulo', 'Bairro são paulo', '789', (SELECT id FROM person WHERE cpf = '222.333.555-99'));