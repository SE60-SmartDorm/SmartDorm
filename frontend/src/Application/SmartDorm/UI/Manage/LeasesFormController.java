package Application.SmartDorm.UI.Manage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //other
    private boolean leasesinV1, leasesinV2, leasesinV3, leasesinV4, leasesinV5, leasesinV6;

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
    @FXML
    public void initialize() {
        //TODO check valid
        checkValidate();
    }

    private void checkValidate() {
        leasesinV1 = leasesinV2 = leasesinV3 = leasesinV4 = leasesinV5 = leasesinV6 = false;
        nameLeasesTF.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (nameLeasesTF.getText() == null || nameLeasesTF.getText().trim().isEmpty()) {
                    if (!nameLeasesTF.getStyleClass().contains("invalidate-field")) {
                        nameLeasesTF.getStyleClass().add("invalidate-field");
                        leasesinV1 = false;
                    }
                } else {
                    nameLeasesTF.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    leasesinV1 = true;
                }
            }
        }));

        phoneLeasesTF.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (phoneLeasesTF.getText() == null || phoneLeasesTF.getText().trim().isEmpty()) {
                    if (!phoneLeasesTF.getStyleClass().contains("invalidate-field")) {
                        phoneLeasesTF.getStyleClass().add("invalidate-field");
                        leasesinV2 = false;
                    }
                } else {
                    phoneLeasesTF.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    leasesinV2 = true;
                }
            }
        }));

        idCardLeasesTF.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (idCardLeasesTF.getText() == null || idCardLeasesTF.getText().trim().isEmpty() || !checkProfessionalID(idCardLeasesTF.getText())) {
                    if (!idCardLeasesTF.getStyleClass().contains("invalidate-field")) {
                        idCardLeasesTF.getStyleClass().add("invalidate-field");
                        leasesinV3 = false;
                    }
                } else {
                    idCardLeasesTF.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    leasesinV3 = true;
                }
            }
        }));

        depositTF.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (depositTF.getText() == null || depositTF.getText().trim().isEmpty() || !checkMoneyInput(depositTF.getText())) {
                    if (!depositTF.getStyleClass().contains("invalidate-field")) {
                        depositTF.getStyleClass().add("invalidate-field");
                        leasesinV4 = false;
                    }
                } else {
                    depositTF.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    leasesinV4 = true;
                }
            }
        }));

        startLeasesDP.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (startLeasesDP.getValue() == null) {
                    if (!startLeasesDP.getStyleClass().contains("invalidate-datePicker")) {
                        startLeasesDP.getStyleClass().add("invalidate-datePicker");
                        leasesinV5 = false;
                    }
                } else {
                    startLeasesDP.getStyleClass().removeAll(Collections.singleton("invalidate-datePicker"));
                    leasesinV5 = true;
                }
            }
        });

        endLeasesDP.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (endLeasesDP.getValue() == null) {
                    if (!endLeasesDP.getStyleClass().contains("invalidate-datePicker")) {
                        endLeasesDP.getStyleClass().add("invalidate-datePicker");
                        leasesinV6 = false;
                    }
                } else {
                    endLeasesDP.getStyleClass().removeAll(Collections.singleton("invalidate-datePicker"));
                    leasesinV6 = true;
                }
            }
        });
    }

    private boolean checkProfessionalID(String id) {
        int sum, i;
        if (id.length() != 13) return false;

        for (i = 0, sum = 0; i < 12; i++) sum += Integer.parseInt(String.valueOf(id.charAt(i))) * (13 - i);

        System.out.println(sum);
        System.out.println((11 - sum % 11) % 10);
        if ((11 - sum % 11) % 10 != Integer.parseInt(String.valueOf(id.charAt(12)))) return false;

        return true;
    }

    private boolean checkMoneyInput(String money) {
        final Pattern moneyPattern = Pattern.compile("\\d+");
        final Matcher match = moneyPattern.matcher(money);
        if (match.find() && match.group().equals(money)) return true;
        return false;
    }

    public boolean checkBeforeSubmitLeases() {
        return leasesinV1 && leasesinV2 && leasesinV3 && leasesinV4 && leasesinV5 && leasesinV6;
    }

}
