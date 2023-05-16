<%-- 
    Document   : roles
    Created on : May 2, 2023, 6:09:56 PM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.helper.RolUsuarioHelper"%>
<%@page import="org.gerdoc.dao.Usuario"%>
<%@page import="org.gerdoc.dao.RolUsuario"%>
<%@page import="org.gerdoc.helper.Helpers"%>
<%@page import="org.gerdoc.helper.RolHelper"%>
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
        <%
            String accion = request.getParameter("accion");
            Helpers helpers = null;
            RolUsuario rolUsuario = null;
            String aux = null;
            boolean flag = false;
            String readonly = null;
            
            if( "Nuevo".equals( accion ) || "Editar".equals( accion ) )
            {
                if( "Nuevo".equals( accion ) )
                {
                    rolUsuario = new RolUsuario( );
                    rolUsuario.setRol( new Rol( "" ) );
                    rolUsuario.setUsuario( new Usuario( "" ) );
                    aux = "Guardar";
                    readonly = "";
                }
                if( "Editar".equals( accion ) )
                {
                    helpers = new RolUsuarioHelper( ).addRequest( request );
                    rolUsuario = (RolUsuario)helpers.getTByKey( );
                    aux = "Actualizar";
                    readonly = "readonly='true'";
                }
        %>
                <jsp:include page="includes/rolUsuario.jsp" >
                    <jsp:param name="rol" value="<%=rolUsuario.getRol().getRol()%>" />
                    <jsp:param name="usuario" value="<%=rolUsuario.getUsuario().getUsuario()%>" />
                    <jsp:param name="accion" value="<%=aux%>" />
                    <jsp:param name="readonly" value="<%=readonly%>" />
                </jsp:include>
        <%
            }
            if( "Guardar".equals( accion ) || "Borrar".equals( accion ) || "Actualizar".equals( accion ) )
            {
                helpers = new RolUsuarioHelper( ).addRequest( request );
                if( "Guardar".equals( accion ) )
                {
                    flag = helpers.addT( );
                }
                if( "Borrar".equals( accion ) )
                {
                    flag = helpers.deleteT( );
                }
                if( "Actualizar".equals( accion ) )
                {
                    flag = helpers.updateT( );
                }
                if( flag )
                {
        %>
                    <jsp:forward page="rolesUsuarios.jsp?accion=list" />
        <%
                }                
            }
            if( accion == null || "list".equals(accion ))
            {
        %>
                <a href="rolesUsuarios.jsp?accion=Nuevo">Nuevo rol usuario</a>
                <jsp:include page="includes/rolUsuarioList.jsp" />
        <%
            }
        %>
        
    </body>
</html>
