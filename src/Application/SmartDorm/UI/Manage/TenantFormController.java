package Application.SmartDorm.UI.Manage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TenantFormController {
    public static AnchorPane shareTenanteFormPane;
    public static TenantFormController tenantFormController;
    private static boolean isSelected;
    //set Controller
    TenantStudentInfoController studentInfoController1;
    TenantTeacherInfoController teacherInfoController1;
    TenantStudentInfoController studentInfoController2;
    TenantTeacherInfoController teacherInfoController2;
    private boolean person1inV1, person1inV2, person1inV3, person1inV4, person1inV5;
    private boolean person2inV1, person2inV2, person2inV3, person2inV4, person2inV5;
    //--- people 1 ---
    @FXML
    private VBox showPersonRole1;
    @FXML
    private ComboBox<String> personRoleCB1;
    @FXML
    private ComboBox<String> prefixNameCB1;
    @FXML
    private TextField firstNameTF1;
    @FXML
    private TextField lastNameTF1;
    @FXML
    private TextField nickNameTF1;
    @FXML
    private TextField idCardTF1;
    @FXML
    private JFXDatePicker birthDayDP1;
    @FXML
    private TextField phoneNumberTF1;
    @FXML
    private TextField emailTF1;
    @FXML
    private TextField contractPersonTF1;
    @FXML
    private TextField relationPersonTF1;
    @FXML
    private TextArea addressTF1;

    @FXML
    private Text roleEduT1;

    @FXML
    private TextField roleEduTF1;

    @FXML
    private Text roleFacultyT1;

    @FXML
    private TextField roleFacultyTF1;

    @FXML
    private Text roleGradeT1;

    @FXML
    private TextField studentGradeTF1;
    //--- people 2 ---
    @FXML
    private VBox showPersonRole2;
    @FXML
    private ComboBox<String> personRoleCB2;
    @FXML
    private ComboBox<String> prefixNameCB2;
    @FXML
    private TextField firstNameTF2;
    @FXML
    private TextField lastNameTF2;
    @FXML
    private TextField nickNameTF2;
    @FXML
    private TextField idCardTF2;
    @FXML
    private JFXDatePicker birthDayDP2;
    @FXML
    private TextField phoneNumberTF2;
    @FXML
    private TextField emailTF2;
    @FXML
    private TextField contractPersonTF2;
    @FXML
    private TextField relationPersonTF2;
    @FXML
    private TextArea addressTF2;
    @FXML
    private JFXToggleButton toggleBT;
    @FXML
    private Label toggleLB;
    @FXML
    private JFXButton clearFieldPerson2BT;
    @FXML
    private AnchorPane tenanteFormPane;

    @FXML
    private Text roleEduT2;

    @FXML
    private TextField roleEduTF2;

    @FXML
    private Text roleFacultyT2;

    @FXML
    private TextField roleFacultyTF2;

    @FXML
    private Text roleGradeT2;

    @FXML
    private TextField roleGradeTF2;

    private AnchorPane personRolePane1, personRolePane2;

    /**
     * The constructor (is called before the initialize()-method).
     */
    public TenantFormController() {
    }

    //set Getter and Setter person 1 ------------------------------------------------------------------------------------------
    public TextField getFirstNameTF1() {
        return firstNameTF1;
    }

    public void setFirstNameTF1(TextField firstNameTF1) {
        this.firstNameTF1 = firstNameTF1;
    }

    public ComboBox<String> getPersonRoleCB1() {
        return personRoleCB1;
    }

    public void setPersonRoleCB1(ComboBox<String> personRoleCB1) {
        this.personRoleCB1 = personRoleCB1;
    }

    public ComboBox<String> getPrefixNameCB1() {
        return prefixNameCB1;
    }

    public void setPrefixNameCB1(ComboBox<String> prefixNameCB1) {
        this.prefixNameCB1 = prefixNameCB1;
    }

    public TextField getLastNameTF1() {
        return lastNameTF1;
    }

    public void setLastNameTF1(TextField lastNameTF1) {
        this.lastNameTF1 = lastNameTF1;
    }

    public TextField getNickNameTF1() {
        return nickNameTF1;
    }

    public void setNickNameTF1(TextField nickNameTF1) {
        this.nickNameTF1 = nickNameTF1;
    }

    public TextField getIdCardTF1() {
        return idCardTF1;
    }

    public void setIdCardTF1(TextField idCardTF1) {
        this.idCardTF1 = idCardTF1;
    }

    public JFXDatePicker getBirthDayDP1() {
        return birthDayDP1;
    }

    public void setBirthDayDP1(JFXDatePicker birthDayDP1) {
        this.birthDayDP1 = birthDayDP1;
    }

    public TextField getPhoneNumberTF1() {
        return phoneNumberTF1;
    }

    public void setPhoneNumberTF1(TextField phoneNumberTF1) {
        this.phoneNumberTF1 = phoneNumberTF1;
    }

    public TextField getEmailTF1() {
        return emailTF1;
    }

    public void setEmailTF1(TextField emailTF1) {
        this.emailTF1 = emailTF1;
    }

    public TextField getContractPersonTF1() {
        return contractPersonTF1;
    }

    public void setContractPersonTF1(TextField contractPersonTF1) {
        this.contractPersonTF1 = contractPersonTF1;
    }

    public TextField getRelationPersonTF1() {
        return relationPersonTF1;
    }

    public void setRelationPersonTF1(TextField relationPersonTF1) {
        this.relationPersonTF1 = relationPersonTF1;
    }

    public TextArea getAddressTF1() {
        return addressTF1;
    }

    public void setAddressTF1(TextArea addressTF1) {
        this.addressTF1 = addressTF1;
    }

    public JFXToggleButton getToggleBT() {
        return toggleBT;
    }
    //-----------------------------------------------------------------------------------------------------------------

    //set Getter and Setter person 2 ----------------------------------------------------------------------------------

    public JFXDatePicker getBirthDayDP2() {
        return birthDayDP2;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {

        // ComboBox selection event
        prefixNameCB1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            }
        });

        prefixNameCB2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            }
        });
        //---------------------------------------------------------------------------------------------------------------------

        //---------------------------------------------------------------------------------------------------------------------
        // Init ComboBox items.
        personRoleCB1.getSelectionModel().selectFirst();
        personRoleCB2.getSelectionModel().selectFirst();
//
//        //  Init student form
//        loadPersonPane2("TenantStudentInfo.fxml");
//        showPersonRole2.getChildren().add(personRolePane2);
//
//        //  Init student form
//        loadPersonPane1("TenantStudentInfo.fxml");
//        showPersonRole1.getChildren().add(personRolePane1);

        // ComboBox selection event change pane form
        personRoleCB1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if ((Integer) newValue == 0) {
                    roleEduT1.setText("สถาบันการศึกษา");
                    roleFacultyT1.setText("คณะ");
                    roleGradeT1.setText("ชั้นปี");
                } else if ((Integer) newValue == 1) {
                    roleEduT1.setText("สถานที่ทำการสอน");
                    roleFacultyT1.setText("สอนประจำคณะ");
                    roleGradeT1.setText("ตำแหน่ง");
                }
            }
        });

        // ComboBox selection event change pane form
        personRoleCB2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if ((Integer) newValue == 0) {
                    roleEduT2.setText("สถาบันการศึกษา");
                    roleFacultyT2.setText("คณะ");
                    roleGradeT2.setText("ชั้นปี");
                } else if ((Integer) newValue == 1) {
                    roleEduT2.setText("สถานที่ทำการสอน");
                    roleFacultyT2.setText("สอนประจำคณะ");
                    roleGradeT2.setText("ตำแหน่ง");
                }
            }
        });
        //---------------------------------------------------------------------------------------------------------------------

        //check validate field
        checkValidation();

        //set Disable field person1
        setDisableField();

    }

    /**
     * load FXML file to parent pane
     */
    private void loadPersonPane1(String FXMLFile) {

        //ChildNode child;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(FXMLFile));
            personRolePane1 = loader.load();

            if (FXMLFile.equals("TenantStudentInfo.fxml")) {
                studentInfoController1 = loader.<TenantStudentInfoController>getController();
            } else {
                teacherInfoController1 = loader.<TenantTeacherInfoController>getController();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPersonPane2(String FXMLFile) {

        //ChildNode child;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(FXMLFile));
            personRolePane2 = loader.load();

            if (FXMLFile.equals("TenantStudentInfo.fxml")) {
                studentInfoController2 = loader.<TenantStudentInfoController>getController();
            } else {
                teacherInfoController2 = loader.<TenantTeacherInfoController>getController();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkValidation() {
        person1inV1 = person1inV2 = person1inV3 = person1inV4 = person1inV5 = false;

        //------------------------ Validation person1 ------------------------------------------
        //check prefixName seleted
        prefixNameCB1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (prefixNameCB1.getSelectionModel().isEmpty() || prefixNameCB1.getSelectionModel().getSelectedItem() == null) {
                    if (!prefixNameCB1.getStyleClass().contains("invalidate-comboBox")) {
                        prefixNameCB1.getStyleClass().add("invalidate-comboBox");
                    }
                    person1inV1 = false;
                } else {
                    prefixNameCB1.getStyleClass().removeAll(Collections.singleton("invalidate-comboBox"));
                    person1inV1 = true;
                }
            }
        }));
        //check firstName input
        firstNameTF1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (firstNameTF1.getText() == null || firstNameTF1.getText().trim().isEmpty()) {
                    if (!firstNameTF1.getStyleClass().contains("invalidate-field")) {
                        firstNameTF1.getStyleClass().add("invalidate-field");
                    }
                    person1inV2 = false;

                } else {
                    firstNameTF1.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                }
                person1inV2 = true;
            }
        }));
        //check lastName input
        lastNameTF1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (lastNameTF1.getText() == null || lastNameTF1.getText().trim().isEmpty()) {
                    if (!lastNameTF1.getStyleClass().contains("invalidate-field")) {
                        lastNameTF1.getStyleClass().add("invalidate-field");
                    }
                    person1inV3 = false;
                } else {
                    lastNameTF1.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    person1inV3 = true;
                }
            }
        }));
        //check IDCard input
        idCardTF1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (idCardTF1.getText() == null || idCardTF1.getText().trim().isEmpty() || !checkProfessionalID(idCardTF1.getText())) {
                    if (!idCardTF1.getStyleClass().contains("invalidate-field")) {
                        idCardTF1.getStyleClass().add("invalidate-field");
                    }
                    person1inV4 = false;
                } else {
                    idCardTF1.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    person1inV4 = true;
                }
            }
        }));
        //check phoneNumber input
        phoneNumberTF1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            ObservableList<String> styleClass = phoneNumberTF1.getStyleClass();
            if (!newValue) {
                if (phoneNumberTF1.getText() == null || phoneNumberTF1.getText().trim().isEmpty() || !validatePhoneNumber(phoneNumberTF1.getText())) {
                    if (!phoneNumberTF1.getStyleClass().contains("invalidate-field")) {
                        phoneNumberTF1.getStyleClass().add("invalidate-field");
                    }
                    person1inV5 = false;
                } else {
                    phoneNumberTF1.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    person1inV5 = true;
                }
            }
        }));

        //------------------------ Validation person2 ------------------------------------------
        //check prefixName selected
        prefixNameCB2.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue && isSelected) {
                if (prefixNameCB2.getSelectionModel().isEmpty()) {
                    if (!prefixNameCB2.getStyleClass().contains("invalidate-comboBox")) {
                        prefixNameCB2.getStyleClass().add("invalidate-comboBox");
                        person2inV1 = false;
                    }
                } else {
                    prefixNameCB2.getStyleClass().removeAll(Collections.singleton("invalidate-comboBox"));
                    person2inV1 = true;
                }
            }
        }));
        //check firstName input
        firstNameTF2.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue && isSelected) {
                if (firstNameTF2.getText() == null || firstNameTF2.getText().trim().isEmpty()) {
                    if (!firstNameTF2.getStyleClass().contains("invalidate-field")) {
                        firstNameTF2.getStyleClass().add("invalidate-field");
                        person2inV2 = false;
                    }
                } else {
                    firstNameTF2.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    person2inV2 = true;
                }
            }
        }));
        //check lastName input
        lastNameTF2.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue && isSelected) {
                if (lastNameTF2.getText() == null || lastNameTF2.getText().trim().isEmpty()) {
                    if (!lastNameTF2.getStyleClass().contains("invalidate-field")) {
                        lastNameTF2.getStyleClass().add("invalidate-field");
                        person2inV3 = false;
                    }
                } else {
                    lastNameTF2.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    person2inV3 = true;
                }
            }
        }));
        //check IDCard input
        idCardTF2.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue && isSelected) {
                if (idCardTF2.getText() == null || idCardTF2.getText().trim().isEmpty() || !checkProfessionalID(idCardTF2.getText())) {
                    if (!idCardTF2.getStyleClass().contains("invalidate-field")) {
                        idCardTF2.getStyleClass().add("invalidate-field");
                        person2inV4 = false;
                    }
                } else {
                    idCardTF2.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    person2inV4 = true;
                }
            }
        }));
        //check phoneNumber input
        phoneNumberTF2.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue && isSelected) {
                if (phoneNumberTF2.getText() == null || phoneNumberTF2.getText().trim().isEmpty() || !validatePhoneNumber(phoneNumberTF2.getText())) {
                    if (!phoneNumberTF2.getStyleClass().contains("invalidate-field")) {
                        phoneNumberTF2.getStyleClass().add("invalidate-field");
                        person2inV5 = false;
                    }
                } else {
                    phoneNumberTF2.getStyleClass().removeAll(Collections.singleton("invalidate-field"));
                    person2inV5 = true;
                }
            }
        }));
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        final Pattern phoneNumberPattern = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$");
        final Matcher match = phoneNumberPattern.matcher(phoneNumber);
        if (match.find() && match.group().equals(phoneNumber)) return true;
        return false;
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

    @FXML
    void clearFieldPerson1(ActionEvent event) {
        System.out.println("Clear person1");
        firstNameTF1.setText("");
        lastNameTF1.setText("");
        nickNameTF1.setText("");
        idCardTF1.setText("");
        birthDayDP1.setValue(null);
        phoneNumberTF1.setText("");
        emailTF1.setText("");
        contractPersonTF1.setText("");
        relationPersonTF1.setText("");
        addressTF1.setText("");
        prefixNameCB1.getSelectionModel().clearSelection();

//        for (Node node : showPersonRole1.getChildren()) {
//            if (node instanceof AnchorPane) {
//                if (node.getId().equals("studentInfo")) {
//                    studentInfoController1.getStudentFacultyTF().setText("");
//                    studentInfoController1.getStudentGradeTF().setText("");
//                    studentInfoController1.getStudentEduTF().setText("");
//                } else {
//                    teacherInfoController1.getTeacherFacultyTF().setText("");
//                    teacherInfoController1.getTeacherPositionTF().setText("");
//                    teacherInfoController1.getTeacherEduTF().setText("");
//                }
//            }
//        }
    }

    @FXML
    void clearFieldPerson2(ActionEvent event) {
        clearDataPerson2();
    }

    @FXML
    void toggleTenant(ActionEvent event) {
        isSelected = toggleBT.isSelected();
        if (isSelected) {
            toggleLB.setText("ON");
            System.out.println("ON");
            setEnableField();
        } else {
            toggleLB.setText("OFF");
            System.out.println("OFF");
            setDisableField();
            clearDataPerson2();
        }
    }

    void setDisableField() {
        prefixNameCB2.setDisable(true);
        firstNameTF2.setDisable(true);
        lastNameTF2.setDisable(true);
        nickNameTF2.setDisable(true);
        birthDayDP2.setDisable(true);
        emailTF2.setDisable(true);
        contractPersonTF2.setDisable(true);
        relationPersonTF2.setDisable(true);
        addressTF2.setDisable(true);
        personRoleCB2.setDisable(true);
        phoneNumberTF2.setDisable(true);
        idCardTF2.setDisable(true);
        clearFieldPerson2BT.setDisable(true);

//        if (personRoleCB2.getSelectionModel().getSelectedItem().equals("นักศึกษา")) {
//            studentInfoController2.getStudentEduTF().setDisable(true);
//            studentInfoController2.getStudentFacultyTF().setDisable(true);
//            studentInfoController2.getStudentGradeTF().setDisable(true);
//        } else {
//            teacherInfoController2.getTeacherEduTF().setDisable(true);
//            teacherInfoController2.getTeacherPositionTF().setDisable(true);
//            teacherInfoController2.getTeacherFacultyTF().setDisable(true);
//        }
    }

    void setEnableField() {
        prefixNameCB2.setDisable(false);
        firstNameTF2.setDisable(false);
        lastNameTF2.setDisable(false);
        nickNameTF2.setDisable(false);
        birthDayDP2.setDisable(false);
        emailTF2.setDisable(false);
        contractPersonTF2.setDisable(false);
        relationPersonTF2.setDisable(false);
        addressTF2.setDisable(false);
        personRoleCB2.setDisable(false);
        phoneNumberTF2.setDisable(false);
        idCardTF2.setDisable(false);
        clearFieldPerson2BT.setDisable(false);

//        if (personRoleCB2.getSelectionModel().getSelectedItem().equals("นักศึกษา")) {
//            studentInfoController2.getStudentEduTF().setDisable(false);
//            studentInfoController2.getStudentFacultyTF().setDisable(false);
//            studentInfoController2.getStudentGradeTF().setDisable(false);
//        } else {
//            teacherInfoController2.getTeacherEduTF().setDisable(false);
//            teacherInfoController2.getTeacherPositionTF().setDisable(false);
//            teacherInfoController2.getTeacherFacultyTF().setDisable(false);
//        }
    }

    void clearDataPerson2() {
        System.out.println("clear person2");
        firstNameTF2.setText("");
        lastNameTF2.setText("");
        nickNameTF2.setText("");
        idCardTF2.setText("");
        birthDayDP2.setValue(null);
        phoneNumberTF2.setText("");
        emailTF2.setText("");
        contractPersonTF2.setText("");
        relationPersonTF2.setText("");
        addressTF2.setText("");
        prefixNameCB2.getSelectionModel().clearSelection();

//        for (Node node : showPersonRole2.getChildren()) {
//            if (node instanceof AnchorPane) {
//                if (node.getId().equals("studentInfo")) {
//                    studentInfoController2.getStudentFacultyTF().setText("");
//                    studentInfoController2.getStudentGradeTF().setText("");
//                    studentInfoController2.getStudentEduTF().setText("");
//                } else {
//                    teacherInfoController2.getTeacherFacultyTF().setText(null);
//                    teacherInfoController2.getTeacherPositionTF().setText(null);
//                    teacherInfoController2.getTeacherEduTF().setText(null);
//                }
//            }
//        }
    }

    public boolean checkBeforeSubmitForm() {
        boolean person1, person2;
        person1 = person1inV1 && person1inV2 && person1inV3 && person1inV4 && person1inV5;
        person2 = person2inV1 && person2inV2 && person2inV3 && person2inV4 && person2inV5;
        if (!isSelected)
            return person1;
        else
            return person1 && person2;
    }
}
