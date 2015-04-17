package cz.jiripinkas.jba.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ksolodovnik
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private static final String QUERY_SELECT_ALL = "SELECT x FROM %s x";

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> type;

    public GenericDaoImpl() {
 /*       Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];*/
    }

    @Override
    public void create(final T t){
        this.sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public List<T> getAll(){
        List<T> list = sessionFactory.getCurrentSession().createQuery("select from").list();
        return list;
    }
}
