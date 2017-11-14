package Application.SmartDorm.UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;


public class LoginControllersd {

    @FXML
    private JFXTextField textID;

    @FXML
    private JFXPasswordField textPassword;

    @FXML
    private JFXButton buttonLogin;



    private String authorize() {
        if("room1000".equals(textID.getText()) && "password".equals(textPassword.getText()))
            System.out.print("Log in complete.");
        else
            System.out.print("Log in fail.");
    }

    //private static int sessionID = 0;

    //private String generateSessionID() {
    //    sessionID++;
    //    return "xyzzy - session " + sessionID;
    //}

}
