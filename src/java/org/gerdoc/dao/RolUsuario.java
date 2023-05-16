/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.dao;

import java.io.Serializable;

/**
 *
 * @author gerdoc
 */
public class RolUsuario implements Serializable
{
    private Rol rol;
    private Usuario usuario;

    public RolUsuario() 
    {
    }

    public Rol getRol() 
    {
        return rol;
    }

    public void setRol(Rol rol) 
    {
        this.rol = rol;
    }

    public Usuario getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario) 
    {
        this.usuario = usuario;
    }
    
}
