package Application.SmartDorm.UI.OwnerNotification;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NoitificationDataTable extends RecursiveTreeObject<NoitificationDataTable> {
    private StringProperty roomCol,statusCol,nameCol,contractSCol, dateCol;

    public NoitificationDataTable(String roomCol, String statusCol, String nameCol, String contractSCol, String dateCol) {
        this.roomCol = new SimpleStringProperty(roomCol);
        this.statusCol = new SimpleStringProperty(statusCol);
        this.nameCol = new SimpleStringProperty(nameCol);
        this.contractSCol = new SimpleStringProperty(contractSCol);
        this.dateCol = new SimpleStringProperty(dateCol);
    }

    public String getRoomCol() {
        return roomCol.get();
    }

    public StringProperty roomColProperty() {
        return roomCol;
    }

    public void setRoomCol(String roomCol) {
        this.roomCol.set(roomCol);
    }

    public String getStatusCol() {
        return statusCol.get();
    }

    public StringProperty statusColProperty() {
        return statusCol;
    }

    public void setStatusCol(String statusCol) {
        this.statusCol.set(statusCol);
    }

    public String getNameCol() {
        return nameCol.get();
    }

    public StringProperty nameColProperty() {
        return nameCol;
    }

    public void setNameCol(String nameCol) {
        this.nameCol.set(nameCol);
    }

    public String getContractSCol() {
        return contractSCol.get();
    }

    public StringProperty contractSColProperty() {
        return contractSCol;
    }

    public void setContractSCol(String contractSCol) {
        this.contractSCol.set(contractSCol);
    }

    public String getDateCol() {
        return dateCol.get();
    }

    public StringProperty dateColProperty() {
        return dateCol;
    }

    public void setDateCol(String dateCol) {
        this.dateCol.set(dateCol);
    }
}
