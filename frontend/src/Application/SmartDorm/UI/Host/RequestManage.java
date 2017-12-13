package Application.SmartDorm.UI.Host;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RequestManage extends AnchorPane implements Initializable {
    // set Singleton pattern
    private static RequestManage instance;
    String t;

    //Constructor
    private RequestManage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Request.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    //get instant singleton pattern class
    public static RequestManage getInstance() {
        if (instance == null) {
            instance = new RequestManage();
        }
        return instance;
    }

    //Clear instance class
    public void Clear() {
        if (instance != null)
            instance = null;
    }

    public void setTTTT(String text){
        t = text;
        System.out.println("2 " + t);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
