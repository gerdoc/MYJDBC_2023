/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.helper;

import java.io.Serializable;
import java.util.List;
import org.gerdoc.dao.Rol;
import org.gerdoc.dao.service.RolService;

/**
 *
 * @author alumno
 */
public class RolHelper extends Helpers<Rol> implements Serializable
{
    private RolService rolService;
    
    public RolHelper() 
    {
    }
    
    public boolean isValidaCamposOk( )
    {
        return isNotNullAndNotEmpity( t.getRol() ) && isNotNullAndNotEmpity( t.getDescripcion() );
    }

    @Override
    public boolean addT() 
    {
        rolService = new RolService();
        t = new Rol();
        t.setRol(getParameter("rol"));
        t.setDescripcion(getParameter("descripcion"));
        if( isValidaCamposOk( ) )
        {
            return rolService.addRol(t );
        }
        return false;
    }

    @Override
    public List<Rol> getListT() 
    {
        rolService = new RolService();
        return rolService.getRolList();
    }

    
    
    
    
}
