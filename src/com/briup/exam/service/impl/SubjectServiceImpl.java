package com.briup.exam.service.impl;

import com.briup.exam.bean.Subject;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.SubjectDao;
import com.briup.exam.service.ISubjectService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
        System.out.println(dao);
        Criteria criteria = dao.getSession().createCriteria(Subject.class);
        criteria.add(Restrictions.eq("id",id));

        return (Subject) criteria.list().get(0);
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
        Criteria subjectCriteria = dao.getSession().createCriteria(Subject.class);

        if(model.getStem()!=null){
            subjectCriteria.add(Restrictions.like("stem", "%"+model.getStem()+"%"));
        }
        if(model.getCheckState()!=null){
            subjectCriteria.add(Restrictions.like("checkState", model.getCheckState()));
        }
        if(model.getSubjectLevel()!=null){
            long id = model.getSubjectLevel().getId();
            if(id!=0) {
                subjectCriteria.createCriteria("subjectLevel").add(Restrictions.eq("id", id));
            }
        }
        if(model.getSubjectType()!=null){
            long id = model.getSubjectType().getId();
            if(id!=0) {
                subjectCriteria.createCriteria("subjectType").add(Restrictions.eq("id", id));
            }
        }
        if(model.getDepartment()!=null){
            long id = model.getDepartment().getId();
            if(id!=0) {
                subjectCriteria.createCriteria("department").add(Restrictions.eq("id", id));
            }
        }
        if(model.getTopic()!=null){
            long id = model.getTopic().getId();
            if(id!=0) {
                subjectCriteria.createCriteria("topic").add(Restrictions.eq("id", id));
            }
        }
        for(Order order:orders) {
            subjectCriteria.addOrder(order).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        }
        return subjectCriteria.list();
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
        dao.saveOrUpdate(model);

    }

    @Override
    public void update(Subject model) {

    }

    @Override
    public void deleteObject(Subject model) {

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
    public void batchDeleteModel(List<Subject> models) {

    }
}
