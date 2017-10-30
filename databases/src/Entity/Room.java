package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private int type;
    private boolean vacant;

    public Room(long id, int type, boolean vacant) {
        this.id = id;
        this.type = type;
        this.vacant = vacant;
    }

    public long getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public boolean isVacant() {
        return vacant;
    }

    @Override
    public String toString() {
        String res = "Entity.Room ";
        res += "ID: " + this.id + " ";
        res += "Type: " + this.type + " ";
        res += "Vacant: " + this.vacant;

        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Room) {
            boolean id = this.id == ((Room) obj).id;
            boolean tp = this.type == ((Room) obj).type;
            boolean vc = this.vacant == ((Room) obj).vacant;

            return (id && tp && vc);
        }
        return false;
    }
}