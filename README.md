# CocinandoConJava

Aplicación web Spring Boot con interfaz Thymeleaf y API REST para gestionar recetas y dificultades. Usa SQLite como fuente de datos embebida y expone la misma información desde una UI tradicional y vía Spring Data REST/OpenAPI.

## Stack principal
- Java 21
- Spring Boot 3.5.9-SNAPSHOT (`spring-boot-starter-web`, `spring-boot-starter-data-jpa`, `spring-boot-starter-thymeleaf`)
- Spring Data REST, Swagger (Springdoc) y SQLite (vía `sqlite-jdbc`)
- Lombok (procesado en tiempo de compilación)

## Prerrequisitos
1. JDK 21 (compatible con el `java.version` del `pom.xml`).
2. (Opcional) Maven instalado; si no lo tienes, usa los wrappers (`./mvnw` / `mvnw.cmd`) incluidos.

## Configuración rápida
1. Clona el repositorio y entra en la carpeta:
   ```bash
   git clone <repo-url>
   cd CocinandoConJava
   ```
2. La base de datos es un fichero SQLite (`cocinandoconjava.db`) en la raíz. No hace falta crearlo: Spring Boot lo inicializa con `spring.jpa.hibernate.ddl-auto=create-drop`, así que los datos se regeneran en cada arranque.
3. Si necesitas compilar antes de arrancar:
   ```bash
   ./mvnw clean package
   ```

## Ejecución
- Para desarrollo con recarga automática, ejecuta:
  ```bash
  ./mvnw spring-boot:run
  ```
- Para desplegar el artefacto WAR generado:
  ```bash
  java -jar target/CocinandoConJava-0.0.1-SNAPSHOT.war
  ```
  *(La aplicación se empaqueta como WAR porque `spring-boot-starter-tomcat` está declarado con `scope=provided`.)*

## Pruebas
- Ejecuta el conjunto de pruebas unitarias/integración:
  ```bash
  ./mvnw test
  ```

## ¿Qué rutas puedes usar?
- UI básica:
  - `/` → página de bienvenida (Thymeleaf).
  - `/mostrar` → lista de recetas guardadas.
  - `/insertar` → formulario de registro de recetas con validación (`/registro` es el POST).
- API REST:
  - `/api/v1/recetas` y `/api/v1/dificultades` (Spring Data REST).
  - `/api/v2/swagger` → consola Swagger UI, y `/api/v2/api-docs` para el JSON OpenAPI.



