package cz.jiripinkas.jba.service;

import cz.jiripinkas.jba.entity.Uzer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ksolodovnik
 */
@Transactional
public interface UzerService {

    public void createUzer(Uzer uzer);
    public List<Uzer> getAllUzers();
}
