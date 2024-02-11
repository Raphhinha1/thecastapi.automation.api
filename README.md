# TheCatAPI Automation API

## Descrição

Este projeto é dedicado à automação de testes na TheCatAPI, utilizando Java, ExtentReports, TestNG e RestAssured.

## Pré-requisitos

- Java 8 ou superior
- Maven

## Instalação e Execução

1. **Clone o repositório:**

   ```bash
   git clone https://seu-repositorio.git
   cd thecastapi.automation.api
   ```

2. **Configuração:**

   - Verifique e ajuste o arquivo `src/main/resources/config.properties` com sua x-api-key.
     ``` properties
     api.key=SUA-X-API-KEY
      ```
3. **Execução dos Testes:**

   ```bash
   mvn test
   ```

   - Para ambientes específicos (dev, qa), use:

     ```bash
     mvn test -D env=dev
     ```
4. **Relatórios:**
   - Os resultados dos testes são gerados em ExtentReports.
   - Para visualizar os relatórios, abra o arquivo `reports/TestReport<ano><mes><dia>_<hora>_<min>_<seg>.html`.

## Contribuição

Contribuições são bem-vindas! Siga estas etapas para contribuir:

1. Faça um fork do projeto.
2. Crie uma branch para a sua contribuição (`git checkout -b feature/sua-contribuicao`).
3. Faça commit das suas alterações (`git commit -am 'Adiciona nova funcionalidade'`).
4. Faça push para a branch (`git push origin feature/sua-contribuicao`).
5. Abra um Pull Request.
