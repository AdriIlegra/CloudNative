# Estrutura do Banco de Dados - Sistema de Gerenciamento Acadêmico

Este projeto implementa um banco de dados relacional para um sistema de gerenciamento acadêmico em um ambiente de faculdade.

## Tabelas

### Tabela `curso`

- `id`: ID único do curso (chave primária)
- `nome`: Nome do curso
- `numero_identificacao`: Número de identificação do curso

### Tabela `disciplina`

- `id`: ID único da disciplina (chave primária)
- `nome`: Nome da disciplina
- `carga_horaria`: Carga horária da disciplina
- `codigo`: Código da disciplina
- `sala`: Número da sala da disciplina
- `id_curso`: ID do curso ao qual a disciplina pertence (chave estrangeira)
- `id_professor`: ID do professor que leciona a disciplina (chave estrangeira)

### Tabela `professor`

- `id`: ID único do professor (chave primária)
- `nome`: Nome do professor
- `email`: Endereço de email do professor
- `telefone`: Número de telefone do professor

### Tabela `aluno`

- `id`: ID único do aluno (chave primária)
- `nome`: Nome do aluno
- `email`: Endereço de email do aluno
- `telefone`: Número de telefone do aluno
- `cpf`: Número de CPF do aluno

### Tabela `matricula`

- `id`: ID único da matrícula (chave primária)
- `id_aluno`: ID do aluno matriculado (chave estrangeira)
- `id_disciplina`: ID da disciplina matriculada (chave estrangeira)
- `nota`: Nota atribuída ao aluno na disciplina
