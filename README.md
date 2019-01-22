# Seleçao de estágio LogAp

## Sobre

Trata-se de um projeto de uma API que trata sobre entidades importantes na área de geração de energia eólica. 
As tecnologias principais do projeto foram Spring Boot, JWT e Swagger.

O projeto está hospedado no Heroku e pode ser acessado clicando [aqui](https://api-logap.herokuapp.com/).

## Documentação

> [Acesso documentação da API](https://api-logap.herokuapp.com/)

### A rota base é https://api-logap.herokuapp.com/

A partir desse link base que deve-se atuar com os endpoints documentados.

### O endpoint /login não está na documentação

Para fazer o login deve-se fazer uma requisição POST na rota https://api-logap.herokuapp.com/login.
A chave de autenticação estará no corpo da resposta. É o par JSON: { "conivente" : < chave > }.
A resposta recebida deve ser adicionada ao Header das demais requisições.

## Melhorias futuras
* Criar módulo de registro de usuários para permissão de acesso a API
* Mudar forma de encriptação de senha de acesso a API
* Utilizar um Banco de Dados que não seja em memória

## Agradecimentos

* Danilo Barros pela documentação do projeto e oportunidade de fazer parte da seleção.
* Lucas Andrey pelo [tutorial de JWT](http://andreybleme.com/2017-04-01/autenticacao-com-jwt-no-spring-boot/).
