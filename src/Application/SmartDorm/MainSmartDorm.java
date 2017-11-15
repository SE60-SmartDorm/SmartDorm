package Application.SmartDorm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class to start the application.
 *
 * @author EIEI ZA
 */
public class MainSmartDorm extends Application {

    Stage stage;
    public static Node tenantManage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("UI/OwnerMain.fxml"));
        tenantManage = FXMLLoader.load(getClass().getResource("UI/Manage/TenantManage.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Smart Dorm");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
