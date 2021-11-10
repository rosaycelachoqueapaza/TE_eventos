<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${seminario.id == 0}">Nuevo </c:if>
            <c:if test="${seminario.id != 0}">Editar </c:if>
                Seminario
            </h1>
            <form action="SeminariosControlador" method="post">
                <input type="hidden" name="id" value="${seminario.id}" />
            <table>
                <tr>
                    <td>Titulo:</td>
                    <td><input type="text" name="titulo" value="${seminario.titulo}" /></td>
                </tr>
                <tr>
                    <td>Expositor:</td>
                    <td><input type="text" name="expositor" value="${seminario.expositor}" /></td>
                </tr>
                <tr>
                    <td>Fecha:</td>
                    <td> <input type="date" name="fecha" value="${seminario.fecha}" /></td>
                </tr>
                <tr>
                    <td>Hora:</td>
                    <td> <input type="text" name="hora" value="${seminario.hora}" /></td>
                </tr>
                <tr>
                    <td>Cupo:</td>
                    <td> <input type="number" name="cupo" value="${seminario.cupo}" /></td>
                </tr>
            </table>
                <input type="submit" value="Enviar" />
        </form>
    </body>
</html>