package Application.SmartDorm.UI.Request;

import Application.SmartDorm.MainSmartDorm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HistoryRequestController {

    Stage tenant_stage = MainSmartDorm.getStage();

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("MainRequest.fxml"));
        Scene home_tenant_page = new Scene(home_tenant_payment);

        tenant_stage.setScene(home_tenant_page);
        tenant_stage.show();
    }
}
