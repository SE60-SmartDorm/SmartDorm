package Application.SmartDorm.UI.TouristUI;


import Application.SmartDorm.UI.TenantMainController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchUIController implements Initializable {


    private String[] province = {"กรุงเทพฯ", "เชียงใหม่"};
    private String[] name = {"Oh! Sleep Sleep", "Hahaha House"};
    private int people_num;
    private int room_num;

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
        setSearchText(searchField.getText());
        Node searchUI2 = FXMLLoader.load(getClass().getResource("SearchUI2.fxml"));
        setNode(searchUI2);
    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);
    }


}
