# 📊 TechCommunity API

API REST construida con **Spring Boot 3**, **Java 21** y **JPA** para la gestión de proyectos y consulta de estadísticas mediante **procedimientos almacenados** en la base de datos.

---

## 🚀 Características

- Registro y gestión de proyectos.
- Consultas de estadísticas usando **Stored Procedures**:
    - Total de proyectos por categoría.
    - Duración promedio de proyectos.
    - Número de proyectos activos.
- Arquitectura en capas: **Controller → Service → Repository -> DTO**.

---

## 🛠️ Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3+**
- **Spring Data JPA / Hibernate**
- **MySQL** o **PostgreSQL** (soportado en ambos)
- **Maven**
- **DTOs** para respuestas limpias
- **Lombok** (opcional)


---

## 🗄️ Base de datos

### MySQL

```sql
CREATE DATABASE techcommunity;
USE techcommunity;

CREATE TABLE proyecto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NULL,
    estado ENUM('ACTIVO', 'FINALIZADO', 'CANCELADO') NOT NULL
);
```
```postgresql
CREATE DATABASE techcommunity;
\c techcommunity;

CREATE TABLE proyecto (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NULL,
    estado VARCHAR(20) CHECK (estado IN ('ACTIVO', 'FINALIZADO', 'CANCELADO')) NOT NULL
);

```
---
## ⚡ Endpoints principales
### 📌 Proyectos

* POST /api/proyectos → Crear un proyecto.
* GET /api/proyectos → Listar proyectos.

### 📌 Estadísticas

* GET /api/estadisticas/categorias → Total de proyectos por categoría.
* GET /api/estadisticas/duracion-promedio → Duración promedio de proyectos (días).
* GET /api/estadisticas/activos → Total de proyectos activos.
