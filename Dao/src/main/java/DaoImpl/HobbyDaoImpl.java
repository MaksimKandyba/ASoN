package DaoImpl;

import DTOs.HobbyDto;
import DaoInterfaces.HobbyDao;
import Entities.Hobby;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static Converters.Converter.convert;

/**
 * Created by max on 02.08.16.
 */
@Transactional
@Repository
public class HobbyDaoImpl implements HobbyDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<HobbyDto> getAllHobbies() {
        List<Hobby> hobbies = sessionFactory.getCurrentSession()
                .createQuery("FROM Hobby").list();

        List<HobbyDto> result = new ArrayList<>(hobbies.size());
        for (Hobby hobby : hobbies) {
            result.add(convert(hobby));
        }
        return result;
    }
}
