# Test02 - REST API

## Ejecutar Aplicacion

Para ejecutar directamente la aplicacion con maven usa el siguiente comando

```shell
mvn spring-boot:run
```

Para crear un arhicvo ejecutable **jar** usa el siguiente comando:

```shell
mvn package
```

Para ejecutar el archivo **jar** creado anteriormente usa el siguiente comando:

```shell
java -jar target/{nombre-jar-creado}
```

reemplazando el nombre por el archivo jar creado anteriormente

> Warning: esta aplicacion se contruyo con una database mongodb alojada en mongodb atlas, debes 
> configurarla antes de iniciar la aplicacion