package modelo.dao;

import java.sql.SQLException;
import java.util.List;

public interface interfaceDao<T> {
    
    // Crear un nuevo registro
    void crear(T entidad)throws SQLException;
    
    // Leer un registro por ID
    T leer(int id)throws SQLException;
    
    // Actualizar un registro
    void actualizar(T entidad) throws SQLException;
    
    // Eliminar un registro por ID
    void eliminar(int id)throws SQLException;
    
    // Listar todos los registros
    List<T> listar()throws SQLException;
}
