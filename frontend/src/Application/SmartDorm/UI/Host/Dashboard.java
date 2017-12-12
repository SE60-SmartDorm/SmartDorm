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
    int number_tourist = 0;
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
        for (int i = 0; i < number_tourist; i++) {
            tourist_list_data.add(new TouristInfo());
            listView_tourist.getChildren().add(tourist_list_data.get(i));
        }
    }

    public void addTourist() {
        number_tourist += 1;
    }

}
