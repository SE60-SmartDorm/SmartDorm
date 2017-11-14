package Application.SmartDorm.UI;


import Application.SmartDorm.MainSmartDorm;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginControllersd {
    @FXML
    JFXTextField textID;
    @FXML
    JFXPasswordField textPassword;

    String user = "anucha";
    String pass = "123456789";

    @FXML
    private void loginPress(ActionEvent event) throws IOException {
        if((user.equals(textID.getText())) && (pass.equals(textPassword.getText())))
        {
            Stage tenant_stage = MainSmartDorm.getStage();

            Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("OwnerDashboard.fxml"));
            Scene tenant3rd_page = new Scene(home_tenant_payment);

            tenant_stage.setScene(tenant3rd_page);
            tenant_stage.show();
            }
    }

}
