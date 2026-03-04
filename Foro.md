# Foro App

[![Made by DigitalPro](https://img.shields.io/badge/Made%20by-DigitalPro-blue)](https://digitalpro.dev)
![Version](https://img.shields.io/badge/Version-1.0.0-blue)
![Tecnología](https://img.shields.io/badge/Tecnología-Java-red)
![Framework](https://img.shields.io/badge/Framework-Spring_Boot-green)
![Base de Datos](https://img.shields.io/badge/Base_de_Datos-MySQL-blue)
![ORM](https://img.shields.io/badge/ORM-Spring_Data_JPA-purple)
![API](https://img.shields.io/badge/API-REST-lightgrey)

## Descripción
Foro App es una aplicación de ejemplo construida con Java y Spring Boot que permite gestionar tópicos de discusión con autenticación vía JWT. Los usuarios pueden crear, listar, actualizar y eliminar tópicos de manera segura.

## Tecnologías y Dependencias
- Java 17
- Spring Boot 4.0.3
- Spring Data JPA
- Spring Security
- Validación con Spring Validation
- MySQL como base de datos
- Flyway para migraciones
- JWT (java-jwt 4.5.1) para autenticación
- Lombok

## Configuración de la base de datos
En `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/TU_BASE_DE_DATOS
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

api.security.token.secret=TU_CONTRASEÑA
api.security.token.expiration=3600
```
`ENPOINT`:

```
| Método | URL           | Descripción                             |
| ------ | ------------- | --------------------------------------- |
| POST   | /login        | Autenticación de usuario, retorna JWT   |
| GET    | /topicos      | Listar todos los tópicos (requiere JWT) |
| GET    | /topicos/{id} | Ver detalles de un tópico               |
| POST   | /topicos      | Crear un nuevo tópico                   |
| PUT    | /topicos      | Actualizar un tópico existente          |
| DELETE | /topicos/{id} | Eliminar un tópico                      |
```