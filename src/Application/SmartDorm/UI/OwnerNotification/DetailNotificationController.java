package Application.SmartDorm.UI.OwnerNotification;

import Application.SmartDorm.UI.OwnerMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DetailNotificationController implements Initializable {

    @FXML
    private TextField headDetail;

    @FXML
    private TextArea requestDetail;

    @FXML
    private Label roomNumber;

    private void showDetail()
    {
        roomNumber.setText(OwnerMainController.notiController.getRoomNumber());
        headDetail.setText(OwnerMainController.notiController.getHead());
        requestDetail.setText(OwnerMainController.notiController.getDetail());
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Node home_tenant_payment = FXMLLoader.load(getClass().getResource("OwnerNotification.fxml"));
        setNode(home_tenant_payment);

    }
    private void setNode(Node node) {
        OwnerMainController.mainOwnerChangePane.getChildren().clear();
        OwnerMainController.mainOwnerChangePane.getChildren().add(node);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showDetail();
    }
}
