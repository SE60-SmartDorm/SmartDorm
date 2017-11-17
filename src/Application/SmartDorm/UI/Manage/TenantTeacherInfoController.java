package Application.SmartDorm.UI.Manage;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TenantTeacherInfoController {

    @FXML
    private TextField teacherEduTF;

    @FXML
    private TextField teacherFacultyTF;

    @FXML
    private TextField teacherPositionTF;

    //Getter and Setter
    public TextField getTeacherEduTF() {
        return teacherEduTF;
    }

    public void setTeacherEduTF(TextField teacherEduTF) {
        this.teacherEduTF = teacherEduTF;
    }

    public TextField getTeacherFacultyTF() {
        return teacherFacultyTF;
    }

    public void setTeacherFacultyTF(TextField teacherFacultyTF) {
        this.teacherFacultyTF = teacherFacultyTF;
    }

    public TextField getTeacherPositionTF() {
        return teacherPositionTF;
    }

    public void setTeacherPositionTF(TextField teacherPositionTF) {
        this.teacherPositionTF = teacherPositionTF;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    public void initialize() {

    }
}
