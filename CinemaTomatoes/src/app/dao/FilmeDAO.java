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
import app.models.Filme;
import app.models.Genero;
import app.services.ComentarioService;
import app.services.GeneroService;

public class FilmeDAO implements GenericDAO<Filme>{
    
    private final Conexao conexao = new Conexao();
    private GeneroService generoService = new GeneroService();

    @Override
    public Filme getById(int idFilme){
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            
            ps = conexao.getConexao().prepareStatement("select * from filme "
                    + " where id = ? ");
            ps.setInt(1, idFilme);
            
            rs = ps.executeQuery();
            if(rs.next()){
               return this.setFilme(rs);
            }
            
        }catch(SQLException ex){
             Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public LinkedList getByTitulo(String titulo){
        PreparedStatement ps;
        ResultSet rs;
        LinkedList lista = new LinkedList();
        try{
            
            ps = conexao.getConexao().prepareStatement("select * from filme "
                    + "order by titulo like ? desc");
            ps.setString(1, "%" + titulo + "%");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(this.setFilme(rs));
            }
            
        }catch(SQLException ex){
             Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    

    
    @Override
    public LinkedList getAll() {
        PreparedStatement st;
        ResultSet rs;
        LinkedList lista = new LinkedList();

        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM filme");
            rs = st.executeQuery();

            while (rs.next()) {
                lista.add(this.setFilme(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    

    @Override
    public Filme save(Filme filme){
        PreparedStatement st;
        ResultSet rs;
        int i = 1 ; 
        try{
            st = conexao.getConexao().prepareStatement("insert into filme (titulo, ano, diretor ,pais, genero_id) "
                    + "values (? , ? , ? , ? ,?)", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, filme.getTitulo());
            st.setString(i++, filme.getAno());
            st.setString(i++, filme.getDiretor());
            st.setString(i++, filme.getPais());
            st.setInt(i++, filme.getGenero().getId());
           
            
            st.execute();
            rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                filme.setId(rs.getInt(1));
            }
            
        }catch(SQLException ex){
             Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.getById(filme.getId());
    }
    
    
    @Override
    public Filme update(Filme filme){
        PreparedStatement st;
        ResultSet rs;
        int i = 0; 
        try {
            st = conexao.getConexao().prepareStatement("UPDATE filme SET "
                    + "titulo = ?, ano = ?, diretor = ?, pais = ?, genero_id = ? "
                    + "WHERE id = ? ");
            st.setString(++i, filme.getTitulo());
            st.setString(++i, filme.getAno());  // Use setInt se o ano for um valor numérico
            st.setString(++i, filme.getDiretor());
            st.setString(++i, filme.getPais());
            st.setInt(++i, filme.getGenero().getId());
            st.setInt(++i, filme.getId());

            st.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.getById(filme.getId());
        
    }
    
  
    @Override
    public void delete(int id){
        PreparedStatement st;
        int i = 1; 
        try {
            st = conexao.getConexao().prepareStatement("DELETE filme"
                    + " WHERE id = ?");
            st.setInt(++i, id);
            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private Filme setFilme(ResultSet rs) throws SQLException {
         Filme filme = new Filme();
         filme.setId(rs.getInt("id"));
         filme.setTitulo(rs.getString("titulo"));
         filme.setGenero(generoService.getbyId(rs.getInt("genero_id")));
         filme.setAno(rs.getString("ano"));
         filme.setDiretor(rs.getString("diretor"));
         filme.setPais(rs.getString("pais"));
         return filme;
    }

        
        
}
