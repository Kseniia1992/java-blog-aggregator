package cz.jiripinkas.jba.dao;

import cz.jiripinkas.jba.entity.Uzer;
import org.springframework.stereotype.Component;

/**
 * @author ksolodovnik
 */
@Component("uzerDao")
public class UzerDaoImpl extends GenericDaoImpl<Uzer> implements UzerDao {}
