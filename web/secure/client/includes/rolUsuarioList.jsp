<%-- 
    Document   : rolList
    Created on : 4 may 2023, 13:19:50
    Author     : alumno
--%>

<%@page import="org.gerdoc.dao.RolUsuario"%>
<%@page import="org.gerdoc.helper.RolUsuarioHelper"%>
<%@page import="org.gerdoc.helper.RolHelper"%>
<%@page import="org.gerdoc.dao.Rol"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.dao.service.RolService"%>
<table border="1">
    <tr>
        <td>Rol</td>
        <td>Usuario</td>
        <td>Acción</td>
    </tr>
    <%
        RolUsuarioHelper rolUsuarioHelper = new RolUsuarioHelper();
        List<RolUsuario>list = rolUsuarioHelper.getListT();
        if( list != null && list.size() > 0)
        {
        for(RolUsuario rolUsuario : list)
        {

    %>
    <tr>
        <td><%=rolUsuario.getRol( ).getRol( )%></td>
        <td><%=rolUsuario.getUsuario( ).getUsuario( )%></td>
        <td>
            <form method="post" action="rolesUsuarios.jsp">
                <input type="hidden" name="rol" id="rol" value="<%=rolUsuario.getRol( ).getRol()%>" />
                <input type="hidden" name="usuario" id="usuario" value="<%=rolUsuario.getUsuario( ).getUsuario( )%>" />
                <input type="submit" id="accion" name="accion" value="Borrar" />
            </form>
        </td>
    </tr>
    <%}
       }
     %>
</table>