package Application.SmartDorm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class to start the application.
 *
 * @author EIEI ZA
 */
public class MainSmartDorm extends Application {

    public static Node tenantManage;
    private static Stage stage;

    static public Stage getStage() {
        return stage;
    }

    private void setStage(Stage stage) {
        MainSmartDorm.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setStage(primaryStage);

        Parent root = FXMLLoader.load(getClass().getResource("UI/login.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Smart Dorm");
        stage.setScene(scene);
        stage.show();

    }

    public void loadAnotherScene(){
        try {
            tenantManage = FXMLLoader.load(getClass().getResource("UI/Manage/TenantManage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
