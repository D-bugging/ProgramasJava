<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- Cabecalho para a JSTL core --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Contatos</title>
    </head>
    <body>
        <h1>Teste</h1>
        
        


<%-- tag jsp:useBean utilizada para instanciar classe --%>
        <jsp:useBean id="dao" class="dao.ContatoDao"/>
    
        <table>
            <!-- contato == variavel temporaria -->
            <!-- percorre contatos montando as linhas da tabela -->
            <c:forEach var="contato" items="${dao.lista}">
                <tr>
                    <td>${contato.nome}</td>
                    <td>${contato.email}</td>
                    <td>${contato.endereco}</td>
                    <td>${contato.dataNascimento.time}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
