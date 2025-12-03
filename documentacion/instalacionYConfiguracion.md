# Instalación de Java y Configuración del Entorno de Desarrollo

## Lista de contenido

1. [Instalación del Kit de Desarrollo de Java (JDK)](#instalación-del-kit-de-desarrollo-de-java-jdk)
    1. [En GNU/Linux](#en-gnulinux)
    1. [En Windows]()
1. [Instalación del IDE](#elemento-2)
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

### En GNU/Linux

En general, la distribución de GNU/Linux que usemos *debería* tener disponible, en sus repositorios oficiales, los paquetes necesarios para instalar tanto el JDK como el JRE, particularmente los correspondientes a OpenJDK.
Para distribuciones que usen `apt` como gestor de paquetes, esto se puede comprobar ejecutando el siguiente comando en una terminal:

```sh
apt search openjdk
```

> **Nota:** El comando `apt search` no requiere permisos administrativos, o sea, se puede ejecutar sin usar `sudo`

El resultado debería ser parecido al siguiente:

![Resultado de ejecutar apt search openjdk en Linux Mint][i1]


Contenido del elemento 1

Esto es un `detalle de código`

```lang
Esto es un bloque de código
```

[_Volver al Inicio_][inicio]
***

## Elemento 2

Contenido del elemento 2

> **Nota: _Esto es una nota informativa_**

### Sub Elemento

Contenido del sub elemento.

[_Volver al Inicio_][inicio]
***

## [Siguiente Documento: ...][siguiente]

[inicio]: #instalación-de-java-y-configuración-del-entorno-de-desarrollo
[siguiente]: siguienteDoc.md
[l1]: https://www.oracle.com/java/technologies/downloads/
[l2]: https://openjdk.org/
[i1]: img/apt_search_openjdk.png