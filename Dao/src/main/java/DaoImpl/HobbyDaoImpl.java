package DaoImpl;

import DTOs.HobbyDto;
import DaoInterfaces.HobbyDao;
import Entities.Hobby;
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
public class HobbyDaoImpl implements HobbyDao {

    @Autowired
    private SessionFactory sessionFactory;

    public HobbyDto get(String title) {
        Hobby hobby = (Hobby)
                sessionFactory.getCurrentSession().createSQLQuery(
                        "select * from ason_db.hobbies " +
                                "where title = :title")
                        .setParameter("title", title);
        return convert(hobby);
    }
}
