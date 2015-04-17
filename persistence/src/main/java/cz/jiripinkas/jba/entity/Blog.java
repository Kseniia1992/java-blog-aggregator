package cz.jiripinkas.jba.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author ksolodovnik
 */

@Entity
public class Blog {

    @Id
    @GeneratedValue
    private long id;

    private String url;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Uzer uzer;

    @OneToMany(mappedBy = "blog", cascade = {CascadeType.ALL})
    private List<Item> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Uzer getUzer() {
        return uzer;
    }

    public void setUzer(Uzer uzer) {
        this.uzer = uzer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
