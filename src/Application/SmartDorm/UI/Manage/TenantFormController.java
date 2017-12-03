package Application.SmartDorm.UI.Manage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TenantFormController {
    private static boolean inValidForm1, inValidForm2;
    //set Controller
    TenantStudentInfoController studentInfoController1;
    TenantTeacherInfoController teacherInfoController1;
    TenantStudentInfoController studentInfoController2;
    TenantTeacherInfoController teacherInfoController2;
    private boolean isSelected;
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

    private AnchorPane personRolePane1, personRolePane2;

    /**
     * The constructor (is called before the initialize()-method).
     */
    public TenantFormController() {

    }

    //set Getter and Setter1 ------------------------------------------------------------------------------------------
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

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        //set format DatePicker
        setDatePickerFormat();
        //---------------------------------------------------------------------------------------------------------------------

        // ComboBox selection event
        prefixNameCB1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(prefixNameCB1.getSelectionModel().getSelectedItem());
            }
        });

        prefixNameCB2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(prefixNameCB2.getSelectionModel().getSelectedItem());
            }
        });
        //---------------------------------------------------------------------------------------------------------------------

        //---------------------------------------------------------------------------------------------------------------------
        // Init ComboBox items.
        personRoleCB1.getSelectionModel().selectFirst();

        // Init ComboBox items.
        personRoleCB2.getSelectionModel().selectFirst();

        //  Init student form
        loadPersonPane2("TenantStudentInfo.fxml");
        showPersonRole2.getChildren().add(personRolePane2);

        //  Init student form
        loadPersonPane1("TenantStudentInfo.fxml");
        showPersonRole1.getChildren().add(personRolePane1);

        // ComboBox selection event change pane form
        personRoleCB1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if ((Integer) newValue == 0) {
                    showPersonRole1.getChildren().removeAll(personRolePane1);
                    loadPersonPane1("TenantStudentInfo.fxml");
                    showPersonRole1.getChildren().add(personRolePane1);
                } else if ((Integer) newValue == 1) {
                    showPersonRole1.getChildren().removeAll(personRolePane1);
                    loadPersonPane1("TenantTeacherInfo.fxml");
                    showPersonRole1.getChildren().add(personRolePane1);
                } else {
                    //TODO other people
                }
            }
        });

        // ComboBox selection event change pane form
        personRoleCB2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if ((Integer) newValue == 0) {
                    showPersonRole2.getChildren().removeAll(personRolePane2);
                    loadPersonPane2("TenantStudentInfo.fxml");
                    showPersonRole2.getChildren().add(personRolePane2);
                } else if ((Integer) newValue == 1) {
                    showPersonRole2.getChildren().removeAll(personRolePane2);
                    loadPersonPane2("TenantTeacherInfo.fxml");
                    showPersonRole2.getChildren().add(personRolePane2);
                } else {
                    //TODO other people
                }
            }
        });
        //---------------------------------------------------------------------------------------------------------------------

        //set Disable field person1
        setDisableField();

        //check validate field
        checkValidation();

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
        //------------------------ Validation person1 ------------------------------------------
        //check prefixName seleted
        prefixNameCB1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            ObservableList<String> styleClass = prefixNameCB1.getStyleClass();
            if (!newValue) {
                if (prefixNameCB1.getSelectionModel().isEmpty()) {
                    if (!styleClass.contains("invalidate-comboBox")) {
                        styleClass.add("invalidate-comboBox");
                    }
                } else {
                    styleClass.removeAll(Collections.singleton("invalidate-comboBox"));
                }
            }
        }));
        //check firstName input
        firstNameTF1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            ObservableList<String> styleClass = firstNameTF1.getStyleClass();
            if (!newValue) {
                if (firstNameTF1.getText() == null || firstNameTF1.getText().trim().isEmpty()) {
                    if (!styleClass.contains("invalidate-field")) {
                        styleClass.add("invalidate-field");
                    }
                } else {
                    styleClass.removeAll(Collections.singleton("invalidate-field"));
                }
            }
        }));
        //check lastName input
        lastNameTF1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            ObservableList<String> styleClass = lastNameTF1.getStyleClass();
            if (!newValue) {
                if (lastNameTF1.getText() == null || lastNameTF1.getText().trim().isEmpty()) {
                    if (!styleClass.contains("invalidate-field")) {
                        styleClass.add("invalidate-field");
                    }
                } else {
                    styleClass.removeAll(Collections.singleton("invalidate-field"));
                }
            }
        }));
        //check nickName input
        nickNameTF1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            ObservableList<String> styleClass = nickNameTF1.getStyleClass();
            if (!newValue) {
                if (nickNameTF1.getText() == null || nickNameTF1.getText().trim().isEmpty()) {
                    if (!styleClass.contains("invalidate-field")) {
                        styleClass.add("invalidate-field");
                    }
                } else {
                    styleClass.removeAll(Collections.singleton("invalidate-field"));
                }
            }
        }));
        //check IDCard input
        idCardTF1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            ObservableList<String> styleClass = idCardTF1.getStyleClass();
            if (!newValue) {
                if (idCardTF1.getText() == null || idCardTF1.getText().trim().isEmpty() || !checkProfessionalID(idCardTF1.getText())) {
                    if (!styleClass.contains("invalidate-field")) {
                        styleClass.add("invalidate-field");
                        String t = idCardTF1.getText();
                    }
                } else {
                    styleClass.removeAll(Collections.singleton("invalidate-field"));
                }
            }
        }));
        //check phoneNumber input
        phoneNumberTF1.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            ObservableList<String> styleClass = phoneNumberTF1.getStyleClass();
            if (!newValue) {
                if (phoneNumberTF1.getText() == null || phoneNumberTF1.getText().trim().isEmpty() || !validatePhoneNumber(phoneNumberTF1.getText())){
                    System.out.println();
                    if (!styleClass.contains("invalidate-field")) {
                        styleClass.add("invalidate-field");
                    }
                } else{
                    styleClass.removeAll(Collections.singleton("invalidate-field"));
                }
            }
        }));

    }

    private boolean validatePhoneNumber(String phoneNumber) {
        final Pattern phoneNumberPattern = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$");
        final Matcher match = phoneNumberPattern.matcher(phoneNumber);
        if(match.find() && match.group().equals(phoneNumber)) return true;
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
        prefixNameCB1.getSelectionModel().select("");

        for (Node node : showPersonRole1.getChildren()) {
            if (node instanceof AnchorPane) {
                if (node.getId().equals("studentInfo")) {
                    studentInfoController1.getStudentFacultyTF().setText("");
                    studentInfoController1.getStudentGradeTF().setText("");
                    studentInfoController1.getStudentEduTF().setText("");
                } else {
                    teacherInfoController1.getTeacherFacultyTF().setText("");
                    teacherInfoController1.getTeacherPositionTF().setText("");
                    teacherInfoController1.getTeacherEduTF().setText("");
                }
            }
        }
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

    private void setDatePickerFormat() {
        String pattern = "วันที่ dd เดือน MM ค.ศ. yyyy";
        birthDayDP1.setPromptText(pattern);
        DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern(pattern);
        birthDayDP1.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter1.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter1);
                } else {
                    return null;
                }
            }
        });

        birthDayDP2.setPromptText(pattern);
        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern(pattern);
        birthDayDP2.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter2.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter2);
                } else {
                    return null;
                }
            }
        });

//        //-- get Date
//        birthDayDP1.setOnAction(event -> {
//            System.out.println("Selected date: " + birthDayDP1.getValue().format(dateFormatter1));
//        });
//
//        birthDayDP2.setOnAction(event -> {
//            System.out.println("Selected date: " + birthDayDP2.getValue().format(dateFormatter2));
//        });
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

        if (personRoleCB2.getSelectionModel().getSelectedItem().equals("นักศึกษา")) {
            studentInfoController2.getStudentEduTF().setDisable(true);
            studentInfoController2.getStudentFacultyTF().setDisable(true);
            studentInfoController2.getStudentGradeTF().setDisable(true);
        } else {
            teacherInfoController2.getTeacherEduTF().setDisable(true);
            teacherInfoController2.getTeacherPositionTF().setDisable(true);
            teacherInfoController2.getTeacherFacultyTF().setDisable(true);
        }
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

        if (personRoleCB2.getSelectionModel().getSelectedItem().equals("นักศึกษา")) {
            studentInfoController2.getStudentEduTF().setDisable(false);
            studentInfoController2.getStudentFacultyTF().setDisable(false);
            studentInfoController2.getStudentGradeTF().setDisable(false);
        } else {
            teacherInfoController2.getTeacherEduTF().setDisable(false);
            teacherInfoController2.getTeacherPositionTF().setDisable(false);
            teacherInfoController2.getTeacherFacultyTF().setDisable(false);
        }
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
        prefixNameCB2.getSelectionModel().select("");
        for (Node node : showPersonRole2.getChildren()) {
            if (node instanceof AnchorPane) {
                if (node.getId().equals("studentInfo")) {
                    studentInfoController2.getStudentFacultyTF().setText("");
                    studentInfoController2.getStudentGradeTF().setText("");
                    studentInfoController2.getStudentEduTF().setText("");
                } else {
                    teacherInfoController2.getTeacherFacultyTF().setText(null);
                    teacherInfoController2.getTeacherPositionTF().setText(null);
                    teacherInfoController2.getTeacherEduTF().setText(null);
                }
            }
        }
    }
}
