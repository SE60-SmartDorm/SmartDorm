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
import javafx.scene.layout.StackPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomDetailController implements Initializable{

    @FXML
    private JFXButton bookingButton;

    @FXML
    private StackPane popupPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void pic1Click(ActionEvent event) throws IOException {
        System.out.println("1");
        JFXDialogLayout imge = new JFXDialogLayout();
        PicturePopupController pic1 = PicturePopupController.getInstance();
        pic1.setImage("hostel_image/cmi1.jpg");
        imge.setBody(pic1);
        JFXDialog dialog = new JFXDialog(popupPane, imge,JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }

    @FXML
    public void pic2Click(ActionEvent event) throws IOException {
        System.out.println("2");
        JFXDialogLayout imge = new JFXDialogLayout();
        PicturePopupController pic2 = PicturePopupController.getInstance();
        pic2.setImage("hostel_image/cmi2.jpg");
        imge.setBody(pic2);
        JFXDialog dialog = new JFXDialog(popupPane, imge,JFXDialog.DialogTransition.CENTER);
        dialog.show();

    }

    @FXML
    public void pic3Click(ActionEvent event) throws IOException {
        System.out.println("3");
        JFXDialogLayout imge = new JFXDialogLayout();
        PicturePopupController pic3 = PicturePopupController.getInstance();
        pic3.setImage("hostel_image/cmi3.jpg");
        imge.setBody(pic3);
        JFXDialog dialog = new JFXDialog(popupPane, imge,JFXDialog.DialogTransition.CENTER);
        dialog.show();

    }

    @FXML
    public void pic4Click(ActionEvent event) throws IOException {
        System.out.println("4");
        JFXDialogLayout imge = new JFXDialogLayout();
        PicturePopupController pic4 = PicturePopupController.getInstance();
        pic4.setImage("hostel_image/cmi4.jpg");
        imge.setBody(pic4);
        JFXDialog dialog = new JFXDialog(popupPane, imge,JFXDialog.DialogTransition.CENTER);
        dialog.show();

    }

    @FXML
    public void pic5Click(ActionEvent event) throws IOException {
        System.out.println("5");
        JFXDialogLayout imge = new JFXDialogLayout();
        PicturePopupController pic5 = PicturePopupController.getInstance();
        pic5.setImage("hostel_image/cmi5.jpg");
        imge.setBody(pic5);
        JFXDialog dialog = new JFXDialog(popupPane, imge,JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }

    @FXML
    public void close(ActionEvent event) throws IOException {
        Node searchUI2 = FXMLLoader.load(getClass().getResource("SearchUI2.fxml"));
        setNode(searchUI2);
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }

}
