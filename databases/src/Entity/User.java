package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "userseq", initialValue = 1, allocationSize = 1000)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private String uid;
    private String password;
    private long tenant_id;

    public User(String uid, String password, long tenant_id) {
        this.uid = uid;
        this.password = password;
        this.tenant_id = tenant_id;
    }

    public long getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public long getTenant_id() {
        return tenant_id;
    }
}