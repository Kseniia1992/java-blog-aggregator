package cz.jiripinkas.jba.dao;

import java.util.List;

/**
 * @author ksolodovnik
 */
public interface GenericDao<T> {

    void create(T t);
    List<T> getAll();
    T getById(long id);

}
