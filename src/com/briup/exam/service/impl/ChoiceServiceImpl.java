package com.briup.exam.service.impl;

import com.briup.exam.bean.Choice;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.BaseDao;
import com.briup.exam.dao.ChoiceDao;
import com.briup.exam.service.IChoiceService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liuqi on 2017/8/25.
 */
@Service
public class ChoiceServiceImpl implements IChoiceService {

    @Autowired
    private ChoiceDao dao;

    @Override
    public Choice findById(Long id) {
        return null;
    }

    @Override
    public List<Choice> findAll(Order... orders) {
        return null;
    }

    @Override
    public List<Choice> findAll(IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<Choice> findByExample(Choice model, Order... orders) {
        return null;
    }

    @Override
    public List<Choice> findByExample(Choice model, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<Choice> findByCriteria(Criteriable criteriaObj, Order... orders) {
        return null;
    }

    @Override
    public List<Choice> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public Choice findUnique(Choice model) {
        return null;
    }

    @Override
    public void save(Choice model) {
        System.out.println("in service choice save...");
        dao.save(model);
    }

    @Override
    public void batchSave(List<Choice> models) {

    }

    @Override
    public void saveOrUpdate(Choice model) {

    }

    @Override
    public void update(Choice model) {

    }

    @Override
    public void deleteObject(Choice model) {

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
    public void batchDeleteModel(List<Choice> models) {

    }
}
