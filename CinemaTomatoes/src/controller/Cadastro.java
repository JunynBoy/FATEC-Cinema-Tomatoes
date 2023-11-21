/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Filme;
import models.Usuario;

public class Cadastro {
    
    private Conexao conexao = new Conexao();
    
    public Usuario consultarUsuario(int idUsuario){
        PreparedStatement st;
        ResultSet rs;
        Usuario usuario = null;
        
        try{
            
            st = conexao.getConexao().prepareStatement("select * from usuario "
                    + " where id_usuario = ? ");
            st.setInt(1, idUsuario);
            
            rs = st.executeQuery();
            if(rs.next()){
               usuario = new Usuario();
               usuario.setId(rs.getInt("id_usuario"));
               usuario.setNome(rs.getString("nome"));
               usuario.setLogin(rs.getString("login"));
               usuario.setSenha(rs.getString("senha"));
            }
            
            
        }catch(SQLException ex){
             Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return usuario;
    }
    
    public Filme consultarFilme(int idFilme){
        PreparedStatement st;
        ResultSet rs;
        Filme filme = null;
        
        try{
            
            st = conexao.getConexao().prepareStatement("select * from filme "
                    + " where id_filme = ? ");
            st.setInt(1, idFilme);
            
            rs = st.executeQuery();
            if(rs.next()){
               filme = new Filme();
               filme.setId(rs.getInt("id_filme"));
               filme.setTitulo(rs.getString("titulo"));
               //filme.setLogin(rs.getString("genero_idgenero"));
               filme.setAno(rs.getString("ano"));
               filme.setDiretor(rs.getString("diretor"));
               filme.setPais(rs.getString("pais"));
            }
            
            
        }catch(SQLException ex){
             Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return filme;
    }
    

    
    public LinkedList consultarFilmes() {
        PreparedStatement st;
        ResultSet rs;
        LinkedList lista = new LinkedList();
        Filme filme = null;

        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM filme");
            rs = st.executeQuery();

            while (rs.next()) {
                filme = new Filme();
                filme.setId(rs.getInt("id_filme"));
                filme.setTitulo(rs.getString("titulo"));
               //filme.setLogin(rs.getString("genero_idgenero"));
                filme.setAno(rs.getString("ano"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setPais(rs.getString("pais"));
                // Adicione o filme à lista
                lista.add(filme);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public void atualizarFilme(Filme filme){
        PreparedStatement st;
        ResultSet rs;
        int i = 0 ; 
        try{
            
            st = conexao.getConexao().prepareStatement("update filme set "
                    + "titulo = ? , ano = ?, diretor = ? , pais = ? "
                    + "where id_filme = ?");
            st.setString(i++, filme.getTitulo());
            st.setString(i++, filme.getAno());
            st.setString(i++, filme.getDiretor());
            st.setString(i++, filme.getPais());
            st.setInt(i++, filme.getId());
           
            
            st.execute();
            
        }catch(SQLException ex){
             Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void salvarFilme(Filme filme){
        //fazer
    }
    
    

    
    
    
    
  
    
    
    
    
    
}
