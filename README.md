# API de CRUD de Livros

Esta é uma API simples desenvolvida em Java 17 utilizando Spring Boot 3.2.2 e banco de dados PostgreSQL para realizar operações de CRUD (Create, Read, Update, Delete) em livros.

## Endpoints

### Listar todos os livros

```
GET http://localhost:8080/books
```

Retorna uma lista de todos os livros cadastrados.

### Cadastrar um novo livro

```
POST http://localhost:8080/books
```

Cria um novo livro com os seguintes parâmetros no corpo da requisição:

```json
{
  "title": "Título do Livro",
  "description": "Descrição do Livro"
}
```

### Atualizar informações de um livro

```
PATCH http://localhost:8080/books/{id}
```

Atualiza informações de um livro específico com o ID fornecido no caminho da URL. Os parâmetros que podem ser atualizados são:

- `favorite`: Indica se o livro é favorito (true/false).
- `reading`: Indica se o livro está sendo lido (true/false).
- `finished`: Indica se o livro foi finalizado (true/false).

Os parâmetros devem ser enviados no corpo da requisição no formato JSON.

### Deletar um livro

```
DELETE http://localhost:8080/books/{id}
```

Remove um livro específico com o ID fornecido no caminho da URL.

## Estrutura do Projeto

```
book
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br.com.dws.book
│   │   │       ├── controllers
│   │   │       ├── domain
│   │   │       │   ├── dto
│   │   │       │   ├── repository
│   │   │       │   └── service
│   │   └── resources
└── pom.xml
```

## Referências

- Documentação do Spring Boot: [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/3.2.2/reference/html/index.html)
- Spring Initializer: [Spring Initializer](https://start.spring.io/)

**Desenvolvido por [William Faria](https://github.com/wmfariadev)**
