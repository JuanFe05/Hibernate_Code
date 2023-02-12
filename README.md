## JPA (Java Persistence API)

Es una **API** de persistencia de datos para **Java** que proporciona un marco de trabajo para la gestión de **entidades** y la persistencia de datos en una base de datos relacional. **JPA** facilita la integración de aplicaciones **Java** con una base de datos, proporcionando una forma estándar de acceder, actualizar y persistir datos en la base de datos. **JPA** es un estándar de persistencia de Java y es compatible con varios proveedores de implementación, como Hibernate, EclipseLink, etc.

## Hibernate

**Hibernate** es un **framework** de **persistencia de objetos relacionales (ORM)** para Java. **ORM** es una técnica que permite a los desarrolladores trabajar con objetos en lugar de tablas de bases de datos directamente. **Hibernate** se encarga de realizar las operaciones de persistencia (como insertar, actualizar, eliminar y recuperar datos) en la base de datos de manera transparente para el programador. **Hibernate** utiliza un **mapeo objeto-relacional** que convierte objetos en registros y viceversa, lo que permite una integración sencilla entre la aplicación y la base de datos. Además, **Hibernate** es compatible con varios sistemas de gestión de bases de datos, incluyendo **MySQL**, **Oracle**, **Microsoft SQL Server**, **PostgreSQL**, entre otros.

## Arquitectura en Capas

La arquitectura en capas consta en dividir la aplicación en capas, con la intención de que cada capa tenga un rol muy definido, como podría ser, una capa de presentación **(UI)**, una capa de reglas de negocio **(servicios)** y una capa de acceso a datos **(DAO)**, sin embargo, este estilo arquitectónico no define cuantas capas debe de tener la aplicación, sino más bien, se centra en la separación de la aplicación en capas.

En la práctica, la mayoría de las veces este estilo arquitectónico es implementado en 4 capas, **presentación**, **negocio**, **persistencia** y **base de datos**, sin embargo, es habitual ver que la capa de negocio y persistencia se combinan en una solo capa, sobre todo cuando la lógica de persistencia está incrustada dentro de la capa de negocio.

<div align="center">
<img src="https://user-images.githubusercontent.com/40324908/217148765-48099e65-a68b-45a4-ba36-47739355574e.png" alt="capas">
</div>

## Data Access Object (DAO)

El objetivo principal de **DAO** es aislar la lógica de acceso a datos de la lógica de negocios de la aplicación, permitiendo que la lógica de negocios se concentre en las tareas relacionadas con el negocio y la lógica de acceso a datos se encargue de las tareas relacionadas con la persistencia de datos.

**DAO** es una clase que se encarga de realizar operaciones **CRUD (Create, Read, Update, Delete)** en una base de datos y proporciona una interfaz para acceder a los datos de una manera abstracción y separada de la implementación específica de la base de datos. Esto permite a los desarrolladores cambiar la implementación de la base de datos sin afectar la lógica de negocios de la aplicación.

El patrón **DAO** es muy útil para mejorar la escalabilidad, la mantenibilidad y la flexibilidad de una aplicación y puede ser una parte integral de la arquitectura en capas.

## Archivo de Persistencia

El archivo de persistencia es un archivo de configuración en Java que se utiliza en aplicaciones con frameworks de persistencia como **Hibernate**. Este archivo contiene información importante sobre la configuración de la persistencia de datos, como el nombre de la unidad de persistencia, la clase de proveedor de persistencia, las clases de entidades que se deben mapear a la base de datos, las propiedades de conexión a la base de datos, entre otros.

El archivo de persistencia típicamente se llama **"persistence.xml"** o **"hibernate.cfg.xml"** y se encuentra en el directorio "META-INF" dentro del paquete de la aplicación. La información especificada en este archivo se utiliza por el **framework** de persistencia para realizar las operaciones de persistencia en la base de datos de manera transparente para el programador.

### Persistence.xml (JavaEE 8)

### Persistence.xml (JakartaEE 9)

### hibernate.cfg.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>
    <!-- Database connection settings -->
    <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
    <property name="connection.url">jdbc:mysql://localhost:3306/testdb</property>
    <property name="connection.username">root</property>
    <property name="connection.password">password</property>

    <!-- Hibernate properties -->
    <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
    <property name="hbm2ddl.auto">update</property>
    <property name="show_sql">true</property>
    <property name="format_sql">true</property>
    <property name="use_sql_comments">true</property>

    <!-- Mapping classes -->
    <mapping class="com.example.Entity"/>
    <mapping class="com.example.AnotherEntity"/>
  </session-factory>
</hibernate-configuration>
  ```
