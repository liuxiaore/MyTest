package com.nnww.test.entity;

import java.util.List;

public class JftcDbrView {

    private String id;
    /** 业务号 */
    private String ywh;
    /** 代表人姓名 */
    private String dbrxm;
    /** 代表人电话 */
    private String dbrdh;
    /** 代表人性别 */
    private String dbrxb;
    /** 代表人住址 */
    private String dbrzz;
    /** 代表人类别 */
    private String dbrlb;
    /** 代表人身份证明书 */
    private String dbrsfzms;
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

    public String getDbrxm() {
        return dbrxm;
    }

    public void setDbrxm(String dbrxm) {
        this.dbrxm = dbrxm;
    }

    public String getDbrdh() {
        return dbrdh;
    }

    public void setDbrdh(String dbrdh) {
        this.dbrdh = dbrdh;
    }

    public String getDbrxb() {
        return dbrxb;
    }

    public void setDbrxb(String dbrxb) {
        this.dbrxb = dbrxb;
    }

    public String getDbrzz() {
        return dbrzz;
    }

    public void setDbrzz(String dbrzz) {
        this.dbrzz = dbrzz;
    }

    public String getDbrlb() {
        return dbrlb;
    }

    public void setDbrlb(String dbrlb) {
        this.dbrlb = dbrlb;
    }

    public String getDbrsfzms() {
        return dbrsfzms;
    }

    public void setDbrsfzms(String dbrsfzms) {
        this.dbrsfzms = dbrsfzms;
    }

    public List<JftcFj> getFjList() {
        return fjList;
    }

    public void setFjList(List<JftcFj> fjList) {
        this.fjList = fjList;
    }
}
