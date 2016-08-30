package ServiceImpl;

import DTOs.HobbyDto;
import DTOs.PlaceDto;
import DaoInterfaces.AnimalDao;
import DaoInterfaces.HobbyDao;
import DaoInterfaces.PlaceDao;
import ServiceInterfaces.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by max on 10.08.16.
 */
@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private AnimalDao animalDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private HobbyDao hobbyDao;

    public void addPlace(String name, Long placeId) {
        animalDao.addPlace(name, placeId);
    }

    public void addHobby(String name, Long hobbyId) {
        animalDao.addHobby(name, hobbyId);
    }

    public List<PlaceDto> getAllPlaces() {
        return placeDao.getAllPlaces();
    }

    public List<HobbyDto> getAllHobbies() {
        return hobbyDao.getAllHobbies();
    }
}
