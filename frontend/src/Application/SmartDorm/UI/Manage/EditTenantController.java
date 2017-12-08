package Application.SmartDorm.UI.Manage;

import Application.SmartDorm.UI.LoginControllersd;
import Application.SmartDorm.UI.OwnerMainController;
import Controller.RoomController;
import Controller.TenantController;
import Controller.UserController;
import Entity.Room;
import Entity.Tenant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class EditTenantController implements Initializable{
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
    JFXButton cancel = new JFXButton("ยกเลิก");
    JFXButton submit = new JFXButton("ยืนยัน");
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

    private Long tid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        autoFillDataLeases();
        List<Tenant> tt = TenantController.getByRoomId(Long.parseLong(treeItemTenant.getValue().getRoom()));
        Tenant t = tt.get(0);
        tid = t.getId();
        String[] nmes = t.getName().split(" ");
        int selected_index = (nmes[0].equals("นาย") ? 0 : (nmes[0].equals("นาง") ? 1 : 2));
        embedTenantFormController.getPrefixNameCB1().getSelectionModel().select(selected_index);
        embedTenantFormController.getFirstNameTF1().setText(nmes[1]);
        embedTenantFormController.getLastNameTF1().setText(nmes[2]);
        embedTenantFormController.getNickNameTF1().setText(t.getNickname());

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final LocalDate dt = LocalDate.parse(t.getDob(), dtf);
        embedTenantFormController.getBirthDayDP1().setValue(dt);
        embedTenantFormController.getIdCardTF1().setText(t.getCitizenId());
        embedTenantFormController.getPhoneNumberTF1().setText(t.getPhone());
        embedTenantFormController.getEmailTF1().setText(t.getEmail());
        embedTenantFormController.getContractPersonTF1().setText(t.getEmergency_ppl());
        embedTenantFormController.getRelationPersonTF1().setText(t.getEmergency_relation());
        embedTenantFormController.getRelationPhoneTF1().setText(t.getEmergency_telephone());
        embedTenantFormController.getAddressTF1().setText(t.getAddress());

        int selected_role_index = t.getType().equals("นักศึกษา") ? 0 : 1;
        embedTenantFormController.getPersonRoleCB1().getSelectionModel().select(selected_role_index);
        embedTenantFormController.getRoleEduTF1().setText(t.getSchool());
        embedTenantFormController.getRoleFacultyTF1().setText(t.getFaculty());
        String role_in_type = t.getType().equals("นักศึกษา") ? t.getYear() : t.getPosition();
        embedTenantFormController.getRoleGradeTF1().setText(role_in_type);


        Room rm = RoomController.getById(Long.parseLong(treeItemTenant.getValue().getRoom()));
        embedLeasesFormController.getStartLeasesDP().setValue(LocalDate.parse(rm.getStart_date(), dtf));
        embedLeasesFormController.getEndLeasesDP().setValue(LocalDate.parse(rm.getEnd_date(), dtf));

        embedLeasesFormController.getNameLeasesTF().setText(t.getName());
        embedLeasesFormController.getPhoneLeasesTF().setText(t.getPhone());
        embedLeasesFormController.getAddressLeasesTF().setText(t.getAddress());
        embedLeasesFormController.getIdCardLeasesTF().setText(t.getCitizenId());
        embedLeasesFormController.getDepositTF().setText("1234");

    }

    @FXML
    void saveData(ActionEvent event) {
        //TODO Save tenant data to DATABASE
        if (embedTenantFormController.checkBeforeSubmitForm() && embedLeasesFormController.checkBeforeSubmitLeases()) {
            alertSubmit();
            System.out.println("Save data");
        } else {
            alertSubmit();
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

        //Set name to Tenant
        name = embedTenantFormController.getPrefixNameCB1().getSelectionModel().getSelectedItem() + " " +
                embedTenantFormController.getFirstNameTF1().getText() + " " +
                embedTenantFormController.getLastNameTF1().getText();

        String nickname = embedTenantFormController.getNickNameTF1().getText();
        String tel = embedTenantFormController.getPhoneNumberTF1().getText();
        String email = embedTenantFormController.getEmailTF1().getText();
        String em_ppl = embedTenantFormController.getContractPersonTF1().getText();
        String em_relation = embedTenantFormController.getRelationPersonTF1().getText();
        String address = embedTenantFormController.getAddressTF1().getText();
        String em_tel = embedTenantFormController.getRelationPhoneTF1().getText();

        String school = embedTenantFormController.getRoleEduTF1().getText();
        String fac = embedTenantFormController.getRoleFacultyTF1().getText();

        status = "ไม่ว่าง";


        TenantController.update(tid, name, nickname, tel, email, address, em_ppl, em_relation, em_tel, school, fac);



        //Set begin
        begin = embedLeasesFormController.getStartLeasesDP().getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        //Set end
        end = embedLeasesFormController.getEndLeasesDP().getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        RoomController.setContactDate(Long.parseLong(roomID), begin, end);

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

    private void alertSubmit() {
        Text text = new Text("ยืนยันการบันทึกข้อมูล");
        text.setStyle("-fx-font-family: 'Sukhumvit Set'; -fx-font-size: 22;");
        submit.setStyle("-fx-text-fill:WHITE;-fx-background-color:#5264AE;-fx-font-size:18px;-fx-font-family: 'Sukhumvit Set';-fx-font-weight: bold;");
        cancel.setStyle("-fx-text-fill:WHITE;-fx-background-color:#e34249;-fx-font-size:18px;-fx-font-family: 'Sukhumvit Set';-fx-font-weight: bold;");
        VBox header = new VBox();
        HBox detail = new HBox();
        detail.setSpacing(30);

        header.getChildren().add(text);
        header.setAlignment(Pos.TOP_CENTER);

        detail.getChildren().addAll(submit, cancel);
        detail.setAlignment(Pos.BASELINE_CENTER);

        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(header);
        content.setBody(detail);
        JFXDialog dialog = new JFXDialog(alertError, content, JFXDialog.DialogTransition.CENTER);
        cancel.setOnAction(event -> {
            dialog.close();
        });
        submit.setOnAction(event -> {
            confirmSaveDa();
            dialog.close();
        });
        dialog.setOverlayClose(false);
        dialog.show();
    }

    private void confirmSaveDa(){
        setTenantData();

        TenantTable n = new TenantTable(roomID, status, name, begin, end, note);
        treeItemTenant.setValue(n);

        OwnerMainController.manageController.getTenantTableView().getSelectionModel().clearSelection();
        OwnerMainController.manageController.tenantSetButtonDisable();
        saveDataBT.getScene().getWindow().hide();
    }

}
