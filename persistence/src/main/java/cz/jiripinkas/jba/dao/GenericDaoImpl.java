package cz.jiripinkas.jba.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ksolodovnik
 */
@Transactional
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> type;

    /**
     * This constructor defines the type of class by using reflection
     */
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    /**
     * Creates entity in db
     */
    public void create(T t){
        this.sessionFactory.getCurrentSession().save(t);
    }

    @Override
    /**
     * Gets all recording from table
     */
    public List<T> getAll(){
        List<T> list = sessionFactory.getCurrentSession().createCriteria(type).list();
        return list;
    }

   @Override
   /**
    * Gets by id
    */
    public T getById(long id){
        return (T) this.sessionFactory.getCurrentSession().get(type,id);
  //   T t = (T) sessionFactory.getCurrentSession().createCriteria(type)
//                .add(Restrictions.eq("id",id)).setFetchMode("", FetchMode.JOIN);

    }
}
