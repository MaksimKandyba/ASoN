package DaoImpl;

import DTOs.AnimalDto;
import DaoInterfaces.AnimalDao;
import Entities.Animal;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Converters.Converter.convert;

/**
 * Created by max on 02.08.16.
 */
@Transactional
@Repository
public class AnimalDaoImpl implements AnimalDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(AnimalDto animalDto) {
        Animal animal = convert(animalDto);
        sessionFactory.getCurrentSession().save(animal);
    }

    public void remove(AnimalDto animalDto) {
        Animal animal = convert(animalDto);
        sessionFactory.getCurrentSession().delete(animal);
    }

    public void addFriendship(String name, Long friendId) {
        sessionFactory.getCurrentSession().createSQLQuery(
                "insert into friendship " +
                        "(friend_1, friend_2, beginning_time)" +
                        "values (:id1, :id2, now())")
                .setParameter("id1", get(name).getId())
                .setParameter("id2", friendId).executeUpdate();
    }

    public AnimalDto get(String name) {
        Animal animal = (Animal)
                sessionFactory.getCurrentSession().createQuery(
                        "select a from Animal a where a.name = :name")
                        .setParameter("name", name).uniqueResult();
        return convert(animal);
    }

    public void addPlace(String name, Long placeId) {
        sessionFactory.getCurrentSession().createSQLQuery(
                "insert into visiting (visitor, place) " +
                        "values (:aId, :pId)")
                .setParameter("aId", get(name).getId())
                .setParameter("pId", placeId).executeUpdate();
    }

    public void addHobby(String name, Long hobbyId) {
        sessionFactory.getCurrentSession().createSQLQuery(
                "insert into leisure (holidaymaker, hobby) " +
                        "values (:aId, :hId)")
                .setParameter("aId", get(name).getId())
                .setParameter("hId", hobbyId).executeUpdate();
    }

    public Set<AnimalDto> getFriends(Long animalId) {
        Animal animal = (Animal) sessionFactory.getCurrentSession()
                .load(Animal.class, animalId);

        Set<AnimalDto> animalDtos = new HashSet<>();
        for (Animal friend:animal.getFriends()) {
            animalDtos.add(convert(friend));
        }
        return animalDtos;
    }

    public List<AnimalDto> getAllAnimals() {
        List<Animal> animals = sessionFactory.getCurrentSession()
                .createQuery("FROM Animal").list();

        List<AnimalDto> result = new ArrayList<>(animals.size());
        for (Animal animal : animals) {
            result.add(convert(animal));
        }
        return result;
    }
}
