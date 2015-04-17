package cz.jiripinkas.jba.dao;

import cz.jiripinkas.jba.entity.Item;
import org.springframework.stereotype.Component;

/**
 * @author ksolodovnik
 */
@Component("itemDao")
public class ItemDaoImpl extends GenericDaoImpl<Item> implements ItemDao{}
