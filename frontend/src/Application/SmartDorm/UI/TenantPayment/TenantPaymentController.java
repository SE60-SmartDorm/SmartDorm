package Application.SmartDorm.UI.TenantPayment;

import Application.SmartDorm.MainSmartDorm;
import Application.SmartDorm.UI.TenantMainController;
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
import static java.time.temporal.ChronoUnit.DAYS;


public class TenantPaymentController {

    @FXML
    private ComboBox<String> listMonth;
    ObservableList<String> list = FXCollections.observableArrayList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    @FXML
    private Label waterUnit;
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
    private String payText = "กดชำระ";
    private String noPay = "ไม่มียอดค้างชำระ";
    private long fine;
    private int currentDay,currentMonth,currentYear;

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

    @FXML
    private void chooseMonth(ActionEvent event) throws IOException{
        currentDay = Integer.parseInt(day.format(dateobj));
        currentMonth = Integer.parseInt(month.format(dateobj));
        currentYear = Integer.parseInt(year.format(dateobj));
        errorChoose.setVisible(false);
        if (("January".equals(listMonth.getValue().toString()))) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,1,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=1) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 3;
                this.eUnit = 17;
                this.oPay = 500;
                fine = daysBetween * 20;
                this.oPay = fine + oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[0] == 1) {
                    pay.setDisable(true);
                    pay.setText(paidText);
                    System.out.println("จ่ายแล้ว");
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("February".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,2,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=2) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 10;
                this.eUnit = 12;
                this.oPay = 100;
                fine = daysBetween * 20;
                this.oPay = fine + oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[1] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("March".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,3,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=3) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 11;
                this.eUnit = 13;
                this.oPay = 200;
                fine = daysBetween*20;
                this.oPay = fine+oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[2] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("April".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,4,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=4) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 50;
                this.eUnit = 50;
                this.oPay = 250;
                fine = daysBetween*20;
                this.oPay = fine+oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[3] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("May".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,5,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=5) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 1;
                this.eUnit = 1;
                this.oPay = 145;
                fine = daysBetween*20;
                this.oPay = fine+oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[4] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("June".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,6,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=6) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 2;
                this.eUnit = 2;
                this.oPay = 325;
                fine = daysBetween*20;
                this.oPay = fine+oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[5] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("July".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,7,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=7) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 7;
                this.eUnit = 7;
                this.oPay = 560;
                fine = daysBetween * 20;
                this.oPay = fine + oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[6] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("August".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,8,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=8) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 1;
                this.eUnit = 2;
                this.oPay = 360;
                fine = daysBetween*20;
                this.oPay = fine+oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[7] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("September".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,9,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=9) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 8;
                this.eUnit = 8;
                this.oPay = 8;
                fine = daysBetween * 20;
                this.oPay = fine + oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[8] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("October".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,10,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth >= 10) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 9;
                this.eUnit = 9;
                this.oPay = 9;
                fine = daysBetween*20;
                this.oPay = fine+oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[9] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("November".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,11,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=11) {
                pay.setDisable(false);
                pay.setText(payText);
                this.wUnit = 10;
                this.eUnit = 10;
                this.oPay = 10;
                fine = daysBetween*20;
                this.oPay = fine+oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[10] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }

        } else if ("December".equals(listMonth.getValue().toString())) {
            dateAfter = LocalDate.of(currentYear,currentMonth,currentDay);
            dateBefore = LocalDate.of(2560,12,05);
            daysBetween = DAYS.between(dateBefore,dateAfter);
            if(currentMonth>=12) {
                pay.setDisable(false);
                pay.setText(payText);
                wUnit = 11;
                eUnit = 11;
                oPay = 11;
                fine = daysBetween*20;
                oPay = fine+oPay;
                room = 3600;
                ePay = eUnit * 7;
                wPay = wUnit * 17;
                total = room + wPay + ePay + oPay;
                setTotal(total);
                setBillDetail(wUnit,eUnit,room,wPay,ePay,oPay,total);
                if (checkMonth[11] == 1) {
                    System.out.println("จ่ายแล้ว");
                    pay.setText(paidText);
                    pay.setDisable(true);
                }
            }
            else {
                setBillDetail(0,0,0,0,0,0,0);
                pay.setDisable(true);
                pay.setText(noPay);
                System.out.println("ยังไม่มียอดค้างชำระ");
            }
        }
    }

    public void initialize() {
        System.out.println(Integer.parseInt(day.format(dateobj)));
        System.out.println(month.format(dateobj));
        System.out.println(year.format(dateobj));
        total = room + wPay + ePay + oPay;
        listMonth.setItems(list);
        waterUnit.setText(String.valueOf(wUnit));
        elecUnit.setText(String.valueOf(eUnit));
        roomRental.setText(String.valueOf(room));
        waterPay.setText(String.valueOf(wPay));
        elecPay.setText(String.valueOf(ePay));
        otherPay.setText(String.valueOf(oPay));
        totalPay.setText(String.valueOf(total));
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
