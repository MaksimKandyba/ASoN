package ServiceImpl;

import DTOs.PostDto;
import DaoInterfaces.AnimalDao;
import DaoInterfaces.PostDao;
import ServiceInterfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by max on 13.08.16.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private AnimalDao animalDao;

    public void publishPost
            (String title, String content, String animalName) {
        PostDto postDto = new PostDto();
        postDto.setTitle(title);
        postDto.setContent(content);
        postDto.setPostOwnerId(animalDao.get(animalName).getId());
        postDto.setPublicationTime(LocalDateTime.now());
        postDao.create(postDto);
    }
}
