/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexao {
    
    private Connection conexao;


    
    public Conexao(){
        
        //verificar se o driver está presente na biblioteca do java
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //estabelecer uma conexão com o banco de dados
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
        }catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Connection getConexao() {
        return conexao;
    }
    
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    

}
