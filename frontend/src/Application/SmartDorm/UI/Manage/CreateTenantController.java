package Application.SmartDorm.UI.Manage;

import Application.SmartDorm.UI.OwnerMainController;
import Controller.RoomController;
import Controller.TenantController;
import Controller.UserController;
import Entity.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
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

    String user_temp;

    //init xy offsets
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    public void initialize() {
        autoFillDataLeases();

    }

    @FXML
    void saveData(ActionEvent event) {
        //TODO Save tenant data to DATABASE
        roomID = treeItemTenant.getValue().getRoom();
        if (embedTenantFormController.checkBeforeSubmitForm() && embedLeasesFormController.checkBeforeSubmitLeases()) {
            alertSubmit();
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

        //Set name to Tenant
        name = embedTenantFormController.getPrefixNameCB1().getSelectionModel().getSelectedItem() + " " +
                embedTenantFormController.getFirstNameTF1().getText() + " " +
                embedTenantFormController.getLastNameTF1().getText();

        String nickname = embedTenantFormController.getNickNameTF1().getText();
        String dob = embedTenantFormController.getBirthDayDP1().getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String ctzn_id = embedTenantFormController.getIdCardTF1().getText();
        String tel = embedTenantFormController.getPhoneNumberTF1().getText();
        String email = embedTenantFormController.getEmailTF1().getText();
        String em_ppl = embedTenantFormController.getContractPersonTF1().getText();
        String em_relation = embedTenantFormController.getRelationPersonTF1().getText();
        String address = embedTenantFormController.getAddressTF1().getText();
        String em_tel = embedTenantFormController.getRelationPhoneTF1().getText();

        String type = embedTenantFormController.getPersonRoleCB1().getSelectionModel().getSelectedItem();
        String school = embedTenantFormController.getRoleEduTF1().getText();
        String fac = embedTenantFormController.getRoleFacultyTF1().getText();
        String grade = "";
        String position = "";

        status = "ไม่ว่าง";

        if (type.equals("นักเรียน"))
            grade = embedTenantFormController.getRoleGradeTF1().getText();
        else
            position = embedTenantFormController.getRoleGradeTF1().getText();

        TenantController.create(Long.parseLong(roomID), name, nickname, dob, ctzn_id, phone, email, address, em_ppl, em_relation, em_tel, type, school, fac, position, grade);


        //Set begin
        begin = embedLeasesFormController.getStartLeasesDP().getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        //Set end
        end = embedLeasesFormController.getEndLeasesDP().getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        RoomController.setRoomToOccupied(Long.parseLong(roomID));
        RoomController.setContactDate(Long.parseLong(roomID), begin, end);
        RoomController.updateTenant(Long.parseLong(roomID), TenantController.getByCitizenId(ctzn_id).getId(), 0);

        Long rid = Long.parseLong(roomID);
        Long tid = RoomController.getById(rid).getPrimary_tenant();

        UserController.updateTidByUid(user_temp, tid);

//        note = "not think";
        System.out.println("EEE" + roomID);

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
        Text text = new Text("บันทึกข้อมูลสำเร็จ");
        Text userText = new Text("USER");
        Text passText = new Text("PASS");
        TextField user = new TextField();
        TextField pass = new TextField();
        userText.setStyle("-fx-font-family: 'Sukhumvit Set'; -fx-font-size: 20;");
        passText.setStyle("-fx-font-family: 'Sukhumvit Set'; -fx-font-size: 20;");
        text.setStyle("-fx-font-family: 'Sukhumvit Set'; -fx-font-size: 22;");
        submit.setStyle("-fx-text-fill:WHITE;-fx-background-color:#5264AE;-fx-font-size:18px;-fx-font-family: 'Sukhumvit Set';-fx-font-weight: bold;");
//        cancel.setStyle("-fx-text-fill:WHITE;-fx-background-color:#e34249;-fx-font-size:18px;-fx-font-family: 'Sukhumvit Set';-fx-font-weight: bold;");
        VBox header = new VBox();
        VBox detail = new VBox();
        detail.setSpacing(10);
        user.setStyle("-fx-padding: 10 10 10 10;");
        user.setEditable(false);
        pass.setStyle("-fx-padding: 10 10 10 10;");
        pass.setEditable(false);

        header.getChildren().add(text);
        header.setAlignment(Pos.TOP_CENTER);

        detail.getChildren().addAll(userText, user, passText, pass, submit);
        detail.setAlignment(Pos.CENTER);

        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(header);
        content.setBody(detail);
        JFXDialog dialog = new JFXDialog(alertError, content, JFXDialog.DialogTransition.CENTER);

        System.out.println(roomID);
        Long rid = Long.parseLong(roomID);
        Long tid = RoomController.getById(rid).getPrimary_tenant();
        User u = UserController.create(tid);

        user_temp = u.getUid();
        user.setText(u.getUid());
        pass.setText(u.getPassword());

        submit.setOnAction(event -> {
            confirmSaveDa();
            dialog.close();
        });
        dialog.setOverlayClose(false);
        dialog.show();
    }

    private void confirmSaveDa() {
        setTenantData();

        TenantTable n = new TenantTable(roomID, status, name, begin, end, note);
        treeItemTenant.setValue(n);

        OwnerMainController.manageController.getTenantTableView().getSelectionModel().clearSelection();
        OwnerMainController.manageController.tenantSetButtonDisable();
        saveDataBT.getScene().getWindow().hide();
    }
}
