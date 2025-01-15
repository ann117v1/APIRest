# ForoHub - Challenge Back-End de Alura

Bienvenido/a al repositorio de **ForoHub**, el proyecto desarrollado como parte del Challenge Back-End de Alura Latam. ForoHub es una API para gestionar un foro en línea, donde los usuarios pueden crear y manejar topicos, aprendiendo a manejar
el uso del CRUD

## ✨ Características Principales
- **Gestión de temas**: Crear, listar, editar y eliminar temas.
- **Organización por categorías**: Facilita la búsqueda y organización del contenido.
- **Autenticación y seguridad**: Acceso restringido a ciertas funciones para usuarios autenticados.
- **Endpoints claros**: Implementación de endpoints RESTful para la interacción con los datos.

## 🔧 Tecnologías Utilizadas
- **Lenguaje**: Java
- **Base de datos**: PostgreSQL
- **Herramienta de pruebas**: Insomnia para probar y documentar los endpoints.
- **Framework**: Spring Boot
- **ORM**: Hibernate para el manejo de la persistencia de datos.

## 🔍 Endpoints y Uso
Este proyecto cuenta con una colección de endpoints que cubren todas las funcionalidades descritas. Puedes importar la colección para Insomnia desde el archivo `ForoHub_Insomnia.json` incluido en el repositorio. Algunos de los endpoints principales son:

- `POST /login`: Autenticar usuarios.
- `GET /topicos`: Listar todos los temas.
- `POST /topicos`: Crear un nuevo tema.
- `PUT /topicos/{id}`: Editar un tema existente.
- `DELETE /topicos/{id}`: Eliminar un tema.

