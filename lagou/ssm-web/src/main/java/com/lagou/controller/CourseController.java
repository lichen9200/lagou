package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/findCourseByCondition", method = RequestMethod.POST)
    public ResponseResult findCourseByCondition(@RequestBody CourseVo courseVo) {
        //理论上要判断数据合法性，长度，范围等
        List<Course> list = courseService.findCourseByCondition(courseVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "success", list);
        return responseResult;


    }

    //上传图片文件
    @RequestMapping(value = "/courseUpload", method = RequestMethod.POST)
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //接受参数使用requestbody干嘛的？注意区分请求还是响应
        try {
//1.判断文件是否为空
            if (file.isEmpty()) {
                throw new RuntimeException();
            }
//2.获取项目部署路径
// D:\apache-tomcat-8.5.56\webapps\ssm_web\
            String realPath = request.getServletContext().getRealPath("/");
// D:\apache-tomcat-8.5.56\webapps\
            String webappsPath =
                    realPath.substring(0, realPath.indexOf("ssm-web"));

            //3.获取原文件名
            String fileName = file.getOriginalFilename();
//4.新文件名
            String newFileName = System.currentTimeMillis() +
                    fileName.substring(fileName.lastIndexOf("."));
//5.上传文件
            String uploadPath = webappsPath + "upload\\";
            File filePath = new File(uploadPath, newFileName);
//如果目录不存在就创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录: " + filePath);
            }
            file.transferTo(filePath);
//6.将文件名和文件路径返回
            Map<String, String> map = new HashMap<>();
            map.put("fileName", newFileName);
            map.put("filePath", "http://localhost:8080" + "/upload/" + newFileName);
            ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @RequestMapping(value = "/saveOrUpdateCourse")  //不写都支持
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVo courseVo) {
        System.out.println("调用了！！！！！！");
        System.out.println("  " + courseVo.toString());
        if(courseVo.getId()==null)
        {
            System.out.println("新增！！！调用了！！！！！！");
            System.out.println("  " + courseVo.toString());
            courseService.saveCourseOrTeacher(courseVo);
            ResponseResult responseResult = new ResponseResult(true, 200, "新增success", " " + courseVo.toString());
            return responseResult;
        }
        else
        {
            System.out.println("修改！！！调用了！！！！！！");
            System.out.println("  " + courseVo.toString());
            courseService.updateCourseOrTeacher(courseVo);
            ResponseResult responseResult = new ResponseResult(true, 200, "修改·success"," " + courseVo.toString());
            return responseResult;
        }
        //courseService.saveCourseOrTeacher(courseVo);

        //System.out.println(courseVo.getCourseName());

       // ResponseResult responseResult = new ResponseResult(true, 200, "success", null);

    }


    //修改老师和课程信息
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id) {

        System.out.println("c调用成功！！！" + id);
        CourseVo courseVo = courseService.findCourseById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "success", courseVo.toString());
        return responseResult;
    }

    /**
     * 修改课程状态
     * */
    @RequestMapping("/updateCourseStatus")


    public ResponseResult updateCourseStatus(@RequestParam Integer id,@RequestParam
    Integer status){
        try {
//执行修改操作
            courseService.updateCourseStatus(id, status);
//保存修改后的状态,并返回
            Map<String,Integer> map = new HashMap<>();
            map.put("status",status);
            ResponseResult result = new ResponseResult(true,200,"响应成功",map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }









}
