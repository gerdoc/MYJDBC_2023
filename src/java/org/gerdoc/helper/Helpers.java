/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.helper;

import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author alumno
 */
public abstract class Helpers<T> implements Serializable
{
    protected HttpServletRequest request;
    protected T t;
    protected List<T> list;

    public Helpers() 
    {
    }
    
    public Helpers addRequest( HttpServletRequest request )
    {
        this.request = request;
        return this;
    }
    
    public String getParameter( String name )
    {
        if( request == null || name == null )
        {
            return null;
        }
        if( name.length() <0 )
        {
            return null;
        }
        return request.getParameter( name );
    }
    
    public abstract boolean addT( );
    public abstract List<T> getListT( );
    
}
