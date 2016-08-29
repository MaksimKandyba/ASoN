package DaoImpl;

import DTOs.PlaceDto;
import DaoInterfaces.PlaceDao;
import Entities.Place;
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
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    private SessionFactory sessionFactory;

    public PlaceDto get(String title) {
        Place place = (Place)
                sessionFactory.getCurrentSession().createSQLQuery(
                        "select * from ason_db.places " +
                                "where title = :title")
                .setParameter("title", title);
        return convert(place);
    }
}
