package com.briup.exam.dao;

import org.springframework.stereotype.Repository;

import com.briup.exam.bean.Topic;

import javax.persistence.criteria.Order;
import java.util.List;

@Repository
public class TopicDao extends BaseDao<Topic> {
}
