package DTOs;

import java.time.LocalDateTime;

/**
 * Created by max on 02.08.16.
 */
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime publicationTime;
    private Long postOwnerId;
    private Integer likesCounter;

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

    public Long getId() {
        return id;
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

    public void setPostOwnerId(Long postOwnerId) {
        this.postOwnerId = postOwnerId;
    }

    public Long getPostOwnerId() {
        return postOwnerId;
    }

    public Integer getLikesCounter() {
        return likesCounter;
    }

    public void setLikesCounter(Integer likesCounter) {
        this.likesCounter = likesCounter;
    }
}
