package Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by max on 30.07.16.
 */
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private LocalDate birthday;
    @OneToMany(mappedBy = "addressee")
    private List<Message> incoming;
    @OneToMany(mappedBy = "sender")
    private List<Message> outgoing;
    @OneToMany(mappedBy = "postOwner")
    private List<Post> posts;
    @ManyToMany(mappedBy = "likesOwners")
    private Set<Post> likedPosts;
    @ManyToMany(mappedBy = "visitors")
    private Set<Place> places;
    @ManyToMany(mappedBy = "holidaymakers")
    private Set<Hobby> hobbies;
    @ManyToMany
    @JoinTable(
            name = "friendship",
            joinColumns = @JoinColumn(name = "friend_1"),
            inverseJoinColumns = @JoinColumn(name = "friend_2")
    )
    private Set<Animal> friends;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public List<Message> getIncoming() {
        return incoming;
    }

    public void setIncoming(List<Message> incoming) {
        this.incoming = incoming;
    }

    public List<Message> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(List<Message> outgoing) {
        this.outgoing = outgoing;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(Set<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public Set<Animal> getFriends() {
        return friends;
    }

    public void setFriends(Set<Animal> friends) {
        this.friends = friends;
    }
}
