package Application.SmartDorm.UI;


import Application.SmartDorm.MainSmartDorm;
import Application.SmartDorm.UI.TenantPayment.TenantPaymentController;
import Controller.UserController;
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
    ObservableList<String> list = FXCollections.observableArrayList("Host","Tourist");

    private String ownerUser = "";
    private String ownerPass = "";
    private String tenantUser = "";
    private String tenantPass = "";
    private String type;

    public static TenantMainController tenantMainController;

    Stage tenant_stage = MainSmartDorm.getStage();


    public void initialize(){
        status.setItems(list);
    }

    @FXML
    private void loginPress(ActionEvent event) throws IOException {
        type = status.getValue();
        warning.setVisible(false);
        warning2.setVisible(false);

        if("Host".equals(type)) {
            String username = textID.getText();
            String password = textPassword.getText();

            if (username.equals("ownerz") && password.equals("bitch")) {
                Parent home_tenant_payment = FXMLLoader.load(getClass().getResource("OwnerMain.fxml"));
                Scene tenant3rd_page = new Scene(home_tenant_payment);

                tenant_stage.setScene(tenant3rd_page);
                tenant_stage.show();
            } else
                warning.setVisible(true);
        }

        else if("Tourist".equals(type))
        {
            String username = textID.getText();
            String password = textPassword.getText();

            System.out.println(username + " " + password);

            if (UserController.checkPassword(username, password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TenantMain.fxml"));

                Parent home_tenant_payment = loader.load();
                TenantMainController tnt_main = loader.getController();
                tnt_main.getUserId(username);
                Scene tenant3rd_page = new Scene(home_tenant_payment);
                tenantMainController = loader.getController();
                tenant_stage.setScene(tenant3rd_page);
                tenant_stage.show();
            } else
                warning.setVisible(true);
        }
        else
            warning2.setVisible(true);
    }

}