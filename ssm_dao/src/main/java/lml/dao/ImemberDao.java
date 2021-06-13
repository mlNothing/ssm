package lml.dao;

import lml.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImemberDao {
    @Select("select *from member where id =#{id}")
    public List<Member> findById(Integer id) throws Exception;
}
