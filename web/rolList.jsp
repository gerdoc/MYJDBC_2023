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
                RolService rolService = new RolService();
                List<Rol>list = rolService.getRolList();
                if( list != null && list.size() > 0)
                {
                for(Rol rol : list)
                {
            
            %>
            <tr>
                <td><%=rol.getRol( )%></td>
                <td><%=rol.getDescripcion( )%></td>
            </tr>
            <%}
               }
             %>
        </table>
    </body>
</html>
