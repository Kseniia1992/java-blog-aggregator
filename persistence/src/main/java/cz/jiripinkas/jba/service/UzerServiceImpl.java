package cz.jiripinkas.jba.service;

import cz.jiripinkas.jba.dao.UzerDao;
import cz.jiripinkas.jba.entity.Uzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ksolodovnik
 */
@Service("uzerService")
public class UzerServiceImpl implements UzerService{

    @Autowired
    private UzerDao uzerDao;

    @Override
    /**
     * Creates user in the db
     */
    public void createUzer(Uzer uzer) {
        uzerDao.create(uzer);
    }

    @Override
    /**
     * Gets all users
     */
    public List<Uzer> getAllUzers() {
        return uzerDao.getAll();
    }

    @Override
    /**
     * Gets user by id
     */
    public Uzer getUzerById(long id) {
        return uzerDao.getById(id);
    }

}
