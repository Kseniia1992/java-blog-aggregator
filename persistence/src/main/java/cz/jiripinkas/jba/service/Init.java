package cz.jiripinkas.jba.service;

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
public class Init {
    public static Uzer initUzer1(){
        Uzer uzer = new Uzer();
        List<Role> roles = new ArrayList<>();
        List<Blog> blogs = new ArrayList<>();
        roles.add(Init.initRoleAdmin());
        roles.add(Init.initRoleUser());
        blogs.add(Init.initBlog1());
        uzer.setName("Admin");
        uzer.setRoles(roles);
        uzer.setBlogs(blogs);
        return uzer;
    }

    public static Uzer initUzer2(){
        Uzer uzer = new Uzer();
        List<Role> roles = new ArrayList<>();
        List<Blog> blogs = new ArrayList<>();
        roles.add(Init.initRoleUser());
        blogs.add(Init.initBlog2());
        uzer.setName("Ksu");
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

    public static Blog initBlog1(){
        Blog blog = new Blog();
        List<Item> items = new ArrayList<>();
        items.add(Init.initItem1());
        blog.setName("JavaVids");
        blog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blog.setItems(items);
        return blog;
    }

    public static Blog initBlog2(){
        Blog blog = new Blog();
        List<Item> items = new ArrayList<>();
        items.add(Init.initItem2());
        blog.setName("Java");
        blog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blog.setItems(items);
        return blog;
    }

    public static Item initItem1(){
        Item item = new Item();
        item.setTitle("first");
        item.setLink("http://wwww.javavids.com");
        item.setPublishedDate(new Date());
        return item;
    }

    public static Item initItem2(){
        Item item = new Item();
        item.setTitle("second");
        item.setLink("http://wwww.javavids.com");
        item.setPublishedDate(new Date());
        return item;
    }
}
