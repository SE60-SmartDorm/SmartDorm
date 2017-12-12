package Application.SmartDorm.UI.TouristUI;

import Application.SmartDorm.UI.TenantMainController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchUI2Controller extends StackPane implements Initializable {

    // set Singleton pattern
    private static SearchUI2Controller instance;

    @FXML
    private StackPane popupPane;

    @FXML
    private JFXButton bookingButton;

    @FXML
    private CheckBox select1;

    @FXML
    private CheckBox select2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private SearchUI2Controller() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchUI2.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static SearchUI2Controller getInstance(){
        if (instance == null) {
            instance = new SearchUI2Controller();
        }
        return instance;
    }

    //Clear instance class
    public void ClearManage() {
        if (instance != null)
            instance = null;
    }

    @FXML
    public void bookingClick(ActionEvent event) throws IOException {
        JFXDialogLayout booking = new JFXDialogLayout();
        FillDataRoomController popup1 = FillDataRoomController.getInstance();
        booking.setBody(popup1);
        JFXDialog dialog = new JFXDialog(popupPane, booking,JFXDialog.DialogTransition.CENTER);
        dialog.show();

    }

    @FXML
    public void detailClick(ActionEvent event) throws IOException {
        RoomDetailController searchVari = RoomDetailController.getInstance();
        setNode(searchVari);
    }

    @FXML
    public void bookingClick2(ActionEvent event) throws IOException {
        JFXDialogLayout booking = new JFXDialogLayout();
        FillDataRoomController2 popup1 = FillDataRoomController2.getInstance();
        booking.setBody(popup1);
        JFXDialog dialog = new JFXDialog(popupPane, booking,JFXDialog.DialogTransition.CENTER);
        dialog.show();

    }

    @FXML
    public void detailClick2(ActionEvent event) throws IOException {
        RoomDetailController2 searchVari = RoomDetailController2.getInstance();
        setNode(searchVari);
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }

}
