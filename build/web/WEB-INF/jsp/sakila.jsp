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
        <title>JSP Page</title>
        <style>
            
        </style>
    </head>
    <body>
        <a href="./cadastrar">Cadastrar Filme</a>
        <h1>Sakila</h1>
        
        <table border = "1">
            <thead>
               <tr>
                <td>ID</td>
                <td>Nome</td>
                <td>Descrição</td>
                <td>Data de lançamento</td>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="filme" items="${filmes}" begin="1000"> 
                <tr> 
                <td>${filme.filme_id}</td>
                <td>${filme.title}</td>
                <td>${filme.descricao}</td>
                <td>${filme.anofilme}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
