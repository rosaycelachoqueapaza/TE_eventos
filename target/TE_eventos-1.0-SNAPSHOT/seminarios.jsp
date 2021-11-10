<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table align = "center" border="1">
            <td>
                <h1> SEGUNDO PARCIAL TEM-742 </h1>
                <h3> Nombre: Rosaycela Danitza Choque Apaza </h3>
                <h3> Carnet: 8415572 LP</h3>
            </td>
        </table>
        <h1 style="color:red" align = "center" >Registro de Seminarios</h1>
        <p><a href="SeminariosControlador?action=add" >Nuevo</a></p>
        <table align = "center" border="1">
            <thead style="color:blueviolet">
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Expositor</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Cupo</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach var="item" items="${seminarios}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.expositor}</td>
                    <td>${item.fecha}</td>
                    <td>${item.hora}</td>
                    <td>${item.cupo}</td>
                    <td><a href="SeminariosControlador?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="SeminariosControlador?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro???'))">Eliminar</a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
