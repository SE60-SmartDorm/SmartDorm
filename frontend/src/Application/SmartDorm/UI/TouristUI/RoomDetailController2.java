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

public class RoomDetailController2 extends StackPane implements Initializable {
    // set Singleton pattern
    private static RoomDetailController2 instance;

    @FXML
    private JFXButton bookingButton;

    @FXML
    private StackPane popupPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private RoomDetailController2() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RoomDetail2.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static RoomDetailController2 getInstance(){
        if (instance == null) {
            instance = new RoomDetailController2();
        }
        return instance;
    }

    //Clear instance class
    public void ClearManage() {
        if (instance != null)
            instance = null;
    }

    @FXML
    public void pic1Click(ActionEvent event) throws IOException {
        System.out.println("1");
        JFXDialogLayout imge = new JFXDialogLayout();
        PicturePopupController pic1 = PicturePopupController.getInstance();
        pic1.setImage("hostel_image/p1.jpg");
        imge.setBody(pic1);
        JFXDialog dialog = new JFXDialog(popupPane, imge,JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }

    @FXML
    public void pic2Click(ActionEvent event) throws IOException {
        System.out.println("2");
        JFXDialogLayout imge = new JFXDialogLayout();
        PicturePopupController pic2 = PicturePopupController.getInstance();
        pic2.setImage("hostel_image/p2.jpg");
        imge.setBody(pic2);
        JFXDialog dialog = new JFXDialog(popupPane, imge,JFXDialog.DialogTransition.CENTER);
        dialog.show();

    }

    @FXML
    public void pic3Click(ActionEvent event) throws IOException {
        System.out.println("3");
        JFXDialogLayout imge = new JFXDialogLayout();
        PicturePopupController pic3 = PicturePopupController.getInstance();
        pic3.setImage("hostel_image/p4.jpg");
        imge.setBody(pic3);
        JFXDialog dialog = new JFXDialog(popupPane, imge,JFXDialog.DialogTransition.CENTER);
        dialog.show();

    }

    @FXML
    public void pic4Click(ActionEvent event) throws IOException {
        System.out.println("4");
        JFXDialogLayout imge = new JFXDialogLayout();
        PicturePopupController pic4 = PicturePopupController.getInstance();
        pic4.setImage("hostel_image/p3.jpg");
        imge.setBody(pic4);
        JFXDialog dialog = new JFXDialog(popupPane, imge,JFXDialog.DialogTransition.CENTER);
        dialog.show();

    }

    @FXML
    public void close(ActionEvent event) throws IOException {
        SearchUI2Controller searchVari = SearchUI2Controller.getInstance();
        setNode(searchVari);

    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }

}
