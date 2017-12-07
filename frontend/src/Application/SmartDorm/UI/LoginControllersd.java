package Application.SmartDorm.UI;


import Application.SmartDorm.MainSmartDorm;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginControllersd {
    @FXML
    JFXTextField textID;
    @FXML
    JFXPasswordField textPassword;
    @FXML
    Label warning;
    @FXML
    Label warning2;
    ObservableList<String> list = FXCollections.observableArrayList("Owner", "Tenant");
    Stage tenant_stage = MainSmartDorm.getStage();
    @FXML
    private ComboBox<String> status;
    private String ownerUser = "";
    private String ownerPass = "";
    private String tenantUser = "";
    private String tenantPass = "";
    private String type;

    public void initialize() {
        status.setItems(list);
    }

    @FXML
    private void loginPress(ActionEvent event) throws IOException {
        type = status.getValue();
        warning.setVisible(false);
        warning2.setVisible(false);

        if ("Owner".equals(type)) {
            if ((ownerUser.equals(textID.getText())) && (ownerPass.equals(textPassword.getText()))) {
                Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("OwnerMain.fxml"));
                Scene tenant3rd_page = new Scene(home_tenant_payment);

                tenant_stage.setScene(tenant3rd_page);
                tenant_stage.show();
            } else
                warning.setVisible(true);
        } else if ("Tenant".equals(type)) {
            if ((tenantUser.equals(textID.getText())) && (tenantPass.equals(textPassword.getText()))) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TenantMain.fxml"));
                Parent home_tenant_payment = loader.load();
                Scene tenant3rd_page = new Scene(home_tenant_payment);

                tenant_stage.setScene(tenant3rd_page);
                tenant_stage.show();
            } else
                warning.setVisible(true);
        } else
            warning2.setVisible(true);
    }

}