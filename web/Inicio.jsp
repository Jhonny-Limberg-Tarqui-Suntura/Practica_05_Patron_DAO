<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <h4 align="right">${usu.usuario}       <a href="Inicio">Salir</a></h4>
        <h1 align="center">BLOG DE TECNOLOGIA</h1>
        <br>
        <p><a href="Controlador?action=add">Nueva Entrada</a></p>
        <br>
        <c:forEach var="item" items="${post}">
            <p>${item.fecha}</p>
            <p><h3>${item.titulo}</h3></p>
            <p>${item.contenido}</p>
            <table align="right">
                <tr>
                    <th><a href="Controlador?action=edit&id=${item.id}">Editar</a></th>
                    <th><a href="Controlador?action=delete&id=${item.id}">Eliminar</a></th>
                </tr>
            </table>
                <br>
                <br>
            <hr>
            <br>
        </c:forEach>
    </body>
</html>