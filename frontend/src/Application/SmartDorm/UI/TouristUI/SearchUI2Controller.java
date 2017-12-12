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
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchUI2Controller extends StackPane implements Initializable {

    @FXML
    private StackPane popupPane;

    @FXML
    private JFXButton bookingButton1;

    @FXML
    private JFXButton bookingButton2;

    @FXML
    private CheckBox select1;

    @FXML
    private CheckBox select2;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    Boolean check1,check2;

    TenantMainController searchUIControler;

    String searchText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchText = searchUIControler.searchUI.getSearchText();
        check1 = select1.isSelected();
        check2 = select2.isSelected();
        if("เชียงใหม่".equals(searchText)||"Hahaha House".equals(searchText))
        {
            vbox2.managedProperty().bind(vbox2.visibleProperty());
            vbox2.setVisible(false);
        }
        else if("พัทยา".equals(searchText)||"Oh! Sleep Sleep".equals(searchText))
        {
            vbox1.managedProperty().bind(vbox1.visibleProperty());
            vbox1.setVisible(false);
        }
        else
        {
            vbox2.managedProperty().bind(vbox2.visibleProperty());
            vbox2.setVisible(false);
            vbox1.managedProperty().bind(vbox1.visibleProperty());
            vbox1.setVisible(false);
        }
        if(check1!=true)
        {
            bookingButton1.setDisable(true);
        }
        if(check2!=true)
        {
            bookingButton2.setDisable(true);
        }

    }

    public String setText(String text){
        String newtext = text;
        System.out.println(newtext + "2");
        return newtext;
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
        Node detailUI1 = FXMLLoader.load(getClass().getResource("RoomDetail.fxml"));
        setNode(detailUI1);
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
        Node detailUI2 = FXMLLoader.load(getClass().getResource("RoomDetail2.fxml"));
        setNode(detailUI2);
    }

    @FXML
    public void setSelect1Click(ActionEvent event) throws IOException {
        check1 = select1.isSelected();
        if(check1!=true)
        {
            bookingButton1.setDisable(true);
        }
        else
        {
            bookingButton1.setDisable(false);
        }

    }

    @FXML
    public void setSelect1Click2(ActionEvent event) throws IOException {
        check2 = select2.isSelected();
        if(check2!=true)
        {
            bookingButton2.setDisable(true);
        }
        else
        {
            bookingButton2.setDisable(false);
        }
    }


    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);
    }
}
