package Application.SmartDorm.UI.Manage;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Sample People model for test
 *
 * @author EIEI ZA
 */

public class TenantTable extends RecursiveTreeObject<TenantTable> {
    private StringProperty room, status, name, startDate, endDate;

    public TenantTable(String room, String status, String name, String sartDate, String endDate) {
        this.room = new SimpleStringProperty(room);
        this.status = new SimpleStringProperty(status);
        this.name = new SimpleStringProperty(name);
        this.startDate = new SimpleStringProperty(sartDate);
        this.endDate = new SimpleStringProperty(endDate);
    }

    public String getRoom() {
        return room.get();
    }

    public void setRoom(String room) {
        this.room.set(room);
    }

    public StringProperty roomProperty() {
        return room;
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public StringProperty statusProperty() {
        return status;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getStartDate() {
        return startDate.get();
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }

    public StringProperty startDateProperty() {
        return startDate;
    }

    public String getEndDate() {
        return endDate.get();
    }

    public void setEndDate(String endDate) {
        this.endDate.set(endDate);
    }

    public StringProperty endDateProperty() {
        return endDate;
    }
}
