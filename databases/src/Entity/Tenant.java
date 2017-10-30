package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "userseq", initialValue = 1, allocationSize = 1000)
public class Tenant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private long roomId;
    private String firstname, lastname;
    private long citizenId;
    private String phone;
    private String address;

    public Tenant(long roomId, String firstname, String lastname, long citizenId, String phone, String address) {
        this.roomId = roomId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.citizenId = citizenId;
        this.phone = phone;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public long getRoomId() {
        return roomId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public long getCitizenId() {
        return citizenId;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        String res = "Entity.Tenant ";
        res += "ID: " + this.id + " ";
        res += "RoomID: " + this.roomId + " ";
        res += "FName: " + this.firstname + " ";
        res += "LName: " + this.lastname + " ";
        res += "CID: " + this.citizenId + " ";
        res += "Phone: " + this.phone + " ";
        res += "ADD: " + this.address + " ";

        return res;
    }
}