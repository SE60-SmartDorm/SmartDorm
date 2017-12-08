package Application.SmartDorm.UI.Request;

import Application.SmartDorm.UI.TenantMainController;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

import java.io.IOException;

public class HistoryRequestController {
    private static ObservableList<RequestTableData> requestList = FXCollections.observableArrayList();
    @FXML
    private JFXTreeTableView<RequestTableData> requestTableView;
    @FXML
    private TreeTableColumn<RequestTableData, String> requestDateCol;
    @FXML
    private TreeTableColumn<RequestTableData, String> requestTypeCol;
    @FXML
    private TreeTableColumn<RequestTableData, String> requestTopicCol;
    @FXML
    private TreeTableColumn<RequestTableData, String> requestDetailCol;

    @FXML
    public void initialize() {
        LoadDataFormTenantTable();
    }

    private void LoadDataFormTenantTable() {
        requestDateCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<RequestTableData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<RequestTableData, String> param) {
                return param.getValue().getValue().requestDateProperty();
            }
        });

        requestTypeCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<RequestTableData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<RequestTableData, String> param) {
                return param.getValue().getValue().requestTypeProperty();
            }
        });

        requestTopicCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<RequestTableData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<RequestTableData, String> param) {
                return param.getValue().getValue().requestTopicProperty();
            }
        });

        requestDetailCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<RequestTableData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<RequestTableData, String> param) {
                return param.getValue().getValue().requestDetailProperty();
            }
        });

        TreeItem<RequestTableData> root = new RecursiveTreeItem<RequestTableData>(requestList, RecursiveTreeObject::getChildren);
        requestTableView.setRoot(root);
        requestTableView.setShowRoot(false);
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Node home_tenant_payment = FXMLLoader.load(getClass().getResource("MainRequest.fxml"));
        setNode(home_tenant_payment);
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }
}
