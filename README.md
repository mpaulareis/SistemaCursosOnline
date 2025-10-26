# 🎓 Sistema de Cursos Online

Olá, esse projeto foi desenvolvido como parte da disciplina de **Programação Orientada a Objetos**, com o objetivo de aplicar os principais conceitos de **abstração, encapsulamento, herança, polimorfismo, exceções, repositórios e arquitetura em camadas (MVC/Fachada)** utilizando a linguagem **Java**.

---

## 🧠 Objetivo

O sistema tem como propósito gerenciar o cadastro de **alunos, professores, cursos e matrículas**, permitindo simular o funcionamento básico de uma plataforma de cursos online.

---

## ⚙️ Funcionalidades Implementadas

### 🧩 Entidades
- `Aluno`
- `Professor`
- `Curso`
- `Aula`
- `Matrícula`

Cada entidade possui seus atributos e métodos próprios, seguindo os princípios de encapsulamento.

---

### 🗃️ Repositórios
Foram implementados repositórios em **array puro** para armazenamento e manipulação dos dados:
- `RepositorioAluno`
- `RepositorioProfessor`
- `RepositorioCurso`
- `RepositorioMatricula`

Cada repositório utiliza o **padrão Singleton**, garantindo apenas uma instância ativa no sistema.

---

### 🧰 Fachada
A classe `Fachada` centraliza o acesso às operações do sistema, encapsulando a comunicação entre as camadas de dados e a camada de interface (Programa).

---

### ⚠️ Exceções
O sistema trata exceções específicas para garantir integridade dos dados:
- `EntidadeJaExisteException`
- `EntidadeNaoEncontradaException`
- `RepositorioCheioException`
