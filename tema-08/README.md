# Calculadora API

Esta é uma API de uma calculadora simples que realiza operações básicas de matemática, como raiz quadrada, soma, multiplicação, divisão e subtração. A API foi desenvolvida utilizando Spring Boot e MongoDB, e pode ser executada usando o Docker.

## Pré-requisitos

Antes de executar a API, certifique-se de ter o Docker instalado em seu sistema. Você pode fazer o download e instalar o Docker a partir do site oficial: https://www.docker.com/get-started

## Configuração do MongoDB

A API utiliza o MongoDB como banco de dados para armazenar registros de operações matemáticas. Antes de executar a aplicação, é necessário configurar o MongoDB no Docker. Para fazer isso, execute o seguinte comando:

docker run -d -p 27017:27017 --name mongodb mongo


Este comando irá iniciar um contêiner Docker com uma instância do MongoDB em execução.

## Executando a API


2. Abra o IntelliJ IDEA e importe o projeto.

3. Configure a porta da aplicação:
    - Navegue até o arquivo `src/main/resources/application.properties`.
    - Altere a porta da aplicação para 8081:
      ```
      server.port=8081
      ```

4. Inicie a aplicação clicando com o botão direito no arquivo `Tema08Application` e selecionando "Run".

A API estará disponível em http://localhost:8081.

## Endpoints da API

A API possui os seguintes endpoints para realizar as operações matemáticas:

1. Raiz Quadrada:
    - URL: http://localhost:8081/raizquadrada?valor=16
    - Método: GET
    - Parâmetro:
        - `valor` (número inteiro) - O valor para calcular a raiz quadrada.

2. Soma:
    - URL: http://localhost:8081/soma?primeiroValor=10&segundoValor=10
    - Método: GET
    - Parâmetros:
        - `primeiroValor` (número inteiro) - O primeiro valor para a operação de soma.
        - `segundoValor` (número inteiro) - O segundo valor para a operação de soma.

3. Multiplicação:
    - URL: http://localhost:8081/multiplicacao?primeiroValor=5&segundoValor=10
    - Método: GET
    - Parâmetros:
        - `primeiroValor` (número inteiro) - O primeiro valor para a operação de multiplicação.
        - `segundoValor` (número inteiro) - O segundo valor para a operação de multiplicação.

4. Divisão:
    - URL: http://localhost:8081/divisao?primeiroValor=5&segundoValor=10
    - Método: GET
    - Parâmetros:
        - `primeiroValor` (número inteiro) - O primeiro valor para a operação de divisão.
        - `segundoValor` (número inteiro) - O segundo valor para a operação de divisão.

5. Subtração:
    - URL: http://localhost:8081/subtracao?primeiroValor=8&segundoValor=20
    - Método: GET
    - Parâmetros:
        - `primeiroValor` (número inteiro) - O primeiro valor para a operação de subtração.
        - `segundoValor` (número inteiro) - O segundo valor para a operação de subtração.

## Testando a API no Postman

Você pode testar os endpoints da API utilizando o aplicativo Postman. Basta importar a coleção de testes que já está pronta:

1. Abra o Postman e clique em "Import" (Importar).
2. Selecione o arquivo "Calculadora_API.postman_collection.json" que está na raiz do projeto.
3. A coleção de testes será importada para o Postman.
4. Agora, você pode executar cada requisição individualmente para testar os diferentes endpoints da API.

## Considerações Finais

Esta é uma API simples de uma calculadora que realiza operações básicas de matemática. Sinta-se à vontade para explorar e modificar o código para atender às suas necessidades. Lembre-se de que, por se tratar de uma API de exemplo, não foram implementadas validações avançadas ou recursos de segurança. Em um ambiente de produção, é importante adicionar camadas de segurança e validações adequadas para garantir a integridade e a segurança dos dados.

Divirta-se explorando a API e fazendo cálculos matemáticos! Se tiver alguma dúvida ou problema, sinta-se à vontade para entrar em contato com a equipe de desenvolvimento.


