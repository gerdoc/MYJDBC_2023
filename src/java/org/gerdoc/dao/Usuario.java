/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.dao;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gerdoc
 */
public class Usuario implements Serializable
{
    private String usuario;
    private String password;
    private String nombre;
    private String correo;
    private Date ultimoLogin;
            

    public Usuario() 
    {
    }

    public String getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public Date getUltimoLogin()
    {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin)
    {
        this.ultimoLogin = ultimoLogin;
    }
    
    
}
