<%-- 
    Document   : index
    Created on : May 12, 2023, 4:29:13 AM
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
        <h1>Login</h1>
        <%
            String action = null;
            LoginHelper loginHelper = null;
            
            action = request.getParameter("action");
            if( action != null && "Login".equals( action ) )
            {
                loginHelper = new LoginHelper( );
                if( !loginHelper.login( request, response ) )
                {
        %>
                    <script>
                        <!--
                            alert( 'Error' );
                        -->
                    </script>
        <%
                }
            }
            
        %>
        <form id="form1">
            <table>
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" id="usuario" name="usuario" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" id="password" name="password" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" id="action" name="action" value="Login" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
