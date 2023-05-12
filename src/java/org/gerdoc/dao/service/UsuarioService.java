/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.dao.Usuario;

/**
 *
 * @author gerdoc
 */
public class UsuarioService extends Conexion<Usuario>
{

    public UsuarioService() 
    {
    }
    
    public List<Usuario> getUsuarioList() 
    {
        List<Usuario> usuarioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;

        try 
        {
            connection = getConnection();
            if (connection == null) 
            {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM USUARIO");
            if (resultSet == null) 
            {
                return null;
            }
            usuarioList = new ArrayList<>();
            while (resultSet.next()) 
            {
                usuario = new Usuario();
                usuario.setUsuario(resultSet.getString(1 ) );
                usuario.setPassword(resultSet.getString(2 ) );
                usuario.setNombre( resultSet.getString(3 ) );
                usuario.setPassword( resultSet.getString( 4 ) );
                usuario.setUltimoLogin( resultSet.getDate(5 ) );
                usuarioList.add(usuario);
            }
            resultSet.close();
            closeConnection(connection);
            return usuarioList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addUsuario( Usuario usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USUARIO(USUARIO,PASSWORD,NOMBRE,CORREO,ULTIMO_LOGIN) VALUES(?,?,?,?,?)";
        int row = 0;
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, usuario.getUsuario( ) );
            preparedStatement.setString(2, usuario.getPassword( ) );
            preparedStatement.setString(3, usuario.getNombre( ) );
            preparedStatement.setString(4, usuario.getCorreo() );
            preparedStatement.setDate(5, dateUtil2DateSql( usuario.getUltimoLogin( ) ) );
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean updateUsuario( Usuario usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update USUARIO SET PASSWORD = ?,NOMBRE = ?,CORREO = ?, ULTIMO_LOGIN = ? WHERE USUARIO = ?";
        int row = 0;
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, usuario.getPassword( ) );
            preparedStatement.setString(2, usuario.getNombre( ) );
            preparedStatement.setString(3, usuario.getCorreo() );
            preparedStatement.setDate(4, dateUtil2DateSql( usuario.getUltimoLogin( ) ) );
            preparedStatement.setString(5, usuario.getUsuario( ) );
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteUsuario( Usuario usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USUARIO WHERE USUARIO = ?";
        int row = 0;
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, usuario.getUsuario() );
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Usuario getUsuarioByUsuario( String usuario) 
    {
        Usuario aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try 
        {
            connection = getConnection();
            if (connection == null) 
            {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO = ?" );
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, usuario );
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new Usuario ( );
            while (resultSet.next()) 
            {
                aux.setUsuario(resultSet.getString(1 ) );
                aux.setPassword(resultSet.getString(2 ) );
                aux.setNombre( resultSet.getString(3 ) );
                aux.setPassword( resultSet.getString( 4 ) );
                aux.setUltimoLogin( resultSet.getDate(5 ) );
            }
            resultSet.close();
            closeConnection(connection);
            return aux;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
