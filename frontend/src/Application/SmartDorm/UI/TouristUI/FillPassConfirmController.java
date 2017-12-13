package Application.SmartDorm.UI.TouristUI;

import Application.SmartDorm.UI.TenantMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;

import java.io.IOException;

public class FillPassConfirmController {

    @FXML
    private PasswordField passField;

    String password = "12345";

    @FXML
    public void ok(ActionEvent event) throws IOException {
        if(password.equals(passField.getText())) {
            Node confirmBookingUI = FXMLLoader.load(getClass().getResource("ConfirmBooking.fxml"));
            setNode(confirmBookingUI);
        }
        else
            System.out.println("password was wrong!");
    }

    @FXML
    public void cancel(ActionEvent event) throws IOException {
        Node searchUI1 = FXMLLoader.load(getClass().getResource("SearchUI.fxml"));
        setNode(searchUI1);
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);
    }
}
