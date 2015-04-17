package cz.jiripinkas.jba.dao;

import java.util.List;

/**
 * @author ksolodovnik
 */
public interface GenericDao<T> {

   public void create(T t);
   public List<T> getAll();
   public T getById(long id);

}
