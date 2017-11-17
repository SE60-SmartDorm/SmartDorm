package Application.SmartDorm.UI.Manage;

import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LeasesFormController {
    @FXML
    private TextField nameLeasesTF;

    @FXML
    private TextField phoneLeasesTF;

    @FXML
    private TextArea addressLeasesTF;

    @FXML
    private TextField idCardLeasesTF;

    @FXML
    private JFXDatePicker startLeasesDP;

    @FXML
    private JFXDatePicker endLeasesDP;

    @FXML
    private TextField depositTF;

    @FXML
    private TextArea noteTF;

    public TextField getNameLeasesTF() {
        return nameLeasesTF;
    }

    public void setNameLeasesTF(TextField nameLeasesTF) {
        this.nameLeasesTF = nameLeasesTF;
    }

    public TextField getPhoneLeasesTF() {
        return phoneLeasesTF;
    }

    public void setPhoneLeasesTF(TextField phoneLeasesTF) {
        this.phoneLeasesTF = phoneLeasesTF;
    }

    public TextArea getAddressLeasesTF() {
        return addressLeasesTF;
    }

    public void setAddressLeasesTF(TextArea addressLeasesTF) {
        this.addressLeasesTF = addressLeasesTF;
    }

    public TextField getIdCardLeasesTF() {
        return idCardLeasesTF;
    }

    public void setIdCardLeasesTF(TextField idCardLeasesTF) {
        this.idCardLeasesTF = idCardLeasesTF;
    }

    public JFXDatePicker getStartLeasesDP() {
        return startLeasesDP;
    }

    public void setStartLeasesDP(JFXDatePicker startLeasesDP) {
        this.startLeasesDP = startLeasesDP;
    }

    public JFXDatePicker getEndLeasesDP() {
        return endLeasesDP;
    }

    public void setEndLeasesDP(JFXDatePicker endLeasesDP) {
        this.endLeasesDP = endLeasesDP;
    }

    public TextField getDepositTF() {
        return depositTF;
    }

    public void setDepositTF(TextField depositTF) {
        this.depositTF = depositTF;
    }

    public TextArea getNoteTF() {
        return noteTF;
    }

    public void setNoteTF(TextArea noteTF) {
        this.noteTF = noteTF;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    public void initialize() {
        //TODO check valid
    }
}
