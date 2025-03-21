📌 Estrutura do Projeto
1️⃣ Funcionalidades principais
✔ Cadastro e login de empresas e candidatos
✔ Empresas podem cadastrar, editar e excluir vagas
✔ Candidatos podem buscar vagas, se candidatar e gerenciar aplicações
✔ Sistema de autenticação e autorização (admin, recrutador, candidato)
✔ Integração com banco de dados PostgreSQL
✔ Deploy na nuvem (Railway, Render ou AWS)

📂 Tecnologias
Back-end: Java + Spring Boot, Spring Security, Spring Data JPA
Banco de Dados: PostgreSQL
Autenticação: JWT
Front-end: HTML/CSS ou React (podemos escolher)
Documentação: Swagger
Testes: JUnit + Mockito
Deploy: Railway/Render para a API, Vercel para o front-end
📁 Estrutura de Pastas (Back-end)
css
Copiar
Editar
📦 portal-vagas
 ┣ 📂 src/main/java/com/seuusuario/portalvagas
 ┃ ┣ 📂 controllers
 ┃ ┣ 📂 models
 ┃ ┣ 📂 repositories
 ┃ ┣ 📂 services
 ┃ ┗ 📂 security
 ┣ 📂 src/main/resources
 ┃ ┣ 📜 application.properties
 ┃ ┣ 📜 data.sql (dados iniciais)
 ┗ 📜 PortalVagasApplication.java
