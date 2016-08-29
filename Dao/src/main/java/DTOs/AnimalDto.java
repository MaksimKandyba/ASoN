package DTOs;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by max on 02.08.16.
 */
public class AnimalDto {
    private Long id;
    private String name;
    private LocalDate birthday;
    private List<MessageDto> incoming;
    private List<MessageDto> outgoing;
    private List<PostDto> posts;
    private Set<PlaceDto> places;
    private Set<HobbyDto> hobbies;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public List<MessageDto> getIncoming() {
        return incoming;
    }

    public void setIncoming(List<MessageDto> incoming) {
        this.incoming = incoming;
    }

    public List<MessageDto> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(List<MessageDto> outgoing) {
        this.outgoing = outgoing;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }

    public Set<PlaceDto> getPlaces() {
        return places;
    }

    public void setPlaces(Set<PlaceDto> places) {
        this.places = places;
    }

    public Set<HobbyDto> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<HobbyDto> hobbies) {
        this.hobbies = hobbies;
    }
}
