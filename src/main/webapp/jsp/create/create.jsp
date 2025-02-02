<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <c:import url="/INC/meta.inc"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.bootstrap}"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}"/>
    </head>

    <body>
        <!-- Cabecera con el menú de navegación  -->
        <c:import url="/INC/cabecera.jsp"/>
        <section class="py-5">
            <div class="container">
                <h2 class="text-center highlight mb-4">Registro Nuevo Profesor</h2>
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <form action="${applicationScope.contexto}/Create" method="post">

                            <div class="mb-3">
                                <label class="form-label">ID</label>
                                <input type="number" class="form-control" id="id" name="id" placeholder="Ingresa el ID">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Tipo</label>
                                <input type="text" class="form-control" id="tipo" name="tipo" placeholder="Ingresa el tipo">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">*Nombre</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingresa tu nombre completo">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">*Primer Apellido</label>
                                <input type="text" class="form-control" id="apellido1" name="apellido1" placeholder="Ingresa tu primer apellido">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Segundo Apellido (Opcional) </label>
                                <input type="text" class="form-control" id="apellido2" name="apellido2" placeholder="Ingresa tu segundo apellido">
                            </div>
                            <p class="p text-white">${requestScope.smsOcupado}</p>
                            <p class="p text-white">${requestScope.smsVacio}</p>
                            <div class="d-flex justify-content-center gap-2">
                                <input type="submit" class="btn btn-highlight w-100" name="registrarse" value="Registrarse" />
                                <input type="submit" class="btn btn-highlight w-100" value="Cancelar" name="cancelar" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
