/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dao.inteface.GenericDAO;
import app.services.connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import app.models.Comentario;

public class ComentarioDAO implements GenericDAO<Comentario>{
    
    private final Conexao conexao = new Conexao();
    

    @Override
    public Comentario getById(int idGenero){
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            
            ps = conexao.getConexao().prepareStatement("select * from comentario "
                    + " where id = ? ");
            ps.setInt(1, idGenero);
            
            rs = ps.executeQuery();
            if(rs.next()){
               return this.setComentario(rs);
            }
            
        }catch(SQLException ex){
             Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    

    
    @Override
    public LinkedList getAll() {
        PreparedStatement st;
        ResultSet rs;
        LinkedList lista = new LinkedList();

        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM comentario");
            rs = st.executeQuery();

            while (rs.next()) {
                lista.add(this.setComentario(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    @Override
    public Comentario save(Comentario comentario){
        PreparedStatement st;
        ResultSet rs = null;
        int i = 1 ; 
        try{
            st = conexao.getConexao().prepareStatement("insert into comentario (comentario, nota, usuario) "
                    + "values (? , ? , ?)", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, comentario.getComentario());
            st.setDouble(++i, comentario.getNota());
            st.setString(++i, comentario.getUsuario());
            
            st.execute();
            st.getGeneratedKeys();
            
            //realmente necessário?
            if(rs.next()){
                comentario.setId(rs.getInt(1));
            }
            
        }catch(SQLException ex){
             Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.getById(comentario.getId());
    }
    
    
    @Override
    public Comentario update(Comentario comentario){
        PreparedStatement st;
        int i = 1; 
        try {
            st = conexao.getConexao().prepareStatement("UPDATE comentario SET "
                    + "comentario = ?, nota = ?, usuario = ? WHERE id = ?");
            st.setString(++i, comentario.getComentario());
            st.setDouble(++i, comentario.getNota());
            st.setString(++i, comentario.getUsuario());
            
            st.setInt(++i, comentario.getId());

            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.getById(comentario.getId());

    }

    
    @Override
    public void delete(int id){
        PreparedStatement st;
        int i = 1; 
        try {
            st = conexao.getConexao().prepareStatement("DELETE comentario"
                    + " WHERE id = ?");
            st.setInt(++i, id);
            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private Comentario setComentario(ResultSet rs) throws SQLException {
         Comentario comentario = new Comentario();
         comentario.setId(rs.getInt("id"));
         //comentario.setFilme(rs.getInt("filme_id"));
         comentario.setComentario(rs.getString("comentario"));
         comentario.setNota(rs.getDouble("nota"));
         comentario.setUsuario(rs.getString("usuario"));
         return comentario;
    }

        
        
}