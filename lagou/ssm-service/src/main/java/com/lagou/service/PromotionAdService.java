package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;

public interface PromotionAdService {
    /*
分页获取所有的广告列表
*/
    public PageInfo findAllAdByPage(PromotionAdVo adVo);

    void savePromotionAd(PromotionAd promotionAd);
    void updatePromotionAd(PromotionAd promotionAd);

    /*
回显广告信息
*/
    PromotionAd findPromotionAdById(Integer id);

    void updatePromotionAdStatus(Integer id, Integer status);
}
