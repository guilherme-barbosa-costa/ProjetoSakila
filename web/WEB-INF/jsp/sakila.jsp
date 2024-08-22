<%-- 
    Document   : sakila
    Created on : 13/08/2024, 15:17:03
    Author     : Senai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="./styles/edicao.css">
        <title>Página Inicial</title>
    </head>
    <body class="bodysakila">
        <a class="inpcad" href="./cadastrar">Cadastrar Filme</a>
        <h1>Sakila</h1>
        
        <table border = "1">
            <thead>
               <tr>
                <td>ID</td>
                <td>Nome</td>
                <td>Descrição</td>
                <td>Data de lançamento</td>
                <td>Ações</td>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="filme" items="${filmes}" begin="1000"> 
                <tr> 
                <td>${filme.filme_id}</td>
                <td>${filme.title}</td>
                <td>${filme.descricao}</td>
                <td>${filme.anofilme}</td>
                <td>
                    <a class="btnedit" href="./editar?filme=${filme.filme_id}"> 
                        <button type="button" class="btn btn-warning"><i class="fa-solid fa-pen-to-square"></i></button></a>
                    <a class="btnedit" href="./excluir?filme=${filme.filme_id}"> 
                        <button type="button" class="btn btn-danger"><i class="fa-solid fa-trash"></i></button>
                    </a>
                </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="https://kit.fontawesome.com/7a580de69a.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
