<%-- 
    Document   : rolList
    Created on : 4 may 2023, 13:19:50
    Author     : alumno
--%>

<%@page import="org.gerdoc.helper.RolHelper"%>
<%@page import="org.gerdoc.dao.Rol"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.dao.service.RolService"%>
<table border="1">
    <tr>
        <td>Rol</td>
        <td>Descripción</td>
    </tr>
    <%
        RolHelper rolHelper = new RolHelper();
        List<Rol>list = rolHelper.getListT();
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