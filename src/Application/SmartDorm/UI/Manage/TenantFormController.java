package Application.SmartDorm.UI.Manage;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;


public class TenantFormController {
    @FXML
    private VBox showPeopleRole;

    @FXML
    private ComboBox<String> PeopleRole1;
    private ObservableList<String> PeopleRoleData = FXCollections.observableArrayList();

    private AnchorPane infopane;


    /**
     * The constructor (is called before the initialize()-method).
     */
    public TenantFormController() {
        // initial data
        PeopleRoleData.addAll("นักศึกษา", "อาจารย์", "บุคคลภายนอก");
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {




        // Init ComboBox items.
        PeopleRole1.setItems(PeopleRoleData);
        PeopleRole1.getSelectionModel().selectFirst();

        //  Init student form
        loadFxml("TenantStudentInfo.fxml");
        showPeopleRole.getChildren().add(infopane);

        // ComboBox selection event change pane form
        PeopleRole1.getSelectionModel()
                .selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if ((Integer) newValue == 0) {
                            showPeopleRole.getChildren().removeAll(infopane);
                            loadFxml("TenantStudentInfo.fxml");
                            showPeopleRole.getChildren().add(infopane);
                        } else if ((Integer) newValue == 1) {
                            showPeopleRole.getChildren().removeAll(infopane);
                            loadFxml("TenantTeacherInfo.fxml");
                            showPeopleRole.getChildren().add(infopane);
                        } else {
                            //TODO other people
                        }
                    }
                });
    }

    /**
     * load FXML file to parent pane
     */
    private void loadFxml(String FXMLFile) {

        //ChildNode child;
        try {
            URL url = getClass().getResource(FXMLFile);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            infopane = fxmlLoader.load(url.openStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
