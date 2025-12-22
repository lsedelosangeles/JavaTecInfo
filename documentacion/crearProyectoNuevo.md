# Creación de un proyecto nuevo de Java

## Lista de contenido

1. [Organización del código en un proyecto de Java](#organización-del-código-en-un-proyecto-de-java)
1. [Iniciando un nuevo proyecto](#iniciando-un-nuevo-proyecto)

***

## Organización del código en un proyecto de Java

Para desarrollar en Java, el código debe organizarse en una estructura de directorios llamada **Proyecto**, que contiene nuestro código fuente, librerías, y configuraciones de ejecución y compilación requeridas por el mismo.

Esta estructura, en general, tiene la siguiente forma:

![i1]

- `Proyecto` es el directorio principal donde esta contenido todo el código y configuración de nuestro trabajo. Tendrá el mismo nombre que indiquemos al crear el proyecto con el IDE.
- `src` es donde encontraremos los archivos de nuestro código fuente propiamente dichos, por lo general organizados en **paquetes**.
- `lib` contiene las librerías extras que agreguemos a nuestro proyecto.

Dependiendo del gestor de proyectos que usemos, esta estructura puede variar un poco y contener otros directorios.
***

## Iniciando un nuevo proyecto

Para crear un nuevo proyecto con NetBeans, usaremos el comando `File`>`New Project...`...

![i2]

...O el botón `New Project...` de la barra de herramientas (su ícono es una caja naranja con un símbolo de "+")

![i3]

Al abrirse la ventana de diálogo `New Project`, en el cuadro `Categories` elegimos `Java with Ant`, y en el cuadro `Projects` elegimos `Java Application`. Una vez hecho esto damos click en `Next`.

![i4]

> **Nota:** `Ant` es un gestor de proyectos de Java. En este curso lo usaremos bastante, ya que resulta muy versátil. Más adelante usaremos otros como ser `Maven` o `Gradle`, que, además, cuentan con un sistema de repositorio de librerías.

Luego veremos la ventana de diálogo `New Java Application`, donde agregaremos el nombre de nuestro proyecto en el campo `Project Name`.

![i5]

En general, se recomienda que el nombre del proyecto tenga las siguientes características:

- Comience por una letra mayúscula.
- **No contenga**:
  - espacios
  - caracteres con tilde o la letra `Ñ`
  - caracteres especiales como ser `@`, `#`, `*`, etc.

En el campo `Project Location`, se indica la ruta donde queremos que se cree nuestro proyecto, y el campo `Project Folder`, nos indica el directorio donde se almacenará.

De momento, no es necesario modificar ninguna otra opción, por lo que podemos dar click en el botón `Finish` para que comience a crearse nuestro proyecto.

Al terminar este proceso, se habrá creado esta estructura de directorios:

![i6]

Por descarte, se abrirá el archivo principal de nuestro proyecto (*que por lo general lleva el mismo nombre que nuestro proyecto*).

![i7]

>**Nota:** Esto puede modificarse más adelante, como veremos, en la configuración del proyecto.

Todo el manejo de contenido de nuestro proyecto lo realizaremos desde la pestaña `Projects` del navegador lateral, como iremos viendo.

![i8]

[*Volver al Inicio*][inicio]
***

## [Siguiente: Estructuras Básicas de Java][siguiente]

[inicio]: #creación-de-un-proyecto-nuevo-de-java
[siguiente]: estructurasBasicasDeJava.md
[i1]: img/java_proyecto_estructura.drawio.png
[i2]: img/netbeans_file_newProject.png
[i3]: img/netbeans_boton_newProject.png
[i4]: img/netbeans_newProject_1.png
[i5]: img/netbeans_newProject_2.png
[i6]: img/netbeans_estructura_proyecto.png
[i7]: img/netbeans_proyecto_creado_1.png
[i8]: img/netbeans_projects_tab.png
