package Application.SmartDorm.UI;


import Application.SmartDorm.MainSmartDorm;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.Observable;


public class LoginControllersd {
    @FXML
    JFXTextField textID;
    @FXML
    JFXPasswordField textPassword;
    @FXML
    Label warning;
    @FXML
    Label warning2;

    @FXML
    private ComboBox<String> status;
    ObservableList<String> list = FXCollections.observableArrayList("Owner","Tenant");

    private String ownerUser = "anucha";
    private String ownerPass = "123456789";
    private String tenantUser = "pongdanai";
    private String tenantPass = "987654321";
    private String type;

    Stage tenant_stage = MainSmartDorm.getStage();

    public void initialize(){
        status.setItems(list);
    }

    @FXML
    private void loginPress(ActionEvent event) throws IOException {
        type = status.getValue();
        warning.setVisible(false);
        warning2.setVisible(false);

        if("Owner".equals(type)) {
            if ((ownerUser.equals(textID.getText())) && (ownerPass.equals(textPassword.getText()))) {
                Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("OwnerDashboard.fxml"));
                Scene tenant3rd_page = new Scene(home_tenant_payment);

                tenant_stage.setScene(tenant3rd_page);
                tenant_stage.show();
            } else
                warning.setVisible(true);
        }

        else if("Tenant".equals(type))
        {
            if ((tenantUser.equals(textID.getText())) && (tenantPass.equals(textPassword.getText()))) {
                Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantDashboard.fxml"));
                Scene tenant3rd_page = new Scene(home_tenant_payment);

                tenant_stage.setScene(tenant3rd_page);
                tenant_stage.show();
            } else
                warning.setVisible(true);
        }
        else
            warning2.setVisible(true);
    }

}