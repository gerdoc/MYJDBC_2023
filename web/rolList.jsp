<%-- 
    Document   : rolList
    Created on : May 2, 2023, 6:09:56 PM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.dao.Rol"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.dao.service.RolService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Rol</td>
                <td>Descripción</td>
            </tr>
            <%
                
                for(int i= 0; i< 1; i++)
                {
            
            %>
            <tr>
                <td>rol <%=i%></td>
                <td>descripción <%=i%></td>
            </tr>
            <%}
             %>
        </table>
    </body>
</html>
