# 🔐 Api de Gerar Senhas

Projeto feito com Java  version 21.

## 🧩 Detalhamento do projeto

- Nesta aplicação optei por serguir a clean architecture por entender a capacidade da escalabilidade e flexbilidade de crescimento do projeto.
Com sua separação de responsabilidade é possível implementar novas funcionalidades sem que mexa em outra existente,o que facilita na evolução e também na manuteção do sistema.

-  Nessa arquitetura também temos ganhos na testabilidade dos recursos, no qual pode ser testado cada caso de uso isoladamente, sem dependêcias externas.

- Como nem tudo é flores, existem uma questão importante que deve ser levada em consideração nessa arquitetura, Ela é bem trabalhosa, estrutura mais elaborada, demanda tempo de organização e maior esforço incial em começos de projetos.


🧩 Comparativo: Clean Architecture vs Arquitetura Tradicional

| Aspecto                     | Clean Architecture                          | Arquitetura Tradicional (MVC)                |
|----------------------------|---------------------------------------------|----------------------------------------------|
| **Separação de responsabilidades** | Forte, bem definida por regras de negócio  | Limitada, misturada entre camada de serviço e controller |
| **Acoplamento com frameworks**     | Baixo (frameworks são detalhes)            | Alto (camadas dependem de Spring, Angular, etc.) |
| **Testabilidade**          | Alta (testes no domínio puro)              | Média (testes muitas vezes com dependências) |
| **Complexidade inicial**   | Alta (exige boa modelagem e organização)    | Baixa (estrutura mais direta)                |
| **Produtividade inicial**  | Mais lenta (mais camadas e abstrações)     | Mais rápida (entrega direta)                 |
| **Manutenção a longo prazo** | Facilitada por isolamento de mudanças      | Difícil em sistemas grandes e antigos        |
| **Curva de aprendizado**   | Alta                                        | Baixa a média                                |



## 🚀 Funcionalidades
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

## 🔧 Estrutura de pastas do Projeto

```
desafio/
├── src
|   ├── main/
│   |   ├── java/
|   |   |    └── com/
|   |   |         └── beehome/
|   |   |              └── desafio/ 
│   │   |                  ├── aplication/
│   │   |                  │      └── usercase 
|   |   |                  |               └── create
|   |   |                  |               |__ delete
|   |   |                  |               |__ list
|   |   |                  ├── domain
|   |   |                  |        |
|   |   |                  |        └── dto
|   |   |                  |        |__ entities
|   |   |                  |        |__ Exception
|   |   |                  |        |__ repositories
|   |   |                  |
│   │   |                  │  
│   │   |                  ├── interfaces
│   │   |                  │   └── controllers
|   |   |                  |   |__ service
|   |   |                  |
│   │   |                  ├── presentation
│   │   |                  └── shared/
│   |   |                        └── util
│   |   |          
|   |   └── resources
|   |       └── application.yml
|   |
|   └── test/
|        └──com
|            └── beehome
|                 └── desafio 
|                       ├── interfaces
|                       |    └── controllers
|                       |    └── services 
|                       ├── shared  
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






