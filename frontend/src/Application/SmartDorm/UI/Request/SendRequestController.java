package Application.SmartDorm.UI.Request;

import Application.SmartDorm.UI.TenantMainController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class SendRequestController {

    String requestTypeText, requestTopicText, requestDetailText;

    @FXML
    private TextArea requestDetail;
    @FXML
    private JFXRadioButton requestCompair;
    @FXML
    private ToggleGroup selection;
    @FXML
    private JFXRadioButton requestCompain;
    @FXML
    private JFXRadioButton requestAnother;
    @FXML
    private JFXTextField requestTopic;

    @FXML
    public void initialize() {
        getRequestType();
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Node main_tenant_request = FXMLLoader.load(getClass().getResource("MainRequest.fxml"));
        setNode(main_tenant_request);
    }

    void getRequestType() {
        selection.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (selection.getSelectedToggle() == requestCompair) {
                requestTypeText = requestCompair.getText();
            } else if (selection.getSelectedToggle() == requestCompain) {
                requestTypeText = requestCompain.getText();
            } else {
                requestTypeText = requestAnother.getText();
                System.out.println(requestTypeText);
            }
        });
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }

    @FXML
    void confirm(ActionEvent event) throws IOException {
        //TODO save data


        if(selection.getSelectedToggle() != null && !requestTopic.getText().trim().isEmpty() && !requestDetail.getText().trim().isEmpty()){
            setRequestText();

            Node tenant_history_request = FXMLLoader.load(getClass().getResource("HistoryRequest.fxml"));
            setNode(tenant_history_request);
        }else{
            System.out.println("Error");
        }

    }

    private void setRequestText() {
        requestTopicText = requestTopic.getText();
        requestDetailText = requestDetail.getText();
    }
}
