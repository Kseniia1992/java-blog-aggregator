package cz.jiripinkas.jba.dao;

import cz.jiripinkas.jba.entity.Uzer;
import org.springframework.stereotype.Component;

/**
 * @author ksolodovnik
 */
@Component("uzerDao")
public class UzerDaoImpl extends GenericDaoImpl<Uzer> implements UzerDao {
/*
    @Override
    public Uzer getUserById(long id) {
       Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Uzer.class)
                .add(Restrictions.eq("id", id)).setFetchMode("roles", FetchMode.JOIN);
        Uzer uzer = (Uzer) criteria.uniqueResult();*/

  /*     Query query = sessionFactory.getCurrentSession().createQuery("select u from Uzer u join " +
                "fetch u.roles where u.id = :name");

       return uzer;
    }*/
}
