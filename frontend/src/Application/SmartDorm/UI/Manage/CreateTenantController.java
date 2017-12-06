package Application.SmartDorm.UI.Manage;

import Application.SmartDorm.UI.OwnerMainController;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;

import java.time.format.DateTimeFormatter;

public class CreateTenantController {

    //Set TenantFormController
    @FXML
    public Parent embedTenantForm;
    @FXML
    TenantManageController manageController;
    @FXML
    FXMLLoader loader = new FXMLLoader();
    @FXML
    JFXButton saveDataBT;
    String roomID, status, name, begin, end, note;
    TreeItem<TenantTable> treeItemTenant = OwnerMainController.manageController.getTenantTableView().getSelectionModel().getSelectedItem();
    @FXML
    private TenantFormController embedTenantFormController;
    @FXML
    private Parent embedLeasesForm;
    @FXML
    private LeasesFormController embedLeasesFormController;
    @FXML
    private MaterialDesignIconView iconClose;

    public void initialize() {
        autoFillDataLeases();
    }

    @FXML
    void saveData(ActionEvent event) {
        //TODO Save tenant data to DATABASE
        setTenantData();
        //OwnerMainController.manageController.getTenantTableData().add(new TenantTable(roomID,status,name,begin,end));
        TenantTable n = new TenantTable(roomID, status, name, begin, end, note);
        treeItemTenant.setValue(n);
        OwnerMainController.manageController.getTenantTableView().getSelectionModel().clearSelection();
        OwnerMainController.manageController.tenantSetButtonDisable();
        saveDataBT.getScene().getWindow().hide();
        System.out.println("Save data");
    }

    //Close Windows state
    @FXML
    void closeState(MouseEvent event) {
        iconClose.getScene().getWindow().hide();
    }

    private void setTenantData() {
        //Set room id
        roomID = treeItemTenant.getValue().getRoom();

        //Set status
        status = "เช่า";

        //Set name to Tenant
        name = embedTenantFormController.getPrefixNameCB1().getSelectionModel().getSelectedItem() + " " +
                embedTenantFormController.getFirstNameTF1().getText() + " " +
                embedTenantFormController.getLastNameTF1().getText();

        //Set begin
        begin = embedLeasesFormController.getStartLeasesDP().getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        //Set end
        end = embedLeasesFormController.getEndLeasesDP().getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        note = "not think";

        OwnerMainController.manageController.tenantSetButtonDisable();
    }

    private void autoFillDataLeases() {
        embedLeasesFormController.getAutoFillData().setOnAction(event -> {
            setTenantData();
            embedLeasesFormController.getNameLeasesTF().setText(name);
            embedLeasesFormController.getPhoneLeasesTF().setText("xxx");
        });
    }
}
