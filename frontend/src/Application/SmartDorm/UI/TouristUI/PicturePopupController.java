package Application.SmartDorm.UI.TouristUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PicturePopupController extends StackPane implements Initializable {
    // set Singleton pattern
    private static PicturePopupController instance;

    @FXML
    private ImageView imageShow;

    public void setImage(String url){
        imageShow.setImage(new Image(getClass().getResourceAsStream(url)));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private PicturePopupController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PicturePopup.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static PicturePopupController getInstance(){
        if (instance == null) {
            instance = new PicturePopupController();
        }
        return instance;
    }

    //Clear instance class
    public void ClearManage() {
        if (instance != null)
            instance = null;
    }
}
