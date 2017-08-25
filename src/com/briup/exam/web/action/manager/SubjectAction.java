package com.briup.exam.web.action.manager;


import com.briup.exam.bean.*;
import com.briup.exam.service.impl.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.Element;
import com.opensymphony.xwork2.util.KeyProperty;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by Liuqi on 2017/8/23.
 */
@Action
public class SubjectAction extends ActionSupport implements RequestAware{

    List<SubjectType> types;
    List<SubjectLevel> levels;
    List<Topic> topics;
    List<Department> departments;
    List<Subject> subjects;

    private Map<String,Object> reqM;

    private Subject subject;
    private List<Choice> choices = new ArrayList<>();


    private SubjectType subjectType;

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Autowired
    private SubjectServiceImpl subjectService;

    @Autowired
    private SubjectTypeServiceImpl subjectTypeService;

    @Autowired
    private SubjectLevelServiceImpl subjectLevelService;

    @Autowired
    private TopicServiceImpl topicService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private ChoiceServiceImpl choiceService;

    public void getList() {
        this.types = subjectTypeService.findAll(Order.asc("id"));
        this.levels = subjectLevelService.findAll(Order.asc("id"));
        this.topics = topicService.findAll(Order.asc("id"));
        this.departments = departmentService.findAll(Order.asc("id"));
        this.subjects = subjectService.findAll(Order.asc("id"));
    }

    public void setReqM(){
        reqM.put("departments",departments);
        reqM.put("topics",topics);
        reqM.put("levels",levels);
        reqM.put("types",types);
        reqM.put("subjects",subjects);
    }





    @Action(value="/saveSubject",results = {
            @Result(name = SUCCESS,location = "#")
    })
    public String saveSubject(){
        System.out.println("in action saveSubjectAction...");
        System.out.println(subject.getStem()+" "+subject.getAnalysis()+" "+subject.getAnswer());
//        System.out.println(subject.getSubjectType()+":"+subject.getSubjectType());
//        System.out.println(choice.getCorrect()+":::"+choice.getContent());

        subject.setCheckState("未审核");
        subject.setUploadTime(new Date());
        if(subject.getSubjectType().getId()==3){
            System.out.println("存简答题");
            subjectService.save(subject);
        }
        else{
            System.out.println("refreshed...");
            System.out.println(choices.size());
            System.out.println("choicesList:");
            subjectService.save(subject);
            for(Choice c:choices){
                System.out.println("save:"+c.getCorrect()+":"+c.getContent());
                c.setSubject(subject);
                choiceService.save(c);
            }
        }

//        subjectService.save(subject);
        return SUCCESS;
    }

    @Action(value="/addSubject",results = {
            @Result(name = SUCCESS,location = "/WEB-INF/jsp/subject/subjectAdd.jsp")
    })
    public String addSubject(){
        System.out.println("in action add Subject...");
        getList();
        setReqM();
        return SUCCESS;
    }




    @Action(value="/getAllSubjectType",results = {
            @Result(name = SUCCESS,location = "/WEB-INF/jsp/subject/subjectAdd.jsp")
    })
    public String getAllSubjectType(){
        System.out.println("in action getAllSubjectAction...");
        List<SubjectType> types = subjectTypeService.findAll(Order.asc("id"));
        for (SubjectType sb:types){
            System.out.println(sb.getId()+" "+sb.getName()+" "+sb.getRealName());
        }
        System.out.println(types);
        reqM.put("types",types);
        return SUCCESS;
    }

    @Action(value = "/subjectList",results = {
            @Result(name = SUCCESS,location = "/WEB-INF/jsp/subject/subjectList.jsp")
    })
    public String subjectList(){
        getList();
        setReqM();
        System.out.println("subject size:"+this.subjects.size());
        return SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.reqM = map;
    }
}
