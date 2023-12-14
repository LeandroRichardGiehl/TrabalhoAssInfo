/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aluno tds
 */
public class ConexaoDB {
        public Connection getConnection(){
    
        Connection conn = null;
        String className = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/BancoDDados";
        String user = "root";
        String password = "123";
        
        try {
            Class.forName(className);
            System.out.println("ClasseName com valor incorreto!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar conexÃ£o!");
        }
        
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("ConexÃ£o realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
