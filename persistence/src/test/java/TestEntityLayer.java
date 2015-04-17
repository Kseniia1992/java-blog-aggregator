import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.Item;
import cz.jiripinkas.jba.entity.Role;
import cz.jiripinkas.jba.entity.Uzer;
import cz.jiripinkas.jba.util.CreateSessionFact;
import cz.jiripinkas.jba.util.Initializator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author ksolodovnik
 */
public class TestEntityLayer {

   private static Session session;
   private static Transaction transaction = null;

    @BeforeClass
    public static void openSession(){
        session = CreateSessionFact.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(Initializator.initUzer());
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Test
    public void testUzer(){
        List<Uzer> uzerList = session.createCriteria(Uzer.class).list();
        Uzer uzer = uzerList.get(0);
        assertTrue(uzer.getId() == 1);
        assertTrue(uzer.getName() == "Admin");
    }

    @Test
    public void testRole(){
        List<Role> roleList = session.createCriteria(Role.class).list();
        Role role = roleList.get(1);
        assertTrue(role.getName() == "ROLE_USER");
        role = roleList.get(0);
        assertTrue(role.getName() == "ROLE_ADMIN");
    }

    @Test
    public void testBlog(){
        List<Blog> blogList = session.createCriteria(Blog.class).list();
        Blog blog = blogList.get(0);
        assertTrue(blog.getName() == "JavaVids");
        assertTrue(blog.getUrl() == "http://feeds.feedburner.com/javavids?format=xml");
    }

    @Test
    public void testItem(){
        List<Item> itemList = session.createCriteria(Item.class).list();
        Item item = itemList.get(0);
        assertTrue(item.getTitle() == "first");
        assertTrue(item.getLink() == "http://wwww.javavids.com");
    }

    @AfterClass
    public static void closeSession(){
        CreateSessionFact.closeSesFact();
    }

}
