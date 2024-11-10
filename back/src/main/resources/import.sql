-- Inserir serviços
INSERT INTO tb_service(service_name, description, instituicao_saude)
VALUES ('Gestão', 'Teste', 'Teste porra');

INSERT INTO tb_service(service_name, description, instituicao_saude)
VALUES ('Informática', 'Teste', 'Teste porra');

-- Inserir voluntários com referência aos serviços
INSERT INTO tb_volunteer(service_id, name, email, cpf, matricula, instituicao_ensino)
VALUES (1, 'Maria', 'maria@gmail.com', '12345678901', '20230001', 'Instituição de Ensino A');

INSERT INTO tb_volunteer(service_id, name, email, cpf, matricula, instituicao_ensino)
VALUES (1, 'Bob', 'bob@gmail.com', '98765432100', '20230002', 'Instituição de Ensino B');

INSERT INTO tb_volunteer(service_id, name, email, cpf, matricula, instituicao_ensino)
VALUES (2, 'Alex', 'alex@gmail.com', '45678912300', '20230003', 'Instituição de Ensino C');

INSERT INTO tb_volunteer(service_id, name, email, cpf, matricula, instituicao_ensino)
VALUES (2, 'Ana', 'ana@gmail.com', '78912345600', '20230004', 'Instituição de Ensino D');

