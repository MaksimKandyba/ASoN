package DaoImpl;

import DTOs.PlaceDto;
import DaoInterfaces.PlaceDao;
import Entities.Place;
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
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<PlaceDto> getAllPlaces() {
        List<Place> places = sessionFactory.getCurrentSession()
                .createQuery("FROM Place").list();

        List<PlaceDto> result = new ArrayList<>(places.size());
        for (Place place : places) {
            result.add(convert(place));
        }
        return result;
    }
}
