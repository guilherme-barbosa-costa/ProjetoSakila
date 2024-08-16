<%-- 
    Document   : cadastar-filme
    Created on : 13/08/2024, 17:12:01
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            .form-container {
                width: 80%;
                margin: 0 auto;
            }
            .btn1{
                display: flex;
                justify-content: center;
                }
                .btn-secondary{
                    background: red;
                }
        </style>
    </head>
    <body>
        <h1 align="center">Cadastrar Filme</h1>
        <form action="./cadastrar" class="form-container" method="post">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" name="titulo" placeholder="Titulo">
                <label for="floatingInput">Titulo</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" name="desc" placeholder="Descrição">
                <label for="floatingInput">Descrição</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" id="floatingInput" name="ano" placeholder="Ano">
                <label for="floatingInput">Ano</label>
            </div>
            <div class="form-floating mb-3 btn1">
                <button class="btn btn-secondary" type="submit">Cadastrar</button>
            </div>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
