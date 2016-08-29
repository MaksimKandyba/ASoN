package Entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by max on 30.07.16.
 */
@Entity
@Table(name = "places")
public class Place {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToMany
    @JoinTable(
            name = "visiting",
            joinColumns = @JoinColumn(name = "place"),
            inverseJoinColumns = @JoinColumn(name = "visitor")
    )
    private Set<Animal> visitors;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<Animal> getVisitors() {
        return visitors;
    }

    public void setVisitors(Set<Animal> visitors) {
        this.visitors = visitors;
    }
}
