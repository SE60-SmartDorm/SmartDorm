package Application.SmartDorm.UI;

import Application.SmartDorm.MainSmartDorm;
import Application.SmartDorm.UI.Manage.TenantManageController;
import Application.SmartDorm.UI.Request.HistoryRequestController;
import Application.SmartDorm.UI.TenantPayment.TenantPaymentController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TenantMainController {
    @FXML
    private AnchorPane ownerRoot;

    @FXML
    private StackPane tenantChangePane;

    public static StackPane mainTenantChangePane;

    Stage tenant_stage = MainSmartDorm.getStage();

    public static TenantPaymentController tenantPayVari;

    @FXML
    JFXButton logoutButton;
    // set pane
    private Node tenantPaymentView,tenantDashboardView,tenantNotificationView;

    //define controller
    public static TenantManageController manageController;
    /**
     * The constructor (is called before the initialize()-method).
     */
    public TenantMainController() {

    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        mainTenantChangePane = tenantChangePane;
        loadOwnerMain();
        setNode(tenantDashboardView);
    }

    @FXML
    private void tenantManageView(ActionEvent event) {
        tenantPayVari.listMonth.getSelectionModel().clearSelection();
        tenantPayVari.setBillDetail(0,0,0,0,0,0,0);
        setNode(tenantPaymentView);
    }

    @FXML
    void dashboardView(ActionEvent event) {
        setNode(tenantDashboardView);
    }

    @FXML
    void ownerNotificationView(ActionEvent event) {
        setNode(tenantNotificationView);
    }


    @FXML
    void loginView(ActionEvent event) {
        //logoutButton.getScene().getWindow().hide();
        try {
            Parent home_login = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(home_login);
            tenant_stage.setScene(scene);
            tenant_stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Set selected node to a content holder
    private void setNode(Node node) {
        tenantChangePane.getChildren().clear();
        tenantChangePane.getChildren().add(node);

    }

    public void loadOwnerMain(){
        FXMLLoader loaderTenantPayment = new FXMLLoader(getClass().getResource("TenantPayment/TenantPayment.fxml"));
        FXMLLoader loaderOwnerDashboard = new FXMLLoader(getClass().getResource("TenantDashboard.fxml"));
        FXMLLoader loaderOwnerNotification = new FXMLLoader(getClass().getResource("Request/MainRequest.fxml"));
        try {
            tenantPaymentView = loaderTenantPayment.load();
            tenantDashboardView = loaderOwnerDashboard.load();
            tenantNotificationView = loaderOwnerNotification.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tenantPayVari = loaderTenantPayment.getController();

    }


}
