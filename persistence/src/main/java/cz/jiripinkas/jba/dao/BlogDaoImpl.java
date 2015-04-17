package cz.jiripinkas.jba.dao;

import cz.jiripinkas.jba.entity.Blog;
import org.springframework.stereotype.Component;

/**
 * @author ksolodovnik
 */
@Component("blogDao")
public class BlogDaoImpl extends GenericDaoImpl<Blog> implements BlogDao {}
