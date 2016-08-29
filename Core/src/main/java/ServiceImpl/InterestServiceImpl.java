package ServiceImpl;

import DTOs.HobbyDto;
import DTOs.PlaceDto;
import DaoInterfaces.AnimalDao;
import DaoInterfaces.HobbyDao;
import DaoInterfaces.PlaceDao;
import ServiceInterfaces.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addPlace(Long animalId, String placeTitle) {
        PlaceDto placeDto = placeDao.get(placeTitle);
        animalDao.addPlace(animalId, placeDto.getId());
    }

    public void addHobby(Long animalId, String hobbyTitle) {
        HobbyDto hobbyDto = hobbyDao.get(hobbyTitle);
        animalDao.addHobby(animalId, hobbyDto.getId());
    }
}
