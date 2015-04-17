package cz.jiripinkas.jba.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

/**
 * @author ksolodovnik
 */

@Entity
public class Role implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Uzer> uzers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Uzer> getUzers() {
        return uzers;
    }

    public void setUzers(List<Uzer> uzers) {
        this.uzers = uzers;
    }
}
