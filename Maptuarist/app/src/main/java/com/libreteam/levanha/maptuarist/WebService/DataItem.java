package com.libreteam.levanha.maptuarist.WebService;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 2/7/2017.
 */

public class DataItem {
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
    private List<ImageItem> images = null;

    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("category")
    @Expose
    private CategoryItem category;

    @SerializedName("cover")
    @Expose
    private CoverItem cover;

    public CoverItem getCover() {
        return cover;
    }

    public void setCover(CoverItem cover) {
        this.cover = cover;
    }

    public CategoryItem getCategory() {
        return category;
    }

    public void setCategory(CategoryItem category) {
        this.category = category;
    }

    public List<ImageItem> getImages() {
        return images;
    }

    public void setImages(List<ImageItem> images) {
        this.images = images;
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
}
