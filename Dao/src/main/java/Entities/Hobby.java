package Entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by max on 30.07.16.
 */
@Entity
@Table(name = "hobbies")
public class Hobby {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToMany
    @JoinTable(
            name = "leisure",
            joinColumns = @JoinColumn(name = "hobby"),
            inverseJoinColumns = @JoinColumn(name = "holidaymaker")
    )
    private Set<Animal> holidaymakers;

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

    public Set<Animal> getHolidaymakers() {
        return holidaymakers;
    }

    public void setHolidaymakers(Set<Animal> holidaymakers) {
        this.holidaymakers = holidaymakers;
    }
}
