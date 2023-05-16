<%-- 
    Document   : rol
    Created on : 4 may 2023, 13:32:28
    Author     : alumno
--%>

<form id="form1" method="post" action="usuarios.jsp" onsubmit="return validateForm( )">
    <table border="1">
        <tr>
            <td>Usuario</td>
            <td>
                
                <input type="text" name="usuario" id="usuario" value="${param.usuario}" ${param.readonly} /> 
                <span id="usuarioError" style="color:red"></span>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <input type="text" name="password" id="password" value="${param.password}" /> 
                <span id="passwordError" style="color:red"></span>
            </td>
        </tr>
        <tr>
            <td>Nombre</td>
            <td>
                <input type="text" name="nombre" id="nombre" value="${param.nombre}" /> 
                <span id="nombreError" style="color:red"></span>
            </td>
        </tr>
        <tr>
            <td>Correo</td>
            <td>
                <input type="text" name="correo" id="correo" value="${param.correo}" /> 
                <span id="correoError" style="color:red"></span>
            </td>
        </tr>
        <tr>
            <td>Último Login</td>
            <td>
                <input type="text" name="ultimoLogin" id="ultimoLogin" value="${param.ultimoLogin}" /> 
                <span id="ultimoLoginError" style="color:red"></span>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"  name="accion" id="accion" value="${param.accion}" />
            </td>
        </tr>
    </table>
    <script>
        <!--
        function validateTexto( obj , textoError, campoError )
        {
            if( obj.value === undefined || obj.value.length <= 0 )
            {
                campoError.innerHTML = "<b>" + textoError + "</b>";
                return false;
            }
            campoError.innerHTML = " ";
            return true;
        
        }
        
        function validateForm( )
        {
            const arr = ['usuario' , 'password', 'nombre' , 'correo' , 'ultimoLogin'];
            let obj1, obj2;
            
            var flag = true;
            for( const aux of arr )
            {
                obj1 = document.getElementById( aux );
                obj2 = document.getElementById( aux + 'Error' );
                if( !validateTexto( obj1 , "El campo " + aux + " es requerido" , obj2 ) )
                {
                    flag = false;
                }
            }
            return flag;
        }
        -->
    </script>
    <a href="usuarios.jsp"> Lista de usuarios</a>
</form>