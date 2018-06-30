# Backoffice Rest API

El objetivo del presente proyecto es crear un prototipo para la nueva generación de backoffice, mediante el uso del lenguaje de programación Java y Spring Framework.
## Frameworks y tecnologías utilizadas en el proyecto

* Java 8
* Spring Boot 2
* Spring Data JPA
* Gradle 4.2
* Swagger/ SwaggerUI 2.8.0


#### Pasos para correr el proyecto 

1. Descargarse o clonar el proyecto
[Guia para clonar un proyecto](https://help.github.com/articles/cloning-a-repository/)

3. Navegar hasta la carpeta backoffice, este directorio posee la siguiente estructura.

        backoffice
            ├───config
            │   └───dev
            │       ├───keystore
            │       └───scripts
            ├───gradle
            │   └───wrapper
            └───src
                ├───main
                │   └───java
                │       └───com
                │           └───geocom
                │               ├───configurations
                │               ├───controllers
                │               ├───converters
                │               ├───dtos
                │               ├───exceptions
                │               ├───models
                │               │   └───abstracts
                │               ├───repositories
                │               └───services
                │                   └───implementation
                └───test
                    ├───java
                    │   └───com
                    │       └───geocom
                    │           ├───controllers
                    │           └───repositories
                    └───resources
										
## Configuración

Antes de correr el proyecto primero debemos editar algunos archivos de configuración.
Para ello vamos a centrarnos en la carpeta  backoffice/config/dev ( para motivos de prueba solo se configuraron las propiedades para un ambiente de desarrollo),dentro de este directorio encontraremos los siguientes archivos:

	config
	└── dev
	    ├── application.properties
	    ├── banner.txt
	    ├── cors.properties
	    ├── database.properties
	    ├── keystore
	    │   └── ssl-server.jks
	    ├── scripts
	    │   ├── data.sql
	    │   └── schema.sql
	    ├── ssl.properties
	    └── swagger.properties

#### application.properties

Posee configuración general del proyecto como ser el puerto donde va a correr el servidor,el nombre de la aplicación y la versión de la misma.
Dentro de este archivo tenemos que editar la siguiente propiedad **spring.banner.location**, esta propiedad nos desplega en la consola al inicio de la aplicación un banner personalizado para la aplicación, ** !importante esta propiedad debe tener como valor  la ruta absoluta del archivo que vamos a utilizar como banner** , en nuestro caso debemos configurar la ruta absoluta al archivo banner.txt. 

#### banner.txt

Posee el Banner para le Rest Api de Backoffice

#### cors.properties

En este Archivo se encuentra la configuración del Control de acceso HTTP 
o Cross Origin Resource Sharing, configuraciones tales como los verbos HTTP y origenes aceptados.

#### database.properties
Configuración de la base de datos.

#### ssl.properties
Este archivo nos permite el uso de un certificado con nuestra API, aqui configuraremos todo lo referente al keystore, como por ejemplo el puerto donde va a correr el servidor, alias, y el password . **!importante** dentro de este archivo se encuentra la propiedad **server.ssl.key-store**   esta propiedad debe configurarse con la ruta absoluta a nuestro keystore. dentro de la carpeta config/dev/keystore encontraremos  un keystore creado para motivos prácticos.
El archivo de configuración posee todas las propiedades para el uso del mismo.
[Guia como crear un keystore](https://docs.oracle.com/cd/E19636-01/819-1655/fapsf/index.html)

#### swagger.properties
Contiene la informacion a mostrarse en la documentación de la Rest API. (swaggerUI).

#### schema.sql y data.sql
Contienen tanto el esquema de la base de datos como los datos respectivamente.


#### ! Antes de continuar...
Debemos de impactar los scripts en la base de datos y asegurarnos que hemos configurado correctamente los archivos de configuración.

Una vez realizado estos pasos navegamos hacia la carpeta **backoffice**

	backoffice
	├── build.gradle
	├── gradle
	│   └── wrapper
	│       ├── gradle-wrapper.jar
	│       └── gradle-wrapper.properties
	├── gradlew
	├── gradlew.bat

en la raíz de esa carpeta tenemos nuestro archivo de configuracion build.gradle (configuración del build para el proyecto)  y otros dos gradlew y gradlew.bat, estos ultimos son scripts para ejecutar gradle wrapper ( una herramienta muy util si no disponemos de gradle en nuestro sistema)

## Creando el jar 
para crear el jar en la raiz del directorio escribimos el siguiente comando:

**./gardlew build (Linux)**

**gradlew.bat build (windows)**

## Corriendo la Rest API
Spring boot nos crea por defecto un jar con un servidor de aplicaciones tomcat embebido, para iniciarlo debemos utilizar nuestra configuracion externa al proyecto (mencionada previemante en este documento)
para ellos vamos a utilizar las properties **spring.config.name** y  **spring.config.location**, propiedades las cuales deben ser configuradas con los archivos de configuracion a utilizar y la ubicacion de los mismos ( debemos utilizar la ruta absoluta), por lo tanto debemos escribir el sieguiente comando.

**Java -jar -Dspring.config.name=application,database,security,ssl,cors,swagger -Dspring.config.location=`<ruta-absoluta`>/config/dev/   `<ruta-jar`>/geocomRestApi-0.0.1-SNAPSHOT.jar**




