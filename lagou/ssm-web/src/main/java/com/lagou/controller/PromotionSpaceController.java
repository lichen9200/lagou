package com.lagou.controller;

import com.lagou.domain.PromotionSpace;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {
    @Autowired
    private PromotionSpaceService promotionSpaceService;
    /*
    查询所有广告位列表
    */
    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> allPromotionSpace = promotionSpaceService.findAllPromotionSpace();
        ResponseResult responseResult = new ResponseResult(true,200,"响应成 功",allPromotionSpace);
        return responseResult;
    }


    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult savePromotionSpace(@RequestBody PromotionSpace
                                                     promotionSpace){
        try {
            if(promotionSpace.getId() == null){
//新增
                promotionSpaceService.savePromotionSpace(promotionSpace);
                ResponseResult responseResult = new ResponseResult(true,200,"响应 成功","");
                return responseResult;
            }else{
//修改
                promotionSpaceService.updatePromotionSpace(promotionSpace);
                ResponseResult responseResult = new ResponseResult(true,200,"响应 成功","");
                return responseResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据id查询 广告位信息
     * */
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(@RequestParam Integer id){
        PromotionSpace promotionSpace =
                promotionSpaceService.findPromotionSpaceById(id);
        ResponseResult result = new ResponseResult(true,200,"响应成 功",promotionSpace);
        return result;
    }
}