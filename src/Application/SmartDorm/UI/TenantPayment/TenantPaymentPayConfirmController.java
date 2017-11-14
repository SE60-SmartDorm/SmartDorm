package Application.SmartDorm.UI.TenantPayment;

import Application.SmartDorm.MainSmartDorm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TenantPaymentPayConfirmController {

    Stage tenant_stage = MainSmartDorm.getStage();

    @FXML
    private void ok(ActionEvent event) throws IOException {
        Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPayment.fxml"));
        Scene home_tenant_page = new Scene(home_tenant_payment);

        tenant_stage.setScene(home_tenant_page);
        tenant_stage.show();
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Stage tenant_stage = MainSmartDorm.getStage();

        Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPayment.fxml"));
        Scene home_tenant_page = new Scene(home_tenant_payment);

        tenant_stage.setScene(home_tenant_page);
        tenant_stage.show();
    }
}
