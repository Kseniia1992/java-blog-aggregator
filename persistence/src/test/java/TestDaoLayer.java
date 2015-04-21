import cz.jiripinkas.jba.dao.BlogDao;
import cz.jiripinkas.jba.dao.ItemDao;
import cz.jiripinkas.jba.dao.RoleDao;
import cz.jiripinkas.jba.dao.UzerDao;
import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.Item;
import cz.jiripinkas.jba.entity.Role;
import cz.jiripinkas.jba.entity.Uzer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

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
public class TestDaoLayer {

    @Autowired
    private UzerDao uzerDao;

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private RoleDao roleDao;

    @Before
    public void init(){
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleDao.create(roleAdmin);

        Uzer userAdmin = new Uzer();
        userAdmin.setName("User");
        List<Role> roles1 = new ArrayList<Role>();
        roles1.add(roleAdmin);
        userAdmin.setRoles(roles1);
        uzerDao.create(userAdmin);

        Blog blog1 = new Blog();
        blog1.setName("JavaVids");
        blog1.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blog1.setUzer(userAdmin);
        blogDao.create(blog1);

        Item item1 = new Item();
        item1.setBlog(blog1);
        item1.setTitle("first");
        item1.setLink("http://wwww.javavids.com");
        item1.setPublishedDate(new Date());
        itemDao.create(item1);
    }

    @Test
    public void testGetAll(){
        List<Uzer> uzerList = uzerDao.getAll();
        assertNotNull(uzerList);
        Uzer uzer = uzerList.get(uzerList.size()-1);
        assertEquals(uzer.getName(),"User");

        List<Role> roleList = roleDao.getAll();
        assertEquals(roleList.get(roleList.size()-1).getName(),"ROLE_ADMIN");

        List<Blog> blogList = blogDao.getAll();
        assertNotNull(blogList);
        Blog blog = blogList.get(blogList.size()-1);
        assertEquals(blog.getName(),"JavaVids");
        assertEquals(blog.getUzer().getName(),"User");
        assertNotNull(blog.getItems());

        List<Item> itemList = itemDao.getAll();
        assertNotNull(itemList);
        Item item = itemList.get(itemList.size()-1);
        assertEquals(item.getTitle(),"first");
        assertEquals(item.getBlog().getName(),"JavaVids");
    }

    @Test
    public void testGetById(){
        assertNotNull(uzerDao.getById(1L));
        assertNotNull(blogDao.getById(1L));
        assertNotNull(roleDao.getById(1L));
        assertNotNull(itemDao.getById(1L));
    }

}
