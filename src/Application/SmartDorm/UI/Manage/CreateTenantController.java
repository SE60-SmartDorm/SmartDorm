package Application.SmartDorm.UI.Manage;

import Application.SmartDorm.UI.OwnerMainController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
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
    //other
    String roomID, status, name, begin, end, note, phone, address, IDCard;
    TreeItem<TenantTable> treeItemTenant = OwnerMainController.manageController.getTenantTableView().getSelectionModel().getSelectedItem();
    @FXML
    private TenantFormController embedTenantFormController;
    @FXML
    private Parent embedLeasesForm;
    @FXML
    private LeasesFormController embedLeasesFormController;
    @FXML
    private MaterialDesignIconView iconClose;
    @FXML
    private StackPane alertError;

    public void initialize() {
        autoFillDataLeases();
    }

    @FXML
    void saveData(ActionEvent event) {
        //TODO Save tenant data to DATABASE
        if (embedLeasesFormController.checkBeforeSubmitLeases() && embedLeasesFormController.checkBeforeSubmitLeases()) {
            setTenantData();

            TenantTable n = new TenantTable(roomID, status, name, begin, end, note);
            treeItemTenant.setValue(n);

            OwnerMainController.manageController.getTenantTableView().getSelectionModel().clearSelection();
            OwnerMainController.manageController.tenantSetButtonDisable();
            saveDataBT.getScene().getWindow().hide();
            System.out.println("Save data");
        } else {
            alertFail();
            System.out.println("Error");
        }
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

    private void setAutoFillData() {
        if (!(embedTenantFormController.getPrefixNameCB1().getSelectionModel().isEmpty() || embedTenantFormController.getPrefixNameCB1().getSelectionModel().getSelectedItem() == null)) {
            name = embedTenantFormController.getPrefixNameCB1().getSelectionModel().getSelectedItem() + " " +
                    embedTenantFormController.getFirstNameTF1().getText() + " " +
                    embedTenantFormController.getLastNameTF1().getText();
        }

        phone = embedTenantFormController.getPhoneNumberTF1().getText();
        address = embedTenantFormController.getAddressTF1().getText();
        IDCard = embedTenantFormController.getIdCardTF1().getText();
    }

    private void autoFillDataLeases() {
        embedLeasesFormController.getAutoFillData().setOnAction(event -> {
            setAutoFillData();
            embedLeasesFormController.getNameLeasesTF().requestFocus();
            embedLeasesFormController.getNameLeasesTF().setText(name);
            embedLeasesFormController.getPhoneLeasesTF().requestFocus();
            embedLeasesFormController.getPhoneLeasesTF().setText(phone);
            embedLeasesFormController.getAddressLeasesTF().setText(address);
            embedLeasesFormController.getIdCardLeasesTF().requestFocus();
            embedLeasesFormController.getIdCardLeasesTF().setText(IDCard);
            saveDataBT.requestFocus();
        });
    }

    private void alertFail() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Alert/Fail.fxml"));
        StackPane icon = null;
        try {
            icon = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Text text = new Text("กรุณากรอกข้อมูลให้ถูกต้อง");
        VBox header = new VBox();
        VBox detail = new VBox();
        header.getChildren().add(icon);
        header.setAlignment(Pos.CENTER);
        detail.setStyle("-fx-font-family: 'Sukhumvit Set'; -fx-font-size: 22;");
        detail.getChildren().add(text);
        detail.setAlignment(Pos.CENTER);

        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(header);
        content.setBody(detail);
        JFXDialog dialog = new JFXDialog(alertError, content, JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }
}
