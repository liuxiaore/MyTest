package com.nnww.test.entity;

import java.util.Date;
import java.util.List;

public class JftcDlrView {

    private String id;
    private String ywh;
    private String dlrxm;
    private String dlrxb;
    private String dlrzw;
    private String dlrlxdh;
    //代表人单位
    private String dlrdw;
    private Date wtrq;
    //授权委托书
    private String sqwts;
    private String dbrlb;
    //附件
    private List<JftcFj> fjList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYwh() {
        return ywh;
    }

    public void setYwh(String ywh) {
        this.ywh = ywh;
    }

    public String getDlrxm() {
        return dlrxm;
    }

    public void setDlrxm(String dlrxm) {
        this.dlrxm = dlrxm;
    }

    public String getDlrxb() {
        return dlrxb;
    }

    public void setDlrxb(String dlrxb) {
        this.dlrxb = dlrxb;
    }

    public String getDlrzw() {
        return dlrzw;
    }

    public void setDlrzw(String dlrzw) {
        this.dlrzw = dlrzw;
    }

    public String getDlrlxdh() {
        return dlrlxdh;
    }

    public void setDlrlxdh(String dlrlxdh) {
        this.dlrlxdh = dlrlxdh;
    }

    public String getDlrdw() {
        return dlrdw;
    }

    public void setDlrdw(String dlrdw) {
        this.dlrdw = dlrdw;
    }

    public Date getWtrq() {
        return wtrq;
    }

    public void setWtrq(Date wtrq) {
        this.wtrq = wtrq;
    }

    public String getSqwts() {
        return sqwts;
    }

    public void setSqwts(String sqwts) {
        this.sqwts = sqwts;
    }

    public String getDbrlb() {
        return dbrlb;
    }

    public void setDbrlb(String dbrlb) {
        this.dbrlb = dbrlb;
    }

    public List<JftcFj> getFjList() {
        return fjList;
    }

    public void setFjList(List<JftcFj> fjList) {
        this.fjList = fjList;
    }
}
