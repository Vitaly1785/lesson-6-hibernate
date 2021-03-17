package ru.geekbrains.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.dao.ProductDao;
import ru.geekbrains.models.Product;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }
    @Transactional
    public void create(Product product){
        productDao.create(product);
    }

    @Transactional
    public List<Product> showAll(){
       return productDao.showAll();
    }
    @Transactional
    public void findById(Long id){
        Optional<Product> products = productDao.findById(id);
        if (products.isPresent()){
            System.out.println(products.get().toString());
        }else{
            System.out.println("Product not found");
        }
    }
    @Transactional
    public void update(Product product, Long id){
        productDao.update(product, id);
    }
    @Transactional
    public void delete(Long id){
        productDao.delete(id);
    }
    public void getPerson(Long id){
        Optional<Product> products = productDao.findById(id);
        if (products.isPresent()){
            System.out.println(products.toString() + "Product purchased by persons: " + products.get().getPersonList());
        }else{
            System.out.println("Product not found");
        }
    }
}
