# Diseño de Diagramas de Clases

## Lista de contenido

1. [Diagramas de Clases](#diagramas-de-clases)

***

## Diagramas de Clases

Para desarrolar correctamente una aplicación en Java (o en cualquier lenguaje siguiendo un paradigma orientado a objetos) es necesario que, **previamente a programar**, hagamos un análisis que detalle con claridad:

- Las clases que harán parte de nuestro proyecto
- Las características de dichas clases
- La forma en que dichas clases interactúan

El resultado de este análisis se detalla en un **Diagrama de Clases**, que se diseña utilizando un lenguaje gráfico llamado **UML** (*Unified Modeling Languaje* o *Lenguaje Unificado de Modelado*), el cual permite visualizar, con relativa facilidad, las características que mencionamos antes.

>**Nota:** Se puede diseñar diagramas de clase con *cualquier software de diseño* que maneje formas básicas, como ser [**Inkscape**][l1], [**draw.io**][l2], [**Dia**][l3], etc.

***

En esta documentación utilizaremos una herramienta llamada [**PlantUML**][l4], que permite el desarrollo de estos diagramas a partir de archivos de texto con una sintaxis sencilla y clara, que puede interpretarse al leerse directamente, o, al ser procesados por el software, un diagrama en un archivo de imágen.

## Desarrollo de un Diagrama de Clases: El Análisis de Realidad

Para comenzar, debemos considerar el **contexto** en el cual existen los elementos que **aportan información relevante** al propósito de la aplicación que queremos desarrollar.

Por ejemplo, si vamos a desarrollar una aplicación para una biblioteca, por ejemplo, tendremos que considerar:

- Los libros de la biblioteca
- Los usuarios de la biblioteca
- Los encargados de la biblioteca

[l1]:https://inkscape.app/es/
[l2]:https://www.drawio.com/
[l3]:http://dia-installer.de/index.html.en
[l4]:https://plantuml.com/es/