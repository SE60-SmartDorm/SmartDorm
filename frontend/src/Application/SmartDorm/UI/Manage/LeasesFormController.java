package Application.SmartDorm.UI.Manage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Collections;

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

    @FXML
    private JFXButton autoFillData;

    public JFXButton getAutoFillData() {
        return autoFillData;
    }

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
        checkValidate();
    }

    private void checkValidate() {
        nameLeasesTF.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (nameLeasesTF.getText() == null || nameLeasesTF.getText().trim().isEmpty()) {
                    if (!nameLeasesTF.getStyleClass().contains("invalidate-field")) {
                        nameLeasesTF.getStyleClass().add("invalidate-field");
                    }
                } else {
                    nameLeasesTF.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                }
            }
        }));

        phoneLeasesTF.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (phoneLeasesTF.getText() == null || phoneLeasesTF.getText().trim().isEmpty()) {
                    if (!phoneLeasesTF.getStyleClass().contains("invalidate-field")) {
                        phoneLeasesTF.getStyleClass().add("invalidate-field");
                    }
                } else {
                    phoneLeasesTF.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                }
            }
        }));

        idCardLeasesTF.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (idCardLeasesTF.getText() == null || idCardLeasesTF.getText().trim().isEmpty()) {
                    if (!idCardLeasesTF.getStyleClass().contains("invalidate-field")) {
                        idCardLeasesTF.getStyleClass().add("invalidate-field");
                    }
                } else {
                    idCardLeasesTF.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                }
            }
        }));

        depositTF.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (depositTF.getText() == null || depositTF.getText().trim().isEmpty()) {
                    if (!depositTF.getStyleClass().contains("invalidate-field")) {
                        depositTF.getStyleClass().add("invalidate-field");
                    }
                } else {
                    depositTF.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                }
            }
        }));

        startLeasesDP.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (startLeasesDP.getValue() == null) {
                    if (!startLeasesDP.getStyleClass().contains("invalidate-datePicker")) {
                        startLeasesDP.getStyleClass().add("invalidate-datePicker");
                    }
                } else {
                    startLeasesDP.getStyleClass().removeAll(Collections.singleton("invalidate-datePicker"));
                }
            }
        });

        endLeasesDP.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (endLeasesDP.getValue() == null) {
                    if (!endLeasesDP.getStyleClass().contains("invalidate-datePicker")) {
                        endLeasesDP.getStyleClass().add("invalidate-datePicker");
                    }
                } else {
                    endLeasesDP.getStyleClass().removeAll(Collections.singleton("invalidate-datePicker"));
                }
            }
        });
    }

}
