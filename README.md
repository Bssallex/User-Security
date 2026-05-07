# 🔐 User Security

API REST desenvolvida para estudos avançados de autenticação e autorização utilizando Spring Security.
A aplicação implementa autenticação stateless com JWT assinado via RSA, controle de acesso baseado em scopes e proteção de rotas utilizando OAuth2 Resource Server.

O sistema permite:

* Cadastro de usuários
* Login com email e senha
* Geração de Bearer Token JWT
* Controle de permissões com scopes
* Proteção de endpoints administrativos

---

## 📊 Tecnologias e Ferramentas

* **Java 17**
* **Spring Boot**
* **Spring Security**
* **OAuth2 Resource Server**
* **JWT (JSON Web Token)**
* **RSA Public/Private Key**
* **Scopes**
* **Spring Data JPA**
* **PostgreSQL**
* **Flyway**
* **Validation**
* **MapStruct**
* **Lombok**
* **Swagger / OpenAPI**
* **Maven**

---

## 🔐 Fluxo de Autenticação

1. O usuário realiza cadastro
2. O usuário envia email e senha para autenticação
3. A aplicação valida as credenciais
4. Um JWT é gerado e assinado com RSA
5. O cliente envia o Bearer Token nas próximas requisições
6. O Spring Security valida automaticamente o token
7. O acesso é liberado com base nos scopes do usuário

---

## 🛡️ Segurança Aplicada

### ✅ Autenticação Stateless

A aplicação não utiliza sessão HTTP.
Toda autenticação ocorre via Bearer Token.

---

### ✅ JWT Assinado com RSA

O sistema utiliza:

* Chave privada → assinatura do token
* Chave pública → validação do token

---

### ✅ Controle de acesso com Scopes

A autorização da aplicação é baseada em scopes/permissões.

Exemplo:

* `ADMIN`
* `USER`

---

### ✅ Proteção de rotas

Endpoints administrativos são protegidos utilizando anotações customizadas.

---

## 📂 Estrutura Interna do Projeto

```
src/main/java
├── controller
├── docs
├── entity
├── exceptions
├── mapper
├── repository
├── request
├── response
├── security
└── service
```

Essa organização facilita:

* manutenção
* separação de responsabilidades
* reutilização de código
* escalabilidade da aplicação

---

## 🚀 Funcionalidades

### 👤 Usuários

* 🔍 Listar usuários
* 🔍 Buscar usuário por ID
* 🔍 Buscar usuário por email
* 📝 Criar usuário
* ➕ Adicionar scopes ao usuário

---

### 🔑 Login

* 🔐 Autenticação com email e senha
* 🎟️ Geração de JWT
* 🛡️ Retorno de Bearer Token

---

### 🛡️ Scopes

* 🔍 Listar scopes
* 📝 Criar scopes
* 🔒 Controle de permissões

---

## 📡 Endpoints Principais

### 👤 Usuários

| Método | Endpoint               |
| ------ | ---------------------- |
| POST   | `/users/created`       |
| GET    | `/users/list`          |
| GET    | `/users/find/{id}`     |
| GET    | `/users/email/{email}` |
| POST   | `/users/scope/{id}`    |

---

### 🔑 Login

| Método | Endpoint |
| ------ | -------- |
| POST   | `/login` |

---

### 🛡️ Scopes

| Método | Endpoint          |
| ------ | ----------------- |
| GET    | `/scopes/list`    |
| POST   | `/scopes/created` |

---

## 🗃️ Banco de Dados

Banco utilizado:

* PostgreSQL

---

## 🔄 Migrations

Controle de versão do banco utilizando:

* Flyway

---

## 🔑 Criptografia de Senhas

As senhas dos usuários são criptografadas utilizando BCrypt.

---

## 📘 Documentação da API (Swagger)

A aplicação utiliza **Springdoc OpenAPI** para documentação automática.

Após iniciar o projeto, a documentação pode ser acessada em:

```bash
http://localhost:8080/swagger-ui/index.html#/
```

---

## ▶️ Como Executar o Projeto

### 1️⃣ Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

---

### 2️⃣ Entre na pasta do projeto

```bash
cd user-security
```

---

### 3️⃣ Configure o PostgreSQL

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

---

### 4️⃣ Configure as chaves RSA

As instruções para geração das chaves RSA estão documentadas separadamente no repositório.

---

### 5️⃣ Execute o projeto

```bash
./mvnw spring-boot:run
```

---

## 📌 Conceitos Estudados

* Spring Security
* JWT Authentication
* OAuth2 Resource Server
* RSA Keys
* Stateless Authentication
* Scopes e autorização
* Segurança em APIs REST
* Bearer Token
* Controle de acesso
* Proteção de endpoints

---

## 👨‍💻 Autor

Projeto desenvolvido para estudos avançados de backend e segurança com Spring Boot e Spring Security.
