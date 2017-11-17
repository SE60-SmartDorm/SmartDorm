package Application.SmartDorm.UI.Manage;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

public class CreateTenantController {
    //Set TenantFormController
    @FXML
    private Parent embedTenantForm;
    @FXML
    private TenantFormController embedTenantFormController;

    @FXML
    private MaterialDesignIconView iconClose;

    public void initialize() {

    }

    @FXML
    void saveData(ActionEvent event) {

        //TODO Save tenant data to DATABASE
    }

    //Close Windows state
    @FXML
    void closeState(MouseEvent event) {
        iconClose.getScene().getWindow().hide();
    }
}
