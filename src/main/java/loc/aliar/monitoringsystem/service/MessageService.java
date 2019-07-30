package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.model.MessageModel;

import java.util.List;

public interface MessageService {
    List<MessageModel> getAllByUserId(Long userId);

    MessageModel getLastMessage(Long userId);

    Long unreadCount(Long userId);

    void readMessages(Long fromUserId, Long toUserId);

    void save(MessageModel messageModel);
}
