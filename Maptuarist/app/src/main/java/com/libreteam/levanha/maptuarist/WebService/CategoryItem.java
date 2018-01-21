package com.libreteam.levanha.maptuarist.WebService;

/**
 * Created by Admin on 2/7/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryItem {
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
}
