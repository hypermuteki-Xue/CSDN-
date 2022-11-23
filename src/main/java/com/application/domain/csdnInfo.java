package com.application.domain;

public class csdnInfo {
    private String title;
    private String author;
    private String Detail;
    private String url;
    private String dayTime;

    public csdnInfo() {
    }

    public csdnInfo(String title, String author, String detail, String url, String dayTime) {
        this.title = title;
        this.author = author;
        Detail = detail;
        this.url = url;
        this.dayTime = dayTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    @Override
    public String toString() {
        return "csdnInfo{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", Detail='" + Detail + '\'' +
                ", url='" + url + '\'' +
                ", dayTime='" + dayTime + '\'' +
                '}';
    }
}
