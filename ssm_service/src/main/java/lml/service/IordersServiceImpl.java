package lml.service;

import com.github.pagehelper.PageHelper;
import lml.dao.IordersDao;
import lml.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IordersServiceImpl implements IordersService{
    @Autowired
    private IordersDao iordersDao;
    @Override
    public List<Orders> findAll(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return iordersDao.findAll();
    }

    @Override
    public Orders findById(Integer id) {
        return iordersDao.findById(id);
    }
}
