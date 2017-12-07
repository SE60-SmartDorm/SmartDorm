package Application.SmartDorm.UI;

import Application.SmartDorm.MainSmartDorm;
import Application.SmartDorm.UI.Manage.TenantManageController;
import Application.SmartDorm.UI.OwnerNotification.OwnerNotificationController;
import com.jfoenix.controls.JFXButton;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class OwnerMainController {
    @FXML
    private AnchorPane ownerRoot;

    @FXML
    private StackPane ownerChangePane;

    public static StackPane mainOwnerChangePane;

    @FXML
    JFXButton logoutButton;

    // set pane
    private Node tenantManageView,dashboardView,ownerNotificationView;

    //define controller
    public static TenantManageController manageController;
    public static OwnerNotificationController notiController;
    /**
     * The constructor (is called before the initialize()-method).
     */
    public OwnerMainController() {

    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        mainOwnerChangePane = ownerChangePane;
        loadOwnerMain();
        setNode(dashboardView);

    }

    @FXML
    private void tenantManageView(ActionEvent event) {
            setNode(tenantManageView);
    }

    @FXML
    void dashboardView(ActionEvent event) {
        setNode(dashboardView);
    }

    @FXML
    void ownerNotificationView(ActionEvent event) {
        notiController.hintSelect.setVisible(false);
        setNode(ownerNotificationView);
    }

    Stage tenant_stage = MainSmartDorm.getStage();

    @FXML
    void loginView(ActionEvent event) {
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
        ownerChangePane.getChildren().clear();
        ownerChangePane.getChildren().add(node);

    }

    public void loadOwnerMain(){
        FXMLLoader loaderTenantManage = new FXMLLoader(getClass().getResource("Manage/TenantManage.fxml"));
        FXMLLoader loaderOwnerDashboard = new FXMLLoader(getClass().getResource("OwnerDashboard.fxml"));
        FXMLLoader loaderOwnerNotification = new FXMLLoader(getClass().getResource("OwnerNotification/OwnerNotification.fxml"));

        try {
            tenantManageView = loaderTenantManage.load();
            dashboardView = loaderOwnerDashboard.load();
            ownerNotificationView = loaderOwnerNotification.load();

        } catch (IOException e) {
            e.printStackTrace();
        }
        manageController = loaderTenantManage.getController();
        notiController = loaderOwnerNotification.getController();
    }


}
