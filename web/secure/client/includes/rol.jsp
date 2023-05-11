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
                <span id="descripcionError"></span>
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
        function validateForm( )
        {
            const rol = document.getElementById("rol");
            const descripcion = document.getElementById("descripcion");
            var flag = true;
            
            if( rol.value === undefined || rol.value.length <= 0 )
            {
                flag = false;
                document.getElementById("rolError").innerHTML = "Campo necesario";
            }
            if( descripcion.value === undefined || descripcion.value.length <= 0)
            {
                flag = false;
                document.getElementById("descripcionError").innerHTML = "Campo necesario";
            }
            return flag;
        }
        -->
    </script>
    <a href="roles.jsp"> Lista de roles </a>
</form>