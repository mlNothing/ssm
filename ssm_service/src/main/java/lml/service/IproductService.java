package lml.service;



import lml.domain.Product;

import java.util.List;

public interface IproductService {
    public List<Product> findAll() throws Exception;

    void save(Product product);
}
