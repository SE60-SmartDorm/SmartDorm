package Application.SmartDorm.UI.TouristUI;

import Application.SmartDorm.UI.TenantMainController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FillDataRoomController implements Initializable {

    @FXML
    private JFXButton ok;

    @FXML
    private JFXButton cancel;

    @FXML
    private JFXDatePicker checkin;

    @FXML
    private JFXDatePicker checkout;


    @FXML
    public ComboBox<String> listRoom;
    ObservableList<String> list = FXCollections.observableArrayList("1", "2", "3");

    public String numRoom, checkinDate, checkoutDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listRoom.setItems(list);
        ok.setOnAction(event -> {
            numRoom = listRoom.getValue().toString();
            checkinDate = checkin.getValue().toString();
            checkoutDate = checkout.getValue().toString();
            System.out.println(numRoom + "" + checkinDate + "-" + checkoutDate);
            Node passConfirm = null;
            try {
                passConfirm = FXMLLoader.load(getClass().getResource("FillPassConfirm.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            setNode(passConfirm);
        });
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);
    }

}
