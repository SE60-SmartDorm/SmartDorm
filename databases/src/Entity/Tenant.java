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

    private String type;
    private long roomId;
    private String name, nickname;
    private String dob;
    private String citizenId;
    private String phone;
    private String email;
    private String address;
    private String emergency_ppl, emergency_relation, emergency_telephone;
    private String school, faculty;
    private String position;
    private String year;

    public Tenant(long roomId, String name, String nickname, String dob, String citizenId, String phone, String email, String address, String emergency_ppl, String emergency_relation, String emergency_telephone, String type, String school, String faculty, String position, String year) {
        this.type = type;
        this.roomId = roomId;
        this.name = name;
        this.nickname = nickname;
        this.dob = dob;
        this.citizenId = citizenId;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.emergency_ppl = emergency_ppl;
        this.emergency_relation = emergency_relation;
        this.emergency_telephone = emergency_telephone;
        this.school = school;
        this.faculty = faculty;
        this.position = position;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public long getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getDob() {
        return dob;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getEmergency_ppl() {
        return emergency_ppl;
    }

    public String getEmergency_relation() {
        return emergency_relation;
    }

    public String getEmergency_telephone() {
        return emergency_telephone;
    }

    public String getSchool() {
        return school;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getPosition() {
        return position;
    }

    public String getYear() {
        return year;
    }

}