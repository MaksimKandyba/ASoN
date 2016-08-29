package ServiceInterfaces;

import DTOs.AnimalDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by max on 07.08.16.
 */
public interface AnimalService {
    void createAnimal(String name, LocalDate birthday);
    void removeAnimal(String name);
    void addFriendship(String name, Long friendId);
    AnimalDto getAnimal(String name);
    Set<AnimalDto> getFriends(Long animalId);
    List<AnimalDto> getAllAnimals();
}
