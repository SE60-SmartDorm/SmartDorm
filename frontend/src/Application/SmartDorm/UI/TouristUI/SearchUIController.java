package Application.SmartDorm.UI.TouristUI;


import Application.SmartDorm.UI.TenantMainController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchUIController extends AnchorPane implements Initializable {

    // set Singleton pattern
    private static SearchUIController instance;

    private String[] province = {"กรุงเทพฯ","เชียงใหม่"};
    private String[] name = {"Oh! Sleep Sleep","Hahaha House"};
    private int people_num;
    private int room_num;

    @FXML
    private TextField searchField;
    @FXML
    private JFXButton searchButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private SearchUIController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchUI.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static SearchUIController getInstance(){
        if (instance == null) {
            instance = new SearchUIController();
        }
        return instance;
    }

    //Clear instance class
    public void ClearManage() {
        if (instance != null)
            instance = null;
    }

    @FXML
    public void searchClick(ActionEvent event) throws IOException {
        System.out.println(searchField.getText());
        SearchUI2Controller searchVari = SearchUI2Controller.getInstance();
        setNode(searchVari);

    }

    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }
}
