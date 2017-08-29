package com.briup.exam.service.impl;

import com.briup.exam.bean.PaperSubject;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.PaperSubjectDao;
import com.briup.exam.service.IPaperSubjectService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liuqi on 2017/8/27.
 */
@Service
public class PaperSubjectServiceImpl implements IPaperSubjectService {

    @Autowired
    private PaperSubjectDao dao;

    @Override
    public PaperSubject findById(Long id) {
        return null;
    }

    @Override
    public List<PaperSubject> findAll(Order... orders) {
        return null;
    }

    @Override
    public List<PaperSubject> findAll(IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<PaperSubject> findByExample(PaperSubject model, Order... orders) {
        return null;
    }

    @Override
    public List<PaperSubject> findByExample(PaperSubject model, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<PaperSubject> findByCriteria(Criteriable criteriaObj, Order... orders) {
        return null;
    }

    @Override
    public List<PaperSubject> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public PaperSubject findUnique(PaperSubject model) {
        return null;
    }

    @Override
    public void save(PaperSubject model) {
        dao.save(model);
    }

    @Override
    public void batchSave(List<PaperSubject> models) {

    }

    @Override
    public void saveOrUpdate(PaperSubject model) {

    }

    @Override
    public void update(PaperSubject model) {

    }

    @Override
    public void deleteObject(PaperSubject model) {

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
    public void batchDeleteModel(List<PaperSubject> models) {

    }
}
