/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.helper;

import java.io.Serializable;
import java.util.List;
import org.gerdoc.dao.Usuario;
import org.gerdoc.dao.service.UsuarioService;

/**
 *
 * @author alumno
 */
public class UsuarioHelper extends Helpers<Usuario> implements Serializable
{
    private UsuarioService usuarioService;
    
    public UsuarioHelper() 
    {
    }
    
    public boolean isValidaCamposOk( )
    {
        return isNotNullAndNotEmpity( t.getUsuario() ) && isNotNullAndNotEmpity( t.getPassword() ) &&
               isNotNullAndNotEmpity( t.getNombre()) && isNotNullAndNotEmpity( t.getCorreo()) &&
               isNotNull( t.getUltimoLogin() );
    }

    @Override
    public boolean addT() 
    {
        usuarioService = new UsuarioService();
        t = new Usuario();
        t.setUsuario(getParameter("usuario"));
        t.setPassword(getParameter("password"));
        t.setNombre(getParameter("nombre"));
        t.setCorreo(getParameter("correo"));
        t.setUltimoLogin(  string2Date( getParameter("ultimoLogin") ) );
        
        if( isValidaCamposOk( ) )
        {
            return usuarioService.addUsuario(t );
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Usuario> getListT() 
    {
        usuarioService = new UsuarioService();
        return usuarioService.getUsuarioList();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean updateT()
    {
        usuarioService = new UsuarioService();
        t = new Usuario();
        t.setUsuario(getParameter("usuario"));
        t.setPassword(getParameter("password"));
        t.setNombre(getParameter("nombre"));
        t.setCorreo(getParameter("correo"));
        t.setUltimoLogin(  string2Date( getParameter("ultimoLogin") ) );
        if( isValidaCamposOk( ) )
        {
            return usuarioService.updateUsuario(t );
        }
        return false;
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean deleteT()
    {
        usuarioService = new UsuarioService();
        t = new Usuario();
        t.setUsuario(getParameter("usuario"));
        if( t.getUsuario( ) != null && t.getUsuario().length( ) > 0 )
        {
            return usuarioService.deleteUsuario(t );
        }
        return false;
        
    }

    @Override
    public Usuario getTByKey() 
    {
        String usuario = null;
        
        usuario = getParameter("usuario" );
        if( usuario == null || usuario.length( ) <= 0 )
        {
            return null;
        }
        usuarioService = new UsuarioService( );
        return usuarioService.getUsuarioByUsuario( usuario );
    }
    
}