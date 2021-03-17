package ru.geekbrains.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.dao.PersonDao;
import ru.geekbrains.models.Person;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional
    public void create(Person person){
        personDao.create(person);
    }

    @Transactional
    public List<Person> showAll(){
       return personDao.showAll();
    }

    @Transactional
    public void findById(Long id){
        Optional<Person> persons = personDao.findById(id);
        if (persons.isPresent()){
            System.out.println(persons.get().toString());
        }else{
            System.out.println("Person not found");
        }
    }

    @Transactional
    public void update(Person person, Long id){
        personDao.update(person, id);
    }

    @Transactional
    public void delete(Long id){
        personDao.delete(id);
    }

    public void getProduct(Long id){
        Optional<Person> persons = personDao.findById(id);
        if (persons.isPresent()){
            System.out.println(persons.toString() +"buy this products: " + persons.get().getProducts());
        } else{
            System.out.println("Person not found");
        }
    }
}
