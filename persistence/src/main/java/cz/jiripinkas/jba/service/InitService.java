package cz.jiripinkas.jba.service;

import cz.jiripinkas.jba.dao.BlogDao;
import cz.jiripinkas.jba.dao.ItemDao;
import cz.jiripinkas.jba.dao.RoleDao;
import cz.jiripinkas.jba.dao.UzerDao;
import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.Item;
import cz.jiripinkas.jba.entity.Role;
import cz.jiripinkas.jba.entity.Uzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ksolodovnik
 */
@Service
public class InitService {

    @Autowired
    private UzerDao uzerDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private ItemDao itemDao;

    @PostConstruct
    public void init(){
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleDao.create(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleDao.create(roleAdmin);

        Uzer userAdmin = new Uzer();
        userAdmin.setName("Admin");
        List<Role> roles1 = new ArrayList<Role>();
        roles1.add(roleUser);
        roles1.add(roleAdmin);
        userAdmin.setRoles(roles1);
        uzerDao.create(userAdmin);

        Uzer simpleUser = new Uzer();
        simpleUser.setName("Ksu");
        List<Role> roles2 = new ArrayList<Role>();
        roles2.add(roleUser);
        userAdmin.setRoles(roles2);
        uzerDao.create(simpleUser);

        Blog blog1 = new Blog();
        blog1.setName("JavaVids");
        blog1.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blog1.setUzer(userAdmin);
        blogDao.create(blog1);

        Blog blog2 = new Blog();
        blog2.setName("Java");
        blog2.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blog2.setUzer(simpleUser);
        blogDao.create(blog2);

        Item item1 = new Item();
        item1.setBlog(blog1);
        item1.setTitle("first");
        item1.setLink("http://wwww.javavids.com");
        item1.setPublishedDate(new Date());
        itemDao.create(item1);

        Item item2 = new Item();
        item2.setBlog(blog2);
        item2.setTitle("second");
        item2.setLink("http://wwww.javavids.com");
        item2.setPublishedDate(new Date());
        itemDao.create(item2);

        Item item3 = new Item();
        item3.setBlog(blog1);
        item3.setTitle("third");
        item3.setLink("http://wwww.javavids.com");
        item3.setPublishedDate(new Date());
        itemDao.create(item3);
    }
}
