package com.briup.exam.service.impl;

import com.briup.exam.bean.Subject;
import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.SubjectLevelDao;
import com.briup.exam.service.ISubjectLevelService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liuqi on 2017/8/23.
 */
@Service
public class SubjectLevelServiceImpl implements ISubjectLevelService {

    @Autowired
    private SubjectLevelDao dao;

    @Override
    public SubjectLevel findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<SubjectLevel> findAll(Order... orders) {
        List<SubjectLevel> levels = dao.findAll(new SubjectLevel(),orders);
        return levels;
    }

    @Override
    public List<SubjectLevel> findAll(IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<SubjectLevel> findByExample(SubjectLevel model, Order... orders) {
        return null;
    }

    @Override
    public List<SubjectLevel> findByExample(SubjectLevel model, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<SubjectLevel> findByCriteria(Criteriable criteriaObj, Order... orders) {
        return null;
    }

    @Override
    public List<SubjectLevel> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public SubjectLevel findUnique(SubjectLevel model) {
        return null;
    }

    @Override
    public void save(SubjectLevel model) {
        dao.save(model);
    }

    @Override
    public void batchSave(List<SubjectLevel> models) {

    }

    @Override
    public void saveOrUpdate(SubjectLevel model) {

    }

    @Override
    public void update(SubjectLevel model) {
        dao.update(model);
    }

    @Override
    public void deleteObject(SubjectLevel model) {

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
    public void batchDeleteModel(List<SubjectLevel> models) {

    }
}
