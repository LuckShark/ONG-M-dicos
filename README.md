# Conecta Saúde Voluntária - Sistema de Gestão de Voluntários e Serviços

Este é um sistema de gerenciamento de voluntários e serviços desenvolvido em **Java** com **Spring Boot** e **Hibernate** para persistência de dados, utilizando um banco de dados **H2** em memória.

## Descrição do Projeto

O sistema permite o cadastro de **serviços** e **voluntários**, com referência entre eles. Os voluntários estão associados a um serviço específico, e cada voluntário possui dados como nome, email, CPF, matrícula e instituição de ensino. O sistema é construído com foco em simplicidade e facilidade de manutenção.

## Tecnologias Utilizadas

- **Java**: Linguagem principal para o desenvolvimento do backend.
- **Spring Boot**: Framework para facilitar a criação de aplicações Java baseadas em Spring.
- **Hibernate**: Framework de mapeamento objeto-relacional (ORM) para a persistência de dados.
- **H2**: Banco de dados em memória utilizado para armazenar as informações de serviços e voluntários.
- **Maven**: Gerenciador de dependências e build.

## Funcionalidades

### Serviços
- Cadastrar serviços com nome, descrição e instituição de saúde.

### Voluntários
- Cadastrar voluntários, incluindo informações pessoais como nome, email, CPF, matrícula e a instituição de ensino.
- Associar voluntários a serviços específicos através de `service_id`.

## Como Rodar o Projeto

### Pré-requisitos

1. **Java 17+**: Certifique-se de ter o Java 17 ou superior instalado.
2. **Maven**: Certifique-se de ter o Maven instalado para gerenciar as dependências e rodar o projeto.

### Passos para execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/lucasigor.git
   cd lucasigor
   ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. O servidor será iniciado na porta **8080**. Você pode acessar a aplicação através do navegador em:
   ```
   http://localhost:8080
   ```

### Banco de Dados

Este projeto utiliza o **H2** como banco de dados em memória. Ao rodar a aplicação, o banco será criado automaticamente com as tabelas `tb_service` e `tb_volunteer`.

### Estrutura de Banco de Dados

O banco de dados possui duas tabelas principais:

1. **tb_service**
   - `service_id` (Primary Key) - Identificador do serviço.
   - `service_name` - Nome do serviço.
   - `description` - Descrição do serviço.
   - `instituicao_saude` - Instituição de saúde associada ao serviço.

2. **tb_volunteer**
   - `volunteer_id` (Primary Key) - Identificador do voluntário.
   - `service_id` (Foreign Key) - Referência ao serviço associado.
   - `name` - Nome do voluntário.
   - `email` - E-mail do voluntário.
   - `cpf` - CPF do voluntário.
   - `matricula` - Matrícula do voluntário.
   - `instituicao_ensino` - Instituição de ensino do voluntário.

### Exemplo de Inserção de Dados

#### Inserir Serviços:
```sql
-- Inserir serviços
INSERT INTO tb_service(service_name, description, instituicao_saude) 
VALUES ('Gestão', 'Teste', 'Teste porra');

INSERT INTO tb_service(service_name, description, instituicao_saude) 
VALUES ('Informática', 'Teste', 'Teste porra');
```

#### Inserir Voluntários:
```sql
-- Inserir voluntários com referência aos serviços
INSERT INTO tb_volunteer(service_id, name, email, cpf, matricula, instituicao_ensino) 
VALUES (1, 'Maria', 'maria@gmail.com', '12345678901', '20230001', 'Instituição de Ensino A');

INSERT INTO tb_volunteer(service_id, name, email, cpf, matricula, instituicao_ensino) 
VALUES (1, 'Bob', 'bob@gmail.com', '98765432100', '20230002', 'Instituição de Ensino B');

INSERT INTO tb_volunteer(service_id, name, email, cpf, matricula, instituicao_ensino) 
VALUES (2, 'Alex', 'alex@gmail.com', '45678912300', '20230003', 'Instituição de Ensino C');

INSERT INTO tb_volunteer(service_id, name, email, cpf, matricula, instituicao_ensino) 
VALUES (2, 'Ana', 'ana@gmail.com', '78912345600', '20230004', 'Instituição de Ensino D');
```

## Contribuindo para o Projeto

Se você deseja contribuir para o projeto, siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma nova branch para sua feature (`git checkout -b feature-nome-da-feature`).
3. Faça as alterações necessárias e commit (`git commit -am 'Adicionar nova feature'`).
4. Push para a branch (`git push origin feature-nome-da-feature`).
5. Abra um pull request.

## Licença

Este projeto está licenciado sob a **MIT License** - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
