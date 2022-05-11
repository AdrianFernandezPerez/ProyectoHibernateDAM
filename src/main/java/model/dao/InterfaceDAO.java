package model.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
    void create(T t) throws SQLException;
    List<T> findAll();
    T find(int id);
    void update(T t);
    void delete(int id);
}
