package DaoInterfaces;

import DTOs.HobbyDto;

/**
 * Created by max on 02.08.16.
 */
public interface HobbyDao {
    HobbyDto get(String title);
}
