<%@page import="entity.Contato"%>
<%@page import="java.util.List"%>
<%@page import="dao.ContatoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello world</title>
    </head>
    <body>
        
        <%-- Comentario em JSP aqui --%>
        <%
            ContatoDao dao = new ContatoDao();
            List<Contato> contatos = dao.getLista();
            for(Contato contato : contatos){
        %>
            <li><%= contato.getNome() %>, <%= contato.getEmail() %>:
                <%= contato.getEndereco()%>
            </li>
        <%
            }
        %>
    </body>
</html>
