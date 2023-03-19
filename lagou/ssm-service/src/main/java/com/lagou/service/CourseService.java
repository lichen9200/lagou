package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;

import java.util.List;

public interface CourseService {
    public List<Course> findCourseByCondition(CourseVo courseVo);


    //不应该是and吗
    //用courseVo的话不是还差很多信息吗，例如简要和价钱等
    public void saveCourseOrTeacher(CourseVo courseVo);

    //回显课程信息
    public CourseVo findCourseById(Integer id);

    //修改课程和老师信息
    public void updateCourseOrTeacher(CourseVo courseVo);

    /**
     * 修改课程状态
     * */
    public void updateCourseStatus(Integer id,Integer status);

}
