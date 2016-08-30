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
    void addPlace(String name, Long placeId);
    void addHobby(String name, Long hobbyId);
    Set<AnimalDto> getFriends(Long animalId);
    List<AnimalDto> getAllAnimals();
}
