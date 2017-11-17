package Application.SmartDorm.UI.Manage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TenantStudentInfoController{

    @FXML
    private TextField studentEduTF;

    @FXML
    private TextField studentFacultyTF;

    @FXML
    private TextField studentGradeTF;

    //Getter and Setter
    public TextField getStudentEduTF() {
        return studentEduTF;
    }

    public void setStudentEduTF(TextField studentEduTF) {
        this.studentEduTF = studentEduTF;
    }

    public TextField getStudentFacultyTF() {
        return studentFacultyTF;
    }

    public void setStudentFacultyTF(TextField studentFacultyTF) {
        this.studentFacultyTF = studentFacultyTF;
    }

    public TextField getStudentGradeTF() {
        return studentGradeTF;
    }

    public void setStudentGradeTF(TextField studentGradeTF) {
        this.studentGradeTF = studentGradeTF;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    public void initialize() {

    }
}
