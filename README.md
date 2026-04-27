# 👕 Camisa Dez

Aplicação web simples para cadastrar uma coleção de camisetas de futebol usando Java, Spring Boot, Thymeleaf e PostgreSQL.

## Funcionalidades

- Página inicial com botão para acessar o formulário de cadastro.
- Formulário com os campos: nome do time, liga, ano da camiseta, nome do jogador e preço.
- Página de listagem com todas as camisetas já cadastradas.
- Página de detalhe ao clicar em uma camiseta da lista.

## Rotas principais

- `/` — página inicial
- `/camisetas/new` — formulário de cadastro
- `/camisetas` — lista de camisetas cadastradas

## PostgreSQL local

Crie o banco, por exemplo:

```sql
CREATE DATABASE cadastrodb;
```

Por padrão, o projeto tenta conectar em:

```text
jdbc:postgresql://localhost:5432/cadastrodb
usuário: postgres
senha: vazia
```

Se seu PostgreSQL tiver outro usuário ou senha, rode definindo as variáveis:

```bash
export DB_URL="jdbc:postgresql://localhost:5432/cadastrodb"
export DB_USERNAME="postgres"
export DB_PASSWORD="sua_senha"
./mvnw spring-boot:run
```

O arquivo `src/main/resources/schema-postgresql.sql` é carregado automaticamente e cria a tabela `camisetas` se ela ainda não existir.

## Variáveis de ambiente para Render

Configure no Render:

- `DB_URL` — precisa estar no formato JDBC, por exemplo `jdbc:postgresql://host:5432/database`
- `DB_USERNAME`
- `DB_PASSWORD`
- `PORT` opcional; o projeto usa `${PORT:8080}`

## Deploy no Render

O projeto já contém `Dockerfile`. No Render, crie um Web Service usando Docker e conecte o repositório do GitHub.
