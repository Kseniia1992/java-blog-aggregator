package cz.jiripinkas.jba.service;

import cz.jiripinkas.jba.entity.Uzer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ksolodovnik
 */
@Transactional
public interface UzerService {

    void createUzer(Uzer uzer);
    List<Uzer> getAllUzers();
    Uzer getUzerById(long id);

}
