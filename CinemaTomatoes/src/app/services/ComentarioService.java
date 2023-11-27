package app.services;

import app.dao.ComentarioDAO;
import app.models.Comentario;
import java.util.LinkedList;

public class ComentarioService {
    
    private final ComentarioDAO dao = new ComentarioDAO();
    
    public Comentario getbyId(int id){
        return dao.getById(id);
    }
    
    public LinkedList getAll(){
        return dao.getAll();
    }
    
    public LinkedList getAllById(int id){
        return dao.getAllById(id);
    }
    
    public Comentario save(Comentario comentario){
        return dao.save(comentario);
    }
    
    public Comentario update(Comentario comentario){
        return dao.update(comentario);
    }
    
    public void delete(int id){
        dao.delete(id);
    }
}
