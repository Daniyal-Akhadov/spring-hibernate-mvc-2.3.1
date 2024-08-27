package homework.services;

import homework.dao.PersonDAO;
import homework.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class PersonService {

    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public List<Person> getUsers() {
        return personDAO.getPeople();
    }

    public void add(Person person) {
        personDAO.addPerson(person);
    }

    public void delete(int id) {
        personDAO.deletePerson(getById(id));
    }

    public void update(Person updatedPerson) {
        personDAO.updatePerson(updatedPerson);
    }

    public Person getById(int id) {
        return personDAO.getPersonById(id);
    }
}
