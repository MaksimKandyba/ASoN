package DaoImpl;

import DTOs.PostDto;
import DaoInterfaces.PostDao;
import Entities.Animal;
import Entities.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static Converters.Converter.convert;

/**
 * Created by max on 02.08.16.
 */
@Transactional
@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(PostDto postDto) {
        Post post = convert(postDto);
        post.setPostOwner((Animal) sessionFactory.getCurrentSession()
                .load(Animal.class, postDto.getPostOwnerId()));
        sessionFactory.getCurrentSession().save(post);
    }
}
