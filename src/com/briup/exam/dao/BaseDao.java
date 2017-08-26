package com.briup.exam.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * 基本dao类，其他dao可以继承该基础类，然后调用现有的增删改查方法
 */
@Repository("baseDao")
@SuppressWarnings("unchecked")
public class BaseDao<M extends java.io.Serializable>{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public void save(Object object){
        System.out.println("in dao basedao.save()...");
        getSession().save(object);
    }

    public void delete(M m) {
        getSession().delete(m);
    }

    public List<M> findAll(M m,Order ... orders){
        System.out.println("in basedao findAll...");
        Criteria criteria = getSession().createCriteria(m.getClass());
	    for(Order order:orders){
	        criteria.addOrder(order);
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//        criteria.add(Restrictions.sqlRestriction("rowid in (select  min(a.rowid)  from tbl_exam_subjection a group by a.id)"));
        List<M> list = criteria.list();
		System.out.println("list size:"+list.size());

	    return list;
    }

    public Class<M> getEntityClass(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        return (Class)params[0];
    }

	public M findById(Long id) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		List<M>list = criteria.add(Restrictions.eq("id", id)).list();
		if(list.size()==0) {
			return null;
		}else {
			return list.get(0);
		}
	}

	public void delete(Long id) {
		delete( (M)findById(id));
	}

    public void saveOrUpdate(M m) {
        getSession().saveOrUpdate(m);
    }
}
