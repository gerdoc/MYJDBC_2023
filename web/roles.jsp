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
            if( "nuevo".equals( accion ) )
            {
        %>
                <jsp:include page="secure/client/includes/rol.jsp" />
        <%
            }
            if( "enviar".equals( accion ) )
            {
                Helpers helpers = new RolHelper( ).addHttpServletRequest(request);
                if( helpers.add( ) )
                {
                %>
                    <jsp:forward page="roles.jsp" />
                <%
                }
                
            }

            if( accion == null )
            {
        %>
                <a href="roles.jsp?accion=nuevo">Nuevo rol </a>
                <jsp:include page="secure/client/includes/rolList.jsp" />
        <%
            }
        %>
        
    </body>
</html>
