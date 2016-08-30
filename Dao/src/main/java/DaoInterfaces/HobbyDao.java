package DaoInterfaces;

import DTOs.HobbyDto;

import java.util.List;

/**
 * Created by max on 02.08.16.
 */
public interface HobbyDao {
    List<HobbyDto> getAllHobbies();
}
