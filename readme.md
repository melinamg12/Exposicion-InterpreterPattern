
# Interpreter Pattern

El patrón intérprete es un patrón de diseño que especifica cómo evaluar sentencias en un lenguaje. La idea es utilizar herramientas de Programación Orientada a Objetos donde cada símbolo del lenguaje es implementado como una clase especializada en evaluar las sentencias definidas por el cliente.

Este patrón define la gramática de un lenguaje particular.


## ¿Qué problemas soluciona?

Cuando se necesita definir reglas gramaticales para interpretar expresiones de un lenguaje simple.

Este tipo de problema es muy común: existen muchas expresiones de búsqueda o son muy diferentes entre sí. Aplicar cada una a una clase es poco práctico porque hace difícil cambiar o agregar expresiones nuevas

## ¿Cómo se implementa?
 **![](https://lh4.googleusercontent.com/rXBO5W7NAweazwRkArgLmArkGrs0ok-WrLpDfxujbwHWgusE2re0ZyHzTq01xoVBJhDhPwvCJ8fOHsecdV8MLcHo6hmQC2j3EqRn68Gv6xk5397PRaNN5YXXxjSxto5xaqlSSTdg)**

- **AbstractExpression:** Es una clase abstracta que define un método interpret(context) que recibe el contexto como parámetro. Gracias a esto, cada expresión va a poder devolver el resultado por sí misma o cambiar el estado del contexto y continuar con la interpretación.
- **TerminalExpression:** Es una clase hoja que implementa el método interpret(). El proceso de interpretación debe terminar con una expresión terminal que devuelve un valor. 
- **NonTerminalExpression:** Es una clase que interpreta el metodo interpret(). El proceso de interpretación deberá llamar desde una clase no terminal a una clase terminal para poder finalizar.
- **Context(String):** Contiene información global para el intérprete. El string es el que debe ser interpretado por el programa.
- **Client():** Invoca el método Interpret()
 
**![](https://lh6.googleusercontent.com/6-hj2pxdbVBtqaaFFn9H56w8-GrB3Kv88WUf64VW9evtmuNCukGWSAZOI2RSrOdwMOFe3P3JMsho78soED2Latcx6CKNCzkvdBUJ-ebMgwrUIV-F40nGmy2oIyiLeh0KOCHwVc1M)**
## Ventajas

 - Es fácil cambiar o extender las reglas gramaticales. Como el patrón usa clases para representar las reglas, es fácil cambiarlas o extenderlas usando herencia. 
 - La implementación es sencilla. En general, las reglas tienen implementaciones similares y fáciles de escribir. 

## Desventajas

 - Las estructuras gramaticales complejas son difíciles de mantener. Como el patrón define al menos una clase por cada regla, tener muchas puede volverse difícil de manejar.

## ¿Quién lo usa?

 - Lenguajes de Bases de Datos especializadas tales como SQL
 - Lenguajes computacionales que describen protocolos de comunicación
 - La mayoría de lenguajes multipropósito incorporan varios lenguajes especializados.

