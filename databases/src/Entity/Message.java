package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private long owner_id;
    private String type;
    private String topic;
    private String detail;
    private String timestamp;
    private boolean read;

    public Message(long owner_id, String type, String topic, String detail, String timestamp) {
        this.owner_id = owner_id;
        this.type = type;
        this.topic = topic;
        this.detail = detail;
        this.timestamp = timestamp;
        this.read = false;
    }

    public long getId() {
        return id;
    }

    public long getOwner_id() {
        return owner_id;
    }

    public String getType() {
        return type;
    }

    public String getTopic() {
        return topic;
    }

    public String getDetail() {
        return detail;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public boolean isRead() {
        return read;
    }
}