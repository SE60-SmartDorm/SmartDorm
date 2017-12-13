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
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FillDataRoomController2 implements Initializable {

    @FXML
    private JFXDatePicker checkin;

    @FXML
    private JFXDatePicker checkout;

    @FXML
    private JFXButton ok;

    @FXML
    private JFXButton cancel;

    @FXML
    public ComboBox<String> listBed;
    ObservableList<String> list = FXCollections.observableArrayList("1", "2", "3","4","5","6","7","8");

    public String numBed, checkinDate, checkoutDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listBed.setItems(list);
        ok.setOnAction(event -> {
            numBed = listBed.getValue().toString();
            checkinDate = checkin.getValue().toString();
            checkoutDate = checkout.getValue().toString();
            System.out.println(numBed+""+checkinDate+"-"+checkoutDate);
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
