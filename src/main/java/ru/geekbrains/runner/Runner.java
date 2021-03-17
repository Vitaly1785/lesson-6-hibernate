package ru.geekbrains.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.Person;
import ru.geekbrains.models.Product;
import ru.geekbrains.services.PersonService;
import ru.geekbrains.services.ProductService;

@Component
public class Runner implements CommandLineRunner {
    private final ProductService productService;
    private final PersonService personService;

    public Runner(ProductService productService, PersonService personService) {
        this.productService = productService;
        this.personService = personService;
    }

    @Override
    public void run(String... args){
        personService.showAll().forEach(person -> System.out.println(person.toString()));
        productService.findById(1L);
        productService.update(new Product("Salt", 3), 5L);
        personService.update(new Person("Alan", "Wake"), 5L);
        productService.delete(5L);
        productService.getPerson(1L);
        //почему то не работают обе выборки сразу(по купленным товарам у Person и по покупателям у Product)
        //по отдельности без проблем)
//        personService.getProduct(2L);

    }
}
