<%-- 
    Document   : rolList
    Created on : 4 may 2023, 13:19:50
    Author     : alumno
--%>

<%@page import="org.gerdoc.dao.Rol"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.dao.service.RolService"%>
<table border="1">
    <tr>
        <td>Rol</td>
        <td>Descripci�n</td>
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