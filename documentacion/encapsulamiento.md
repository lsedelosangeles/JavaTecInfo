# Java: Encapsulamiento

## Lista de contenido

1. [Diagramas de Clases](#diagramas-de-clases)

***

## Concepto General

Llamamos *encapsulamiento* a un mecanismo en POO mediante el cual definimos métodos públicos para acceder o modificar, de forma "segura" los valores contenidos dentro de atributos privados.

>**Nota: Por *"seguro"*, en este caso, nos referimos a "seguro dentro de los parámetros aceptables en el contexto de la aplicación", o sea, que y no a "seguro según los parámetros aceptables según la ciberseguridad"**

El encapsulamiento permite resolver dos problemas:

- Cómo acceder a los contenido dentro de un atributo privado desde fuera del contexto del objeto.
- Cómo establecer reglas que permitan modificar dicho contenido de forma adecuada.

## Aplicación: Getters y Setters

Para lograr esto, estableceremos métodos públicos conocidos como **getters** y **setters**. En inglés, *getter* significa "que consigue (algo)", y *setter* siginifica "que establece o determina (algo)". Así que un método *getter* accede a datos, y un método *setter* establece su valor.
Ahora bien, estos métodos deben contener, en su algoritmo, un determinado protocolo para que el uso de accesibilidad privada en el atributo sea justificada, de lo contrario en realidad tendremos un atributo público, pero con más pasos.

Para profundizar en este concepto, supongamos la siguiente clase:

```java
public class Persona{
    private String nombre;
}
```

### Getters

Los getters son métodos públicos que permiten obtener la información de atributos, pero un getter para un atributo público no tiene mucho sentido (a no ser que hablemos de un método que actúe como conversor, por ejemplo), y en el caso de un 
