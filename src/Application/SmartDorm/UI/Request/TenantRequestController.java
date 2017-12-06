package Application.SmartDorm.UI.Request;
import Application.SmartDorm.MainSmartDorm;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class  TenantRequestController {

    @FXML
    private JFXButton buttonRequest;


    @FXML
    private JFXButton buttonHistory;

    Stage tenant_stage = MainSmartDorm.getStage();

    @FXML
    private void sendRequest(ActionEvent event) throws IOException {
        Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("SendRequest.fxml"));
        Scene home_tenant_page = new Scene(home_tenant_payment);

        tenant_stage.setScene(home_tenant_page);
        tenant_stage.show();
    }

    @FXML
    private void historyRequest(ActionEvent event) throws IOException {
        Stage tenant_stage = MainSmartDorm.getStage();
        Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("HistoryRequest.fxml"));
        Scene home_tenant_page = new Scene(home_tenant_payment);

        tenant_stage.setScene(home_tenant_page);
        tenant_stage.show();
    }

}
