package com.gnq.video.video.entity;

import java.io.Serializable;

public class Video extends Media implements Serializable {
    private static final long serialVersionUID = 9165648102449504771L;

    private Long id;
    private String url;
    private String title;
//    String accessKeyId;
//    String accessKeySecret;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getAccessKeyId() {
//        return accessKeyId;
//    }
//
//    public void setAccessKeyId(String accessKeyId) {
//        this.accessKeyId = accessKeyId;
//    }
//
//    public String getAccessKeySecret() {
//        return accessKeySecret;
//    }
//
//    public void setAccessKeySecret(String accessKeySecret) {
//        this.accessKeySecret = accessKeySecret;
//    }
}
