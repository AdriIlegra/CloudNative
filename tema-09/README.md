
# Sistema de Barbearia

## Descrição

O Sistema de Barbearia é uma API REST desenvolvida com Spring Boot que permite gerenciar os clientes e os agendamentos de uma barbearia.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger

## Configuração do Banco de Dados

O projeto utiliza o banco de dados PostgreSQL. Certifique-se de que o PostgreSQL esteja instalado e configurado corretamente em sua máquina. Em seguida, configure as informações de conexão com o banco de dados no arquivo "application.properties":

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=create
Como Executar a Aplicação
Certifique-se de ter o Java JDK instalado em sua máquina.
Clone o repositório do projeto em sua máquina local.
Configure as informações do banco de dados no arquivo "application.properties".
Execute a classe "BarbeariaApplication" para iniciar a aplicação.
A aplicação estará disponível na porta 8080. Você pode acessar a API em http://localhost:8080/clientes para gerenciar os clientes e http://localhost:8080/agendamentos para gerenciar os agendamentos.
Documentação da API com Swagger
A API utiliza o Swagger para fornecer uma documentação detalhada. Após iniciar a aplicação, você pode acessar a documentação em http://localhost:8080/swagger-ui.html. O Swagger UI é uma interface interativa que permite explorar e testar os endpoints da API diretamente no navegador.

Endpoints Disponíveis
Cliente
POST /clientes: Endpoint para cadastrar um novo cliente. Envie os detalhes do cliente no corpo da requisição em formato JSON.
GET /clientes/{id}: Endpoint para buscar um cliente específico. Substitua {id} pelo identificador único do cliente.
GET /clientes/todos: Endpoint para listar todos os clientes cadastrados.
PUT /clientes/{id}: Endpoint para atualizar um cliente existente. Substitua {id} pelo identificador único do cliente.
DELETE /clientes/{id}: Endpoint para deletar um cliente. Substitua {id} pelo identificador único do cliente.
Agendamento
POST /agendamentos: Endpoint para agendar um novo compromisso. Envie os detalhes do agendamento no corpo da requisição em formato JSON.
DELETE /agendamentos/{id}: Endpoint para desmarcar um compromisso existente. Substitua {id} pelo identificador único do agend