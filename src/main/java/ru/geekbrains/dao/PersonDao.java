package ru.geekbrains.dao;

import org.springframework.stereotype.Repository;
import ru.geekbrains.manager.HibernateManager;
import ru.geekbrains.models.Person;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDao {
    private final HibernateManager manager;

    public PersonDao(HibernateManager manager) {
        this.manager = manager;
    }

    public void create(Person person){
        EntityManager em = manager.getManager();
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            em.close();
    }
    @SuppressWarnings("unchecked")
    public List<Person> showAll(){
        EntityManager em = manager.getManager();
        return em.createQuery("select a from Person a").getResultList();
    }

    public Optional<Person> findById(Long id){
       return showAll().stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    public void update(Person person, Long id){
        EntityManager em = manager.getManager();
        Optional<Person> persons = findById(id);
        Person updatablePerson = em.find(Person.class, id);
        if (persons.isPresent()){
            em.getTransaction().begin();
            updatablePerson.setFirstName(person.getFirstName());
            updatablePerson.setLastName(person.getLastName());
            em.getTransaction().commit();
            em.close();
        }
    }
    public void delete(Long id){
        EntityManager em = manager.getManager();
        Optional<Person> persons = findById(id);
        Person person = em.find(Person.class, id);
        if (persons.isPresent()){
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
            em.close();
        }else{
            System.out.println("Person to delete was not found");
        }
    }
}
