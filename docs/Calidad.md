# Calidad

Este documento presenta una guía con las prácticas de calidad implementadas en este proyecto. proyecto.

## Arquitectura

Al ejecutar el conjunto de pruebas provistas en la clase `ModelDependenciesTest` se verificarán de manera estática las siguientes reglas de dependencias:

![paquete_modelo dependencias](../diagrams/packages/paquete_modelo_dependencias.png).

Las pruebas ejecutadas verifican que el paquete `edu.fiuba.algo3.modelo` solo dependa de paquetes "conocidos" a saber:

- Todo el SDK de *java*
- Todo el SDK de *JUnit 4* y/o *JUnit 5*

## Seguridad

Al pushear el código al repositorio este es analizado con [CodeQL](https://codeql.github.com/docs/). Si se encuentra algún error o vulnerabilidad se mostrará en la pestaña Security -> [Code scanning alerts](https://github.com/fiuba/algo3_proyecto_base_tp2/security/code-scanning). Luego de que dicho error sea arreglado la alerta se resuelve de forma automática, para más información consultar la [documentación de github](https://docs.github.com/en/code-security/secure-coding/automatically-scanning-your-code-for-vulnerabilities-and-errors).

