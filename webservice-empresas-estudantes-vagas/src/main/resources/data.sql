-- Areas
INSERT INTO area (id, nome) VALUES (1, 'Desenvolvimento');
INSERT INTO area (id, nome) VALUES (2, 'Dados');

-- Empresas
INSERT INTO empresa (id, nome_fantasia, cnpj, email_contato, endereco, descricao) VALUES
(1, 'Tech Solutions LTDA', '12.345.678/0001-99', 'contato@tech.com', 'Av. A, 100', 'Empresa de tecnologia'),
(2, 'InovaSoft Tecnologia', '98.765.432/0001-22', 'rh@inovasoft.com', 'Rua B, 200', 'Software solutions');

-- Estudantes
INSERT INTO estudante (id, nome, email, nascimento, ano_ingresso, area_id) VALUES
(1, 'Gabriel Freitas', 'gabriel@email.com', '2006-01-01', 2024, 1),
(2, 'Ana Paula', 'ana@email.com', '2002-03-15', 2020, 2);

-- Vagas
INSERT INTO vaga (id, titulo, descricao, publicacao, ativo, empresa_id, area_id) VALUES
(1, 'Desenvolvedor Java Jr', 'API REST com Spring Boot', '2025-10-01', true, 1, 1),
(2, 'Analista de Dados', 'Processamento de dados e SQL', '2025-09-20', true, 2, 2);

-- Inscricoes
INSERT INTO inscricao (id, data_inscricao, status, mensagem_apresentacao, estudante_id, vaga_id) VALUES
(1, '2025-10-10', 'PENDENTE', 'Tenho experiência com Java', 1, 1);
