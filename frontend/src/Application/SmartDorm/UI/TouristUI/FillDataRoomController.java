package Application.SmartDorm.UI.TouristUI;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FillDataRoomController extends StackPane implements Initializable {
    // set Singleton pattern
    private static FillDataRoomController instance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private FillDataRoomController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FillDataPrivateRoomPopup.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static FillDataRoomController getInstance(){
        if (instance == null) {
            instance = new FillDataRoomController();
        }
        return instance;
    }

    //Clear instance class
    public void ClearManage() {
        if (instance != null)
            instance = null;
    }
}
