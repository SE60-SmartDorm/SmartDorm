package Application.SmartDorm.UI.Request;

import Application.SmartDorm.UI.TenantMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class HistoryRequestController {

    @FXML
    private void back(ActionEvent event) throws IOException {
        Node home_tenant_payment = FXMLLoader.load(getClass().getResource("MainRequest.fxml"));
        setNode(home_tenant_payment);
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }
}
