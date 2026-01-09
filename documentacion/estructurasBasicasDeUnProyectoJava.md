# Estructuras Básicas dentro de un Proyecto de Java

## Lista de contenido

1. [Clases](#clases)
1. [Paquetes](#paquetes)

***

## Clases

Las clases son la estructura básica de todo proyecto de Java.

Todo nuestro código estará organizado en un conjunto de clases, a partir de las cuales declararemos, a su vez, objetos. La interacción de estos objetos determinará el funcionamiento de nuestra aplicación.

>**Nota:** Para profundizar en las características generales de clases y objetos, se recomienda leer, en la documentación complementaria, el capítulo [**"¿Qué es un objeto?"**][l1] y los que le siguen, donde se describe en más detalle estos conceptos.

Para agregarle una clase nueva a nuestro proyecto, simplemente crearemos un archivo de texto plano, pero con extensión `.java` en nuestro directorio `src`.

Nuestro IDE nos facilita el trabajo de agregarle el código inicial básico mediante el uso de asistentes de creación.

En NetBeans, para crear una clase, utilizaremos el comando `File`>`New File...` para abrir el asistente de creación de archivos nuevos.

En el cuadro `Categories` elegiremos `Java`, y en el cuadro `File Types` elegiremos `Java Class`. Luego damos click en el botón `Next`.

![i1]

En la siguiente pantalla ingresaremos el nombre de nuestra clase en el campo `Class Name`, cuidando de que se esta creando en el proyecto correcto (se puede comprobar en el campo `Project`). Los demás detalles que se mencionan en el diálogo, por ahora, no los modificaremos.

![i2]

Por [convención][l2], los nombres de las clases en Java deben seguir estas reglas:

- Se debe procurar que sean simples y descriptivos.
- Deben iniciar en una letra mayúscula, por ejemplo: `Usuario`.
- Deben ser sustantivos (o sea, un nombre de una entidad, cosa, lugar, etc). por ejemplo: `Usuario`, `Sesion`, `Producto`.
- Si necesitan estar formados por más de una palabra, cada palabra irá con su primer letra en mayúscula (lo que suele llamarse [*Pascal Case*][l3]), por ejemplo: `UsuarioRegistrado`, `MenuPrincipal`.
- **No pueden contener** espacios, guiones, símbolos o caracteres especiales.

Para terminar, damos click en `Finish`, y el IDE creará nuestra clase con el código básico para comenzar a desarrollar en la misma.

[*Volver al Inicio*][inicio]
***

## Paquetes

Si nuestro proyecto resulta medianamente complejo, seguramente contendrá muchas clases, lo que puede dificultar el manejo del código. Para organizar las clases de nuestro proyecto y facilitarnos el desarrollo, usaremos **pauetes** para agruparlas según su naturaleza.

[*Volver al Inicio*][inicio]
***

## [Siguiente: Estructuras Básicas dentro de un Proyecto de Java][siguiente]

[inicio]: #estructuras-básicas-dentro-de-un-proyecto-de-java
[l1]:https://docs.google.com/document/d/1ugzyqNtsgjWWQnuIRFpN_YpB_clXWFdvtsTNZmrzVBE/edit?tab=t.0#heading=h.6e9egy8ceiey
[l2]: https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html
[l3]: https://www.aluracursos.com/blog/convenciones-de-nomenclatura-camel-pascal-kebab-snake-case#pascal-case
[i1]: img/netbeans_newFile_1.png
[i2]: img/netbeans_newFile_2.png