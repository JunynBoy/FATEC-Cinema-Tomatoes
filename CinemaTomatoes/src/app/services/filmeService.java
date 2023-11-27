package app.services;

import app.dao.FilmeDAO;
import app.models.Filme;
import java.util.LinkedList;

public class FilmeService {
    
    private final FilmeDAO dao = new FilmeDAO();
    
    public Filme getbyId(int id){
        return dao.getById(id);
    }
    
    public Filme getbyName(int id){
        return dao.getById(id);
    }
    
    
    public LinkedList getAll(){
        return dao.getAll();
    }
    
    public Filme save(Filme filme){
        return dao.save(filme);
    }
    
    public Filme update(Filme filme){
        return dao.update(filme);
    }
    
    public void delete(int id){
            dao.delete(id);
    }
}
