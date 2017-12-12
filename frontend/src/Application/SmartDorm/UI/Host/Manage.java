package Application.SmartDorm.UI.Host;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Manage extends AnchorPane implements Initializable{
    // set Singleton pattern
    private static Manage instance;

    //FXML Variable
    @FXML
    private JFXTreeTableView<TouristBooking> tourist_tableview;

    @FXML
    private TreeTableColumn<TouristBooking, String> booking_date_col;

    @FXML
    private TreeTableColumn<TouristBooking, String>  tourist_name_col;

    @FXML
    private TreeTableColumn<TouristBooking, String>  room_type_col;

    @FXML
    private TreeTableColumn<TouristBooking, String>  room_number_col;

    @FXML
    private TreeTableColumn<TouristBooking, String>  checkin_col;

    @FXML
    private TreeTableColumn<TouristBooking, String>  checkout_col;

    @FXML
    private JFXButton detailBT;

    //other Variable
    ObservableList<TouristBooking> tourist_bookings_list = FXCollections.observableArrayList();

    //Constructor
    private Manage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manage.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    //get instant singleton pattern class
    public static Manage getInstance(){
        if (instance == null) {
            instance = new Manage();
        }
        return instance;
    }

    //Clear instance class
    public void ClearManage() {
        if (instance != null)
            instance = null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tourist_bookings_list.add(new TouristBooking("111","222","333","444","555","666"));
    }
}
