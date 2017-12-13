package Application.SmartDorm.UI.TouristUI;

import Application.SmartDorm.UI.TenantMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookingController implements Initializable {

    @FXML
    private StackPane popupPane;

    @FXML
    public void detailClick(ActionEvent event) throws IOException {
        Node detailUI1 = FXMLLoader.load(getClass().getResource("RoomDetail.fxml"));
        setNode(detailUI1);
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
