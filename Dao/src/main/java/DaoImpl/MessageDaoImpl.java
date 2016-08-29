package DaoImpl;

import DTOs.MessageDto;
import DaoInterfaces.MessageDao;
import Entities.Animal;
import Entities.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static Converters.Converter.convert;

/**
 * Created by max on 02.08.16.
 */
@Transactional
@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(MessageDto messageDto) {
        Message message = convert(messageDto);

        message.setSender((Animal) sessionFactory.getCurrentSession()
                .createQuery("select a from Animal a " +
                        "where a.name = :name")
                .setParameter("name",
                        messageDto.getSender()).uniqueResult());

        message.setAddressee((Animal) sessionFactory.getCurrentSession()
                .createQuery("select a from Animal a " +
                        "where a.name = :name")
                .setParameter("name",
                        messageDto.getAddressee()).uniqueResult());

        sessionFactory.getCurrentSession().save(message);
    }
}
