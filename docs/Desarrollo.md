# Desarrollo

Este documento presenta una guía para los desarrolladores del proyecto.

## Configuración del ambiente

Existen distintas maneras de configurar el ambiente de desarrollo:

- [Nativo](./Nativo.md)
- [Docker](./Docker.md)

## Diagramas

[Plantuml](https://plantuml.com/) soporta un mecanísmo que facilita la generación y posterior mantenimiento de los diagramas de clase, secuencia, estado y paquetes. Para mayor información referir a la [guía de PlantUML](./PlantUML.md).

## Empaquetado

Cuando se genera un **tag** que comienza con `v` (ejemplo `v0.0.1`) automáticamente se produce un [release](https://github.com/fiuba/algo3_proyecto_base_tp2/releases) con la aplicación empaquetada. Para el nombre de la versión se recomienda utilizar [versionado semántico](https://semver.org/lang/es/), por ejemplo:

```bash
$ git tag v0.0.1   # Genera el tag sobre el commit actual
$ git push --tags  # Pushea el tag al repo, iniciando el release automático
```

Para más información sobre cómo generar tags ver la [documentación de git](https://git-scm.com/book/es/v2/Fundamentos-de-Git-Etiquetado).

## Distribución

El archivo `.jar` generado en el release contiene la aplicación empaquetada y puede distribuirse. Luego puede ejecutarse en Windows, Mac o Linux con:

```bash
$ java -jar <archivo.jar>
```

