package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {
    @Autowired
    private PromotionAdService adService;
    /*
    分页查询所有广告信息
    */
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllAdByPage(PromotionAdVo adVo) {
        PageInfo allAdByPage = adService.findAllAdByPage(adVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", allAdByPage);
        return responseResult;
    }

    /*
新增或更新广告位置
*/
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd
                                                          promotionAd) {
        System.out.println("添加或更新广告c层运行了。。。。");
        try {
            if (promotionAd.getId() == null) {
                Date date = new Date();
                promotionAd.setCreateTime(date);
                promotionAd.setUpdateTime(date);
                adService.savePromotionAd(promotionAd);
                ResponseResult result = new ResponseResult(true, 200, "响应成功",
                        null);
                return result;
            } else {
                Date date = new Date();
                promotionAd.setUpdateTime(date);
                adService.updatePromotionAd(promotionAd);
                ResponseResult result = new ResponseResult(true, 200, "响应成功",
                        null);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id回显 广告数据
     * */
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam Integer id){
        try {
            PromotionAd promotionAd = adService.findPromotionAdById(id);
            ResponseResult result = new ResponseResult(true,200,"响应成 功",promotionAd);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
广告位置上下线
*/
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updateCourseStatus(@RequestParam Integer id, @RequestParam Integer status) {
        try {
//执行修改操作
            if (status == 1) {
                adService.updatePromotionAdStatus(id, status);
            } else {
                adService.updatePromotionAdStatus(id, 0);
            }
//保存修改后的状态,并返回
            Map<String, Integer> map = new HashMap<>();
            map.put("status", status);
            ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}