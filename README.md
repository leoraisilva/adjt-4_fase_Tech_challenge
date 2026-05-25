# 🍽️ Tech Challenge: API Feedback

## 📋 Sobre o Projeto

A API Feedback foi desenvolvida utilizando o framework Quarkus, seguindo princípios de Clean Architecture e separação de responsabilidades. O sistema tem como objetivo gerenciar usuários, avaliações acadêmicas, avisos e relatórios, permitindo o registro de feedbacks entre alunos e professores de forma estruturada

A aplicação foi organizada em camadas bem definidas, separando regras de negócio, casos de uso, adapters, persistência e controllers, facilitando manutenção, escalabilidade e evolução do projeto.

### 🏗️ Arquitetura do Projeto

O projeto segue uma estrutura modular organizada da seguinte forma:

	src
	├── main
	│   ├── docker
	│   ├── java
	│   │   └── br.com.fiap
	│   │       ├── application
	│   │       │   ├── domain
	│   │       │   ├── service
	│   │       │   └── useCase
	│   │       │       ├── inbound
	│   │       │       └── outbound
	│   │       └── infra
	│   │           ├── adapter
	│   │           └── config
	│   └── resources
	└── test

## 🚀 Tecnologias Utilizadas

<ol>
<dl>
  
<li> <dt>Java</dt> </li>

<li> <dt>Quarkus</dt> </li>

<li> <dt>Maven (Gerenciador de Dependências)</dt> </li>

<li> <dt>Dockerfile / Docker Compose (Containerização e Orquestração)</dt> </li>

<li> <dt> PostgreSQL (Banco de Dados Relacional)</dt> </li>

</dl>
</ol>

## 🚀 Como Executar o Projeto

Java / Maven (Opcional, para rodar sem Docker ou gerar o JAR)

## ⚙️ Como Executar o Projeto

	./mvnw quarkus:dev

#### 2. Ambiente localhost:

    http://localhost:8080

#### 3. 🐳 Docker:

    docker build -f src/main/docker/Dockerfile.jvm -t feedback-api .

    docker run -i --rm -p 8080:8080 feedback-api

## 📖 Padrões Utilizados

<ol>
<dl>
  
<li> <dt>Clean Architecture</dt> </li>

<li> <dt>SOLID</dt> </li>

<li> <dt>DTO Pattern</dt> </li>

<li> <dt>Repository Pattern</dt> </li>

<li> <dt>Mapper Pattern</dt> </li>

</dl>
</ol>

# OKAY
