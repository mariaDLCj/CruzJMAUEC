<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <c:import url="/INC/meta.inc"/>
        <c:set var="contexto" value="${pageContext.request.contextPath}" scope="application"/>
        <c:url var="estilo" value="/CSS/styles.css" scope="application"/>
        <c:url var="bootstrap" value="/CSS/bootstrap.css" scope="application"/>
        <title>CRUD</title>
        <c:import url="/INC/meta.inc"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.bootstrap}"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}"/>
    </head>

    <body>
        <!-- Cabecera con el menú de navegación  -->
        <c:import url="/INC/cabecera.jsp"/>

        <!-- Encabezado -->
        <header class="py-5 text-center">
            <div class="containern ">
                <h1 class="display-4">Operaciones <span class="highlight">CRUD</span></h1>
                <p class="lead">Esta página realiza operaciones CRUD con Hibernate</p>
                <br>
                <c:if test="${requestScope.lista == null}">
                    <div class="bg-danger text-center rounded m-5">
                        <p class="text-white">${requestScope.sms}</p>
                    </div>
                </c:if>
            </div>
        </header>

        <!-- Tarjetas -->
        <section class="py-5">
            <div class="container">
                <div class="row text-center">
                    <p>${requestScope.FECHA}</p>
                    <div class="col-md-3">
                        <div class="card p-4 mb-4">
                            <h5 class="card-title highlight">Create</h5>
                            <p class="card-text">Añade información de la base de datos</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card p-4 mb-4">
                            <h5 class="card-title highlight">Read</h5>
                            <p class="card-text">Visualiza información de la base de datos</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card p-4 mb-4">
                            <h5 class="card-title highlight">Update</h5>
                            <p class="card-text">Actualiza la información de la base de datos</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card p-4 mb-4">
                            <h5 class="card-title highlight">Delete</h5>
                            <p class="card-text">Elimina información de la base de datos</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <c:import url="/INC/pie.jsp"/>

    </body>

</html>