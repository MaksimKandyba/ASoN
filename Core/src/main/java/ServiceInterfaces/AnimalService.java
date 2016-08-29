package ServiceInterfaces;

import DTOs.AnimalDto;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by max on 07.08.16.
 */
public interface AnimalService {
    void createAnimal(String name, LocalDate birthday);
    void removeAnimal(String name);
    void addFriendship(Long id1, Long id2);
    AnimalDto getAnimal(String name);
    Set<AnimalDto> getFriends(Long animalId);
}
