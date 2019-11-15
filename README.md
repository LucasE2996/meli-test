<header style="display:flex;flex-direction:column;justify-content:center;align-items:center;">
<img alt="Logo" src="./meli-logo.png" style="width:250px"/>
<h1 align="center">Simian API</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000" />
</p>
<p align="center">Em um futuro distante, na cadeia de evolução, os símios e os humanos estão cada vez mais semelhantes. Por esse motivo ficou muito difícil distinguir quem é humano e quem é símio. Você foi contratado para desenvolver um projeto em Java, que vai identificar se uma sequência de DNA pertence a um humano ou a um símio.</br>O projeto consiste em desenvolver uma ​API REST​, e​ disponibilizar ​um endpoint HTTP POST "/​simian​". Esse endpoint receberá como ​parâmetro​, um​ JSON​ com a sequência de DNA ​(​Array de Strings)​, onde, cada elemento desse array representa uma linha de uma​ ​tabela​ quadrada de (NxN)​.</p>
</header>

## Produção

Para testar a aplicação que está em produção utilize um serviço para testes de requisição HTTP (Postman, Insominia, etc).

URL: *herokuapp.app.com*

> Para rodar localmente e caso você utilize uma IDE java ignore os passos abaixo.

## Instalação

Com o maven instalado execute o seguinte comando:

```sh
mvn clean install
```

## Usage

Após finalizada a instalação rode o seguinte comando:

```sh
java -jar target/dna-1.0.0.jar
```

## API Endpoints

### **/simian - POST**

Analisa o DNA passado no corpo da requisição e retorna se este é simian ou humano.

URL: *localhost:8080/simian*

Exemplo de corpo:

```json
{
  "dna": ["​CTG​A​G​A​", "​CT​A​T​G​C​", "​T​AT​T​G​T​", "​A​GAG​G​G​", "​CCCC​TA​", "​TCACTG​"]
}
```

Exemplo de resposta:

```json
{
  "is_simian": true
}
```

### **/stats - GET**

Retorna a proporção entre DNA simian e humano em ratio.

URL: *localhost:8080/stats*

Exemplo de resposta:

```json
{
  "count_simian_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}
```

## Author

👤 **Lucas Rosa**

* Website: https://codepen.io/Lucas-Rosa/
* Twitter: [@lucashtwt](https://twitter.com/lucashtwt)
* Github: [@LucasE2996](https://github.com/LucasE2996)
