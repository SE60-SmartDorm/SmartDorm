package Application.SmartDorm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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

        Image icon = new Image(getClass().getResourceAsStream("UI/resource/images/home-icon.png"));
        stage.getIcons().add(icon);
        Scene scene = new Scene(root);

        stage.setTitle("Smart Dorm");
        stage.setScene(scene);
        stage.show();

    }
}
