package Application.SmartDorm.UI.Host;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Tourist booking data
 *
 * @author Hotel_OOAD
 */

public class TouristBooking extends RecursiveTreeObject<TouristBooking> {
    private StringProperty booking_date, tourist_name, room_type, room_number, checkin, checkout;

    public TouristBooking(String booking_date, String tourist_name, String room_type, String room_number, String checkin, String checkout) {
        this.booking_date = new SimpleStringProperty(booking_date);
        this.tourist_name = new SimpleStringProperty(tourist_name);
        this.room_type = new SimpleStringProperty(room_type);
        this.room_number = new SimpleStringProperty(room_number);
        this.checkin = new SimpleStringProperty(checkin);
        this.checkout = new SimpleStringProperty(checkout);
    }

    public String getBooking_date() {
        return booking_date.get();
    }

    public StringProperty booking_dateProperty() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date.set(booking_date);
    }

    public String getTourist_name() {
        return tourist_name.get();
    }

    public StringProperty tourist_nameProperty() {
        return tourist_name;
    }

    public void setTourist_name(String tourist_name) {
        this.tourist_name.set(tourist_name);
    }

    public String getRoom_type() {
        return room_type.get();
    }

    public StringProperty room_typeProperty() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type.set(room_type);
    }

    public String getRoom_number() {
        return room_number.get();
    }

    public StringProperty room_numberProperty() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number.set(room_number);
    }

    public String getCheckin() {
        return checkin.get();
    }

    public StringProperty checkinProperty() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin.set(checkin);
    }

    public String getCheckout() {
        return checkout.get();
    }

    public StringProperty checkoutProperty() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout.set(checkout);
    }
}
