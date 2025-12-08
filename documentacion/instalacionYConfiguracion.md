# Instalación de Java y Configuración del Entorno de Desarrollo

## Lista de contenido

1. [Instalación del Kit de Desarrollo de Java (JDK)](#instalación-del-kit-de-desarrollo-de-java-jdk)
    1. [En GNU/Linux](#en-gnulinux)
    1. [En Windows](#en-windows)
1. [Instalación del IDE](#instalación-del-ide)
    1. [IDEs Recomendadas](#sub-elemento)
    1. [Instalación de Apache NetBeans]()

***

## Instalación del Kit de Desarrollo de Java (JDK)

Para el desarrollo de aplicaciones ustilizando Java, necesitamos dos componentes:
    - El **Kit de Desarrollo de Java, o *Java Development Kit* (JDK)**, que contiene las librerías, el software auxiliar, y la documentación básicas para permitirnos programar, compilar, y testear aplicaciones usando Java.
    - El **Entorno de Ejecución de Java, o *Java Runtime Environment* (JRE)**, que nos permite ejecutar aplicaciones desarrolladas usando Java.

> **Nota:** Es posible desarrollar una aplicación de Java de tal forma que incluya el JRE, para que el usuario no deba instalarlo por su cuenta, pero no es un tema que trataremos en este curso.

Existen dos fuentes para obtener estos componentes:

- [La fuente "oficial" de Oracle][l1]
- [La fuente "alternativa" de OpenJDK][l2]

En ambos casos, el proceso a seguir varía ligeramente dependiendo de nuestro sistema operativo, pero el resultado final es el mismo.

> **Nota:** Los ejemplos de este repositorio se desarrollaron con las versiones 21 ó 25 de estos componentes.

### En GNU/Linux

En general, la distribución de GNU/Linux que usemos *debería* tener disponible, en sus repositorios oficiales, los paquetes necesarios para instalar tanto el JDK como el JRE, particularmente los correspondientes a OpenJDK.
Para distribuciones que usen `apt` como gestor de paquetes (*Debian*, *Ubuntu*, y *Mint* lo utilizan), esto se puede comprobar ejecutando el siguiente comando en una terminal:

```sh
apt search openjdk
```

> **Nota:** El comando `apt search` no requiere permisos administrativos, o sea, se puede ejecutar sin usar `sudo`

El resultado debería ser parecido al siguiente:

![Resultado de ejecutar apt search openjdk en Linux Mint][i1]

Nosotros necesitamos tres paquetes principales:

- **openjdk-25-jdk**: Instala el JDK
- **openjdk-25-jre**: Instala el JRE
- **openjdk-25-doc**: Instala la documentación de desarrollo de Java (opcional, pero muy recomendable)

El comando para instalar estos paquetes es el siguiente:

```sh
sudo apt install openjdk-25-jdk openjdk-25-jre openjdk-25-doc
```

> **Nota:** Aparte de estos paquetes, se instalarán dependencias de los mismos.

Si la distribución de tu sistema no utiliza `apt`, una rápida búsqueda en Internet te debería permitir encontrar fácilmente los comandos equivalentes para tu caso.

En caso de que no quieras utilizar los paquetes *OpenJDK*, también se puede descargar el instalador correspondiente del [sitio oficial de descargas de *Oracle*][l1], seleccionando *Linux* en el listado de opciones de descarga, y teniendo cuidado de elegir el paquete correspondiente para nuestra distribución.
Una vez descargado, bastará con seguir los pasos del gestor de instalación de paquetes para instalarlo.

### En Windows

Para instalar el JDK en Windows, deberemos descargar los instaladores correspondientes. En general resulta más sencillo utilizar los paquetes de instalación de Oracle, ya que estos establecen toda la configuración necesaria automáticamente, y además instalan el JRE. Para descargarlos se los puede obtener del [sitio oficial de descargas de Oracle][l1], seleccionando *Windows* en el listado de opciones de descarga. Tanto el instalador *EXE* como el *MSI* deberían funcionar sin problemas en una instalación "normal" de Windows.

En caso de **no poder instalar estos paquetes**, existen versiones "*portables*" tanto del JDK como del JRE que pueden ayudar a solucionar este problema.

[*Volver al Inicio*][inicio]
***

## Instalación del IDE

Un **IDE** o **Entorno Integrado de Desarrollo**, es un conjunto de aplicaciones diseñadas para facilitar la tarea de desarrollar software.
Suelen incluír:

- Un editor de texto con resaltado de sintaxis y detección de errores
- Herramientas para crear y administrar proyectos
- Herramientas para probar el software desarrollado y detectar errores durante su ejecución.

En el contexto de esta documentación, se utilizará **Apache NetBeans** en una versión reciente. Sin perjuicio de esto, es perfectamente viable utilizar otros entornos de desarrollo como ser:

- Visual Studio Code
- IntelliJ Idea
- Eclipse IDE for Java

No cubriremos el proceso de instalación y configuración de estos IDE's en esta documentación, y lo dejamos a criterio del lector, ya que es muy fácil encontrar guías al respecto en la web.

### Descarga de Apache NetBeans

Para descargar este IDE, nos dirigiremos a la [página oficial de descargas del mismo][l3]. Hay varias opciones disponibles:

- **Paquete comprimido en ZIP:** esta opción es la más "portable". No requiere instalación, y debería funcionar en cualquier sistema que tenga JRE y JDK instalados. Simplemente se descomprime el paquete, y se busca el directorio `bin` dentro del directorio `netbeans` que extrajimos. Dentro encontraremos tres archivos ejecutables:

  - `netbeans`: un shell script ejecutable que usaremos para iniciar el IDE en GNU/Linux
        > **Nota:** chequear que esté habilitado el bit de ejecución en el archivo
  - `netbeans.exe`: un ejecutable para para iniciar el IDE en sistemas Windows de 32 bits
  - `netbeans64.exe`: un ejecutable para iniciar el IDE en sistemas Windows de 64 bits.

Para abrir NetBeans, usaremos el ejecutable que corresponda a nuestro sistema operativo.

- **Instalador específico:** esta opción puede resultar más cómoda en un sistema propio. Para obtenerla vamos a la sección [*Installers and Packages*][l4], y allí vamos al sitio de [*Codelerity*][l5], donde podremos descargar el instalador adecuado para nuestro sistema operativo.

Una vez culminada la instalación deberíamos poder iniciar el IDE desde el menú de nuestro sistema operativo.

### Configuración y Activación de NetBeans

Para usarse para desarrollar aplicaciones con Java, NetBeans debe activar las funcionalidades adecuadas.

Inicialmente veremos una ventana semejante a la siguiente:

![i2]

Para activar las funcionalidades de desarrollo con Java, iremos al menú `Tools` > `Options`. Esto abrirá un cuadro de opciones como el siguiente:

![i3]

En el mismo eligiremos la opción **Java** (con el ícono de la taza de café), que aparece desactivada. Al hacerlo, se iniciará un proceso de activación con una barra de progreso, durante el cual NetBeans debería detectar el JRE y el JDK instalados en nuestro sistema. Una vez terminado el proceso, veremos que la ventana principal se habrá modificado, mostrando nuevas herramientas:

![i4]

  >**Nota:** Es recomendable revisar las opciones de apariencia y visualización disponibles en las secciones `Fonts and Colors` (aparece luego de activar la funcionalidad básica) y `Appearence`.

Ahora podemos cerrar el cuadro de opciones, y comenzar a trabajar con Java.

[*Volver al Inicio*][inicio]
***

## [Siguiente: Creación de un proyecto nuevo de Java][siguiente]

[inicio]: #instalación-de-java-y-configuración-del-entorno-de-desarrollo
[siguiente]: crearProyectoNuevo.md
[l1]: https://www.oracle.com/java/technologies/downloads/
[l2]: https://openjdk.org/
[l3]: https://netbeans.apache.org/front/main/download/nb28/
[l4]: https://netbeans.apache.org/front/main/download/nb28/#_installers_and_packages
[l5]: https://www.codelerity.com/netbeans/
[i1]: img/apt_search_openjdk.png
[i2]: img/netbeans_inicio.png
[i3]: img/netbeans_options.png
[i4]: img/netbeans_activado.png