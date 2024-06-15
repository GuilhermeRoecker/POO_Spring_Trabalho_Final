# Trabalho Final de Programação Orientada a Objetos com a utilização do Spring Boot 

Este projeto é uma aplicação Spring Boot para gerenciar carros e multas. Ele utiliza JPA para persistência de dados e fornece uma API REST para interação com o sistema.

## Estrutura do Projeto

- **Model:** Contém as classes de entidade `Carro` e `Multa`.
- **Repository:** Contém as interfaces de repositório `CarroRepository` e `MultaRepository` para interação com o banco de dados.
- **Resources:** Contém os controladores REST `CarroResource` e `MultaResource`.
- **Services:** Contém os serviços `CarroService` e `MultaService` que implementam a lógica de negócio.
- **Application:** Classe principal para iniciar a aplicação.

## Requisitos

- Java 17+
- Maven 3.6+
- Banco de dados H2 (default) ou outro banco de dados suportado pelo Spring Data JPA

## Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/trabalho_final.git
   cd trabalho_final

Endpoints da API
Carro
GET /carro: Lista todos os carros cadastrados.
GET /carro/{id}: Busca um carro pelo ID.
GET /carro/modelo/{modelo}: Lista carros por modelo.
GET /carro/placa/{placa}: Busca um carro pela placa.
GET /carro/motorista/{nomeMotorista}: Busca um carro pelo nome do motorista.
POST /carro: Cadastra um novo carro.
PUT /carro/{id}: Atualiza os dados de um carro existente.
DELETE /carro/{id}: Exclui um carro pelo ID.
Multa
GET /multa: Lista todas as multas cadastradas.
GET /multa/{id}: Busca uma multa pelo ID.
GET /multa/infracao/{infracao}: Lista multas por infração.
POST /multa: Cadastra uma nova multa.
PUT /multa/{id}: Atualiza os dados de uma multa existente.
DELETE /multa/{id}: Exclui uma multa pelo ID

## Exemplo de Uso
### Cadastrar um Carro

curl -X POST http://localhost:8080/carro -H "Content-Type: application/json" -d '{
  "nomeMotorista": "João Silva",
  "placa": "ABC1234",
  "modelo": "Sedan",
  "cor": "Preto"
}'

### Buscar Carro por Placa
curl -X GET http://localhost:8080/carro/placa/ABC1234

### Cadastrar uma Multa
curl -X POST http://localhost:8080/multa -H "Content-Type: application/json" -d '{
  "infracao": "Excesso de velocidade",
  "valor": 150.0,
  "carro": {
    "id": 1
  }
}'

### Esse `README.md` fornece uma visão geral do projeto, instruções de configuração e uso, e detalhes sobre os endpoints da API. Certifique-se de ajustar quaisquer informações específicas do seu projeto, como o link do repositório e detalhes adicionais que possam ser relevantes
