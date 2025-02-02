
# Proyecto CRUD - Gestión de Profesores

Este es un proyecto realizado en Java utilizando **NetBeans** y **Maven**, consiste en un **CRUD** 
de operaciones sobre una entidad llamada **Profesor**. Se utiliza **Hibernate** con **anotaciones** para mapear las entidades y 
gestionar la persistencia de los datos.

# Descripción del Proyecto

Esta aplicación realiza la gestión de la entidad `Profesor` que tiene una clave compuesta, `codigo`, que está compuesto por un `id` int y 
un `tipo` String. 

### Funcionalidades Implementadas:

1. **Create**: Agregar nuevos profesores a la base de datos y comprobar que no haya campos obligatorios vacíos.
2. **Read**: Consultar la información de los profesores ya existentes.
3. **Update**: Modificar los datos de un profesor evitando que los campos obligatorios se queden vacíos.
4. **Delete**: Eliminar un profesor
