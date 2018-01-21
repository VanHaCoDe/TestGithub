package com.libreteam.levanha.vietnamtouristmap.webService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 2/11/2017.
 */

public class Dataitem {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("name_vi")
    @Expose
    private String nameVi;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("short_description_vi")
    @Expose
    private String shortDescriptionVi;
    @SerializedName("short_description_en")
    @Expose
    private String shortDescriptionEn;
    @SerializedName("description_vi")
    @Expose
    private String descriptionVi;
    @SerializedName("description_en")
    @Expose
    private String descriptionEn;
    @SerializedName("how_to_go_vi")
    @Expose
    private String howToGoVi;
    @SerializedName("how_to_go_en")
    @Expose
    private String howToGoEn;
    @SerializedName("enable_en")
    @Expose
    private Integer enableEn;
    @SerializedName("enable_vi")
    @Expose
    private Integer enableVi;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("name_in_url")
    @Expose
    private String nameInUrl;
    @SerializedName("address_vi")
    @Expose
    private String addressVi;
    @SerializedName("address_en")
    @Expose
    private String addressEn;
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("status_vi_id")
    @Expose
    private Integer statusViId;
    @SerializedName("status_en_id")
    @Expose
    private Integer statusEnId;
    @SerializedName("dri_vi_id")
    @Expose
    private Integer driViId;
    @SerializedName("dri_en_id")
    @Expose
    private Integer driEnId;
    @SerializedName("markdown_flg")
    @Expose
    private String markdownFlg;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("created_by")
    @Expose
    private Integer createdBy;
    @SerializedName("updated_by")
    @Expose
    private Integer updatedBy;
    @SerializedName("images_count")
    @Expose
    private Integer imagesCount;
    @SerializedName("rating_count")
    @Expose
    private Integer ratingCount;
    @SerializedName("rate_real_count")
    @Expose
    private Integer rateRealCount;
    @SerializedName("review_count")
    @Expose
    private Integer reviewCount;
    @SerializedName("checkin_count")
    @Expose
    private Integer checkinCount;
    @SerializedName("recommend_count")
    @Expose
    private Integer recommendCount;
    @SerializedName("report_count")
    @Expose
    private Integer reportCount;
    @SerializedName("approve")
    @Expose
    private Integer approve;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("cover")
    @Expose
    private List<Cover> covers = null;
    @SerializedName("category")
    @Expose

    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getShortDescriptionVi() {
        return shortDescriptionVi;
    }

    public void setShortDescriptionVi(String shortDescriptionVi) {
        this.shortDescriptionVi = shortDescriptionVi;
    }

    public String getShortDescriptionEn() {
        return shortDescriptionEn;
    }

    public void setShortDescriptionEn(String shortDescriptionEn) {
        this.shortDescriptionEn = shortDescriptionEn;
    }

    public String getDescriptionVi() {
        return descriptionVi;
    }

    public void setDescriptionVi(String descriptionVi) {
        this.descriptionVi = descriptionVi;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getHowToGoVi() {
        return howToGoVi;
    }

    public void setHowToGoVi(String howToGoVi) {
        this.howToGoVi = howToGoVi;
    }

    public String getHowToGoEn() {
        return howToGoEn;
    }

    public void setHowToGoEn(String howToGoEn) {
        this.howToGoEn = howToGoEn;
    }

    public Integer getEnableEn() {
        return enableEn;
    }

    public void setEnableEn(Integer enableEn) {
        this.enableEn = enableEn;
    }

    public Integer getEnableVi() {
        return enableVi;
    }

    public void setEnableVi(Integer enableVi) {
        this.enableVi = enableVi;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getNameInUrl() {
        return nameInUrl;
    }

    public void setNameInUrl(String nameInUrl) {
        this.nameInUrl = nameInUrl;
    }

    public String getAddressVi() {
        return addressVi;
    }

    public void setAddressVi(String addressVi) {
        this.addressVi = addressVi;
    }

    public String getAddressEn() {
        return addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStatusViId() {
        return statusViId;
    }

    public void setStatusViId(Integer statusViId) {
        this.statusViId = statusViId;
    }

    public Integer getStatusEnId() {
        return statusEnId;
    }

    public void setStatusEnId(Integer statusEnId) {
        this.statusEnId = statusEnId;
    }

    public Integer getDriViId() {
        return driViId;
    }

    public void setDriViId(Integer driViId) {
        this.driViId = driViId;
    }

    public Integer getDriEnId() {
        return driEnId;
    }

    public void setDriEnId(Integer driEnId) {
        this.driEnId = driEnId;
    }

    public String getMarkdownFlg() {
        return markdownFlg;
    }

    public void setMarkdownFlg(String markdownFlg) {
        this.markdownFlg = markdownFlg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(Integer imagesCount) {
        this.imagesCount = imagesCount;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Integer getRateRealCount() {
        return rateRealCount;
    }

    public void setRateRealCount(Integer rateRealCount) {
        this.rateRealCount = rateRealCount;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getCheckinCount() {
        return checkinCount;
    }

    public void setCheckinCount(Integer checkinCount) {
        this.checkinCount = checkinCount;
    }

    public Integer getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(Integer recommendCount) {
        this.recommendCount = recommendCount;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public Integer getApprove() {
        return approve;
    }

    public void setApprove(Integer approve) {
        this.approve = approve;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Cover> getCover() {
        return covers;
    }

    public void setCover(List<Cover> covers) {
        this.covers = covers;
    }





    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



}
