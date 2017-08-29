package com.briup.exam.service.impl;

import com.briup.exam.bean.ExamPaper;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.ExamPaperDao;
import com.briup.exam.dao.SubjectDao;
import com.briup.exam.service.IExamPaperService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liuqi on 2017/8/27.
 */
@Service
public class ExamPaperServiceImpl implements IExamPaperService {

    @Autowired
    private ExamPaperDao dao;

    @Override
    public ExamPaper findById(Long id) {
        return null;
    }

    @Override
    public List<ExamPaper> findAll(Order... orders) {
        return (List)dao.findAll(orders);
    }

    @Override
    public List<ExamPaper> findAll(IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<ExamPaper> findByExample(ExamPaper model, Order... orders) {
        return null;
    }

    @Override
    public List<ExamPaper> findByExample(ExamPaper model, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<ExamPaper> findByCriteria(Criteriable criteriaObj, Order... orders) {
        return null;
    }

    @Override
    public List<ExamPaper> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public ExamPaper findUnique(ExamPaper model) {
        return null;
    }

    @Override
    public void save(ExamPaper model) {
        dao.save(model);
    }

    @Override
    public void batchSave(List<ExamPaper> models) {

    }

    @Override
    public void saveOrUpdate(ExamPaper model) {

    }

    @Override
    public void update(ExamPaper model) {

    }

    @Override
    public void deleteObject(ExamPaper model) {

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
    public void batchDeleteModel(List<ExamPaper> models) {

    }
}
