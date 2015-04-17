package cz.jiripinkas.jba.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ksolodovnik
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public void create(T t){
        this.sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public List<T> getAll(){
        List<T> list = sessionFactory.getCurrentSession().createCriteria(type).list();
        return list;
    }

    @Override
    public T getById(long id){
        return (T) this.sessionFactory.getCurrentSession().get(type,id);
    }
}
