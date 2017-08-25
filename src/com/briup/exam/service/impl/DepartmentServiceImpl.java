package com.briup.exam.service.impl;

import com.briup.exam.bean.Department;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.DepartmentDao;
import com.briup.exam.service.IDepartmentService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liuqi on 2017/8/23.
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentDao dao;

    @Override
    public Department findById(Long id) {
        return null;
    }

    @Override
    public List<Department> findAll(Order... orders) {
        List<Department> departments = dao.findAll(new Department(),orders);
        return departments;
    }

    @Override
    public List<Department> findAll(IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<Department> findByExample(Department model, Order... orders) {
        return null;
    }

    @Override
    public List<Department> findByExample(Department model, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<Department> findByCriteria(Criteriable criteriaObj, Order... orders) {
        return null;
    }

    @Override
    public List<Department> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public Department findUnique(Department model) {
        return null;
    }

    @Override
    public void save(Department model) {

    }

    @Override
    public void batchSave(List<Department> models) {

    }

    @Override
    public void saveOrUpdate(Department model) {

    }

    @Override
    public void update(Department model) {

    }

    @Override
    public void deleteObject(Department model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void batchDelete(List<Long> ids) {

    }

    @Override
    public void batchDelete(Long[] ids) {

    }

    @Override
    public void batchDeleteModel(List<Department> models) {

    }
}
