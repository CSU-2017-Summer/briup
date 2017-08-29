package com.briup.exam.web.action.manager;


import com.briup.exam.bean.Department;
import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.bean.SubjectType;

import com.briup.exam.bean.Topic;
import com.briup.exam.service.impl.DepartmentServiceImpl;
import com.briup.exam.service.impl.SubjectLevelServiceImpl;
import com.briup.exam.service.impl.SubjectTypeServiceImpl;
import com.briup.exam.service.impl.TopicServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;


@Action
public class ManagerAction extends BaseAction implements RequestAware {



    private Map<String,Object> reqM;
    private SubjectType subjectType;
    private SubjectLevel subjectLevel;
    private Topic topic;
    private Department department;

    private List<SubjectType> subjectTypes;
    private List<SubjectLevel> subjectLevels;
    private List<Department> departments;
    private List<Topic> topics;

    public List<SubjectType> getSubjectTypes() {
        return subjectTypes;
    }

    public void setSubjectTypes(List<SubjectType> subjectTypes) {
        this.subjectTypes = subjectTypes;
    }

    public List<SubjectLevel> getSubjectLevels() {
        return subjectLevels;
    }

    public void setSubjectLevels(List<SubjectLevel> subjectLevels) {
        this.subjectLevels = subjectLevels;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Autowired
    private SubjectTypeServiceImpl subjectTypeService;

    @Autowired
    private SubjectLevelServiceImpl subjectLevelService;

    @Autowired
    private TopicServiceImpl topicService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public SubjectLevel getSubjectLevel() {
        return subjectLevel;
    }

    public void setSubjectLevel(SubjectLevel subjectLevel) {
        this.subjectLevel = subjectLevel;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Action(value="/manageDepartment",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/departmentManager.jsp")
    })
    public String manageDepartment(){
        List<Department> departments= departmentService.findAll(Order.asc("id"));
        reqM.put("departments",departments);
        return SUCCESS;
    }

    @Action(value="/manageLevel",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/subjectLevelManager.jsp")
    })
    public String manageLevel(){
        List<SubjectLevel> levels= subjectLevelService.findAll(Order.asc("id"));
        reqM.put("levels",levels);
        return SUCCESS;
    }

    @Action(value="/manageType",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/subjectTypeManager.jsp")
    })
    public String manageType(){
        List<SubjectType> types = subjectTypeService.findAll(Order.asc("id"));
        reqM.put("types",types);
        return SUCCESS;
    }

    @Action(value="/manageTopic",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/topicManager.jsp")
    })
    public String manageTopic(){
        System.out.println("--- in topic");
        List<Topic> topics = topicService.findAll(Order.asc("id"));
        reqM.put("topics",topics);
        return SUCCESS;
    }

    @Action(value="/toEditType",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/edit/editType.jsp")
    })
    public String editType(){
        System.out.println("--- in editType");
        long id = subjectType.getId();
        if (id > 0){
            subjectType = subjectTypeService.findById(id);
            reqM.put("vi",subjectType);
        }
        return SUCCESS;
    }

    @Action(value="/toEditTopic",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/edit/editTopic.jsp")
    })
    public String editTopic(){
        System.out.println("--- in editTopic");
        long id = topic.getId();
        if (id > 0){
            topic = topicService.findById(id);
            reqM.put("vi",topic);
        }
        List<Department> departments= departmentService.findAll(Order.asc("id"));
        reqM.put("departments",departments);
        return SUCCESS;
    }

    @Action(value="/toEditDepartment",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/edit/editDepartment.jsp")
    })
    public String editDepartment(){
        System.out.println("--- in editDepartment");
        long id = department.getId();
        if (id > 0){
            department = departmentService.findById(id);
            reqM.put("vi",department);
        }
        return SUCCESS;
    }

    @Action(value="/toEditLevel",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/edit/editLevel.jsp")
    })
    public String editLevel(){
        System.out.println("--- in edit level");
        long id = subjectLevel.getId();
        if (id > 0){
            subjectLevel = subjectLevelService.findById(id);
            reqM.put("vi",subjectLevel);
        }
        return SUCCESS;
    }

    @Action(value="/saveLevel",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/subjectLevelManager.jsp"),
            @Result(name=ERROR, location = "/WEB-INF/jsp/manager/subjectLevelManager.jsp")
    })
    public String saveLevel(){
        System.out.println("--- in save level");

        if (subjectLevel.getId() > 0){
            System.out.println("--- in update level");
            subjectLevelService.update(subjectLevel);
        } else {
            System.out.println("new subject level");
            List<SubjectLevel> levels= subjectLevelService.findAll(Order.asc("id"));
            for(SubjectLevel s : levels){
                if (s.getName().equals(subjectLevel.getName()) || s.getRealName().equals(subjectLevel.getName())){
                    System.out.println("--- level exist");
                    responseJSON("ERROR");
                    return ERROR;
                }
            }
            System.out.println("save new level");
            SubjectLevel ss = new SubjectLevel();
            ss.setName(subjectLevel.getName());
            ss.setRealName(subjectLevel.getRealName());
            subjectLevelService.save(ss);
        }
        updateApplication();
        return  SUCCESS;
    }

    @Action(value="/delLevel",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/subjectLevelManager.jsp")
    })
    public String delLevel(){
        System.out.println("--- in del level");
        for(SubjectLevel l:subjectLevels)
            subjectLevelService.delete(l.getId());
        return SUCCESS;
    }


    @Action(value="/saveType",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/subjectTypeManager.jsp"),
            @Result(name=ERROR, location = "/WEB-INF/jsp/manager/subjectTypeManager.jsp")
    })
    public String saveType(){
        System.out.println("--- in save type");

        if (subjectType.getId() > 0){
            System.out.println("--- in update type");
            subjectTypeService.update(subjectType);
        } else {
            System.out.println("new subject type");
            List<SubjectType> types= subjectTypeService.findAll(Order.asc("id"));
            for(SubjectType s : types){
                if (s.getName().equals(subjectType.getName()) || s.getRealName().equals(subjectType.getName())){
                    System.out.println("--- type exist");
                    responseJSON("ERROR");
                    return ERROR;
                }
            }
            System.out.println("save new type");
            SubjectType ss = new SubjectType();
            ss.setName(subjectType.getName());
            ss.setRealName(subjectType.getRealName());
            subjectTypeService.save(ss);
        }
        updateApplication();
        return  SUCCESS;
    }

    @Action(value="/delType",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/subjectTypeManager.jsp")
    })
    public String delType(){
        System.out.println("--- in del type");
        System.out.println(subjectTypes.size());

        for(SubjectType s:subjectTypes){
            subjectTypeService.delete(s.getId());
        }
        return SUCCESS;
    }

    @Action(value="/saveDepartment",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/departmentManager.jsp"),
            @Result(name=ERROR, location = "/WEB-INF/jsp/manager/departmentManager.jsp")
    })
    public String saveDepartment(){
        System.out.println("--- in save department");

        if (department.getId() > 0){
            System.out.println("--- in update department");
            departmentService.update(department);
        } else {
            System.out.println("new department");
            List<Department> types= departmentService.findAll(Order.asc("id"));
            for(Department s : types){
                if (s.getName().equals(department.getName()) ){
                    System.out.println("--- department exist");
                    responseJSON("ERROR");
                    return ERROR;
                }
            }
            System.out.println("save new department");
            Department ss = new Department();
            ss.setName(department.getName());
            departmentService.save(ss);
        }
        updateApplication();
        return  SUCCESS;
    }


    @Action(value="/delDepartment",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/departmentManager.jsp")
    })
    public String delDepartment(){
        System.out.println("--- in delDepartment");
        for(Department d:departments){
            departmentService.delete(d.getId());

        }
        return SUCCESS;
    }


    @Action(value="/saveTopic",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/topicManager.jsp"),
            @Result(name=ERROR, location = "/WEB-INF/jsp/manager/topicManager.jsp")
    })
    public String saveTopic(){
        System.out.println("--- in saveTopic");

        if (topic.getId() > 0){
            System.out.println("--- in update topic");
            topicService.update(topic);
        } else {
            System.out.println("new topic");
            List<Topic> types= topicService.findAll(Order.asc("id"));
            for(Topic s : types){
                if (s.getTitle().equals(topic.getTitle()) ){
                    System.out.println("--- topic exist");
                    responseJSON("ERROR");
                    return ERROR;
                }
            }
            System.out.println("save new topic");
            topicService.save(topic);
        }
        updateApplication();
        return  SUCCESS;
    }


    @Action(value="/delTopic",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/manager/topicManager.jsp")
    })
    public String delTopic(){
        System.out.println("--- in delTopic");
        for(Topic t:topics)
            topicService.delete(t.getId());
        return SUCCESS;
    }




    @Override
    public void setRequest(Map<String, Object> map) {
        this.reqM = map;
    }
}
