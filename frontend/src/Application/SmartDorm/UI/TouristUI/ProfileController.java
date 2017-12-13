package Application.SmartDorm.UI.TouristUI;

import Application.SmartDorm.UI.TenantMainController;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController extends StackPane implements Initializable {

    @FXML
    private StackPane popupPane;

    @FXML
    public TextField nameField;

    @FXML
    public TextArea introField;

    public TextField getNameField() {
        return nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public TextArea getIntroField() {
        return introField;
    }

    public void setIntroField(TextArea introField) {
        this.introField = introField;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(getNameField().getText());
        System.out.println("-----------------------------------------------------");
        System.out.println(getIntroField().getText());
        nameField.setText(getNameField().getText());
        introField.setText(getIntroField().getText());
    }

    @FXML
    public void edit(ActionEvent event) throws IOException {
        JFXDialogLayout edit = new JFXDialogLayout();
        FXMLLoader popup = new FXMLLoader(getClass().getResource("EditProfilePopup.fxml"));
        StackPane newPopup = null;
        newPopup = popup.load();
        edit.setBody(newPopup);
        JFXDialog dialog = new JFXDialog(popupPane, edit,JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }



    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);
    }
}
