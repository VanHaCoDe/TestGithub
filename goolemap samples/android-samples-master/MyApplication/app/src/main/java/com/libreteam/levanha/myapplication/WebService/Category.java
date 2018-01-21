package com.libreteam.levanha.myapplication.WebService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 2/11/2017.
 */

public class Category {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name_vi")
    @Expose
    private String nameVi;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("icon_id")
    @Expose
    private Integer iconId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("icon_small_id")
    @Expose
    private Integer iconSmallId;
    @SerializedName("icon")
    @Expose
    private Object icon;
    @SerializedName("icon_small")
    @Expose
    private Object iconSmall;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
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

    public Integer getIconSmallId() {
        return iconSmallId;
    }

    public void setIconSmallId(Integer iconSmallId) {
        this.iconSmallId = iconSmallId;
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    public Object getIconSmall() {
        return iconSmall;
    }

    public void setIconSmall(Object iconSmall) {
        this.iconSmall = iconSmall;
    }
}
