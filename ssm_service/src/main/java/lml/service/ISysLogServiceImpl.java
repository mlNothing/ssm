package lml.service;

import lml.dao.ISysDao;
import lml.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ISysLogServiceImpl implements ISysLogService{
    @Autowired
    private ISysDao iSysDao;
    @Override
    public void save(SysLog sysLog) {
        iSysDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return iSysDao.findAll();
    }
}
