package Entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by max on 30.07.16.
 */
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "publication_time")
    private LocalDateTime publicationTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Animal postOwner;
    @ManyToMany
    @JoinTable(
            name = "likes",
            joinColumns = @JoinColumn(name = "post"),
            inverseJoinColumns = @JoinColumn(name = "owner")
    )
    private Set<Animal> likesOwners;

    public Set<Animal> getLikesOwners() {
        return likesOwners;
    }

    public void setLikesOwners(Set<Animal> likesOwners) {
        this.likesOwners = likesOwners;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublicationTime(LocalDateTime publicationTime) {
        this.publicationTime = publicationTime;
    }

    public void setPostOwner(Animal postOwner) {
        this.postOwner = postOwner;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublicationTime() {
        return publicationTime;
    }

    public Animal getPostOwner() {
        return postOwner;
    }
}

