package Application.SmartDorm.UI.Host;

import Application.SmartDorm.UI.OwnerMainController;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RequestManage extends StackPane implements Initializable {
    // set Singleton pattern
    private static RequestManage instance;

    TreeItem<TouristBooking> itemtmp;

    @FXML
    private JFXButton reject;

    @FXML
    private JFXButton accept;

    //Constructor
    private RequestManage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Request.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    //get instant singleton pattern class
    public static RequestManage getInstance() {
        if (instance == null) {
            instance = new RequestManage();
        }
        return instance;
    }

    //Clear instance class
    public void Clear() {
        if (instance != null)
            instance = null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reject.setOnAction(event -> {
            Manage re = Manage.getInstance();
            setNode(re);
        });

        accept.setOnAction(event -> {
            Manage re = Manage.getInstance();
            Dashboard add = Dashboard.getInstance();
            add.addTourist();
            re.ClearManage();
            setNode(re);
        });
    }

    private void setNode(Node node) {
        OwnerMainController.mainOwnerChangePane.getChildren().clear();
        OwnerMainController.mainOwnerChangePane.getChildren().add(node);

    }

    public void getItem(TreeItem<TouristBooking> item){
        itemtmp = item;
    }
}
