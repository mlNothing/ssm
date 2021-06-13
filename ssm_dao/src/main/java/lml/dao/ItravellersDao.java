package lml.dao;

import lml.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItravellersDao {
    @Select("SELECT *FROM traveller WHERE id IN(SELECT travellerId FROM order_traveller  WHERE orderId = #{ordersId})")
    public List<Traveller> findByOrdersId(Integer ordersId);
}
