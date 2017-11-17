package Application.SmartDorm.UI.TenantPayment;

import Application.SmartDorm.MainSmartDorm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import java.io.IOException;

public class TenantPayment3rdLoginController {

    @FXML
    private TextField accountNum;
    @FXML
    private PasswordField pass;
    @FXML
    private Label errorHint;

    private String accountDB = "58011398";
    private String passwordDB = "123456789";

    Stage tenant_stage = MainSmartDorm.getStage();

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        errorHint.setVisible(false);
        if((accountDB.equals(accountNum.getText()))&&(passwordDB.equals(pass.getText()))) {

                Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPaymentPayConfirm.fxml"));
                Scene tenant3rdConfirm_page = new Scene(home_tenant_payment);

                tenant_stage.setScene(tenant3rdConfirm_page);
                tenant_stage.show();
        }
        else
            errorHint.setVisible(true);
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPayment.fxml"));
        Scene home_tenant_page = new Scene(home_tenant_payment);

        tenant_stage.setScene(home_tenant_page);
        tenant_stage.show();
    }
}

