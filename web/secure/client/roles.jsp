<%-- 
    Document   : roles
    Created on : May 2, 2023, 6:09:56 PM
    Author     : gerdoc
--%>

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
            Rol rol = null;
            String aux = null;
            boolean flag = false;
            String readonly = null;
            
            if( "Nuevo".equals( accion ) || "Editar".equals( accion ) )
            {
                if( "Nuevo".equals( accion ) )
                {
                    rol = new Rol( );
                    rol.setRol( "" );
                    rol.setDescripcion( "" );
                    aux = "Guardar";
                    readonly = "";
                }
                if( "Editar".equals( accion ) )
                {
                    helpers = new RolHelper( ).addRequest( request );
                    rol = (Rol)helpers.getTByKey( );
                    aux = "Actualizar";
                    readonly = "readonly='true'";
                }
                
            
        %>
                <jsp:include page="includes/rol.jsp" >
                    <jsp:param name="rol" value="<%=rol.getRol()%>" />
                    <jsp:param name="descripcion" value="<%=rol.getDescripcion()%>" />
                    <jsp:param name="accion" value="<%=aux%>" />
                    <jsp:param name="readonly" value="<%=readonly%>" />
                </jsp:include>
        <%
            }
            if( "Guardar".equals( accion ) || "Borrar".equals( accion ) || "Actualizar".equals( accion ) )
            {
                helpers = new RolHelper( ).addRequest( request );
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
                    <jsp:forward page="roles.jsp?accion=list" />
        <%
                }                
            }
            if( accion == null || "list".equals(accion ))
            {
        %>
                <a href="roles.jsp?accion=Nuevo">Nuevo rol </a>
                <jsp:include page="includes/rolList.jsp" />
        <%
            }
        %>
        
    </body>
</html>
