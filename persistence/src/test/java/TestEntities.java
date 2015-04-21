import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.Item;
import cz.jiripinkas.jba.entity.Role;
import cz.jiripinkas.jba.entity.Uzer;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author ksolodovnik
 */

@ContextConfiguration(locations = "file:web/src/main/webapp/WEB-INF/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
@Transactional
public class TestEntities {

    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void init(){
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        sessionFactory.getCurrentSession().save(roleAdmin);

        Uzer userAdmin = new Uzer();
        userAdmin.setName("User");
        List<Role> roles1 = new ArrayList<Role>();
        roles1.add(roleAdmin);
        userAdmin.setRoles(roles1);
        sessionFactory.getCurrentSession().save(userAdmin);

        Blog blog1 = new Blog();
        blog1.setName("JavaVids");
        blog1.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blog1.setUzer(userAdmin);
        sessionFactory.getCurrentSession().save(blog1);

        Item item1 = new Item();
        item1.setBlog(blog1);
        item1.setTitle("first");
        item1.setLink("http://wwww.javavids.com");
        item1.setPublishedDate(new Date());
        sessionFactory.getCurrentSession().save(item1);
    }

    @Test
    public void testUzer(){
        List<Uzer> uzerList = sessionFactory.getCurrentSession().createCriteria(Uzer.class).list();
        Uzer uzer = uzerList.get(uzerList.size()-1);
        assertEquals(uzer.getName(), "User");
        assertNotNull(uzer.getRoles());

        List<Role> list = new ArrayList<>();
        list = uzer.getRoles();
        assertEquals(list.get(list.size()-1).getName(),"ROLE_ADMIN");
    }

    @Test
    public void testRole(){
        List<Role> roleList = sessionFactory.getCurrentSession().createCriteria(Role.class).list();
        Role role = roleList.get(roleList.size()-1);
        assertEquals(role.getName(), "ROLE_ADMIN");
    }

    @Test
    public void testBlog(){
        List<Blog> blogList = sessionFactory.getCurrentSession().createCriteria(Blog.class).list();
        Blog blog = blogList.get(blogList.size()-1);
        assertEquals(blog.getName(),"JavaVids");
        assertEquals(blog.getUzer().getName(),"User");
    }

    @Test
    public void testItem() {
        List<Item> itemList = sessionFactory.getCurrentSession().createCriteria(Item.class).list();
        Item item = itemList.get(itemList.size()-1);
        assertEquals(item.getTitle(), "first");
        assertEquals(item.getBlog().getName(), "JavaVids");
        assertEquals(item.getBlog().getUzer().getName(),"User");
    }

}
