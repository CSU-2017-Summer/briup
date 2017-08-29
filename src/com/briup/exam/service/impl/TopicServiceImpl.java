package com.briup.exam.service.impl;

import com.briup.exam.bean.Topic;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.TopicDao;
import com.briup.exam.service.ITopicService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liuqi on 2017/8/23.
 */
@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private TopicDao dao;

    @Override
    public Topic findById(Long id){
        return dao.findById(id);
    }

    @Override
    public List<Topic> findAll(Order... orders) {
        List<Topic> topics = dao.findAll(new Topic(),orders);
        return topics;
    }

    @Override
    public List<Topic> findAll(IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<Topic> findByExample(Topic model, Order... orders) {
        return null;
    }

    @Override
    public List<Topic> findByExample(Topic model, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public List<Topic> findByCriteria(Criteriable criteriaObj, Order... orders) {
        return null;
    }

    @Override
    public List<Topic> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        return null;
    }

    @Override
    public Topic findUnique(Topic model) {
        return null;
    }

    @Override
    public void save(Topic model) {
        System.out.println("in TopicSave Service...");
        dao.save(model);
    }

    @Override
    public void batchSave(List<Topic> models) {

    }

    @Override
    public void saveOrUpdate(Topic model) {

    }

    @Override
    public void update(Topic model) {
        dao.update(model);
    }

    @Override
    public void deleteObject(Topic model) {

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
    public void batchDeleteModel(List<Topic> models) {

    }
}
