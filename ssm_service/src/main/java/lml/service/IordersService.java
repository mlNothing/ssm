package lml.service;


import lml.domain.Orders;

import java.util.List;

public interface IordersService {

    public List<Orders> findAll(Integer page,Integer pageSize) throws Exception;

    Orders findById(Integer id);
}
