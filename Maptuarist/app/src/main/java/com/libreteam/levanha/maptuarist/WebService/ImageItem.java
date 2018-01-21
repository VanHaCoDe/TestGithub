package com.libreteam.levanha.maptuarist.WebService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 2/7/2017.
 */

public class ImageItem {
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


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
