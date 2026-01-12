# Estructuras Básicas dentro de un Proyecto de Java

## Lista de contenido

1. [Clases](#clases)
    1. [¿Qué es una clase?](#qué-es-una-clase)
    1. [Creación de clases](#creación-de-clases)
1. [Paquetes](#paquetes)
    1. [¿Qué es un paquete?](#qué-es-un-paquete)
    1. [Creación de paquetes](#creación-de-paquetes)

***

## Clases

### ¿Qué es una clase?

Las clases son la estructura básica de todo proyecto de Java, ya que todo objeto que declaremos en nuestro código debe pertenecer a alguna clase.

Asi que todo nuestro código estará organizado en un conjunto de clases, a partir de las cuales declararemos, a su vez, objetos. La interacción de estos objetos determinará el funcionamiento de nuestra aplicación.

>**Nota:** Para profundizar en las características generales de clases y objetos, se recomienda leer, en la documentación complementaria, el capítulo [**"¿Qué es un objeto?"**][l1] y los que le siguen, donde se describe en más detalle estos conceptos.

### Creación de clases

Para crear una clase nueva dentro de nuestro proyecto, simplemente crearemos un archivo de texto plano, pero con extensión `.java` en nuestro directorio `src`.

Por [convención][l2], los nombres de las clases en Java deben seguir estas reglas:

- Se debe procurar que sean simples y descriptivos.
- Debe ser único dentro del proyecto.
- Deben iniciar en una letra mayúscula, por ejemplo: `Usuario`.
- Deben ser sustantivos (o sea, un nombre de una entidad, cosa, lugar, etc). por ejemplo: `Usuario`, `Sesion`, `Producto`.
- Si necesitan estar formados por más de una palabra, cada palabra irá con su primer letra en mayúscula (lo que suele llamarse [*Pascal Case*][l3]), por ejemplo: `UsuarioRegistrado`, `MenuPrincipal`.
- **No pueden contener** espacios, guiones, símbolos, tildes, o caracteres especiales.

Nuestro IDE nos facilita el trabajo de agregarle el código inicial básico mediante el uso de asistentes de creación.

En NetBeans, para crear una clase, utilizaremos el comando `File`>`New File...` para abrir el asistente de creación de archivos nuevos.

En el cuadro `Categories` elegiremos `Java`, y en el cuadro `File Types` elegiremos `Java Class`. Luego damos click en el botón `Next`.

![i1]

En la siguiente pantalla ingresaremos el nombre de nuestra clase en el campo `Class Name`, cuidando de que se esta creando en el proyecto correcto (se puede comprobar en el campo `Project`). Los demás detalles que se mencionan en el diálogo, por ahora, no los modificaremos.

![i2]

Para terminar, damos click en `Finish`, y el IDE creará nuestra clase con el código básico para comenzar a desarrollar en la misma.

[*Volver al Inicio*][inicio]
***

## Paquetes

Si nuestro proyecto resulta medianamente complejo, seguramente contendrá muchas clases, y por lo tanto, muchos archivos, lo que puede dificultar el manejo del código.

Para organizar las clases de nuestro proyecto y facilitarnos el desarrollo, usaremos **paquetes** para agruparlas según su naturaleza.

### ¿Qué es un paquete?

Un paquete es un subdirectorio dentro del directorio `src` que, además, se identifica en el código mismo mediante la palabra clave `package`, la cual se agrega al comienzo de cada clase contenida dentro de ese paquete.

Esto crea una estructura de clases relacionadas llamada `namespace` (*espacio de nombres*).

Por descarte, NetBeans nos crea un paquete base para nuestras clases con el mismo nombre que nuestro proyecto.

Entre otras ventajas, el uso de paquetes permite, además, usar clases con ***nombres idénticos***, siempre y cuando se ***encuentren en paquetes diferentes***, ya que su ***ruta*** dentro del `namespace` del proyecto será diferente.

### Creación de paquetes

Para crear un paquete y asignarle clases al mismo debemos seguir los siguientes pasos:

1. Crear un subdirectorio dentro de `src` con el nombre de nuestro paquete.
1. Crear archivos de clases dentro de ese directorio.
1. En cada clase que creemos, debemos agregar la palabra clave `package` seguida del nombre del paquete **al comienzo del archivo, antes que cualquier otra línea de código** (*que no sea un comentario*, claro esta).

Los nombres de los paquetes siguen las mismas reglas generales que las que vimos para las clases, pero con algunas diferencias y agregados:

- Son escritos **completamente en minúsculas**, incluso cuando se trata de nombres compuestos por varias palabras. Por ejemplo: `gestiondeusuarios`
- Si hay varios niveles de estructura (o sea, paquetes que contengan paquetes), la misma se debe indicar en el nombre del paquete. Por ejemplo: las clases que esten dentro del paquete `creacion`, dentro del paquete `gestiondeusuarios`, se identifican con el paquete `gestiondeusuarios.creacion`.

Al igual que con las clases, el IDE nos facilita esta tarea mediante un asistente.

En NetBeans, podemos usar el comando `File`>`New File...` para crear paquetes.

Simplemente seleccionamos `Java` en el cuadro `Categories`, y `Java Package` en el cuadro `File Types`, y damos click en `Next`.

![i3]

En la siguiente pantalla ingresaremos el nombre de nuestro paquete en el campo `Package Name`(notemos que nos agrega automáticamente el paquete básico, que podemos editar), cuidando de que se esta creando en el proyecto correcto (se puede comprobar en el campo `Project`). Los demás detalles que se mencionan en el diálogo, por ahora, no los modificaremos.

![i4]

Para terminar, damos click en `Finish`, y el IDE creará nuestro paquete.

[*Volver al Inicio*][inicio]
***

## [Siguiente: Diseño de clases][siguiente]

[inicio]: #estructuras-básicas-dentro-de-un-proyecto-de-java
[siguiente]: diseñoDeClases.md
[l1]:https://docs.google.com/document/d/1ugzyqNtsgjWWQnuIRFpN_YpB_clXWFdvtsTNZmrzVBE/edit?tab=t.0#heading=h.6e9egy8ceiey
[l2]: https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html
[l3]: https://www.aluracursos.com/blog/convenciones-de-nomenclatura-camel-pascal-kebab-snake-case#pascal-case
[i1]: img/netbeans_newFile_1.png
[i2]: img/netbeans_newFile_2.png
[i3]: img/netbeans_newFile_3.png
[i4]: img/netbeans_newFile_4.png
