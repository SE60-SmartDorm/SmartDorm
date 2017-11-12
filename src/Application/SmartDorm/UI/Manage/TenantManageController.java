package Application.SmartDorm.UI.Manage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class TenantManageController implements Initializable {
    @FXML
    private JFXTreeTableView<PeopleExData> peopleTableView;

    @FXML
    private TreeTableColumn<PeopleExData, String> roomCol;

    @FXML
    private TreeTableColumn<PeopleExData, String> statusCol;

    @FXML
    private TreeTableColumn<PeopleExData, String> nameCol;

    @FXML
    private TreeTableColumn<PeopleExData, String> contractSCol;

    @FXML
    private TreeTableColumn<PeopleExData, String> contractECol;

    @FXML
    private TextField searchData;

    @FXML
    private JFXButton addData;

    @FXML
    private JFXButton editData;

    @FXML
    private JFXButton deleteData;

    @FXML
    private JFXButton detailData;

    private ObservableList<PeopleExData> list = FXCollections.observableArrayList();

    /**
     * The constructor (is called before the initialize()-method).
     */
    public TenantManageController() {
        //TODO DATABASE
        // Data call DATABASE
        list.add(new PeopleExData("101", "BOOK", "ABCD", "10/10/2559", "15/10/2560"));
        list.add(new PeopleExData("102", "-", "adcd", "01/10/2559", "15/01/2560"));
        list.add(new PeopleExData("103", "-", "aBCde", "14/10/2559", "15/12/2560"));
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Load person detail to treeTable
        LoadDataToTable();

        //Search data in treeTable
        SearchDataInTable();

    }

    void LoadDataToTable() {
        roomCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PeopleExData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PeopleExData, String> param) {
                return param.getValue().getValue().room;
            }
        });

        statusCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PeopleExData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PeopleExData, String> param) {
                return param.getValue().getValue().status;
            }
        });

        nameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PeopleExData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PeopleExData, String> param) {
                return param.getValue().getValue().name;
            }
        });

        contractSCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PeopleExData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PeopleExData, String> param) {
                return param.getValue().getValue().startDate;
            }
        });

        contractECol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PeopleExData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PeopleExData, String> param) {
                return param.getValue().getValue().endDate;
            }
        });

        // show data
        TreeItem<PeopleExData> root = new RecursiveTreeItem<PeopleExData>(list, RecursiveTreeObject::getChildren);
        peopleTableView.setRoot(root);
        peopleTableView.setShowRoot(false);
    }

    void SearchDataInTable() {

        searchData.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                peopleTableView.setPredicate(new Predicate<TreeItem<PeopleExData>>() {

                    @Override
                    public boolean test(TreeItem<PeopleExData> peopleExDataTreeItem) {
                        return peopleExDataTreeItem.getValue().room.getValue().contains(newValue) |
                                peopleExDataTreeItem.getValue().status.getValue().contains(newValue) |
                                peopleExDataTreeItem.getValue().name.getValue().contains(newValue) |
                                peopleExDataTreeItem.getValue().startDate.getValue().contains(newValue) |
                                peopleExDataTreeItem.getValue().endDate.getValue().contains(newValue);
                    }
                });
            }
        });
    }

    @FXML
    void deleteData(ActionEvent event) {

        //TODO FIX bug when delete null TreeTable
        int indexTable = peopleTableView.getSelectionModel().getSelectedIndex();
        list.remove(indexTable);
    }
}
