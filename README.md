# spring-boot-employees
Proyecto de SpringBoot para el listado y creación de empleados

Vista previa del Front-End en GitHub Pages (Se necesita del uso de Docker Compose para el Back-End) [aquí](https://jsovalles.github.io/angular-employees/employees)

## Instalación/Despliegue

Se descarga el proyecto desde GitHub y después se realiza el siguiente comando en la carpeta principal del proyecto
```
mvn clean install
```
**Nota**: En el caso de que no se tenga Maven instalado para la compilación del proyecto, se subió en la rama **target-build** el archivo target donde contiene la última compilación correspondiente al proyecto.

Después de que el comando termine de compilar se debe realizar el siguiente comando:
```
docker-compose up
```
Cuando termine de finalizar Docker Compose ya se puede comprobar el funcionamiento de los servicios tanto en un navegador web como en aplicaciones para APIs (Postman, Insomia, etc).

**Link de los diferentes servicios**
```
listEmployees (GET) - http://localhost:8080/employees

createEmployee (POST) - http://localhost:8080/employees?bossId=1

createEmployee Body Example - {
    "fullName": "Mario Mora",
    "function": "Proyect Owner"
}
```
**En el caso de que el Docker Compose no funcione se deben realizar los siguientes comandos:**
```
docker-compose rm
docker-compose down
docker image rm employees-app
docker-compose up
```

# Desarrollado en

* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - The Java IDE
* [Maven](https://maven.apache.org/) - Dependency Management
* Java 11 JDK
