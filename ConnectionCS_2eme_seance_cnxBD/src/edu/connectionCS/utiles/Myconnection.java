/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connectionCS.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author zied
 */
public class Myconnection {
    
    public String url="jdbc:mysql://localhost:3306/esprit" ; 
    public String login="root" ; 
    public String pwd="" ; 
    Connection cnx ;
    
    public Myconnection(){
        try {
            cnx= DriverManager.getConnection(url, login, pwd);
            System.out.println("connection établie avec success");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
