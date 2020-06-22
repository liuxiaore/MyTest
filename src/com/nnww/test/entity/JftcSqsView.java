package com.nnww.test.entity;



import java.util.Date;
import java.util.List;

public class JftcSqsView {

    /** ID */
    private String id;

    /** 业务号 */
    private String ywh;

    /** 申请书类型 */
    private String lx;

    /** 案件名称 */
    private String ajmc;

    /** 录入人员 */
    private String lrry;

    /** 录入时间 */
    private Date lrsj;

    /** 申请人姓名 */
    private String sqrxm;

    /** 申请人ID */
    private String sqrId;

    /** 申请人证件类型(数据字典) */
    private String sqrzjlx;

    /** 申请人证件号 */
    private String sqrzjh;

    /** 申请人地址 */
    private String sqrdz;

    /** 申请人电话 */
    private String sqrdh;

    /** 申请人法定代表人姓名 */
    private String sqrfddbrxm;

    /** 申请人法定代表人身份证 */
    private String sqrfddbrsfz;

    /** 申请人法定代表人电话 */
    private String sqrfddbrdh;

    /** 被申请人姓名 */
    private String bsqrxm;

    /** 被申请人ID */
    private String bsqrId;

    /** 被申请人证件类型(数据字典) */
    private String bsqrzjlx;

    /** 被申请人证件号 */
    private String bsqrzjh;

    /** 被申请人地址 */
    private String bsqrdz;

    /** 被申请人法定代表人姓名 */
    private String bsqrfddbrxm;

    /** 被申请人法定代表人身份证 */
    private String bsqrfddbrsfz;

    /** 被申请人法定代表人电话 */
    private String bsqrfddbrdh;

    /** 仲裁请求内容 */
    private String qqnr;

    /** 仲裁请求事实和理由 */
    private String qqsshnr;

    /** 申请书副本份数 */
    private Long sqsfbfs;

    /** 其他相关材料份数 */
    private Long qtxgclfs;

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

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getAjmc() {
        return ajmc;
    }

    public void setAjmc(String ajmc) {
        this.ajmc = ajmc;
    }

    public String getLrry() {
        return lrry;
    }

    public void setLrry(String lrry) {
        this.lrry = lrry;
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    public String getSqrxm() {
        return sqrxm;
    }

    public void setSqrxm(String sqrxm) {
        this.sqrxm = sqrxm;
    }

    public String getSqrId() {
        return sqrId;
    }

    public void setSqrId(String sqrId) {
        this.sqrId = sqrId;
    }

    public String getSqrzjlx() {
        return sqrzjlx;
    }

    public void setSqrzjlx(String sqrzjlx) {
        this.sqrzjlx = sqrzjlx;
    }

    public String getSqrzjh() {
        return sqrzjh;
    }

    public void setSqrzjh(String sqrzjh) {
        this.sqrzjh = sqrzjh;
    }

    public String getSqrdz() {
        return sqrdz;
    }

    public void setSqrdz(String sqrdz) {
        this.sqrdz = sqrdz;
    }

    public String getSqrdh() {
        return sqrdh;
    }

    public void setSqrdh(String sqrdh) {
        this.sqrdh = sqrdh;
    }

    public String getSqrfddbrxm() {
        return sqrfddbrxm;
    }

    public void setSqrfddbrxm(String sqrfddbrxm) {
        this.sqrfddbrxm = sqrfddbrxm;
    }

    public String getSqrfddbrsfz() {
        return sqrfddbrsfz;
    }

    public void setSqrfddbrsfz(String sqrfddbrsfz) {
        this.sqrfddbrsfz = sqrfddbrsfz;
    }

    public String getSqrfddbrdh() {
        return sqrfddbrdh;
    }

    public void setSqrfddbrdh(String sqrfddbrdh) {
        this.sqrfddbrdh = sqrfddbrdh;
    }

    public String getBsqrxm() {
        return bsqrxm;
    }

    public void setBsqrxm(String bsqrxm) {
        this.bsqrxm = bsqrxm;
    }

    public String getBsqrId() {
        return bsqrId;
    }

    public void setBsqrId(String bsqrId) {
        this.bsqrId = bsqrId;
    }

    public String getBsqrzjlx() {
        return bsqrzjlx;
    }

    public void setBsqrzjlx(String bsqrzjlx) {
        this.bsqrzjlx = bsqrzjlx;
    }

    public String getBsqrzjh() {
        return bsqrzjh;
    }

    public void setBsqrzjh(String bsqrzjh) {
        this.bsqrzjh = bsqrzjh;
    }

    public String getBsqrdz() {
        return bsqrdz;
    }

    public void setBsqrdz(String bsqrdz) {
        this.bsqrdz = bsqrdz;
    }

    public String getBsqrfddbrxm() {
        return bsqrfddbrxm;
    }

    public void setBsqrfddbrxm(String bsqrfddbrxm) {
        this.bsqrfddbrxm = bsqrfddbrxm;
    }

    public String getBsqrfddbrsfz() {
        return bsqrfddbrsfz;
    }

    public void setBsqrfddbrsfz(String bsqrfddbrsfz) {
        this.bsqrfddbrsfz = bsqrfddbrsfz;
    }

    public String getBsqrfddbrdh() {
        return bsqrfddbrdh;
    }

    public void setBsqrfddbrdh(String bsqrfddbrdh) {
        this.bsqrfddbrdh = bsqrfddbrdh;
    }

    public String getQqnr() {
        return qqnr;
    }

    public void setQqnr(String qqnr) {
        this.qqnr = qqnr;
    }

    public String getQqsshnr() {
        return qqsshnr;
    }

    public void setQqsshnr(String qqsshnr) {
        this.qqsshnr = qqsshnr;
    }

    public Long getSqsfbfs() {
        return sqsfbfs;
    }

    public void setSqsfbfs(Long sqsfbfs) {
        this.sqsfbfs = sqsfbfs;
    }

    public Long getQtxgclfs() {
        return qtxgclfs;
    }

    public void setQtxgclfs(Long qtxgclfs) {
        this.qtxgclfs = qtxgclfs;
    }

    public List<JftcFj> getFjList() {
        return fjList;
    }

    public void setFjList(List<JftcFj> fjList) {
        this.fjList = fjList;
    }
}
