package Controller;

import Entity.Message;
import Model.MessageModel;
import ProgramException.DatabaseException;

import java.util.List;

public class MessageController {
    public static void create(long oid, String type, String topic, String detail, String timestamp) {
        MessageModel.connect();
        MessageModel.createMessage(oid, type, topic, detail, timestamp);
        MessageModel.close();
    }

    public static long count() {
        MessageModel.connect();
        long count = MessageModel.countMessage();
        MessageModel.close();
        return count;
    }

    public static List<Message> getAll() {
        MessageModel.connect();
        List<Message> m = MessageModel.getAllMessages();
        MessageModel.close();
        return m;
    }

    public static Message getById(long mid) {
        MessageModel.connect();
        Message m = MessageModel.getMessageById(mid);
        MessageModel.close();
        return m;
    }

    public static void setMessageRead(long mid) {
        MessageModel.connect();
        MessageModel.updateReadById(mid, true);
        MessageModel.close();
    }

    public static List<Message> getByOwnerId(long oid) {
        MessageModel.connect();
        List<Message> m = MessageModel.getMessageByOwnerId(oid);
        MessageModel.close();
        return m;
    }

    public static void removeMessageByRoomId(long rid) {
        MessageModel.connect();
        MessageModel.removeMessageByRoomId(rid);
        MessageModel.close();
    }

}
