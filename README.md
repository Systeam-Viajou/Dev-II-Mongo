# Dev-II-Mongo

Este repositório contém uma aplicação Java com Spring boot, para criar uma api para o banco de dados MongoDB, utilizando Swagger.

## Estrutura do Projeto

- `models`: Possui as classe de objetos das collection
- `repositorys`: Classes que extende o JpaReposytory
- `services`: Classes que organiza e executa a lógica de negócios
- `controllers`: Classes que recebe e responde a requisições HTTP
- `mongo`: Classe para testar se a conexão com o banco esta certa

## Funcionalidade

  1. ** Criação de Endpoints RESTful**: Define rotas e métodos HTTP (GET, POST, PUT, DELETE, etc.) para criar uma API RESTful de forma simples e organizada.
  2. **Acesso a dados**: Integra com bancos de dados relacionais de forma simplificada
  3. **Swagger**: Gera automaticamente a documentação da API, o que facilita o consumo por outros desenvolvedores.
  4. **Validação de Dados**: Validação de dados de entrada com anotações do Bean Validation (como @NotNull, @Size, etc.), simplificando o código de validação.

## Configuração Inicial

1. Clone o repositório:
git clone https://github.com/Systeam-Viajou/Dev-II-Mongo.git

2. configure o .env

3. rode o projeto na sua IDE.

#### Desenvolvido com ❤ e carinho pela equipe de desenvolvimento *Viajou*:

- [Evellyn Nakamura](https://github.com/evellynNakamura)
- [João Oliveira](https://github.com/Jampeta)
