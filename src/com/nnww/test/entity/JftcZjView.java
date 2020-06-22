package com.nnww.test.entity;

import java.util.List;

public class JftcZjView {

    /** ID */
    private String id;

    /** 业务号 */
    private String ywh;

    /** 材料名称 */
    private String clmc;

    /** 材料来源 */
    private String clly;

    /** 证据种类 */
    private String zjzl;

    /** 材料类型 */
    private String cllx;

    /** 文件份数 */
    private Long wjfs;

    /** 证据类型 */
    private String zjlx;

    /** 地址 */
    private String dz;

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

    public String getClmc() {
        return clmc;
    }

    public void setClmc(String clmc) {
        this.clmc = clmc;
    }

    public String getClly() {
        return clly;
    }

    public void setClly(String clly) {
        this.clly = clly;
    }

    public String getZjzl() {
        return zjzl;
    }

    public void setZjzl(String zjzl) {
        this.zjzl = zjzl;
    }

    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx;
    }

    public Long getWjfs() {
        return wjfs;
    }

    public void setWjfs(Long wjfs) {
        this.wjfs = wjfs;
    }

    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public List<JftcFj> getFjList() {
        return fjList;
    }

    public void setFjList(List<JftcFj> fjList) {
        this.fjList = fjList;
    }
}
