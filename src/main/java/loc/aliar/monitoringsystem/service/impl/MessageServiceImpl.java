package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.Message;
import loc.aliar.monitoringsystem.model.MessageModel;
import loc.aliar.monitoringsystem.repository.MessageRepository;
import loc.aliar.monitoringsystem.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ConversionService conversionService;

    @Override
    public List<MessageModel> getAllByUserId(Long userId) {
        List<Message> messages = messageRepository.findAllByFromUserIdOrToUserId(userId, userId);
        return messages.parallelStream()
                .map(m -> conversionService.convert(m, MessageModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public MessageModel getLastMessage(Long userId) {
        Optional<Message> message = messageRepository.findFirstByFromUserIdOrToUserIdOrderByCreatedDate(userId, userId);
        return message.map(m -> conversionService.convert(m, MessageModel.class)).orElse(null);
    }

    @Override
    public Long unreadCount(Long userId) {
        return messageRepository.countAllByToUserIdAndIsReadFalse(userId);
    }

    @Override
    public void readMessages(Long fromUserId, Long toUserId) {
        messageRepository.readMessages(fromUserId, toUserId);
    }

    @Override
    public void save(MessageModel messageModel) {
        Message message = conversionService.convert(messageModel, Message.class);
        messageRepository.save(message);
    }
}
