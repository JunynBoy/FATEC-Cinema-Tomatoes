package app.services;

import app.dao.GeneroDAO;
import app.models.Genero;
import java.util.LinkedList;

public class GeneroService {
    
    private final GeneroDAO dao = new GeneroDAO();
    
    public Genero getbyId(int id){
        return dao.getById(id);
    }
    
    public LinkedList getAll(){
        return dao.getAll();
    }
    
    public Genero save(Genero genero){
        return dao.save(genero);
    }
    
    public Genero update(Genero genero){
        return dao.save(genero);
    }
    
    public void delete(int id){
        dao.delete(id);
    }
}
