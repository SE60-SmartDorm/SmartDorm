package Application.SmartDorm.UI.Request;

import Application.SmartDorm.MainSmartDorm;
import Application.SmartDorm.UI.TenantMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class SendRequestController {
    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Node home_tenant_payment = FXMLLoader.load(getClass().getResource("MainRequest.fxml"));
        setNode(home_tenant_payment);
    }
    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }
}
