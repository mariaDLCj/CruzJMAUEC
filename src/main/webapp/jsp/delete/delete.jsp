<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
        <c:import url="/INC/meta.inc"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.bootstrap}"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}"/>
    </head>

    <body>
        <!-- Cabecera con el menú de navegación  -->
        <c:import url="/INC/cabecera.jsp"/>
        <h2 class="text-center mb-4">Eliminar Profesor</h2>
        <div class="container mt-5">
            <form action="${applicationScope.contexto}/Delete" method="post">

                <table class="table table-bordered table-striped">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Tipo</th>
                            <th>Nombre</th>
                            <th>Primer Apellido</th>
                            <th>Segundo Apellido</th>
                            <th>Fecha</th>
                            <th>Escala</th>
                            <th>Borrar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="profesor" items="${requestScope.lista}" varStatus="i">
                            <!-- Más información sobre el foreach 
                            https://stackoverflow.com/questions/2017753/jstl-iterate-list-but-treat-first-element-differently
                            -->
                            <tr>
                                <td>${profesor.codigo.id}</td>
                                <td>${profesor.codigo.tipo}</td>
                                <td>${profesor.nombre}</td>
                                <td>${profesor.apellido1}</td>
                                <td>${profesor.apellido2}</td>
                                <td>${profesor.fechaFormateada}</td>
                                <td>${profesor.escala}</td>
                                <td><input type="radio" name="idProfesor" value="${profesor.codigo.id}_${profesor.codigo.tipo}" class="form-check-input"  
                                           <c:if test="${i.first}">checked</c:if> /></td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="d-flex justify-content-center gap-2">
                    <input type="submit" name="eliminar" value="Eliminar" class="btn btn-danger">
                    <input type="submit" name="cancelar" value="Cancelar" class="btn btn-danger">
                </div>
            </form>
        </div>
    </body>
</html>
