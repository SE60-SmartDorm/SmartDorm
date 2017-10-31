package Application.SmartDorm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainSmartDorm extends Application {

    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("UI/TenantPayment/TenantPayment.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Smart Dorm");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
