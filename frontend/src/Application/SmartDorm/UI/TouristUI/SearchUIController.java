package Application.SmartDorm.UI.TouristUI;


import Application.SmartDorm.UI.TenantMainController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchUIController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private JFXButton searchButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public String searchText;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @FXML
    public void searchClick(ActionEvent event) throws IOException {
        searchText = searchField.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchUI2.fxml"));
        StackPane searchUI2 = loader.load();
        setNode(searchUI2);
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);
    }


}
