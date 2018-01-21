package com.libreteam.levanha.myapplication.WebService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 2/11/2017.
 */

public class Image {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("o_height")
    @Expose
    private Integer oHeight;
    @SerializedName("o_width")
    @Expose
    private Integer oWidth;
    @SerializedName("o_size")
    @Expose
    private String oSize;
    @SerializedName("domination_color")
    @Expose
    private String dominationColor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getOHeight() {
        return oHeight;
    }

    public void setOHeight(Integer oHeight) {
        this.oHeight = oHeight;
    }

    public Integer getOWidth() {
        return oWidth;
    }

    public void setOWidth(Integer oWidth) {
        this.oWidth = oWidth;
    }

    public String getOSize() {
        return oSize;
    }

    public void setOSize(String oSize) {
        this.oSize = oSize;
    }

    public String getDominationColor() {
        return dominationColor;
    }

    public void setDominationColor(String dominationColor) {
        this.dominationColor = dominationColor;
    }


}
