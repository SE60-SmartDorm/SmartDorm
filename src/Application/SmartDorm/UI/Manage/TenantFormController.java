package Application.SmartDorm.UI.Manage;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TenantFormController {
    //set Controller
    TenantStudentInfoController studentInfoController1 = new TenantStudentInfoController();
    TenantTeacherInfoController teacherInfoController1 = new TenantTeacherInfoController();
    TenantStudentInfoController studentInfoController2 = new TenantStudentInfoController();
    TenantTeacherInfoController teacherInfoController2 = new TenantTeacherInfoController();

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

    private AnchorPane personRolePane1, personRolePane2;

    boolean isSelected;

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

    //-----------------------------------------------------------------------------------------------------------------

    public void setAddressTF1(TextArea addressTF1) {
        this.addressTF1 = addressTF1;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {

        //set Disable field person1
        setFieldDisable();

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

    @FXML
    void clearFieldPerson1(ActionEvent event) {
        firstNameTF1.setText(null);
        lastNameTF1.setText(null);
        nickNameTF1.setText(null);
        idCardTF1.setText(null);
        birthDayDP1.setValue(null);
        phoneNumberTF1.setText(null);
        emailTF1.setText(null);
        contractPersonTF1.setText(null);
        relationPersonTF1.setText(null);
        addressTF1.setText(null);
        prefixNameCB1.getSelectionModel().select(null);

        for (Node node : showPersonRole1.getChildren()) {
            if (node instanceof AnchorPane) {
                if (node.getId().equals("studentInfo")) {
                    studentInfoController1.getStudentFacultyTF().setText(null);
                    studentInfoController1.getStudentGradeTF().setText(null);
                    studentInfoController1.getStudentEduTF().setText(null);
                } else {
                    teacherInfoController1.getTeacherFacultyTF().setText(null);
                    teacherInfoController1.getTeacherPositionTF().setText(null);
                    teacherInfoController1.getTeacherEduTF().setText(null);
                }
            }
        }
    }

    @FXML
    void clearFieldPerson2(ActionEvent event) {
        System.out.println("clear");
        firstNameTF2.setText(null);
        lastNameTF2.setText(null);
        nickNameTF2.setText(null);
        idCardTF2.setText(null);
        birthDayDP2.setValue(null);
        phoneNumberTF2.setText(null);
        emailTF2.setText(null);
        contractPersonTF2.setText(null);
        relationPersonTF2.setText(null);
        addressTF2.setText(null);
        prefixNameCB2.getSelectionModel().select("");
        for (Node node : showPersonRole2.getChildren()) {
            if (node instanceof AnchorPane) {
                if (node.getId().equals("studentInfo")) {
                    studentInfoController2.getStudentFacultyTF().setText(null);
                    studentInfoController2.getStudentGradeTF().setText(null);
                    studentInfoController2.getStudentEduTF().setText(null);
                } else {
                    teacherInfoController2.getTeacherFacultyTF().setText(null);
                    teacherInfoController2.getTeacherPositionTF().setText(null);
                    teacherInfoController2.getTeacherEduTF().setText(null);
                }
            }
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

    void setFieldDisable(){
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
    }

    void setFieldEnable(){
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
    }
}
