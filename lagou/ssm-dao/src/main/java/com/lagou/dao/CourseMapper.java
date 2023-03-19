package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.Teacher;

import java.util.List;

public interface CourseMapper {
    public List<Course> findCourseByCondition(CourseVo courseVo);

    //新增一个course
    public void saveCourse(Course course);

    //新增一个讲师
    public void saveTeacher(Teacher teacher);

    //通过id找courseVo
    public CourseVo findCourseById(Integer id);

    //修改课程信息
    public void updateCourse(Course course);

    //修改讲师信息
    public void  updateTeacher(Teacher teacher);

    //更新课程状态
    public void updateCourseStatus(Course course);


}


