# E-Commerce API

API de backend para um sistema de e-commerce construída com **Spring Boot**, usando **JWT** para autenticação.

---

## 🔧 Tecnologias

- Java 24
- Spring Boot (Web, Data JPA, Security)  
- JWT (JSON Web Tokens)   
- MySQL
---

## ⚙️ Configuração

### Banco de Dados
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Rodando a Aplicação
```bash
git clone <URL_DO_REPOSITORIO>
cd E_commerce
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 🔐 Autenticação

**Login**

`POST /api/auth/login`

**Body:**
```json
{
  "username": "jean",
  "password": "123456"
}
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

Use o token no header de requisições autenticadas:

```
Authorization: Bearer <TOKEN>
```

---

## 👥 Clientes

- **Listar todos:** `GET /api/clientes`  
- **Buscar por ID:** `GET /api/clientes/{id}`  
- **Criar cliente:** `POST /api/clientes`  
  ```json
  {
    "nome": "João",
    "email": "joao@email.com",
    "senha": "123456"
  }
  ```  
- **Atualizar cliente:** `PUT /api/clientes/{id}`  
  ```json
  {
    "nome": "João Atualizado",
    "email": "joao@email.com",
    "senha": "novaSenha"
  }
  ```  
- **Deletar cliente:** `DELETE /api/clientes/{id}`  

---

## 🛍 Produtos

- **Listar todos:** `GET /api/produtos`  
- **Buscar por ID:** `GET /api/produtos/{id}`  
- **Criar produto:** `POST /api/produtos`  
  ```json
  {
    "nome": "Camisa",
    "descricao": "Camisa de algodão",
    "preco": 59.90,
    "quantidade": 10
  }
  ```  
- **Atualizar produto:** `PUT /api/produtos/{id}`  
  ```json
  {
    "nome": "Camisa Premium",
    "descricao": "Camisa premium",
    "preco": 79.90,
    "quantidade": 15
  }
  ```  
- **Deletar produto:** `DELETE /api/produtos/{id}`  

---

## 📝 Pedidos (opcional)

- **Listar todos:** `GET /api/pedidos`  
- **Criar pedido:** `POST /api/pedidos`  
  ```json
  {
    "clienteId": 1,
    "produtos": [
      {
        "produtoId": 1,
        "quantidade": 2
      }
    ]
  }
  ```  
- **Buscar pedido por ID:** `GET /api/pedidos/{id}`  

---

## ⚡ Testando no Insomnia

1. Faça login (`/api/auth/login`) e copie o token.  
2. Crie um Environment com variável:
```
TOKEN = <token retornado>
```  
3. Nas requisições autenticadas, adicione o header:
```
Authorization: Bearer {{ TOKEN }}
```  
4. Use os bodies de exemplo para clientes, produtos e pedidos.
