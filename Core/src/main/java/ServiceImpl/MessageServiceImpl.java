package ServiceImpl;

import DTOs.MessageDto;
import DaoInterfaces.AnimalDao;
import DaoInterfaces.MessageDao;
import ServiceInterfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by max on 13.08.16.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private AnimalDao animalDao;
    @Autowired
    private MessageDao messageDao;

    public void sendMessage
            (String senderName, String addresseeName, String content) {
        MessageDto messageDto = new MessageDto();
        messageDto.setSender(senderName);
        messageDto.setAddressee(addresseeName);
        messageDto.setContent(content);
        messageDto.setSendingOffTime(LocalDateTime.now());
        messageDao.create(messageDto);
    }
}
