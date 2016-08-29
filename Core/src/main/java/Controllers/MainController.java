package Controllers;

import DTOs.AnimalDto;
import ServiceInterfaces.AnimalService;
import ServiceInterfaces.MessageService;
import ServiceInterfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * Created by max on 13.08.16.
 */
@Controller
public class MainController {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private PostService postService;
    @Autowired
    private MessageService messageService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String redirect(){
        return "StartPage";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String getAnimal
            (@RequestParam("name") String name, ModelMap model){

        model.addAttribute("name", name);
        AnimalDto animalDto = animalService.getAnimal(name);
        model.addAttribute("birthday", animalDto.getBirthday());
        model.addAttribute("places", animalDto.getPlaces());
        model.addAttribute("hobbies", animalDto.getHobbies());
        model.addAttribute("posts", animalDto.getPosts());
        model.addAttribute("incoming", animalDto.getIncoming());
        model.addAttribute("outgoing", animalDto.getOutgoing());
        model.addAttribute("friends",
                animalService.getFriends(animalDto.getId()));

        return "MainPage";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    String addAnimal(@RequestParam String name,
                     @RequestParam String year,
                     @RequestParam String month,
                     @RequestParam String day) {
        LocalDate birthday = LocalDate.of(new Integer(year),
                new Integer(month), new Integer(day));
        animalService.createAnimal(name, birthday);
        return "StartPage";
    }

    @RequestMapping(value = "/delAnimal", method = RequestMethod.POST)
    String deleteAnimal(@RequestParam String name) {
        animalService.removeAnimal(name);
        return "StartPage";
    }

    @RequestMapping(value = "/addFriend", method = RequestMethod.POST)
    String addFriend(@RequestBody Long id1, Long id2) {
        animalService.addFriendship(id1, id2);
        return "MainPage";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    String addPost(@RequestParam String title,
                  @RequestParam String content,
                  @RequestParam String name,
                  ModelMap model) {
        postService.publishPost(title, content, name);
        return getAnimal(name, model);
    }

    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    String sendMsg(@RequestParam String content,
                   @RequestParam String addressee,
                   @RequestParam String name,
                   ModelMap model) {
        messageService.sendMessage(name, addressee, content);
        return getAnimal(name, model);
    }
}