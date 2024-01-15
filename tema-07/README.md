
Construindo e Executando os Microserviços:

1. Construa as imagens Docker para cada microserviço:

- Serviço do Twitter:
  ```
  cd twitter-service
  docker build -t twitter-service .
  ```

- Serviço do GitHub:
  ```
  cd github-service
  docker build -t github-service .
  ```

2. Execute os containers Docker:

- Serviço do Twitter:
  ```
  docker run  -p 8080:8080 --name twitter-service-container twitter-service
  ```

- Serviço do GitHub:
  ```
  docker run -p 8081:8081 --name github-service-container github-service
  ```

3. Os microserviços devem estar em execução. Você pode acessá-los usando os seguintes endpoints:

- Endpoint do Serviço do Twitter:
  ```
  GET http://localhost:8080/totalizadores?twitter=<twitter-username>&github=<github-username>
  ```
  Este endpoint retornará o número de seguidores no Twitter e o número de repositórios públicos no GitHub para os nomes de usuário do Twitter e GitHub fornecidos.

- Endpoint do Serviço do GitHub:
  ```
  GET http://localhost:8081/api/<github-username>
  ```
  Este endpoint retornará informações sobre o usuário do GitHub com o nome de usuário fornecido, incluindo detalhes sobre seus repositórios.

