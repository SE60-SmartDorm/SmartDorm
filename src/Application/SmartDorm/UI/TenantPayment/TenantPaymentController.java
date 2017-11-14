package Application.SmartDorm.UI.TenantPayment;

import Application.SmartDorm.MainSmartDorm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TenantPaymentController {
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        Stage tenant_stage = MainSmartDorm.getStage();

        Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPayment3rdLogin.fxml"));
        Scene tenant3rd_page = new Scene(home_tenant_payment);

        tenant_stage.setScene(tenant3rd_page);
        tenant_stage.show();
    }
}
