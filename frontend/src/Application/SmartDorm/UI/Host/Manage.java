package Application.SmartDorm.UI.Host;

import Application.SmartDorm.UI.OwnerMainController;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Manage extends AnchorPane implements Initializable {
    // set Singleton pattern
    private static Manage instance;
    //other Variable
    ObservableList<TouristBooking> tourist_bookings_list = FXCollections.observableArrayList();
    String test;
    //FXML Variable
    @FXML
    private JFXTreeTableView<TouristBooking> tourist_tableview;
    @FXML
    private TreeTableColumn<TouristBooking, String> booking_date_col;
    @FXML
    private TreeTableColumn<TouristBooking, String> tourist_name_col;
    @FXML
    private TreeTableColumn<TouristBooking, String> room_type_col;
    @FXML
    private TreeTableColumn<TouristBooking, String> room_number_col;
    @FXML
    private TreeTableColumn<TouristBooking, String> checkin_col;
    @FXML
    private TreeTableColumn<TouristBooking, String> checkout_col;
    @FXML
    private JFXButton detailBT;
    @FXML
    private StackPane popup_pane;

    public JFXTreeTableView<TouristBooking> getTourist_tableview() {
        return tourist_tableview;
    }

    //Constructor
    private Manage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manage.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    //get instant singleton pattern class
    public static Manage getInstance() {
        if (instance == null) {
            instance = new Manage();
        }
        return instance;
    }

    //Clear instance class
    public void ClearManage() {
        if (instance != null)
            instance = null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTouristToTable();

//
    }

    @FXML
    void detail(ActionEvent event) {
        RequestManage requestManage = RequestManage.getInstance();
        tourist_tableview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                requestManage.getItem(newValue);
            }
        });

        setNode(requestManage);
    }


    public void addDataTable(String startD, String endD, String room_num) {
        tourist_bookings_list.add(new TouristBooking("2017/12/13", "Kekie", "ห้องส่วนตัว", room_num, startD, endD));
    }

    void loadTouristToTable() {
        booking_date_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TouristBooking, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TouristBooking, String> param) {
                return param.getValue().getValue().booking_dateProperty();
            }
        });

        tourist_name_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TouristBooking, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TouristBooking, String> param) {
                return param.getValue().getValue().tourist_nameProperty();
            }
        });

        room_type_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TouristBooking, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TouristBooking, String> param) {
                return param.getValue().getValue().room_typeProperty();
            }
        });

        room_number_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TouristBooking, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TouristBooking, String> param) {
                return param.getValue().getValue().room_numberProperty();
            }
        });

        checkin_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TouristBooking, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TouristBooking, String> param) {
                return param.getValue().getValue().checkinProperty();
            }
        });

        checkout_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TouristBooking, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TouristBooking, String> param) {
                return param.getValue().getValue().checkoutProperty();
            }
        });

        // build tree
        TreeItem<TouristBooking> root = new RecursiveTreeItem<TouristBooking>(tourist_bookings_list, RecursiveTreeObject::getChildren);
        tourist_tableview.setRoot(root);
        tourist_tableview.setShowRoot(false);
    }

    public void addTouristRequest(TouristBooking request) {
        tourist_bookings_list.add(request);
    }

    //Set selected node to a content holder
    private void setNode(Node node) {
        OwnerMainController.mainOwnerChangePane.getChildren().clear();
        OwnerMainController.mainOwnerChangePane.getChildren().add(node);

    }
}
