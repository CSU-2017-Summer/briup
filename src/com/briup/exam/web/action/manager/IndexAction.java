package com.briup.exam.web.action.manager;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.awt.*;

/**
 * Created by Liuqi on 2017/8/24.
 */
@Action
public class IndexAction extends ActionSupport {

    @Action(value="/indexAction",results = {
            @Result(name=SUCCESS,location = "/WEB-INF/index.jsp")
    })
    public String indexAction(){
        System.out.println("to index");
        System.out.println("...to...index...");
        return SUCCESS;
    }
}
