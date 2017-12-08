package Application.SmartDorm.UI.Manage;

import Application.SmartDorm.MainSmartDorm;
import Controller.RoomController;
import Controller.TenantController;
import Entity.Room;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TenantManageController {
    private final Comparator<TenantTable> ROOM_COMPARATOR = (TenantTable o1, TenantTable o2) -> o1.roomProperty().get().compareTo(o2.roomProperty().get());
    private final ObjectProperty<Comparator<? super TenantTable>> ROOM_COMPARATOR_WRAPPER = new SimpleObjectProperty<>(ROOM_COMPARATOR);
    //component
    String roomID;
    private ObservableList<TenantTable> tenantTableData = FXCollections.observableArrayList();
    private SortedList<TenantTable> sortedData;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTreeTableView<TenantTable> tenantTableView;
    @FXML
    private TreeTableColumn<TenantTable, String> tenantRoomCol;
    @FXML
    private TreeTableColumn<TenantTable, String> tenantStatusCol;
    @FXML
    private TreeTableColumn<TenantTable, String> tenantNameCol;
    @FXML
    private TreeTableColumn<TenantTable, String> tenantLeasesSCol;
    @FXML
    private TreeTableColumn<TenantTable, String> tenantLeasesECol;
    @FXML
    private TreeTableColumn<TenantTable, String> noteTenantCol;
    @FXML
    private TextField searchData;
    @FXML
    private JFXButton addTenantDataBT;
    @FXML
    private JFXButton editTenantDataBT;
    @FXML
    private JFXButton deleteTenantDataBT;
    @FXML
    private JFXButton detailTenantDataBT;
    //init xy offsets
    private double xOffset = 0;
    private double yOffset = 0;

    /**
     * The constructor (is called before the initialize()-method).
     */
    public TenantManageController() {

    }

    //setter and setter
    public ObservableList<TenantTable> getTenantTableData() {
        return tenantTableData;
    }

    public JFXTreeTableView<TenantTable> getTenantTableView() {
        return tenantTableView;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        tenantTableData.clear();
        List<Room> allRooms = RoomController.getAllRooms();

        for (Room r : allRooms) {
            String rm = "" + r.getId();
            String sts = (r.isVacant() == true ? "ว่าง" : "ไม่ว่าง");
            String tenant = (r.getPrimary_tenant() == 0 ? "" : TenantController.getById(r.getPrimary_tenant()).getName());
            String std = r.getStart_date();
            String ed = r.getEnd_date();
            tenantTableData.add(new TenantTable(rm, sts, tenant, std, ed, ""));
        }

        //Load person detail to treeTable
        LoadDataFormTenantTable();

        //Search data in treeTable
        SearchTenantDataInTable();

        //Selection room
        tenantSetButtonDisable();
        tenantTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            tenantSetButtonEnable();
//            if(newValue.getValue().getRoom().equals("ว่าง")){
//                addTenantDataBT.setDisable(false);
//                editTenantDataBT.setDisable(true);
//                deleteTenantDataBT.setDisable(true);
//                detailTenantDataBT.setDisable(true);
//            }else if(newValue.getValue().getRoom().equals("ไม่ว่าง")){
//                addTenantDataBT.setDisable(true);
//                editTenantDataBT.setDisable(false);
//                deleteTenantDataBT.setDisable(false);
//                detailTenantDataBT.setDisable(false);
//            }
        });
    }

    private void LoadDataFormTenantTable() {
        tenantRoomCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TenantTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TenantTable, String> param) {
                return param.getValue().getValue().roomProperty();
            }
        });

        tenantStatusCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TenantTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TenantTable, String> param) {
                return param.getValue().getValue().statusProperty();
            }
        });

        tenantNameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TenantTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TenantTable, String> param) {
                return param.getValue().getValue().nameProperty();
            }
        });

        tenantLeasesSCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TenantTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TenantTable, String> param) {
                return param.getValue().getValue().startDateProperty();
            }
        });

        tenantLeasesECol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TenantTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TenantTable, String> param) {
                return param.getValue().getValue().endDateProperty();
            }
        });

        noteTenantCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TenantTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TenantTable, String> param) {
                return param.getValue().getValue().tenantNoteProperty();
            }
        });
//        sort data (not important now)
//        sortedData = new SortedList<>(tenantTableData);
//        sortedData.comparatorProperty().bind(ROOM_COMPARATOR_WRAPPER);

        // build tree
        TreeItem<TenantTable> root = new RecursiveTreeItem<TenantTable>(tenantTableData, RecursiveTreeObject::getChildren);
        tenantTableView.setRoot(root);
        tenantTableView.setShowRoot(false);
    }

    private void SearchTenantDataInTable() {

        searchData.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tenantTableView.setPredicate(new Predicate<TreeItem<TenantTable>>() {
                    @Override
                    public boolean test(TreeItem<TenantTable> peopleExDataTreeItem) {
                        return peopleExDataTreeItem.getValue().roomProperty().getValue().contains(newValue) |
                                peopleExDataTreeItem.getValue().statusProperty().getValue().contains(newValue) |
                                peopleExDataTreeItem.getValue().nameProperty().getValue().contains(newValue) |
                                peopleExDataTreeItem.getValue().startDateProperty().getValue().contains(newValue) |
                                peopleExDataTreeItem.getValue().endDateProperty().getValue().contains(newValue);
                    }
                });
            }
        });
    }

    public void tenantSetButtonEnable() {
        addTenantDataBT.setDisable(false);
        editTenantDataBT.setDisable(false);
        deleteTenantDataBT.setDisable(false);
        detailTenantDataBT.setDisable(false);
    }

    public void tenantSetButtonDisable() {
        addTenantDataBT.setDisable(true);
        editTenantDataBT.setDisable(true);
        deleteTenantDataBT.setDisable(true);
        detailTenantDataBT.setDisable(true);
    }

    @FXML
    private void deleteTenantData(ActionEvent event) {
        System.out.println("delete tenant");
        int selectionIndex = tenantTableView.getSelectionModel().getSelectedIndex();

        if (selectionIndex >= 0) {
            TreeItem<TenantTable> treeItemTenant = tenantTableView.getSelectionModel().getSelectedItem();
            TenantTable n = new TenantTable(treeItemTenant.getValue().getRoom(), "ว่าง", "", "", "", "");
            treeItemTenant.setValue(n);
            tenantTableView.getSelectionModel().clearSelection();
            Long room_id = Long.parseLong(tenantTableView.getSelectionModel().getModelItem(selectionIndex).getValue().getRoom());
            Room r = RoomController.getById(room_id);
            TenantController.removeById(r.getPrimary_tenant());
            RoomController.updateTenant(room_id, 0, 0);
            RoomController.setRoomToVacant(room_id);
            RoomController.setContactDate(room_id, "", "");

        } else {
            //TODO Show ERROR
            System.out.println("Error");
        }
        tenantSetButtonDisable();
    }

    @FXML
    void editTenantData(ActionEvent event) {
        setStage("EditTenant.fxml");
    }

    @FXML
    void addTenantData(ActionEvent event) {
        setStage("CreateTenant.fxml");
    }

    private void setStage(String fxml) {
        try {
            //dim overlay on new stage opening
            Region veil = new Region();
            veil.setPrefSize(1000, 768);
            veil.setStyle("-fx-background-color:rgba(0,0,0,0.3)");
            Stage newStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource(fxml));

            //--------------------- Set mouse event ----------------------------
            parent.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            //set mouse drag
            parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    newStage.setX(event.getScreenX() - xOffset);
                    newStage.setY(event.getScreenY() - yOffset);
                }
            });
            //------------------------------------------------------------------

            Scene scene = new Scene(parent);
            scene.setFill(Color.TRANSPARENT);
            newStage.setScene(scene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.getScene().getRoot().setEffect(new DropShadow());
            newStage.showingProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    rootPane.getChildren().add(veil);
                } else if (rootPane.getChildren().contains(veil)) {
                    rootPane.getChildren().removeAll(veil);
                }

            });
            newStage.show();

            //set to center on parent state
            double centerXPosition = MainSmartDorm.getStage().getX() + MainSmartDorm.getStage().getWidth() / 2d;
            double centerYPosition = MainSmartDorm.getStage().getY() + MainSmartDorm.getStage().getHeight() / 2d;
            newStage.setX(centerXPosition - newStage.getWidth() / 2d);
            newStage.setY(centerYPosition - newStage.getHeight() / 2d);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
