package Application.SmartDorm.UI.Host;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Dashboard extends AnchorPane implements Initializable {
    // set Singleton pattern
    private static Dashboard instance;
    List<TouristInfo> tourist_list_data = new ArrayList<TouristInfo>();
    int number_tourist = 2;
    int total_room = 3;
    int empt_room = 2;
    int booking_room = 1;

    @FXML
    private Label totalRoom;
    @FXML
    private Label emptyRoom;

    @FXML
    private Label bookingRoom;
    @FXML
    private Label touristNumber;
    @FXML
    private VBox listView_tourist;

    //Constructor
    private Dashboard() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    //get instant singleton pattern class
    public static Dashboard getInstance() {
        if (instance == null) {
            instance = new Dashboard();
        }
        return instance;
    }

    //Clear instance class
    public void ClearDashboard() {
        if (instance != null)
            instance = null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        totalRoom.setText(String.valueOf(total_room));
        touristNumber.setText(String.valueOf(number_tourist));
        emptyRoom.setText(String.valueOf(empt_room));
        bookingRoom.setText(String.valueOf(booking_room));
        tourist_list_data.add(new TouristInfo());
        tourist_list_data.get(0);
        listView_tourist.getChildren().add(tourist_list_data.get(0));
        tourist_list_data.get(0).setTouristInfo("Coppor", "2017/12/10", "2017/12/10", "ห้องส่วนตัว", "1 ห้อง");
    }

    public void addTourist() {
        number_tourist += 1;
        empt_room -= 1;
        booking_room += 1;
        totalRoom.setText(String.valueOf(total_room));
        touristNumber.setText(String.valueOf(number_tourist));
        emptyRoom.setText(String.valueOf(empt_room));
        bookingRoom.setText(String.valueOf(booking_room));
        tourist_list_data.add(new TouristInfo());
        tourist_list_data.get(1).setPhoto("../TouristUI/user kekie.png");
        listView_tourist.getChildren().add(tourist_list_data.get(1));

    }

    public void setDashboard(String total_room) {
        totalRoom.setText(total_room);
    }

}
