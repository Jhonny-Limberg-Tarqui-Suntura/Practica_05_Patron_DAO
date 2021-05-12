<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>     
        <h1>Inicio de Sesion</h1>
        <form action="Inicio" method="post">
            <p>Usuario: </p>
            <input type="text" name="usuario" required>
            <p>Password: </p>
            <input type="password" name="password" required>
            <br><br>
            <input type="submit" value="Ingresar">
        </form>
    </body>
</html>