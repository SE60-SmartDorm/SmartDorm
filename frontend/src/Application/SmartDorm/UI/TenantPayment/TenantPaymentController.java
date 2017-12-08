package Application.SmartDorm.UI.TenantPayment;

import Application.SmartDorm.MainSmartDorm;
import Application.SmartDorm.UI.LoginControllersd;
import Application.SmartDorm.UI.TenantMainController;
import Controller.RentalController;
import Controller.RoomController;
import Controller.UserController;
import Entity.Rental;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;


public class TenantPaymentController {

    @FXML
    public ComboBox<String> listMonth;
    ObservableList<String> list = FXCollections.observableArrayList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    @FXML
    public  Label waterUnit;

    @FXML
    private Label elecUnit;
    @FXML
    private Label roomRental;
    @FXML
    private Label waterPay;
    @FXML
    private Label elecPay;
    @FXML
    private Label otherPay;
    @FXML
    private Label totalPay;
    @FXML
    private JFXButton pay;
    @FXML
    private Label errorChoose;

    private double wUnit;
    private double eUnit;
    private double room;
    private double wPay;
    private double ePay;
    private double oPay;
    private static double total;
    private static String monthTemp;
    static int[] checkMonth = new int[12];
    private String paidText = "ชำระแล้ว";
    private String payText = "ชำระ";
    private String noPay = "ไม่มียอดค้างชำระ";
    private long fine;
    private int currentDay,currentMonth,currentYear;
    public Long pay_id;
    public Long oid;
    public double ttl;

    public String uid;
    private Long owner_id;

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public static String getMonthTemp() {
        return monthTemp;
    }

    public static void setMonthTemp(String monthTemp) {
        TenantPaymentController.monthTemp = monthTemp;
    }

    DateFormat day = new SimpleDateFormat("dd");
    DateFormat month = new SimpleDateFormat("MM");
    DateFormat year = new SimpleDateFormat("yyyy");
    Date dateobj = new Date();
    LocalDate dateBefore;
    LocalDate dateAfter;
    long daysBetween;

    List<Rental> rents;



    Map<String, Integer> map = new HashMap<String, Integer>();

    @FXML
    private void chooseMonth(ActionEvent event) throws IOException{
        currentDay = Integer.parseInt(day.format(dateobj));
        currentMonth = Integer.parseInt(month.format(dateobj));
        currentYear = Integer.parseInt(year.format(dateobj));
        errorChoose.setVisible(false);
        uid = LoginControllersd.tenantMainController.uid;
        owner_id = UserController.getTenantIdByUid(uid);
        System.out.println("DBG_OID: " + owner_id);
        rents = RentalController.getByOwnerId(owner_id);

        String selected_month = listMonth.getValue().toString();
        int month_int = map.get(selected_month);
        Rental this_rent = null;
        for (Rental r : rents) {
            if (r.getMonth() == month_int) {
                this_rent = r;
                break;
            }
        }


        pay.setDisable(this_rent.isPaid());
        pay.setText(this_rent.isPaid() ? paidText : payText);
        wUnit = this_rent.getWater();
        eUnit = this_rent.getElectric();
        oPay = this_rent.getOther();
        room = this_rent.getRoom_rent();
        ePay = eUnit * 7;
        wPay = wUnit * 17;
        total = room + wPay + ePay + oPay;
        setTotal(total);
        setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);

        pay_id = this_rent.getId();
        oid = RoomController.getByTenantId(owner_id).getId();
        ttl = total;

        System.out.println("XX " + oid + " " + ttl);


    }

    @FXML
    public void initialize() {
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);
        listMonth.setItems(list);
        System.out.println(Integer.parseInt(day.format(dateobj)));
        System.out.println(month.format(dateobj));
        System.out.println(year.format(dateobj));
        total = room + wPay + ePay + oPay;
        waterUnit.setText(String.valueOf(wUnit));
        elecUnit.setText(String.valueOf(eUnit));
        roomRental.setText(String.valueOf(room));
        waterPay.setText(String.valueOf(wPay));
        elecPay.setText(String.valueOf(ePay));
        otherPay.setText(String.valueOf(oPay));
        totalPay.setText(String.valueOf(total));
        pay.setDisable(true);
    }


    public void setBillDetail(double wUnit,double eUnit,double room,double wPay,double ePay,double oPay,double total)
    {
        waterUnit.setText(String.valueOf(wUnit));
        elecUnit.setText(String.valueOf(eUnit));
        roomRental.setText(String.valueOf(room));
        waterPay.setText(String.valueOf(wPay));
        elecPay.setText(String.valueOf(ePay));
        otherPay.setText(String.valueOf(oPay));
        totalPay.setText(String.valueOf(total));
    }


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(listMonth.getValue()!=null) {
            setMonthTemp(listMonth.getValue().toString());

            Node home_tenant_payment = FXMLLoader.load(getClass().getResource("TenantPayment3rdLogin.fxml"));
            setNode(home_tenant_payment);

        }
        else{
            errorChoose.setVisible(true);
        }
    }
    private void setNode(Node node) {
        TenantMainController.mainTenantChangePane.getChildren().clear();
        TenantMainController.mainTenantChangePane.getChildren().add(node);

    }

}
