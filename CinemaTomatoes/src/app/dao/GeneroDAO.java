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
import app.models.Genero;

public class GeneroDAO implements GenericDAO<Genero>{
    
    private final Conexao conexao = new Conexao();
    

    @Override
    public Genero getById(int idGenero){
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            
            ps = conexao.getConexao().prepareStatement("select * from genero "
                    + " where id = ? ");
            ps.setInt(1, idGenero);
            
            rs = ps.executeQuery();
            if(rs.next()){
               return this.setGenero(rs);
            }
            
        }catch(SQLException ex){
             Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    

    
    @Override
    public LinkedList getAll() {
        PreparedStatement st;
        ResultSet rs;
        LinkedList lista = new LinkedList();

        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM genero");
            rs = st.executeQuery();

            while (rs.next()) {
                lista.add(this.setGenero(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    @Override
    public Genero save(Genero genero){
        PreparedStatement st;
        ResultSet rs;
        int i = 1 ; 
        try{
            st = conexao.getConexao().prepareStatement("insert into genero (descricao) "
                    + "values (?)", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, genero.getDescricao());
            
            
            st.execute();
            st.getGeneratedKeys();
            rs = st.getGeneratedKeys();
            if(rs.next()){
                genero.setId(rs.getInt(1));
            }
            
        }catch(SQLException ex){
             Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.getById(genero.getId());
    }
    
    
    @Override
    public Genero update(Genero genero){
        PreparedStatement st;
        int i = 1; 
        try {
            st = conexao.getConexao().prepareStatement("UPDATE genero SET "
                    + "descricao = ? WHERE id = ?");
            st.setString(++i, genero.getDescricao());
            st.setInt(++i, genero.getId());

            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.getById(genero.getId());
    }

    
    @Override
    public void delete(int id){
        PreparedStatement st;
        int i = 1; 
        try {
            st = conexao.getConexao().prepareStatement("DELETE genero"
                    + " WHERE id = ?");
            st.setInt(++i, id);
            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private Genero setGenero(ResultSet rs) throws SQLException {
         Genero genero = new Genero();
         genero.setId(rs.getInt("id"));
         genero.setDescricao(rs.getString("descricao"));
         return genero;
    }

        
        
}
