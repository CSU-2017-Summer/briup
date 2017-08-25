/**
 * Created by lichunyu on 16/9/22.
 * 首页核心js文件
 */
$(function(){
    //实现左侧导航动画效果
    $(".baseUI>li>a").off("click");
    $(".baseUI>li>a").on("click",function () {
        $(".baseUI>li>ul").slideUp();
        $(this).next().slideDown(300);
    });
    //默认收起全部，展示第一个
    $(".baseUI>li>ul").slideUp();
    $(".baseUI>li>a").eq(0).trigger("click");

    $(".baseUI>li>ul>li").off();
    $(".baseUI>li>ul>li").on("click",function () {
        if(!$(this).hasClass("current")){
            $(".baseUI>li>ul>li").removeClass("current");
            $(this).addClass("current");
        }
    });
    //模拟点击
    $(".baseUI>li>ul>li>a").eq(0).trigger("click");
});

//核心模块
angular.module("app",["ng","ngRoute","app.subject","app.paper","app.subjectType","app.subjectLevel","app.department","app.topic"])
    //核心模块控制器
    .controller("mainCtrl",["$scope",function ($scope) {
        
    }])
    //路由配置
    .config(["$routeProvider",function ($routeProvider) {
        /*
        * a  类型id
        * b  难度id
        * c  方向id
        * d  知识点id
        * */

        //试题管理
        $routeProvider.when("/AllSubject/a/:a/b/:b/c/:c/d/:d",{
            templateUrl:"tpl/subject/subjectList.html",
            controller:"subjectController"
        }).when("/SubjectAdd",{
            templateUrl:"/addSubject.action",
            controller:"subjectController"
        }).when("/SubjectDel/id/:id",{
            templateUrl:"tpl/subject/subjectList.html",
            controller:"subjectDelController"
        }).when("/SubjectCheck/id/:id/state/:state",{
            templateUrl:"tpl/subject/subjectList.html",
            controller:"subjectCheckController"
        //试卷管理
        }).when("/PaperList",{
            templateUrl:"tpl/paper/paperManager.html",
            controller:"paperListController"
        }).when("/PaperAdd/id/:id/stem/:stem/type/:type/topic/:topic/level/:level",{
            templateUrl:"tpl/paper/paperAdd.html",
            controller:"paperAddController"
        }).when("/PaperSubjectList",{
            templateUrl:"tpl/paper/subjectList.html",
            controller:"subjectController"

        //题型管理
        }).when("/subjectTypeManager",{
            templateUrl:"tpl/manager/subjectTypeManager.html",
            controller:"subjectTypeController"
            //难度管理
        }).when("/subjectLevelManager",{
            templateUrl:"tpl/manager/subjectLevelManager.html",
            controller:"subjectLevelController"
            //部门管理
        }).when("/departmentManager",{
            templateUrl:"tpl/manager/departmentManager.html",
            controller:"departmentController"
            //知识点管理
        }).when("/topicManager",{
            templateUrl:"tpl/manager/topicManager.html",
            controller:"topicController"
        });


    }]);

