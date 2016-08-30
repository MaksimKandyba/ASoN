package ServiceInterfaces;

import DTOs.HobbyDto;
import DTOs.PlaceDto;

import java.util.List;

/**
 * Created by max on 08.08.16.
 */
public interface InterestService {
    void addPlace(String name, Long placeId);
    void addHobby(String name, Long hobbyId);
    List<PlaceDto> getAllPlaces();
    List<HobbyDto> getAllHobbies();
}
