<%-- 
    Document   : rolList
    Created on : 4 may 2023, 13:19:50
    Author     : alumno
--%>

<%@page import="org.gerdoc.dao.Usuario"%>
<%@page import="org.gerdoc.helper.UsuarioHelper"%>
<%@page import="org.gerdoc.helper.RolHelper"%>
<%@page import="org.gerdoc.dao.Rol"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.dao.service.RolService"%>
<table border="1">
    <tr>
        <td>Usuario</td>
        <td>Password</td>
        <td>Nombre</td>
        <td>Correo</td>
        <td>Último Login</td>
        <td>Acción</td>
    </tr>
    <%
        UsuarioHelper usuarioHelper = new UsuarioHelper();
        List<Usuario>list = usuarioHelper.getListT();
        if( list != null && list.size() > 0)
        {
        for(Usuario usuario : list)
        {

    %>
    <tr>
        <td><%=usuario.getUsuario()%></td>
        <td><%=usuario.getPassword()%></td>
        <td><%=usuario.getNombre()%></td>
        <td><%=usuario.getCorreo()%></td>
        <td><%=usuarioHelper.date2String( usuario.getUltimoLogin( ) )%></td>
        <td>
            <form method="post" action="usuarios.jsp">
                <input type="hidden" name="usuario" id="usuario" value="<%=usuario.getUsuario()%>" />
                <input type="submit" id="accion" name="accion" value="Borrar" />
                <input type="submit" id="accion" name="accion" value="Editar" />
            </form>
        </td>
    </tr>
    <%}
       }
     %>
</table>