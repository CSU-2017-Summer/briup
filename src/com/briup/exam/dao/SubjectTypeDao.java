package com.briup.exam.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.briup.exam.bean.SubjectType;

import java.util.List;

@Repository
public class SubjectTypeDao extends BaseDao<SubjectType> {
//    public List<SubjectType> findAll(Order ... orders){
//        Criteria criteria = getSession().createCriteria(SubjectType.class);
//        for(Order order:orders){
//            criteria.addOrder(order);
//        }
//        List<SubjectType> list = criteria.list();
//        return list;
//    }
}
