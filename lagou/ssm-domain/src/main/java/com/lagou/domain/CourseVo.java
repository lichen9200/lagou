package com.lagou.domain;

public class CourseVo {
    //为了修改课程update信息添加了这个破玩意id
    private Integer id;
    private String courseName;
    private Integer status = 0;//设个默认值，自己加的

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String brief;
    private String description;
    private String position;



    private String previewFirstField;
    private  String previewSecondField;
    private Double discounts;
    private Double price;
    private String discountsTag;
    private String courseImgUrl;
    private String courseListImg;
    private Integer sortNum;
    private String courseDescriptionMarkDown;
     private Integer sales;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPreviewFirstField() {
        return previewFirstField;
    }

    public void setPreviewFirstField(String previewFirstField) {
        this.previewFirstField = previewFirstField;
    }

    public String getPreviewSecondField() {
        return previewSecondField;
    }

    public void setPreviewSecondField(String previewSecondField) {
        this.previewSecondField = previewSecondField;
    }

    public Double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Double discounts) {
        this.discounts = discounts;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDiscountsTag() {
        return discountsTag;
    }

    public void setDiscountsTag(String discountsTag) {
        this.discountsTag = discountsTag;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    public String getCourseListImg() {
        return courseListImg;
    }

    public void setCourseListImg(String courseListImg) {
        this.courseListImg = courseListImg;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getCourseDescriptionMarkDown() {
        return courseDescriptionMarkDown;
    }

    public void setCourseDescriptionMarkDown(String courseDescriptionMarkDown) {
        this.courseDescriptionMarkDown = courseDescriptionMarkDown;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "CourseVo{" +
                "courseName='" + courseName + '\'' +
                ", status=" + status +
                ", brief='" + brief + '\'' +
                ", description='" + description + '\'' +
                ", position='" + position + '\'' +
                ", previewFirstField='" + previewFirstField + '\'' +
                ", previewSecondField='" + previewSecondField + '\'' +
                ", discounts=" + discounts +
                ", price=" + price +
                ", discountsTag='" + discountsTag + '\'' +
                ", courseImgUrl='" + courseImgUrl + '\'' +
                ", courseListImg='" + courseListImg + '\'' +
                ", sortNum=" + sortNum +
                ", courseDescriptionMarkDown='" + courseDescriptionMarkDown + '\'' +
                ", sales=" + sales +
                '}';
    }
}
