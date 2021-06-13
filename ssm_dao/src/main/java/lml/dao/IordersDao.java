package lml.dao;

import lml.domain.Member;
import lml.domain.Orders;
import lml.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IordersDao {
    @Select("select *from orders")
    @Results({
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "orderNum" ,column = "orderNum"),
            @Result(property = "orderTime" ,column = "orderTime"),
            @Result(property = "peopleCount" ,column = "peopleCount"),
            @Result(property = "oderDesc" ,column = "oderDesc"),
            @Result(property = "payType" ,column = "payType"),
            @Result(property = "orderStatus" ,column = "orderStatus"),
            @Result(property = "product" ,column = "productId",javaType = Product.class,one = @One(select = "lml.dao.IproductDao.findById"))


    })
    public List<Orders> findAll() throws Exception;
    @Select("select *from orders where id=#{id}")
    @Results({
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "orderNum" ,column = "orderNum"),
            @Result(property = "orderTime" ,column = "orderTime"),
            @Result(property = "peopleCount" ,column = "peopleCount"),
            @Result(property = "oderDesc" ,column = "oderDesc"),
            @Result(property = "payType" ,column = "payType"),
            @Result(property = "orderStatus" ,column = "orderStatus"),
            @Result(property = "product" ,column = "productId",javaType = Product.class,one = @One(select = "lml.dao.IproductDao.findById")),
            @Result(property = "member" ,column = "memberId",javaType = Member.class,one = @One(select = "lml.dao.ImemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,
            many = @Many(select = "lml.dao.ItravellersDao.findByOrdersId"))


    })
    Orders findById(Integer id);
}
