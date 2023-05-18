<%-- 
    Document   : index.jsp
    Created on : May 12, 2023, 4:28:25 AM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.helper.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World cliente!</h1>
        <%
            String action = null;
            LoginHelper loginHelper = null;
            
            action = request.getParameter("action");
            if( action != null && "Salir".equals( action ) )
            {
                loginHelper = new LoginHelper( );
                if( !loginHelper.logout( session ) )
                {
        %>
                    <script>
                        <!--
                            alert( 'Error' );
                        -->
                    </script>
        <%
                }
                else
                {
                    System.out.println( request.getContextPath() ); 
                    response.sendRedirect( request.getContextPath() );
                    
                }
            }
            
        %>
        <a href="roles.jsp">Roles</a><br/>
        <a href="rolesUsuarios.jsp">Roles usuarios</a>
        <form>
            <input type="submit" id="accion" name="action" value="Salir" />
        </form>
    </body>
</html>
