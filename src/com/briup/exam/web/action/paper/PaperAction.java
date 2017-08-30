package com.briup.exam.web.action.paper;

import com.briup.exam.bean.*;
import com.briup.exam.service.impl.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Paper;
import java.util.*;

/**
 * Created by Liuqi on 2017/8/26.
 */
@Action
public class PaperAction extends ActionSupport implements ApplicationAware{

    List<SubjectType> types;
    List<SubjectLevel> levels;
    List<Topic> topics;
    List<Department> departments;
    List<Subject> subjects;


    private Map<String,Object> appM;

    private Subject subject;
    private ExamPaper paper;
    private List<PaperSubject> paperSubjects;

    private List<ExamPaper> papers;

    public List<ExamPaper> getPapers() {
        return papers;
    }

    public void setPapers(List<ExamPaper> papers) {
        this.papers = papers;
    }

    public List<PaperSubject> getPaperSubjects() {
        return paperSubjects;
    }

    public void setPaperSubjects(List<PaperSubject> paperSubjects) {
        this.paperSubjects = paperSubjects;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    public ExamPaper getPaper() {
        return paper;
    }

    public void setPaper(ExamPaper paper) {
        this.paper = paper;
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

    @Autowired
    private ExamPaperServiceImpl examPaperService;

    @Autowired
    private PaperSubjectServiceImpl paperSubjectService;


    public void getAllList() {
        this.types = subjectTypeService.findAll(Order.asc("id"));
        this.levels = subjectLevelService.findAll(Order.asc("id"));
        this.topics = topicService.findAll(Order.asc("id"));
        this.departments = departmentService.findAll(Order.asc("id"));
        this.subjects = subjectService.findAll(Order.asc("id"));
    }




    @Action(value = "/paperAdd",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/paper/paperAdd.jsp")
    })
    public String paperAdd(){
        getAllList();
//        System.out.println("department: "+subject.getDepartment().getId());
        appM.put("departments",departments);
        return SUCCESS;
    }

    @Action(value="/paperList",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/paper/paperList.jsp")
    })
    public String paperList(){
        return SUCCESS;
    }

    @Action(value="/paperManager",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/paper/paperManager.jsp")
    })
    public String paperManager(){
        List<ExamPaper> list;
        list = examPaperService.findAll(Order.asc("id"));
        System.out.println("找到的试卷数目为："+list.size());
        appM.put("papers",list);
        return SUCCESS;
    }

    @Action(value="/querySubject",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/paper/querySubject.jsp")
    })
    public String querySubject(){
        List<Subject> list = new ArrayList<>();
        System.out.println("in querySubject action...");
        System.out.println(subject.getDepartment().getId());
        list = subjectService.findByExample(subject,Order.asc("id"));
        System.out.println("list的大小:"+list.size());
        appM.put("subjects",list);
        return SUCCESS;
    }

    @Action(value = "/saveExampaper",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/paper/paperAdd.jsp")
    })
    public String saveExampaper(){
        System.out.println("title: "+paper.getTitle()+" description:"+paper.getDescription()+" department:"+paper.getDepartment().getId());
        paper.setCreateTime(new Date());
        examPaperService.save(paper);

        for(PaperSubject s:paperSubjects){
            System.out.println(s.getScore()+":"+s.getSubject().getId());
            s.setExamPaper(paper);
            s.setSubject(subjectService.findById(s.getSubject().getId()));
            paperSubjectService.save(s);
        }
        return SUCCESS;
    }

    @Action(value = "/deletePaper",results = {
            @Result(name = SUCCESS,location = "/WEB-INF/jsp/paper/paperManager.jsp")
    })
    public String deletePaper(){
        if(papers!=null){
            for(ExamPaper paper:papers){
                System.out.println(paper.getId());
                examPaperService.delete(paper.getId());
            }
        }
        return SUCCESS;
    }

    @Action(value = "/viewPaper",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/jsp/paper/paper.jsp")
    })
    public String viewPaper(){
//        System.out.println("title:"+paper.getId());

        ExamPaper exam = examPaperService.findById(paper.getId());
        System.out.println(paper.getId());
        System.out.println("title"+exam.getTitle());
        List<Subject> sublist = new LinkedList<Subject>();
        Set<PaperSubject> list = exam.getPaperSubjects();
        long type[] = {0,0,0};
        int i=0;
        for(PaperSubject s:list){
            System.out.println(s.getSubject());
            sublist.add(s.getSubject());
            if(s.getSubject().getSubjectType().getId()==1){
                type[0]=1;
            }
            else if(s.getSubject().getSubjectType().getId()==2){
                type[1]=1;
            }
            else if(s.getSubject().getSubjectType().getId()==3){
                type[2]=1;
            }
        }


        appM.put("exampaper",exam);
        appM.put("examsubjects",sublist);
        appM.put("types",type);

        System.out.println("list size:"+sublist.size());
        return SUCCESS;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        this.appM = map;
    }
}
