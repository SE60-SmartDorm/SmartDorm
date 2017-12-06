package Application.SmartDorm.UI.TenantPayment;

import Application.SmartDorm.MainSmartDorm;
import Application.SmartDorm.UI.TenantMainController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class TenantPaymentPayConfirmController {

    Stage tenant_stage = MainSmartDorm.getStage();

    TenantPaymentController paymentVariable = new TenantPaymentController();
    TenantPayment3rdLoginController thirdPartyVariable = new TenantPayment3rdLoginController();

    @FXML
    private Label totalLB;
    @FXML
    private Label accountNameLB;
    @FXML
    private Label accountCurentLB;
    @FXML
    private Label accountAfterLB;
    @FXML
    private Label errorHintMoney;
    @FXML
    private JFXButton ok;

    double tempAccountBalance;


    public void initialize() {
        totalLB.setText(String.valueOf(paymentVariable.getTotal()));
        accountNameLB.setText(thirdPartyVariable.getAccountName());
        accountCurentLB.setText(String.valueOf(thirdPartyVariable.getAccountCurrent()));
        calAccountAfter();
    }

    public void calAccountAfter(){
        if(thirdPartyVariable.getAccountCurrent() > paymentVariable.getTotal())
        {
            tempAccountBalance = thirdPartyVariable.getAccountCurrent() - paymentVariable.getTotal();
            accountAfterLB.setText(String.valueOf(tempAccountBalance));
        }
        else
        {
            ok.setDisable(true);
            tempAccountBalance = thirdPartyVariable.getAccountCurrent() - paymentVariable.getTotal();
            accountAfterLB.setText(String.valueOf(tempAccountBalance));
            errorHintMoney.setVisible(true);
        }
    }

    @FXML
    private void ok(ActionEvent event) throws IOException {
        paymentVariable.setTotal(0);
        checkPaid();
        thirdPartyVariable.setAccountCurrent(tempAccountBalance);
        Node home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPayment.fxml"));
        setNode(home_tenant_payment);
    }

    public void checkPaid()
    {
        if("January".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[0] = 1;
            System.out.println("January");
        }
        else if ("February".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[1] = 1;
            System.out.println("February");
        }
        else if ("March".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[2] = 1;
            System.out.println("March");
        }
        else if ("April".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[3] = 1;
            System.out.println("April");
        }
        else if ("May".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[4] = 1;
            System.out.println("May");
        }
        else if ("June".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[5] = 1;
            System.out.println("June");
        }
        else if ("July".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[6] = 1;
            System.out.println("July");
        }
        else if ("August".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[7] = 1;
            System.out.println("August");
        }
        else if ("September".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[8] = 1;
            System.out.println("September");
        }
        else if ("October".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[9] = 1;
            System.out.println("October");
        }
        else if ("November".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[10] = 1;
            System.out.println("November");
        }
        else if ("December".equals(paymentVariable.getMonthTemp()))
        {
            paymentVariable.checkMonth[11] = 1;
            System.out.println("December");
        }
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Stage tenant_stage = MainSmartDorm.getStage();

        Node home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPayment.fxml"));
        setNode(home_tenant_payment);

    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }
}
