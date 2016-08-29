package DTOs;

import java.time.LocalDateTime;

/**
 * Created by max on 02.08.16.
 */
public class MessageDto {
    private Long id;
    private String content;
    private LocalDateTime sendingOffTime;
    private String sender;
    private String addressee;

    public void setAddressee(String addressee) {
        this.addressee = addressee;
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

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getSendingOffTime() {
        return sendingOffTime;
    }

    public String getSender() {
        return sender;
    }

    public String getAddressee() {
        return addressee;
    }
}
