package com.hyunsense.web.entity;

import java.util.Date;

public class Notice_View {

    private int id;
    private String title;
    private String writerId;
//    private String content;
    private Date regDate;
    private int hit;
    private String files;
    private int cnt;

    public Notice_View() {
    }

    public Notice_View(int id, String title, String writerId, Date regDate, int hit, String files, int cnt) {
        this.id = id;
        this.title = title;
        this.writerId = writerId;
        this.regDate = regDate;
        this.hit = hit;
        this.files = files;
        this.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
