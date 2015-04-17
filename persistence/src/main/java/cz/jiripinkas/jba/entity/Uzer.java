package cz.jiripinkas.jba.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ksolodovnik
 */

@Entity
public class Uzer implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    private String password;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable
    private List<Role> roles;

    @OneToMany(mappedBy = "uzer", cascade = {CascadeType.ALL})
    private List<Blog> blogs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
