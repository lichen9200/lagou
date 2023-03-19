package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> findCourseByCondition(CourseVo courseVo) {
        //调用mapper，返回list
        List<Course> list = courseMapper.findCourseByCondition(courseVo);
        return list;
    }

    @Override
    public void saveCourseOrTeacher(CourseVo courseVo) {
        try{
            //封装课程信息
            Course course = new Course();
            System.out.println("course的service层被调用了！！");
            //这个是什么玩意工具？？？
            BeanUtils.copyProperties(courseVo,course);
            //看看course咋呀。。。
            System.out.println("course:" + course.toString());
            Date date = new Date();
            course.setCreateTime(date);
            course.setUpdateTime(date);
            //保存课程
            courseMapper.saveCourse(course);
            //获取新插入数据的id??
            int id = course.getId();
            //还有其他信息呢？？？？？？？？？？？不要了？
            //封装僵尸信息
            Teacher teacher = new Teacher();
            //这句话好像没啥意义吧？没啥对应字段
            BeanUtils.copyProperties(teacher,courseVo);

            //补全信息
            teacher.setCourseId(id);
            teacher.setCreateTime(date);
            teacher.setUpdateTime(date);

            //保存讲师信息
            courseMapper.saveTeacher(teacher);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public CourseVo findCourseById(Integer id) {
        System.out.println("s调用成功！！！"+id);
        CourseVo courseVo = courseMapper.findCourseById(id);
        //ResponseResult responseResult = new ResponseResult(true,200,"success",courseVo);
        return courseVo;
    }

    //修改课程和老师信息

    @Override
    public void updateCourseOrTeacher(CourseVo courseVo) {

        try {
//封装课程信息
            System.out.println("update的service调用了。。。。");
            Course course = new Course();
            BeanUtils.copyProperties(courseVo,course);
            System.out.println("update的service调用了。。。。course::" + course.toString());
//补全信息
            Date date = new Date();
            course.setUpdateTime(date);
//更新课程
            courseMapper.updateCourse(course);
//封装讲师信息
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(courseVo,teacher);
            System.out.println("update的service调用了。。。。teacher::" + teacher.toString());
//补全信息
            teacher.setCourseId(course.getId());
            teacher.setUpdateTime(date);
//更新讲师信息
            courseMapper.updateTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //

    @Override
    public void updateCourseStatus(Integer id, Integer status) {

        try {
//封装数据
            Course course = new Course();
            course.setStatus(status);
            course.setId(id);
            course.setUpdateTime(new Date());
//调用Dao
            courseMapper.updateCourseStatus(course);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
