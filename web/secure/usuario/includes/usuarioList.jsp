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
        <td>Acción</td>
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
        <td>
            <form method="post" action="roles.jsp">
                <input type="hidden" name="rol" id="rol" value="<%=rol.getRol( )%>" />
                <input type="submit" id="accion" name="accion" value="Borrar" />
                <input type="submit" id="accion" name="accion" value="Editar" />
            </form>
        </td>
    </tr>
    <%}
       }
     %>
</table>