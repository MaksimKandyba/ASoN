package Converters;

import DTOs.*;
import Entities.*;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by max on 04.08.16.
 */
public final class Converter {

    public static Animal convert(AnimalDto animalDto) {
        if (animalDto == null) {
            return null;
        }
        Animal animal = new Animal();
        animal.setId(animalDto.getId());
        animal.setName(animalDto.getName());
        animal.setBirthday(animalDto.getBirthday());

        if (animalDto.getHobbies() != null) {
            animal.setHobbies(new HashSet<Hobby>());
            for (HobbyDto hobby : animalDto.getHobbies()) {
                animal.getHobbies().add(convert(hobby));
            }
        }

        if (animalDto.getPlaces() != null) {
            animal.setPlaces(new HashSet<Place>());
            for (PlaceDto place : animalDto.getPlaces()) {
                animal.getPlaces().add(convert(place));
            }
        }

        if (animalDto.getIncoming() != null) {
            animal.setIncoming(new ArrayList<Message>());
            for (MessageDto message : animalDto.getIncoming()) {
                animal.getIncoming().add(convert(message));
            }
        }

        if (animalDto.getOutgoing() != null) {
            animal.setOutgoing(new ArrayList<Message>());
            for (MessageDto message : animalDto.getOutgoing()) {
                animal.getOutgoing().add(convert(message));
            }
        }

        if (animalDto.getPosts() != null) {
            animal.setPosts(new ArrayList<Post>());
            for (PostDto post : animalDto.getPosts()) {
                animal.getPosts().add(convert(post));
            }
        }

        return animal;
    }

    public static AnimalDto convert(Animal animal) {
        if (animal == null) {
            return null;
        }
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animal.getId());
        animalDto.setName(animal.getName());
        animalDto.setBirthday(animal.getBirthday());

        if (animal.getHobbies() != null) {
            animalDto.setHobbies(new HashSet<HobbyDto>());
            for (Hobby hobby : animal.getHobbies()) {
                animalDto.getHobbies().add(convert(hobby));
            }
        }

        if (animal.getPlaces() != null) {
            animalDto.setPlaces(new HashSet<PlaceDto>());
            for (Place place : animal.getPlaces()) {
                animalDto.getPlaces().add(convert(place));
            }
        }

        if (animal.getIncoming() != null) {
            animalDto.setIncoming(new ArrayList<MessageDto>());
            for (Message message : animal.getIncoming()) {
                animalDto.getIncoming().add(convert(message));
            }
        }

        if (animal.getOutgoing() != null) {
            animalDto.setOutgoing(new ArrayList<MessageDto>());
            for (Message message : animal.getOutgoing()) {
                animalDto.getOutgoing().add(convert(message));
            }
        }

        if (animal.getPosts() != null) {
            animalDto.setPosts(new ArrayList<PostDto>());
            for (Post post : animal.getPosts()) {
                animalDto.getPosts().add(convert(post));
            }
        }

        return animalDto;
    }

    public static Hobby convert(HobbyDto hobbyDto) {
        if (hobbyDto == null) {
            return null;
        }
        Hobby hobby = new Hobby();
        hobby.setId(hobbyDto.getId());
        hobby.setTitle(hobbyDto.getTitle());
        hobby.setDescription(hobbyDto.getDescription());
        return hobby;
    }

    public static HobbyDto convert(Hobby hobby) {
        if (hobby == null) {
            return null;
        }
        HobbyDto hobbyDto = new HobbyDto();
        hobbyDto.setId(hobby.getId());
        hobbyDto.setTitle(hobby.getTitle());
        hobbyDto.setDescription(hobby.getDescription());
        return hobbyDto;
    }

    public static Message convert(MessageDto messageDto) {
        if (messageDto == null) {
            return null;
        }
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setContent(messageDto.getContent());
        message.setSendingOffTime(messageDto.getSendingOffTime());
        return message;
    }

    public static MessageDto convert(Message message) {
        if (message == null) {
            return null;
        }
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setContent(message.getContent());
        messageDto.setSendingOffTime(message.getSendingOffTime());
        messageDto.setSender(message.getSender().getName());
        messageDto.setAddressee(message.getAddressee().getName());
        return messageDto;
    }

    public static Place convert(PlaceDto placeDto) {
        if (placeDto == null) {
            return null;
        }
        Place place = new Place();
        place.setId(placeDto.getId());
        place.setTitle(placeDto.getTitle());
        place.setDescription(placeDto.getDescription());
        return place;
    }

    public static PlaceDto convert(Place place) {
        if (place == null) {
            return null;
        }
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setTitle(place.getTitle());
        placeDto.setDescription(place.getDescription());
        return placeDto;
    }

    public static Post convert(PostDto postDto) {
        if (postDto == null) {
            return null;
        }
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setPublicationTime(postDto.getPublicationTime());
        return post;
    }

    public static PostDto convert(Post post) {
        if (post == null) {
            return null;
        }
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setPublicationTime(post.getPublicationTime());
        postDto.setPostOwnerId(post.getPostOwner().getId());
        postDto.setLikesCounter(post.getLikesOwners().size());
        return postDto;
    }
}
