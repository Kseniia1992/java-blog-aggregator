package cz.jiripinkas.jba.util;

import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.Item;
import cz.jiripinkas.jba.entity.Role;
import cz.jiripinkas.jba.entity.Uzer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ksolodovnik
 */
public class Initializator {

    public static Uzer initUzer(){
        Uzer uzer = new Uzer();
        List<Role> roles = new ArrayList<>();
        List<Blog> blogs = new ArrayList<>();
        roles.add(Initializator.initRoleAdmin());
        roles.add(Initializator.initRoleUser());
        blogs.add(Initializator.initBlog());
        uzer.setName("Admin");
        uzer.setRoles(roles);
        uzer.setBlogs(blogs);
        return uzer;
    }

    public static Role initRoleAdmin(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return role;
    }

    public static Role initRoleUser(){
        Role role = new Role();
        role.setName("ROLE_USER");
        return role;
    }

    public static Blog initBlog(){
        Blog blog = new Blog();
        List<Item> items = new ArrayList<>();
        items.add(Initializator.initItem());
        blog.setName("JavaVids");
        blog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blog.setItems(items);
        return blog;
    }

    public static Item initItem(){
        Item item = new Item();
        item.setTitle("first");
        item.setLink("http://wwww.javavids.com");
        item.setPublishedDate(new Date());
        return item;
    }

}
