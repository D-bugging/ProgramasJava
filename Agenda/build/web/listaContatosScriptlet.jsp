<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="entity.Contato"%>
<%@page import="dao.ContatoDao"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
    </head>
    <body>
        <table>
            <%--
                ContatoDao dao = new ContatoDao();
                List<Contato> contatos = dao.getLista();
                
                /*
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println(d + "\n");
                System.out.println(sdf.format(d));
                sdf = new SimpleDateFormat("HH:mm:ss");
                System.out.println(sdf.format(d));
                */
                
                //contato.getDataNascimento()
                
                
                //System.out.println(sdf.format(d));
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
                
                for (Contato contato : contatos){
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM").parse(contato.getDataNascimento());
                    //Date dn = new contato.getDataNascimento();
                    
                    //Date dataNasci = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
                    
                    //String sdf = new SimpleDateFormat("dd/MM").format(contato.getDataNascimento());
                    //System.out.println(sdf);
                    
                    System.out.println(contato);
                    //String dataNascimento = sdf.parse(contato.getDataNascimento());
            --%>
                <!--
                <tr>
                    <td><%--=contato.getNome() %></td>
                    <td><%=contato.getEmail() %></td>
                    <td><%=contato.getEndereco() %></td>
                    <td><%=contato.getDataNascimento() --%></td>
                </tr>
                -->
            <%--
                }
            --%>
        
        </table>
    </body>
</html>
