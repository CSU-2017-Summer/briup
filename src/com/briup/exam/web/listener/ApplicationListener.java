package com.briup.exam.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.criterion.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.briup.exam.bean.Department;
import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.bean.SubjectType;
import com.briup.exam.bean.Topic;
import com.briup.exam.service.IDepartmentService;
import com.briup.exam.service.ISubjectLevelService;
import com.briup.exam.service.ISubjectTypeService;
import com.briup.exam.service.ITopicService;

/**
 * 当应用启动时，加载所有的subjectLevel subjectType	department topic 到application中
 * */
@WebListener
public class ApplicationListener implements ServletContextListener {
	
    /**
     * Default constructor. 
     */
    public ApplicationListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
        // TODO: 2017/8/24 add Application context,and set attribute.

    }
}
