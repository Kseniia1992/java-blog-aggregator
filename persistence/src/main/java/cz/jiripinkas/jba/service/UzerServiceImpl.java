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
    public void createUzer(Uzer uzer) {
        uzerDao.create(uzer);
    }

    @Override
    public List<Uzer> getAllUzers() {
        uzerDao.create(Init.initUzer1());
        uzerDao.create(Init.initUzer2());
        return uzerDao.getAll();
    }

    @Override
    public Uzer getUzerById(long id) {
        return uzerDao.getById(id);
    }


}
