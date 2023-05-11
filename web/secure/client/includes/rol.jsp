<%-- 
    Document   : rol
    Created on : 4 may 2023, 13:32:28
    Author     : alumno
--%>

<form id="form1" method="post" action="roles.jsp" onsubmit="return validateForm( )">
    <table border="1">
        <tr>
            <td>ROL</td>
            <td>
                <input type="text" name="rol" id="rol" /> 
                <span id="rolError"></span>
            </td>
        </tr>
        <tr>
            <td>DESCRIPCION</td>
            <td>
                <input type="text" name="descripcion" id="descripcion" /> 
                <span id="descripcionError" style="color:red"></span>
            </td>
        </tr>        
        <tr>
            <td colspan="2">
                <input type="submit"  name="accion" id="accion" value="enviar" />
            </td>
        </tr>
    </table>
    <script>
        <!--
        function validateTexto( obj , textoError, campoError )
        {
            if( obj.value === undefined || obj.value.length <= 0 )
            {
                campoError.innerHTML = "<b>Campo necesario</b>";
                return false;
            }
            campoError.innerHTML = "";
            return true;
        
        }
        function validateForm( )
        {
            const rol = document.getElementById("rol");
            const descripcion = document.getElementById("descripcion");
            var flag = true;
            
            if( validateTexto( rol , "El rol es un campo requerido" , document.getElementById("rolError") ) )
            {
                flag = false;
            }
            if( validateTexto( rol , "Descripción es un campo requerido" , document.getElementById("descripcionError") ) )
            {
                flag = false;
                document.getElementById("").innerHTML = "Campo necesario";
            }
            return flag;
        }
        -->
    </script>
    <a href="roles.jsp"> Lista de roles </a>
</form>