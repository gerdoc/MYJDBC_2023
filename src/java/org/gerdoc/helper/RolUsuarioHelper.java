/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.helper;

import java.io.Serializable;
import java.util.List;
import org.gerdoc.dao.Rol;
import org.gerdoc.dao.RolUsuario;
import org.gerdoc.dao.Usuario;
import org.gerdoc.dao.service.RolUsuarioService;

/**
 *
 * @author alumno
 */
public class RolUsuarioHelper extends Helpers<RolUsuario> implements Serializable
{
    private RolUsuarioService rolService;
    
    public RolUsuarioHelper() 
    {
    }
    
    public boolean isValidaCamposOk( )
    {
        return isNotNullAndNotEmpity( t.getRol().getRol() ) && isNotNullAndNotEmpity( t.getUsuario().getUsuario());
    }

    @Override
    public boolean addT() 
    {
        rolService = new RolUsuarioService();
        t = new RolUsuario();
        t.setRol( new Rol( getParameter("rol")));
        t.setUsuario( new Usuario(getParameter("usuario")));
        if( isValidaCamposOk( ) )
        {
            return rolService.addRolUsuario(t );
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public List<RolUsuario> getListT() 
    {
        rolService = new RolUsuarioService();
        return rolService.getRolUsuarioList();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean updateT()
    {
        return false;   
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean deleteT()
    {
        rolService = new RolUsuarioService();
        t = new RolUsuario();
        t.setRol( new Rol(getParameter("rol" ) ) );
        t.setUsuario( new Usuario( getParameter("usuario") ) );
        if( t.getRol( ).getRol() != null && t.getRol().getRol().length( ) > 0 && 
            t.getUsuario().getUsuario()!= null && t.getUsuario().getUsuario().length( ) > 0 )
        {
            return rolService.deleteRolUsuario(t );
        }
        return false;
        
    }

    @Override
    public RolUsuario getTByKey() 
    {
        String rol = null;
        String usuario = null;
        
        rol = getParameter("rol" );
        usuario = getParameter("usuario" );
        if( rol == null || rol.length( ) <= 0 )
        {
            return null;
        }
        if( usuario == null || usuario.length( ) <= 0 )
        {
            return null;
        }
        rolService = new RolUsuarioService( );
        return rolService.getRolUsuarioByRolUsuario( rol , usuario );
    }
    
}