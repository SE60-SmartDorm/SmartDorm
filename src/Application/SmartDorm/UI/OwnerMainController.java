package Application.SmartDorm.UI;

import Application.SmartDorm.MainSmartDorm;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class OwnerMainController {
    @FXML
    private AnchorPane ownerRoot;

    @FXML
    private StackPane ownerChangePane;

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

    }

    @FXML
    private void tenantManageView(ActionEvent event) {
        PauseTransition pause = new PauseTransition(Duration.seconds(0.05));
        pause.setOnFinished(actionEvent -> {
            setNode(MainSmartDorm.tenantManage);
        });
        pause.play();
    }

    //Set selected node to a content holder
    private void setNode(Node node) {
        ownerChangePane.getChildren().clear();
        ownerChangePane.getChildren().add(node);

    }


}
