# 👕 Camisa Dez

Aplicação web simples para cadastrar uma coleção de camisetas de futebol.

## Funcionalidades

- Página inicial com botão para acessar o formulário de cadastro.
- Formulário com os campos: nome do time, liga, ano da camiseta, nome do jogador e preço.
- Página de listagem com todas as camisetas já cadastradas.
- Página de detalhe ao clicar em uma camiseta da lista.

## Tecnologias

- Java 21
- Spring Boot
- Thymeleaf
- HTML/CSS/JavaScript
- PostgreSQL
- Docker

## Rotas principais

- `/` — página inicial
- `/camisetas/new` — formulário de cadastro
- `/camisetas` — lista de camisetas cadastradas

## Variáveis de ambiente para Render

Configure no Render:

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`
- `PORT` opcional; o projeto usa `${PORT:8080}`

## Deploy no Render

O projeto já contém `Dockerfile`. No Render, crie um Web Service usando Docker e conecte o repositório do GitHub.
