package lml.service;


import lml.dao.IproductDao;
import lml.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IproductServiceImpl implements IproductService {
    @Autowired
    private IproductDao iproductDao;
    @Override
    public List<Product> findAll() throws Exception {
        return iproductDao.findAll();
    }

    @Override
    public void save(Product product) {
        iproductDao.save(product);
    }
}
