package ru.geekbrains.dao;

import org.springframework.stereotype.Repository;
import ru.geekbrains.models.Product;
import ru.geekbrains.manager.HibernateManager;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDao {
    private final HibernateManager manager;

    public ProductDao(HibernateManager manager) {
        this.manager = manager;
    }

    public void create(Product product) {
        EntityManager em = manager.getManager();
        Optional<Product> products = showAll().stream().
                filter(product1 -> product1.getTitle().equals(product.getTitle())).findFirst();
        if (products.isPresent()) {
            System.out.println("The product already exists");
        } else {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            em.close();
        }
    }

    public Optional<Product> findById(Long id) {
        return showAll().stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @SuppressWarnings("unchecked")
    public List<Product> showAll() {
        EntityManager em = manager.getManager();
        return em.createQuery("select p from Product p").getResultList();
    }

    public void update(Product product, Long id) {
        EntityManager em = manager.getManager();
        Optional<Product> products = findById(id);
        Product updatableProduct = em.find(Product.class, id);
        if (products.isPresent()) {
            em.getTransaction().begin();
            updatableProduct.setTitle(product.getTitle());
            updatableProduct.setPrice(product.getPrice());
            em.getTransaction().commit();
            em.close();
        } else {
            System.out.println("Product to update was not found");
        }
    }

    public void delete(Long id) {
        EntityManager em = manager.getManager();
        Optional<Product> products = findById(id);
        Product product = em.find(Product.class, id);
        if (products.isPresent()) {
            em.getTransaction().begin();
            em.remove(product);
            em.getTransaction().commit();
            em.close();
        } else {
            System.out.println("Product to delete was not found");
        }
    }
}
