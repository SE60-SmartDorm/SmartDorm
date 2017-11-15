package Application.SmartDorm.UI;

import Application.SmartDorm.MainSmartDorm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class OwnerMainController {
    @FXML
    private static AnchorPane ownerRoot;
    AnchorPane home, tenantManage;
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
        // Switch pane
    }

    @FXML
    private void tenantManageView(ActionEvent event) {
        setNode(MainSmartDorm.tenantManage);
    }

    //Set selected node to a content holder
    private void setNode(Node node) {
        ownerChangePane.getChildren().clear();
        ownerChangePane.getChildren().add(node);

    }
}
