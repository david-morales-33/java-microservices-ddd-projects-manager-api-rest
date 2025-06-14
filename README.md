# 🧱 Java Microservices DDD - Projects Manager API REST

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9-blue.svg)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> API REST para la gestión de proyectos desarrollada con Java, arquitectura de microservicios y Domain-Driven Design (DDD). Ideal como base para aplicaciones empresariales escalables y modulares.

## 🧭 Tabla de Contenidos

- [🧱 Java Microservices DDD - Projects Manager API REST](#-java-microservices-ddd---projects-manager-api-rest)
  - [🧭 Tabla de Contenidos](#-tabla-de-contenidos)
  - [🚀 Características principales](#-características-principales)
  - [📁 Estructura del proyecto](#-estructura-del-proyecto)
  - [⚙️ Tecnologías utilizadas](#️-tecnologías-utilizadas)
  - [📦 Instalación](#-instalación)
  - [🔧 Configuración](#-configuración)
  - [▶️ Uso](#️-uso)
  - [🧪 Pruebas](#-pruebas)
  - [📄 Licencia](#-licencia)
  - [🤝 Contribuciones](#-contribuciones)
  - [👨‍💻 Autor](#-autor)

---

## 🚀 Características principales

🌟 **¿Qué es la arquitectura hexagonal?**
También llamada "Ports and Adapters", la arquitectura hexagonal busca aislar el núcleo de negocio (la lógica pura de tu aplicación) del resto del sistema, como bases de datos, servicios externos o interfaces de usuario.

Hexágono (el núcleo): contiene la lógica del dominio, es decir, el "qué hace" tu sistema.

Puertos (Ports): son interfaces que definen cómo puede interactuar el núcleo con el exterior.

Adaptadores (Adapters): son implementaciones concretas de esos puertos (por ejemplo, un repositorio con TypeORM, un controlador de Express, etc).

🧠 **¿Y cómo encaja DDD aquí?**
Domain-Driven Design (DDD) es una forma de diseñar software que pone énfasis en el modelo del dominio, es decir, en representar correctamente las reglas del negocio con clases, entidades, agregados, etc.
En una arquitectura hexagonal orientada a DDD:

El dominio (con sus entidades, agregados, value objects, etc.) está al centro del hexágono.

El caso de uso (application layer) orquesta las acciones del dominio.

Todo lo externo (UI, base de datos, APIs externas) se conecta al núcleo a través de puertos y adaptadores.

🔄  **Relación entre DDD y microservicios**
DDD te ayuda a diseñar buenos microservicios, porque:

Cada Bounded Context puede convertirse en un microservicio independiente.

El DDD te fuerza a entender los límites del dominio, lo cual es clave al dividir sistemas.

Al tener contratos claros (puertos) y comunicaciones definidas, podés exponer esos puertos como APIs o eventos en una arquitectura distribuida.

👉 Los microservicios no son DDD, pero DDD es una excelente guía para diseñarlos.

🎯 Para este proyecto tenemos las siguientes características:

- 🧩 Separación por módulos y contextos delimitados (Bounded Contexts)
- 📐 Arquitectura hexagonal y orientación a DDD
- 🛠️ Clean Architecture para cada microservicio
- 🌐 API REST lista para producción
- 🔐 Seguridad integrada (preparado para JWT / OAuth2)
- 🧪 Testing modular por contexto
- 🐳 Integración con Docker y Docker Compose

---

## 📁 Estructura del proyecto (estructura modular)

```text
.
├── microservice-administrative/               # Microservicio para gestión administrativa
|   ├──pom.xml
|   └──src/main/java/com/microservice
|   |   ├──administrative
|   |   |   ├──user                            # Estructura con vertical slice
|   |   |   |   ├──application
|   |   |   |   ├──domain
|   |   |   |   ├──infrastructure
|   |   |   ├──role
|   |   |   ├──team
|   |   |   ├──project
|   |   |   ├──card
|   |   |   ├──board
|   |   |   └──module
|   |   └──server
├── microservice-authentication/               # Microservicio de autenticación
|   ├──pom.xml
|   └──src/main/java/com/microservice
├── microservice-development/                  # Microservicio para desarrollo de proyectos
|   ├──pom.xml
|   └──src/
|   |   ├──/main/java/com/microservice
|   |   └──/test/java/com/microservice
|   |   |   ├──development
|   |   |   |   ├──user                        # Estructura con vertical slice
|   |   |   |   |   ├──application
|   |   |   |   |   ├──domain
|   |   |   |   |   └──infrastructure
├── microservice-media/                        # Microservicio para comunicación de e
|   ├──pom.xml
|   └──src/main/java/com/microservice
├── microservice-config/                       
├── microservice-eureka/                       
├── microservice-gateway/                      
├── docker/                                    # Archivos Docker y configuración de servicios
├── .github/                                   # Workflows, PR templates, etc.
├── pom.xml                                    # Configuración Maven principal
└── README.md
```

---

## ⚙️ Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **Maven**
- **JUnit 5**
- **Mockito**
- **Docker / Docker Compose**
- **Arquitectura hexagonal**
- **DDD (Domain-Driven Design)**
- **Microservicios**

---

## 📦 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/david-morales-33/java-microservices-ddd-projects-manager-api-rest.git
cd java-microservices-ddd-projects-manager-api-rest
```

### 2. Construir el proyecto

```bash
./mvnw clean install
```

---

## 🔧 Configuración

Este proyecto utiliza configuración basada en Spring Boot. Puedes definir las propiedades necesarias en los archivos:

- `application.properties`
- `application-dev.properties`
  
Esto para cada servicio.

También puedes definir variables de entorno o montar un archivo `.env` para tu entorno local si usás Docker:

```dotenv
DB_HOST=localhost
DB_PORT=5432
DB_USER=admin
DB_PASSWORD=secret
```

---

## ▶️ Uso

### Levantar con Spring Boot


### Levantar servicios con Docker


## 🧪 Pruebas


Las pruebas están organizadas por:

- ✅ **Dominio**: lógica de negocio pura
- ⚙️ **Aplicación**: casos de uso
- 🌐 **Infraestructura**: adaptadores, controladores, etc.

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más información.

---

## 🤝 Contribuciones

¡Las contribuciones son más que bienvenidas!

1. Fork del proyecto
2. Crea tu rama (`git checkout -b feature/nueva-funcionalidad`)
3. Commit a tus cambios (`git commit -m 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abrí un Pull Request 🚀

---

## 👨‍💻 Autor

Desarrollado por [David Morales](https://github.com/david-morales-33)
