package com.xujiaji.todo.repository.bean;

import com.google.gson.annotations.SerializedName;

public class DailyBean {
    /**
     * picUrl : https://cdn.pixabay.com/photo/2017/05/08/13/15/spring-bird-2295431__480.jpg
     * content : 他日江湖相逢，再当杯酒言欢。咱们就此别过
     * color : #FF000000
     * size : 14
     */

    @SerializedName("picUrl")
    private String picUrl;
    @SerializedName("content")
    private String content;
    @SerializedName("color")
    private String color;
    @SerializedName("size")
    private int size;
    @SerializedName("from")
    private String from;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
