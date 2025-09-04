# Sistema de Pedidos en Línea para Pastelería Aurora
## Descipción del Proyecto
- **Problemática:** La pastelería Aurora solo atienden de forma presencial o por teléfono suelen tener desorden en los pedidos, errores en la comunicación y limitaciones para llegar a más clientes.
- **Solución:** Un sistema en línea que permita a los clientes realizar pedidos mediante un carrito de compras y a los administradores gestionar productos y ventas en un solo lugar.
- **Objetivos:**
  - Facilitar el proceso de compra al cliente mediante pedidos en línea.
  - Disminuir errores en la toma y gestión de pedidos.
  - Ampliar las ventas al ofrecer un canal digital.

## Tecnologias usadas
- Lenguaje de programación **Java**
- Base de datos **MySQL**
- **Git / Github**

## Instalación y Ejecución
1. Instalar Java Development Kit (JDK 17 o superior). <https://www.oracle.com/java/technologies/downloads/>

y luego verificar en el cmd con:
```bash
java -version
```

2. Instalar Maven. <https://maven.apache.org/download.cgi>

y luego verificar en el cmd con:
```bash
mvn -v
```

3. Instalar un IDE compatible. <https://code.visualstudio.com/download>
4. Ingresar a Spring Initializr y crear un proyecto <https://start.spring.io/>
5. Descargar y abrir el proyecto en el IDE.
6. Configurar el archivo application.properties con la conexión a la base de datos MySQL
```bash
//BD
spring.datasource.url=jdbc:mysql://localhost:3306/pasteleria
spring.datasource.username=Pasteleria
spring.datasource.password=pasteleriagera

//JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
```
7. Crear las entidades, repositorios, servicios y controladores necesarios.
8. Diseñar las páginas HTML en la carpeta src/main/resources/templates (usando Thymeleaf).
9. Ejecutar el proyecto con:
```bash
mvn spring-boot:run
```
10.Abrir el navegador en <http://localhost:8080> para ver la aplicación funcionando.

## Roles y Crédito
| Nombre     |               Rol                   |                                 Funciones                                  |
|------------|-------------------------------------|----------------------------------------------------------------------------|
| Gerardo    | Líder del Proyecto                  | Coordinar al equipo, definir tareas, integrar módulos, supervisar avances  |
| Ana        | Desarrolladora Frontend             | Diseñar interfaces en HTML, estructurar formularios y vistas del sistema   |
| Alexander  | Encargado de Control de Versiones   | Configurar Git/GitHub, gestionar ramas, merge y resolver conflictos        |
| Josue      | Desarrolladora Backend              | Implementar lógica con Spring Boot, crear controladores y servicios        |
| Jennifer   | Administradora de Base de Datos     | Crear y gestionar la base en MySQL, modelar tablas y relaciones            |

## Flujo de Trabajo en Git
![Inicio](https://raw.githubusercontent.com/usuario/repositorio/main/dpaz/IMG/inicio.png)

## Capturas de Pantalla
### **Usuario**
#### Inicio

#### Lista de Productos
#### Carrito de Compras
