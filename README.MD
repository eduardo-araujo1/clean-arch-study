# Estrutura do Projeto Clean Architecture

Este projeto utiliza a Clean Architecture, garantindo uma separação clara de responsabilidades e promovendo alta coesão e baixo acoplamento. Abaixo está a descrição da estrutura de pastas e as responsabilidades de cada componente.

## Estrutura de Pastas

```
java/com/eduardo/clean_arch_study
|-- core
|   |-- entities
|   |   \-- User.java
|   |-- enums
|   |   \-- UserType.java
|   |-- exceptions
|   |   \-- BusinessException.java
|   |-- gateways
|   |   \-- UserGateway.java
|   \-- usecases
|       |-- impl
|       |   |-- CreateUserUseCaseImpl.java
|       |   \-- FindAllUseCaseImpl.java
|       |-- CreateUserUseCase.java
|       \-- FindAllUseCase.java
|-- infrastructure
    |-- configuration
    |   \-- BeansConfig.java
    |-- controllers
    |   |-- UserController.java
    |   \-- UserDtoMapper.java
    |-- dtos
    |   \-- UserDto.java
    |-- gateways
    |   |-- UserEntityMapper.java
    |   \-- UserRepositoryGateway.java
    |-- persistence
    |   |-- UserEntity.java
    |   \-- UserRepository.java
    \-- CleanArchStudyApplication.java
```

## Descrição das Pastas e Responsabilidades

### Core

#### `Entities`
Contém as entidades centrais do domínio, como `User`, que representam os modelos principais do sistema. São independentes de frameworks e bibliotecas externas.

#### `Enums`
Define tipos enumerados usados no domínio, como `UserType`, para representar categorias ou estados específicos.

#### `Exceptions`
Inclui exceções personalizadas, como `BusinessException`, para tratar erros de negócio de forma clara e estruturada.

#### `Gateways`
Define interfaces que descrevem contratos para interações externas, como persistência de dados, APIs, etc. Um exemplo é `UserGateway`.

#### `Usecases`
Implementa a lógica de negócio em casos de uso específicos.
- **Interface:** Define a API dos casos de uso, como `CreateUserUseCase`.
- **Implementação:** Contém a lógica concreta, como `CreateUserUseCaseImpl`.

### Infrastructure

#### `Configuration`
Configuração de injeção de dependências, como a classe `BeansConfig`, que gerencia a criação e ligação de dependências entre as camadas.

#### `Controllers`
Controladores REST responsáveis por expor a API aos clientes. Inclui o `UserController` e o mapeador `UserDtoMapper`, que converte entre DTOs e entidades de domínio.

#### `Dtos`
Define objetos de transferência de dados, como `UserDto`, usados para comunicação entre o cliente e o backend.

#### `Gateways`
Implementações concretas das interfaces definidas no core. Exemplos:
- `UserEntityMapper` mapeia entre entidades do domínio e entidades persistentes.
- `UserRepositoryGateway` implementa `UserGateway` para interagir com o repositório.

#### `Persistence`
Define a camada de persistência:
- `UserEntity`: Representa a entidade do banco de dados.
- `UserRepository`: Interface do Spring Data JPA para operações de banco de dados.

---

Esta organização facilita a manutenção, escalabilidade e teste da aplicação, separando claramente as preocupações e promovendo boas práticas de design.

