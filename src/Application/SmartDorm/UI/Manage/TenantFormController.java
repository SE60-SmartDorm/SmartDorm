package Application.SmartDorm.UI.Manage;

import com.jfoenix.controls.JFXDatePicker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class TenantFormController {
    //set Controller
    TenantStudentInfoController studentInfoController1 = new TenantStudentInfoController();
    TenantTeacherInfoController teacherInfoController1 = new TenantTeacherInfoController();
    TenantStudentInfoController studentInfoController2 = new TenantStudentInfoController();
    TenantTeacherInfoController teacherInfoController2 = new TenantTeacherInfoController();

    //--- people 1 ---
    @FXML
    private VBox showPeopleRole1;
    @FXML
    private ComboBox<String> PeopleRoleCB1;
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
    private VBox showPeopleRole2;
    @FXML
    private ComboBox<String> PeopleRoleCB2;
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
    private AnchorPane personRolePane1, personRolePane2;

    //set Getter and Setter1 ------------------------------------------------------------------------------------------
    public TextField getFirstNameTF1() {
        return firstNameTF1;
    }

    public void setFirstNameTF1(TextField firstNameTF1) {
        this.firstNameTF1 = firstNameTF1;
    }

    public ComboBox<String> getPeopleRoleCB1() {
        return PeopleRoleCB1;
    }

    public void setPeopleRoleCB1(ComboBox<String> peopleRoleCB1) {
        PeopleRoleCB1 = peopleRoleCB1;
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

    //-----------------------------------------------------------------------------------------------------------------

    /**
     * The constructor (is called before the initialize()-method).
     */
    public TenantFormController() {

    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {

//        firstNameTF1.textProperty().addListener((observable, oldValue, newValue) ->{
//            System.out.println(newValue);
//        });

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
        PeopleRoleCB1.getSelectionModel().selectFirst();

        // Init ComboBox items.
        PeopleRoleCB2.getSelectionModel().selectFirst();

        //  Init student form
        loadPersonPane2("TenantStudentInfo.fxml");
        showPeopleRole2.getChildren().add(personRolePane2);

        //  Init student form
        loadPersonPane1("TenantStudentInfo.fxml");
        showPeopleRole1.getChildren().add(personRolePane1);

        // ComboBox selection event change pane form
        PeopleRoleCB1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if ((Integer) newValue == 0) {
                    showPeopleRole1.getChildren().removeAll(personRolePane1);
                    loadPersonPane1("TenantStudentInfo.fxml");
                    showPeopleRole1.getChildren().add(personRolePane1);
                } else if ((Integer) newValue == 1) {
                    showPeopleRole1.getChildren().removeAll(personRolePane1);
                    loadPersonPane1("TenantTeacherInfo.fxml");
                    showPeopleRole1.getChildren().add(personRolePane1);
                } else {
                    //TODO other people
                }
            }
        });

        // ComboBox selection event change pane form
        PeopleRoleCB2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if ((Integer) newValue == 0) {
                    showPeopleRole2.getChildren().removeAll(personRolePane2);
                    loadPersonPane2("TenantStudentInfo.fxml");
                    showPeopleRole2.getChildren().add(personRolePane2);
                } else if ((Integer) newValue == 1) {
                    showPeopleRole2.getChildren().removeAll(personRolePane2);
                    loadPersonPane2("TenantTeacherInfo.fxml");
                    showPeopleRole2.getChildren().add(personRolePane2);
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

        for (Node node : showPeopleRole1.getChildren()) {
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
        for (Node node : showPeopleRole2.getChildren()) {
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

}
