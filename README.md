# Sobre o projeto
Um projeto simples de uma casa de apostas, onde um usuário registrado pode fazer uma aposta, com chances de ganhar ou perder.

# Regras
- O usuário precisa estar registrado.
- O usuário deve ser maior de 18 anos.
- O valor da aposta deve ser maior que $20.
- O saldo do usuário deve ser suficiente para cobrir o valor da aposta.

# Tecnologias
- Spring Web
- Spring JPA
- Validation Beans
- Lombok
- JUnit
- Mockito
- Docker
- MySQL
- Swagger

# Como executar
- Digite "docker-compose up" no terminal
- A aplicação inicia na porta 8080

# Template para o método POST
### User
```
{
    "name": "junior",
    "amount": 500,
    "age": 18,
    "cpf": "12345678902",
    "email": "juniorsantos@gmail.com"
}
```
### Bet
```
{
    "amountBet": 20,
    "userId": 1
}
```
