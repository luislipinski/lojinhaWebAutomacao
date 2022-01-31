# Lojinha Web Automação
Esse é um repositório que contem a automação de alguns testes de web de um site denominado lojinha. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologia Utilizadas

- Java
  (https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
- JUnit 5
  (https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.0-M1)
- Selenium Web Driver 4.1
  (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.1.1)
- Chrome Driver 97.0.4692.71
  (https://chromedriver.chromium.org/downloads)

## Testes Automatizados
Testes para validar as partições de equivalencias relacionadas ao valor do produto na lojinha, que estão vinculados diretamente a regra de negocio que diz que o valor do produto deve estar entre R$ 0,01 e  R$ 7.000,00.

## Notas Gerais

- Sempre utilizamos a anotação Before Each para iniciar o navegador com o Web Driver, maximizar a tela e acessar a pagina da lojinha.
- Foi divido no padrão Page Objects a organização de utilização em cada pagina no site, separando por arquivos.
- Nesse projeto fazemos o uso do JUnit 5, o que nos da a possibilidade de usar a anotação Display Name, para dar descrições em português para os nossos testes.
