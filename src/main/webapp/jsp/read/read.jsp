<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read</title>
        <c:import url="/INC/meta.inc"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.bootstrap}"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}"/>
    </head>

    <body>
        <!-- Cabecera con el menú de navegación  -->
        <c:import url="/INC/cabecera.jsp"/>
        <div class="container mt-5">
            <h2 class="text-center mb-4">Lista de Profesores</h2>

            <div class="card p-3 shadow-sm">
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
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="profesor" items="${requestScope.lista}">
                            <tr>
                                <td>${profesor.codigo.id}</td>
                                <td>${profesor.codigo.tipo}</td>
                                <td>${profesor.nombre}</td>
                                <td>${profesor.apellido1}</td>
                                <td>${profesor.apellido2}</td>
                                <td>${profesor.fechaFormateada}</td>
                                <td>${profesor.escala}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
