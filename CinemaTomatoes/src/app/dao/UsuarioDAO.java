/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.services.connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import app.models.Usuario;

public class UsuarioDAO{
    
    private final Conexao conexao = new Conexao();
    
    public Usuario getByLogin(String login) {
        PreparedStatement ps;
        ResultSet rs;
        int i = 1;

        try {
            ps = conexao.getConexao().prepareStatement("SELECT * from usuario u where u.login = ? ");

            ps.setString(i++, login);
            rs = ps.executeQuery();

            if (rs.next()) {
                return this.setUsuario(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public Usuario getById(int idUsuario){
        PreparedStatement st;
        ResultSet rs;
        
        try{
            
            st = conexao.getConexao().prepareStatement("select * from usuario "
                    + " where id = ? ");
            st.setInt(1, idUsuario);
            
            rs = st.executeQuery();
            if(rs.next()){
                return this.setUsuario(rs);
            }
            
            
        }catch(SQLException ex){
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
    public Usuario save(Usuario usuario) {
        PreparedStatement ps;
        ResultSet rs;
        int i = 1;
                
        try {
            ps = conexao.getConexao().prepareStatement("INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(i++, usuario.getNome());
            ps.setString(i++, usuario.getLogin());
            ps.setString(i++, usuario.getSenha());
            ps.execute();
            
            rs = ps.getGeneratedKeys();
            
            if(rs.next()) {
                usuario.setId(rs.getInt(1));
                return usuario;
            }
            
            
        } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void update(){
        
    }
    
    
    public void delete(){
        
    }
    
    private Usuario setUsuario(ResultSet rs) throws SQLException {
         Usuario usuario = new Usuario();
         usuario.setId(rs.getInt("id"));
         usuario.setLogin(rs.getString("login"));
         //filme.setLogin(rs.getString("genero_idgenero"));
         usuario.setNome(rs.getString("nome"));
         usuario.setSenha(rs.getString("senha"));
         return usuario;
    }
    
   
        
}
