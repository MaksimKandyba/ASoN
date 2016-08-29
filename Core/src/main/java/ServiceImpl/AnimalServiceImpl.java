package ServiceImpl;

import DTOs.AnimalDto;
import DaoInterfaces.AnimalDao;
import ServiceInterfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by max on 07.08.16.
 */
@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalDao animalDao;

    public void createAnimal(String name, LocalDate birthday) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setName(name);
        animalDto.setBirthday(birthday);
        animalDao.create(animalDto);
    }

    public void removeAnimal(String name) {
        animalDao.remove(animalDao.get(name));
    }

    public void addFriendship(String name, Long friendId) {
        animalDao.addFriendship(name, friendId);
    }

    public AnimalDto getAnimal(String name) {
        return animalDao.get(name);
    }

    public Set<AnimalDto> getFriends(Long animalId) {
        return animalDao.getFriends(animalId);
    }

    public List<AnimalDto> getAllAnimals() {
        return animalDao.getAllAnimals();
    }
}
