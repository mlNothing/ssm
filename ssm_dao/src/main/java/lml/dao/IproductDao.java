package lml.dao;


import lml.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IproductDao {
    @Select("select *from product where id =#{id}")
    public List<Product> findById(Integer id) throws Exception;
    //查询所有的产品信息
    @Select("select *from product")
   public List<Product> findAll() throws Exception;
    @Insert("INSERT INTO  product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) \n" +
            "VALUES(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
