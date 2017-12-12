package Application.SmartDorm.UI.Host;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TouristInfo extends StackPane implements Initializable {
    // set Singleton pattern
//    private static TouristInfo instance;

    @FXML
    private Label tourist_nameLB;

    @FXML
    private Label checkin_dateLB;

    @FXML
    private Label checkout_dateLB;

    @FXML
    private Label room_typeLB;

    @FXML
    private Label room_numberLB;

    @FXML
    private JFXButton profileBT;

    @FXML
    private StackPane info_pane;

    public TouristInfo() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TouristInfo.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

//    public static TouristInfo getInstance() {
//        if (instance == null) {
//            instance = new TouristInfo();
//        }
//        return instance;
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setTouristInfo(String name, String checkin, String checkout, String roomType, String roomNum) {
        tourist_nameLB.setText(name);
        checkin_dateLB.setText(checkin);
        checkout_dateLB.setText(checkout);
        room_typeLB.setText(roomType);
        room_numberLB.setText(roomNum);
    }

    public void setTourist_nameLB(String tourist_nameLB) {
        this.tourist_nameLB.setText(tourist_nameLB);
    }

    public void setCheckin_dateLB(String checkin_dateLB) {
        this.checkin_dateLB.setText(checkin_dateLB);
    }

    public void setCheckout_dateLB(String checkout_dateLB) {
        this.checkout_dateLB.setText(checkout_dateLB);
    }

    public void setRoom_typeLB(String room_typeLB) {
        this.room_typeLB.setText(room_typeLB);
    }

    public void setRoom_numberLB(String room_numberLB) {
        this.room_numberLB.setText(room_numberLB);
    }
}
