package cz.jiripinkas.jba.dao;

import java.util.List;

/**
 * @author ksolodovnik
 */
public interface GenericDao<T> {

   public void create(T t);

    List<T> getAll();
//   public List<T> getAll();
}
