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
import org.gerdoc.dao.Rol;
import org.gerdoc.dao.RolUsuario;
import org.gerdoc.dao.Usuario;

/**
 *
 * @author gerdoc
 */
public class RolUsuarioService extends Conexion<RolUsuario>
{
    public List<RolUsuario> getRolUsuarioList() 
    {
        List<RolUsuario> rolUsuarioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        RolUsuario rolUsuario = null;

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
            resultSet = statement.executeQuery("SELECT * FROM ROL_Usuario");
            if (resultSet == null) 
            {
                return null;
            }
            rolUsuarioList = new ArrayList<>();
            while (resultSet.next()) 
            {
                rolUsuario = new RolUsuario();
                rolUsuario.setRol( new Rol( resultSet.getString(1) ) );
                rolUsuario.setUsuario( new Usuario( resultSet.getString(2) ) );
                rolUsuarioList.add(rolUsuario);
            }
            resultSet.close();
            closeConnection(connection);
            return rolUsuarioList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addRolUsuario( RolUsuario rolUsuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ROL_Usuario(ROL,USUARIO) VALUES(?,?)";
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
            preparedStatement.setString(1, rolUsuario.getRol().getRol() );
            preparedStatement.setString(2, rolUsuario.getUsuario().getUsuario() );
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
    
    public boolean updateRolUsuario( RolUsuario rolUsuario )
    {
        return false;
    }
    
    public boolean deleteRolUsuario( RolUsuario rolUsuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ROL_Usuario WHERE ROL = ? AND USUARIO = ?";
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
            preparedStatement.setString(1, rolUsuario.getRol().getRol());
            preparedStatement.setString(2, rolUsuario.getUsuario().getUsuario() );
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
    
    public RolUsuario getRolUsuarioByRolUsuario( String rol , String usuario) 
    {
        RolUsuario aux = null;
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
            preparedStatement = connection.prepareStatement("SELECT * FROM ROL_Usuario WHERE ROL = ? AND USUARIO = ?" );
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, rol );
            preparedStatement.setString(2, usuario );
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new RolUsuario ( );
            while (resultSet.next()) 
            {
                
                aux.setRol( new Rol( resultSet.getString(1)) );
                aux.setUsuario( new Usuario( resultSet.getString(2)) );
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
    
    public RolUsuario getRolUsuarioByUsuarioPassword( String usuario , String password ) 
    {
        RolUsuario aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder stringBuilder = null;
        try 
        {
            connection = getConnection();
            if (connection == null) 
            {
                return null;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT RU.ROL , RU.USUARIO FROM ROL_Usuario RU INNER JOIN Usuario US ON RU.USUARIO = US.USUARIO" );
            stringBuilder.append( " WHERE US.USUARIO = ? AND US.PASSWORD = ?" );
            preparedStatement = connection.prepareStatement( stringBuilder.toString( ) );
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, usuario );
            preparedStatement.setString(2, password );
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new RolUsuario ( );
            while (resultSet.next()) 
            {
                aux.setRol( new Rol( resultSet.getString(1)) );
                aux.setUsuario( new Usuario( resultSet.getString(2)) );
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
