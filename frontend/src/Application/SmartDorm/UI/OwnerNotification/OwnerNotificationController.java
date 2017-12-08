package Application.SmartDorm.UI.OwnerNotification;

import Application.SmartDorm.UI.Manage.TenantTable;
import Application.SmartDorm.UI.OwnerMainController;
import Application.SmartDorm.UI.TenantMainController;
import Controller.MessageController;
import Entity.Message;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OwnerNotificationController implements Initializable {
    @FXML
    private JFXTreeTableView<NoitificationDataTable> peopleTableView;

    @FXML
    private TreeTableColumn<NoitificationDataTable, String> roomCol;

    @FXML
    private TreeTableColumn<NoitificationDataTable, String> statusCol;

    @FXML
    private TreeTableColumn<NoitificationDataTable, String> nameCol;

    @FXML
    private TreeTableColumn<NoitificationDataTable, String> contractSCol;

    @FXML
    private JFXButton buttonUpload;

    @FXML
    public Label hintSelect;



    private static ObservableList<NoitificationDataTable> notificationTableData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadDataFormTenantTable();
        notificationTableData.clear();
        List<Message> m = MessageController.getAll();

        for (Message mm : m) {
            notificationTableData.add(new NoitificationDataTable(mm.getOwner_id() + "", mm.getType(), mm.getTopic(), mm.getDetail()));
        }

    }


    private void LoadDataFormTenantTable() {
        roomCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<NoitificationDataTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<NoitificationDataTable, String> param) {
                return param.getValue().getValue().roomColProperty();
            }
        });

        statusCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<NoitificationDataTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<NoitificationDataTable, String> param) {
                return param.getValue().getValue().statusColProperty();
            }
        });

        nameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<NoitificationDataTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<NoitificationDataTable, String> param) {
                return param.getValue().getValue().nameColProperty();
            }
        });

        contractSCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<NoitificationDataTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<NoitificationDataTable, String> param) {
                return param.getValue().getValue().contractSColProperty();
            }
        });

        TreeItem<NoitificationDataTable> root = new RecursiveTreeItem<NoitificationDataTable>(notificationTableData, RecursiveTreeObject::getChildren);
        peopleTableView.setRoot(root);
        peopleTableView.setShowRoot(false);
    }

    TreeItem<NoitificationDataTable> roomID = new TreeItem<>();
    TreeItem<NoitificationDataTable> detailID = new TreeItem<>();
    TreeItem<NoitificationDataTable> headlID = new TreeItem<>();

    public static String roomNumber,detail,head;

    public  String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        OwnerNotificationController.roomNumber = roomNumber;
    }

    public static String getDetail() {
        return detail;
    }

    public static void setDetail(String detail) {
        OwnerNotificationController.detail = detail;
    }

    public static String getHead() {
        return head;
    }

    public static void setHead(String head) {
        OwnerNotificationController.head = head;
    }

    private void check(){

        System.out.println(getRoomNumber());

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        roomID = peopleTableView.getSelectionModel().getSelectedItem();
        detailID = peopleTableView.getSelectionModel().getSelectedItem();
        headlID = peopleTableView.getSelectionModel().getSelectedItem();
        if(roomID != null) {
           setRoomNumber(roomID.getValue().getRoomCol());
           setDetail(detailID.getValue().getContractSCol());
           setHead(headlID.getValue().getNameCol());
           check();
           Node home_tenant_payment = FXMLLoader.load(getClass().getResource("DetailNotification.fxml"));
           setNode(home_tenant_payment);
       }
       else
       {
           hintSelect.setVisible(true);
       }

    }
    private void setNode(Node node) {
        OwnerMainController.mainOwnerChangePane.getChildren().clear();
        OwnerMainController.mainOwnerChangePane.getChildren().add(node);

    }
}
