/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.dao.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gerdoc
 */
public abstract class Conexion<T> implements Serializable 
{

    public static String user = "root";
    public static String password = "n0m3l0";
    public static String db = "Prueba";

    public boolean testDriver() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            return true;
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }

    public Connection getConnection(String user, String password, String db, String server) 
    {
        String url = null;
        if (user == null || password == null || db == null || server == null) {
            return null;
        }
        if ("".equals(user) || "".equals(password) || "".equals(db) || "".equals(server)) 
        {
            return null;
        }
        url = String.format("jdbc:mysql://%s:3308/%s?user=%s&password=%s", server, db, user, password);
        try 
        {
            if (!testDriver()) 
            {
                return null;
            }
            return DriverManager.getConnection(url);
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() 
    {
        return getConnection(user, password, db, "127.0.0.1");
    }

    public void closeConnection(Connection connection) 
    {
        try {
            if (connection == null) 
            {
                return;
            }
            if (connection.isClosed()) 
            {
                return;
            }
            connection.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }

}
