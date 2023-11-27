package app.services;

import app.dao.UsuarioDAO;
import app.models.Usuario;

public class UsuarioService {
    
    private final UsuarioDAO dao = new UsuarioDAO();
    
    
    public Usuario getbyLogin(String login) {
        Usuario usuario = dao.getByLogin(login);

        if (usuario == null) {
            return null;
        }

        return usuario;
    }
    
    public Usuario getbyId(int id){
        Usuario usuario = dao.getById(id);
        
        if (usuario == null) {
            return null;
        }

        return usuario;
        
    }
    
    public Usuario save(Usuario usuario){
        return dao.save(usuario);
    }
    

}
