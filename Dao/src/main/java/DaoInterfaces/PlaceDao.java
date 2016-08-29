package DaoInterfaces;

import DTOs.PlaceDto;

/**
 * Created by max on 02.08.16.
 */
public interface PlaceDao {
        PlaceDto get(String title);
}
