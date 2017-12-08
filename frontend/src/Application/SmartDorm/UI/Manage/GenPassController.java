package Application.SmartDorm.UI.Manage;

import Application.SmartDorm.MainSmartDorm;
import Application.SmartDorm.UI.OwnerMainController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenPassController implements Initializable{

    TreeItem<TenantTable> treeItemTenant = OwnerMainController.manageController.getTenantTableView().getSelectionModel().getSelectedItem();
    @FXML
    private Label showNoRoom;
    @FXML
    private JFXButton backMenu;
    @FXML
    private TextField showUser;
    @FXML
    private TextField showPass;

    @FXML
    void colse(ActionEvent event) {
        backMenu.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String room = treeItemTenant.getValue().getRoom();
        showNoRoom.setText(room);
        System.out.println("room");
    }
}
