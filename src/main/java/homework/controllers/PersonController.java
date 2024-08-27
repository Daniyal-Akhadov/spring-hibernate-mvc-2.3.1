package homework.controllers;

import homework.model.Person;
import homework.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getPeople(Model model) {
        List<Person> people = personService.getUsers();
        model.addAttribute("people", people);

        return "person/people";
    }

    @GetMapping("/person_info")
    public String getUserInfo(@RequestParam("id") int id, Model model) {
        Person person = personService.getById(id);

        model.addAttribute("person", person);

        return "person/person_info";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") int id, Model model) {

        Person person = personService.getById(id);
        System.out.println(person);
        model.addAttribute("person", person);

        return "person/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute Person person) {
        personService.update(person);

        return "redirect:/people";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("person") Person person) {
        personService.add(person);

        return "redirect:/people";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        personService.delete(id);

        return "redirect:/people";
    }
}
