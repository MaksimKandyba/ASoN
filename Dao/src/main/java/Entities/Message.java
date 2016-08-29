package Entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by max on 30.07.16.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "sending_off_time")
    private LocalDateTime sendingOffTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender")
    private Animal sender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressee")
    private Animal addressee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSendingOffTime(LocalDateTime sendingOffTime) {
        this.sendingOffTime = sendingOffTime;
    }

    public void setSender(Animal sender) {
        this.sender = sender;
    }

    public void setAddressee(Animal addressee) {
        this.addressee = addressee;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getSendingOffTime() {
        return sendingOffTime;
    }

    public Animal getSender() {
        return sender;
    }

    public Animal getAddressee() {
        return addressee;
    }
}
