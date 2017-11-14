package Application.SmartDorm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class to start the application.
 *
 * @author EIEI ZA
 */
public class MainSmartDorm extends Application {
    private static Stage stage;

    private void setStage(Stage stage)
    {
        MainSmartDorm.stage = stage;
    }

    static public Stage getStage()
    {
        return MainSmartDorm.stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;

        setStage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("UI/login.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Smart Dorm");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
