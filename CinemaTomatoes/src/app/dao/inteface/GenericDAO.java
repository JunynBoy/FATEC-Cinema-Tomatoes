package app.dao.inteface;

import java.util.List;

public interface GenericDAO<T> {
    
    
    T getById(int id);
    List<T> getAll();
    T save(T object);
    T update(T object);
    void delete(int id);
    
}

