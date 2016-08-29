package DaoInterfaces;

import DTOs.AnimalDto;

import java.util.List;
import java.util.Set;

/**
 * Created by max on 02.08.16.
 */
public interface AnimalDao {
    void create(AnimalDto animalDto);
    void remove(AnimalDto animalDto);
    void addFriendship(String name, Long friendId);
    AnimalDto get(String name);
    void addPlace(Long animalId, Long placeId);
    void addHobby(Long animalId, Long hobbyId);
    Set<AnimalDto> getFriends(Long animalId);
    List<AnimalDto> getAllAnimals();
}
