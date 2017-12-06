package Application.SmartDorm.UI.TenantPayment;

import Application.SmartDorm.MainSmartDorm;
import Application.SmartDorm.UI.TenantMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

    private String accountDB = "";
    private String passwordDB = "";
    private String accountName = "Anucha Raseebut";
    private static double accountCurrent = 1000000;

    public static double getAccountCurrent() {
        return accountCurrent;
    }

    public static void setAccountCurrent(double accountCurrent) {
        TenantPayment3rdLoginController.accountCurrent = accountCurrent;
    }

    public String getAccountName() {
        return accountName;
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        errorHint.setVisible(false);
        if((accountDB.equals(accountNum.getText()))&&(passwordDB.equals(pass.getText()))) {

                Node home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPaymentPayConfirm.fxml"));
                setNode(home_tenant_payment);

        }
        else
            errorHint.setVisible(true);
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Node home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPayment.fxml"));
        setNode(home_tenant_payment);

    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }
}

