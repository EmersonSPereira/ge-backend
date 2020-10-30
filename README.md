
<!-- Configuração Inicial -->
## Configuração Inicial

Api para gerenciamento de estabelecimento e profissionais.

### Pré Requisitos

* java 8
* Docker ou Postgres sql
* Maven

### Instalação

1. Criando base de dados Postgres chamada gedb ou vá até a pasta docker na raiz do projeto e execute

```sh
docker-compose up -d
```
3. Construa o Projeto
```sh
mvn clean install -DskipTests
```
4. Criando modelo de dados com`liquibase`
```sh
mvn liquibase:update
```
4. Execute a classe principal`GerenciadorDeEmpresasApplication.class`

5. Acesse o link para ter acesso a documentação com Swagger `http://localhost:8080/swagger-ui/`



<!-- USAGE EXAMPLES -->
## Front-End

O front-end da aplicação está disponível no link [ge-front-end](https://github.com/EmersonSPereira/ge-front-end)_


