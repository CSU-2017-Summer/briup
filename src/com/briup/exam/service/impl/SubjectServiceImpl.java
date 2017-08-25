package com.briup.exam.service.impl;

import com.briup.exam.bean.Subject;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.SubjectDao;
import com.briup.exam.service.ISubjectService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liuqi on 2017/8/23.
 */
@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private SubjectDao dao;

    @Override
    public Subject findById(Long id) {
        return null;
    }

    @Override
    public List<Subject> findAll(Order... orders) {
        return dao.findAll(new Subject(),orders);
    }

    @Override
    public List<Subject> findAll(IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<Subject> findByExample(Subject model, Order... orders) {
        return null;
    }

    @Override
    public List<Subject> findByExample(Subject model, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<Subject> findByCriteria(Criteriable criteriaObj, Order... orders) {
        return null;
    }

    @Override
    public List<Subject> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public Subject findUnique(Subject model) {
        return null;
    }

    @Override
    public void save(Subject model) {
        System.out.println("in service save()...");
        dao.save(model);
    }

    @Override
    public void batchSave(List<Subject> models) {

    }

    @Override
    public void saveOrUpdate(Subject model) {

    }

    @Override
    public void update(Subject model) {

    }

    @Override
    public void deleteObject(Subject model) {

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
    public void batchDeleteModel(List<Subject> models) {

    }
}
