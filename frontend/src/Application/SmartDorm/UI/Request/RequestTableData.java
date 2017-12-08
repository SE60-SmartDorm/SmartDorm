package Application.SmartDorm.UI.Request;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RequestTableData extends RecursiveTreeObject<RequestTableData> {
    private StringProperty requestDate, requestType, requestTopic, requestDetail;

    public RequestTableData(String requestDate, String requestType, String requestTopic, String requestDetail) {
        this.requestDate = new SimpleStringProperty(requestDate);
        this.requestType = new SimpleStringProperty(requestType);
        this.requestTopic = new SimpleStringProperty(requestTopic);
        this.requestDetail = new SimpleStringProperty(requestDetail);
    }

    public String getRequestDate() {
        return requestDate.get();
    }

    public void setRequestDate(String requestDate) {
        this.requestDate.set(requestDate);
    }

    public StringProperty requestDateProperty() {
        return requestDate;
    }

    public String getRequestType() {
        return requestType.get();
    }

    public void setRequestType(String requestType) {
        this.requestType.set(requestType);
    }

    public StringProperty requestTypeProperty() {
        return requestType;
    }

    public String getRequestTopic() {
        return requestTopic.get();
    }

    public void setRequestTopic(String requestTopic) {
        this.requestTopic.set(requestTopic);
    }

    public StringProperty requestTopicProperty() {
        return requestTopic;
    }

    public String getRequestDetail() {
        return requestDetail.get();
    }

    public void setRequestDetail(String requestDetail) {
        this.requestDetail.set(requestDetail);
    }

    public StringProperty requestDetailProperty() {
        return requestDetail;
    }
}
