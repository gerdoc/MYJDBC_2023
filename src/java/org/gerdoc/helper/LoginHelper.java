/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.helper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import org.apache.catalina.Session;
import org.gerdoc.dao.RolUsuario;
import org.gerdoc.dao.service.RolUsuarioService;

/**
 *
 * @author gerdoc
 */
public class LoginHelper implements  Serializable
{
    private String usuario;
    private String password;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    
    public boolean login( HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse )
    {
        RolUsuarioService rolUsuarioService = null;
        RolUsuario rolUsuario = null;
        String page = null;
        
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        usuario = httpServletRequest.getParameter("usuario" );
        password = httpServletRequest.getParameter("password" );
        if( !isLoginOk( ) )
        {
            return false;
        }
        rolUsuarioService = new RolUsuarioService( );
        rolUsuario = rolUsuarioService.getRolUsuarioByUsuarioPassword( usuario , password );
        if( rolUsuario == null )
        {
            return false;
        }
        httpServletRequest.getSession(true ).setAttribute("rolUsuario", rolUsuario);
        switch (rolUsuario.getRol().getRol()) 
        {
            case "client":
                page = "/secure/client/index.jsp";
                break;
            case "usuario":
                page = "/secure/usuario/index.jsp";
                break;
            default:
                return false;
        }
        
        return redirect( page );
    }
    
    public boolean isLoginOk( )
    {
        try 
        {
            httpServletRequest.login(usuario, password);
            return true;
        } 
        catch (ServletException ex) 
        {
            Logger.getLogger(LoginHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean redirect( String page )
    {
        try 
        {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + page );
            return true;
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(LoginHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean logout( HttpSession httpSession )
    {
        if( httpSession == null )
        {
            return false;
        }
        httpSession.invalidate();
        return true;
    }
}
