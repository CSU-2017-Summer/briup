package com.briup.exam.service.impl;

import com.briup.exam.bean.SubjectType;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.SubjectTypeDao;
import com.briup.exam.service.ISubjectTypeService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liuqi on 2017/8/23.
 */
@Service
public class SubjectTypeServiceImpl implements ISubjectTypeService {

    @Autowired
    private SubjectTypeDao dao;

    @Override
    public SubjectType findById(Long id) {
        return dao.findById(id);

    }

    @Override
    public List<SubjectType> findAll(Order... orders) {
        List list = dao .findAll(new SubjectType(),orders);
        return list;
    }

    @Override
    public List<SubjectType> findAll(IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<SubjectType> findByExample(SubjectType model, Order... orders) {
        return null;
    }

    @Override
    public List<SubjectType> findByExample(SubjectType model, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<SubjectType> findByCriteria(Criteriable criteriaObj, Order... orders) {
        return null;
    }

    @Override
    public List<SubjectType> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public SubjectType findUnique(SubjectType model) {
        return null;
    }

    @Override
    public void save(SubjectType model) {
        dao.save(model);
    }

    @Override
    public void batchSave(List<SubjectType> models) {

    }

    @Override
    public void saveOrUpdate(SubjectType model) {

    }

    @Override
    public void update(SubjectType model) {
        dao.update(model);
    }

    @Override
    public void deleteObject(SubjectType model) {

    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void batchDelete(List<Long> ids) {

    }

    @Override
    public void batchDelete(Long[] ids) {

    }

    @Override
    public void batchDeleteModel(List<SubjectType> models) {

    }
}
