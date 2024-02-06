# Taller-2-AREP
En este taller se requiere buscar archivos desde el disco duro local, para si poder observarlos dentro de el mismo path de la URI, a su vez que permita la busqueda como RESTfulAPI.

## Uso del programa

Para usar apropiadamente el programa se debe ejecutar el ciclo de vida en MAVEN en y un IDE de su preferencia se puede ejecutar el programa, el cliente es tu mismo browser, asi que solo es iniciar el servidor y usarlo a gusto.

para poder ver mas a fondo los paths involucrados, se adjuntaran las URIS necesarias para observar los distintos comportamientos

  * http://localhost:35000/cliente.html
  * http://localhost:35000/error.html
  * http://localhost:35000/prueba.css
  * http://localhost:35000/prueba.wepb
  * http://localhost:35000/xd.jpg

### Extensibilidad

Lo unico que necesitas para extender la funcionalidad de este programa es que agregues tus propios paths y sus respectivas respuestas, ya que esta diseñado para que cualquier persona desee hacer un host local de una pagina web

### Diseño

  Este programa sigue el Principio Open/Closed, ya que no es un proyecto lo suficientemente grande para aplicar todo el principio SOLID, se usa el patron builder ya que se construye procedimentalmente una clase compleja a base de pasos pequeños y simples.

#### PRUEBAS REALIZADAS
 todas las pruebas realizadas fueron de aceptacion, a la hora de probar el programa con diferentes parametros y verificando si tiene el comportamiento deseado

1. prueba de busqueda de archivos
   se usan las siguentes URI con  el fin de verificar la existencia de los archivos, ademas de inspeccionar el elemento

   nosotros contamos los siguientes archivos:
   
  ![image](https://github.com/Parralol/Taller-2-AREP/assets/110953563/59a93a29-2f32-4d77-be7e-eae87d3430d6)

Para verificar que existan iniciaremos el programa y usaremos inspeccionar elemento en el browser de preferencia,podremos observar que los archivos vitales son subidos a la misma pagina:


![image](https://github.com/Parralol/Taller-2-AREP/assets/110953563/472d3918-f14c-41c6-92e8-1cb0a2b5510f)

y Como podremos observar, la pagina cargara correctamente:

![image](https://github.com/Parralol/Taller-2-AREP/assets/110953563/2e19be50-580a-4bfe-83e9-a361c3f81493)

Se realizo una consulta restApi antes de esto para poder mostrar que todo esta funcionando correctamente, inclusive cargando el CSS correcto de la pagina.

Ahora, si deseamos acceder a los archivos en otra forma, es solo escribir el archivo en el path respectivo



### Prerequisitos

  * conexión a internet
  * SDK javaSE-1.8 y posterior
  * MAVEN

### Respecto a la instalacion
  No se debe tener nada especial para realizar la instalacion del programa o su empaquetamiento a jar.

## Despliegue

  El siguiente programa no se encuentra desplegado

## Construido con

  * MAVEN
  * Java
  * HTML
  * CSS
  * JS
      
## Autor

 * **Santiago Parra**
