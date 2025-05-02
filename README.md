# 🔐 Api de Gerar Senhas

Projeto feito com Java  version 21.


🚀 Funcionalidades
- Geração de Senhas

- Listagem Paginada de senhas

- Filtro por Data

- Deleção de senhas

## 🛠️ Tecnologias Utilizadas

- Java 21
- Mariadb
- Swagger



## 📦 Instalação 

clone o repositorio:

```bash
ssh:
git clone git@github.com:jonatas401/password-generate-api.git

https:
git clone https://github.com/jonatas401/password-generate-api.git
```

Após clonar o projeto rode o comando:

```bash
mvn clean install
```

## 🔧 Estrutura do Projeto

```
desafio/
├── src
|    ├── main/
│    |   ├── java
|    |   |    └── com
|    |   |         └── beehome
|    |   |              └── desafio 
│    │   |                  ├── aplication/
│    │   |                  │      └── usercase 
|    |   |                  |               └── create
|    |   |                  |               |__ delete
|    |   |                  |               |__ list
|    |   |                  ├── domain
|    |   |                  |        |
|    |   |                  |        └── dto
|    |   |                  |        |__ entities
|    |   |                  |        |__ Exception
|    |   |                  |        |__ repositories
|    |   |                  |
│    │   |                  │  
│    │   |                  ├── interfaces
│    │   |                  │   └── controllers
|    |   |                  |   |__ service
|    |   |                  |
│    │   |                  ├── presentation
│    │   |                  └── shared/
│    |   |                        └──util
│    |   |          
|    |   |__ resources
|    |        ├── application.yml
|    |
|    ├── test/
|    |    ├── interfaces
|    |    ├── shared  
|
├── pom.xml
└── README.md
```

## 📄 API
- Geração de Senha:​

    - Endpoint: POST /api/generate-password

    - Descrição: Gera uma nova senha.​

- Listagem de Senhas:​

    - Endpoint: GET /api/password-history

    - Parâmetros:

    - page: número da página (opcional)

    - limit: número de itens por página (opcional)

    - filtro: data para filtro("createdDate") (opcional, formato YYYY-MM-DD)

- Deleção de Senha:​

    - Endpoint: DELETE /api/delete-password

    - Descrição: deletar uma senha.​

## ✨ Acesse o swagger:

http://localhost:8080/swagger-ui/index.html






