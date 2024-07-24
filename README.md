# prueba-users
** Requisitos **
Se usa java 21
Maven 3



# Arquitectura  Hexagonal


![Texto alternativo](https://github.com/juliaosistem/prueba-Beyserin-Consulting-Daniel-jualiao/blob/master/imgDocumentacion/arquitectura.png)

En el paquete de infraestructura  esta la logica del negocio separada por dos paquetes

**paquete primary**
Este se encarga de implementar toda la logica de negocio

**paquete secundary**
Este se encarga de interactuar con la base de datos


## Proceso de installacion y ejecucion sin ide

**paso 1**  descargar repositorio

**paso 2** entrar ala carpeta src

**paso 3**  instalar en maquina local jdk 21


**paso 6** instalar maven

**paso 7**  ubicarse en la consola en la carpeta src 

**paso 8**  ejecutar mvn clean  install 



![Texto alternativo](https://github.com/Farius-red/mcs-financial/blob/master/imgDocumentacion/creaciondeJar.png)

**una salida en la terminal  similar a esta**


**paso  9**  copar la ruta que aparece en lo resaltado en blanco

**paso 10**  ejecutar  la ruta que copiamos sin la parte final del .jar
cd  /home/daniel-juliao-sistem/Documentos/desarrollo/backend/mcs-financial/target/

es un ejemplo para poder correrlo localmente las carpetas tienen q ser en la ubicacion en la que se descarga y cambiando las rutas 




**paso 11**
java -jar nombre del jar aqui.jar

**esto ejecutara la aplicación**


**paso 12** 


ir a google y poner esta url
http://localhost:8090/documentacion

**Debe aparecer la interfase visual  de swagger**



## Front

Desarrollado en angular requisitos para correrlo 

node  v20.14.0
npm version  10.7.0 
angular version  18

ir ala carpeta front/template-test-ng/projects/test-app-ng/
ejecutar npm install 
ng serve 

