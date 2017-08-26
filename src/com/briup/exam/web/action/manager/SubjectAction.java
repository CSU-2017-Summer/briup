package com.briup.exam.web.action.manager;


import com.briup.exam.bean.*;
import com.briup.exam.service.impl.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.Element;
import com.opensymphony.xwork2.util.KeyProperty;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by Liuqi on 2017/8/23.
 */
@Action
public class SubjectAction extends ActionSupport implements ApplicationAware{

    List<SubjectType> types;
    List<SubjectLevel> levels;
    List<Topic> topics;
    List<Department> departments;
    List<Subject> subjects;
    List<Choice> choices;

    private Map<String,Object> reqM;

    private Subject subject;
    private List<Choice> choice = new ArrayList<>();


    private SubjectType subjectType;

    public List<Choice> getChoice() {
        return choice;
    }

    public void setChoice(List<Choice> choice) {
        this.choice = choice;
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
//        reqM.put("subjects",subjects);
    }





    @Action(value="/saveSubject",results = {
            @Result(name = SUCCESS,location = "#")
    })
    public String saveSubject(){
        System.out.println("in action saveSubjectAction...");
        System.out.println(subject.getStem()+" "+subject.getAnalysis()+" "+subject.getAnswer());

        subject.setCheckState("未审核");
        subject.setUploadTime(new Date());
        if(subject.getSubjectType().getId()==3){
            System.out.println("存简答题");
            subjectService.save(subject);
        }
        else{
            subjectService.save(subject);
            for(Choice c:choice){
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
        getList();
        setReqM();
        return SUCCESS;
    }




    @Action(value="/getAllSubjectType",results = {
            @Result(name = SUCCESS,location = "/WEB-INF/jsp/subject/subjectList.jsp")
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

    @Action(value="/subjectDetail", results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/subject/subjectList.jsp")
    })
    public String subjectDetail(){
        System.out.println("type: "+subject.getSubjectType().getId()+" level:"+subject.getSubjectLevel().getId()+" stem:"+subject.getStem());
        List<Subject> list = subjectService.findByExample(subject,Order.asc("id"));
        System.out.println(list.size());
        getList();
        setReqM();
        for(Subject s:list){
            System.out.println(s);
        }
        reqM.put("subjects",list);
        reqM.put("typeid",subject.getSubjectType().getId());
        reqM.put("levelid",subject.getSubjectLevel().getId());
        reqM.put("topicid",subject.getTopic().getId());
        reqM.put("departmentid",subject.getDepartment().getId());
        return SUCCESS;
    }

    @Action(value = "/getDetail",results = {
            @Result(name = SUCCESS,location = "/WEB-INF/jsp/subject/subjectDetail.jsp")
    })
    public String getDetail(){
        return SUCCESS;
    }


    @Action(value = "/deleteSubject",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/subject/subjectList.jsp")
    })
    public String deleteSubject(){
        System.out.println("in delete subject... "+subject.getId());
        subjectService.delete(subject.getId());
        return SUCCESS;
    }


    @Action(value = "/changeCheckState",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/subject/subjectList.jsp")
    })
    public String changeCheckState(){
        System.out.println("in changecheckstate"+subject.getId()+" :"+subject.getCheckState());
        Subject s = subjectService.findById(subject.getId());
        s.setCheckState(subject.getCheckState());
        subjectService.saveOrUpdate(s);
        return SUCCESS;
    }



    @Override
    public void setApplication(Map<String, Object> map) {
        this.reqM = map;
    }
}
