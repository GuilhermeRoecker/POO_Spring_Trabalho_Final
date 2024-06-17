# Alunos: Guilherme Roecker e Eduardo Vandresen
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

## Endpoints da API
### Carro
- GET /carro: Lista todos os carros cadastrados.
- GET /carro/{id}: Busca um carro pelo ID.
- GET /carro/modelo/{modelo}: Lista carros por modelo.
- GET /carro/placa/{placa}: Busca um carro pela placa.
- GET /carro/motorista/{nomeMotorista}: Busca um carro pelo nome do motorista.
- POST /carro: Cadastra um novo carro.
- PUT /carro/{id}: Atualiza os dados de um carro existente.
- DELETE /carro/{id}: Exclui um carro pelo ID.
### Multa
- GET /multa: Lista todas as multas cadastradas.
- GET /multa/{id}: Busca uma multa pelo ID.
- GET /multa/infracao/{infracao}: Lista multas por infração.
- POST /multa: Cadastra uma nova multa.
- PUT /multa/{id}: Atualiza os dados de uma multa existente.
- DELETE /multa/{id}: Exclui uma multa pelo ID

# Exemplo de Uso

### Cadastrar um Carro
`Post`
``` 
localhost:8080/carro
 ```
`Dados cadastrais`
```
{
  "nomeMotorista": "João Silva",
  "placa": "ABC-123",
  "modelo": "Fiesta",
  "cor": "Preto"
}
 ```
`Retorno`
```
id: 1
Motorista: João Silva
placa: ABC-123
Modelo: Fiesta
Cor: Preto
 ```
`Obs: Placa deve estar no formato "ABC-123" caso contrario sistema não deixara cadastrar.`

### Consultar todos os carro cadastrados
`GET`
```
localhost:8080/carro
```
`Retorno`
```
id: 1
Motorista: João Silva
placa: ABC-123
Modelo: Fiesta
Cor: Preto

id: 2
Motorista: Eduardo Rocha
placa: DEF-456
Modelo: Uno
Cor: Vermelho
 ```

### Consultar carro cadastrado pelo id
`GET`
```
 localhost:8080/carro/1
```
`Retorno`
```
id: 1
Motorista: João Silva
placa: ABC-123
Modelo: Fiesta
Cor: Preto
 ```

### Consultar todos os carro de um determinado modelo
`GET` 
```
localhost:8080/carro/modelo/Fiesta
 ```
`Retorno`
```
id: 1
Motorista: João Silva
placa: ABC-123
Modelo: Fiesta
Cor: Preto
 ```

### Consultar um carro pelo placa
`GET`
```
localhost:8080/carro/placa/ABC-123
  ```
`Retorno`
```
id: 1
Motorista: João Silva
placa: ABC-123
Modelo: Fiesta
Cor: Preto
 ```

### Buscar Carro pelo Motorista
`Get` 
```
localhost:8081/carro/motorista?nomeMotorista=Jo%C3%A3o%20Silva
 ```
`Retorno`
```
id: 1
Motorista: João Silva
placa: ABC-123
Modelo: Sedan
Cor: Preto
 ```
`Obs: Os espaços em branco devem ser preenchidos pelo caracter %20 para que a pesquisa funcione.
É possivel relaizar busca por palavras chaves. Ex: Silva`

### Alterar um carro ja cadastrado

`PUT`
```
localhost:8080/carro/1
 ```
```
{
  "placa": "XYZ-258",
  "cor": "Azul"
}
 ```
`Retorno`
```
id: 1
Motorista: João Silva
placa: XYZ-258
Modelo: Sedan
Cor: Azul
 ```

### Apagar carro cadastrado
`DELETE`
```
localhost:8080/carro/1
 ```
`Retorno`
```
Carro com o id: 1 foi apagado com sucesso
 ```

### Cadastrar uma Multa
`POST`
```
localhost:8080/multa
 ```
`Dados cadastrais`
```
{
  "infracao": "Excesso de velocidade",
  "valor": 150.0,
  "carro": {
    "id": 1
  }
}
 ```
`Retorno`
```
Multa
Id: 1
Infracao: Excesso de velocidade
Valor: 150.0
Carro: id: 1
Motorista: null
placa: null
Modelo: null
Cor: null
 ```
### Visualizar todas as multas cadastradas
`GET`
```
localhost:8080/multa
 ```
`Retorno`
```
Multa
Id: 1
Infracao: Excesso de velocidade
Valor: 150.0
Carro: id: 1
Motorista: João Silva
placa: ABC-123
Modelo: Sedan
Cor: Preto

Multa
Id: 2
Infracao: Dirigir embreagado
Valor: 150.0
Carro: id: 2
Motorista: João Silva
placa: ABC-123
Modelo: Fiesta
Cor: Preto
 ```

### Buscar multa por id
`GET`
```
localhost:8080/multa/1
 ```
`Retorno`
```
Multa
Id: 1
Infracao: Excesso de velocidade
Valor: 150.0
Carro: id: 1
Motorista: João Silva
placa: ABC-123
Modelo: Sedan
Cor: Preto
 ```
### Listar todas as multa por determinada Infração
`GET`
```
localhost:8081/multa/infracao?infracao=excesso%20de%20velocidade
 ```
`Retorno`
```
Multa
Id: 1
Infracao: Excesso de velocidade
Valor: 150.0
Carro: id: 1
Motorista: João Silva
placa: ABC-123
Modelo: Sedan
Cor: Preto
 ```
`Obs: Os espaços em branco devem ser preenchidos pelo caracter %20 para que a pesquisa funcione.
É possivel relaizar busca por palavras chaves. Ex: velocidade`

### Alterar multa existente
`PUT`
```
localhost:8081/multa/1
 ```
`Dados passados`
```
{
  "infracao": "Excesso de velocidade",
  "valor": 200.0,
  "carro": {
    "id": 2
  }
}
 ```
`Retorno`
```
Multa
Id: 1
Infracao: Excesso de velocidade
Valor: 200
Carro: id: 2
Motorista: João Silva
placa: ABC-123
Modelo: Fiesta
Cor: Preto
 ```

### Deletar multa existente
`DELETE`
```
localhost:8081/multa/1
 ```
`Retorno`
```
Multa com o Id 1 apagada com sucesso
 ```

### Limpar tabela de dados
```
DELETE FROM avaliacao_3.carro WHERE id > 0;
ALTER TABLE avaliacao_3.carro AUTO_INCREMENT = 1 ;

DELETE FROM avaliacao_3.multa WHERE id > 0;
ALTER TABLE avaliacao_3.multa AUTO_INCREMENT = 1 ;
```
