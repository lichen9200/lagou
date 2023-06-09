package com.lagou.domain;

import java.util.Date;
import java.util.List;

/**
 * 章节类
 * */
public class CourseSection {

    //id
    private Integer id;

    //课程id
    private Integer courseId;

    //章节名
    private String sectionName;

    //章节描述
    private String description;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //是否删除
    private Integer isDe;

    //排序
    private Integer orderNum;

    //状态
    private Integer status;

    //课时集合
    private List<CourseLesson> lessonList;

    public List<CourseLesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<CourseLesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDe() {
        return isDe;
    }

    public void setIsDe(Integer isDe) {
        this.isDe = isDe;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
