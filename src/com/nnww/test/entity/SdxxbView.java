package com.nnww.test.entity;


import java.util.Date;


//@Entity
//@Table(name = "JFZC_SDXXB")
public class SdxxbView {

    /** 主键自增 */
    
    private Long id;

    /** 业务号 */
    
    private String ywh;

    /** 送达类型 */
    
    private String sdlx;

    /** 送件人姓名 */
    
    private String sdrxm;

    /** 送达时间 */
    private Date sdsj;

    /** 签收人姓名 */
    
    private String qsrxm;

    /** 文件类型 */
    
    private String wjlx;

    /** 附件路径 */
    
    private String fjlj;

    /** C1 */
    
    private String c1;

    /** C2 */
    
    private String c2;

    /** C3 */
    
    private String c3;

    /**
     * 获取主键自增
     * 
     * @return 主键自增
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置主键自增
     * 
     * @param id
     *          主键自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取业务号
     * 
     * @return 业务号
     */
    public String getYwh() {
        return this.ywh;
    }

    /**
     * 设置业务号
     * 
     * @param ywh
     *          业务号
     */
    public void setYwh(String ywh) {
        this.ywh = ywh;
    }

    /**
     * 获取送达类型
     * 
     * @return 送达类型
     */
    public String getSdlx() {
        return this.sdlx;
    }

    /**
     * 设置送达类型
     * 
     * @param sdlx
     *          送达类型
     */
    public void setSdlx(String sdlx) {
        this.sdlx = sdlx;
    }

    /**
     * 获取送件人姓名
     * 
     * @return 送件人姓名
     */
    public String getSdrxm() {
        return this.sdrxm;
    }

    /**
     * 设置送件人姓名
     * 
     * @param sdrxm
     *          送件人姓名
     */
    public void setSdrxm(String sdrxm) {
        this.sdrxm = sdrxm;
    }

    /**
     * 获取送达时间
     * 
     * @return 送达时间
     */
    public Date getSdsj() {
        return this.sdsj;
    }

    /**
     * 设置送达时间
     * 
     * @param sdsj
     *          送达时间
     */
    public void setSdsj(Date sdsj) {
        this.sdsj = sdsj;
    }

    /**
     * 获取签收人姓名
     * 
     * @return 签收人姓名
     */
    public String getQsrxm() {
        return this.qsrxm;
    }

    /**
     * 设置签收人姓名
     * 
     * @param qsrxm
     *          签收人姓名
     */
    public void setQsrxm(String qsrxm) {
        this.qsrxm = qsrxm;
    }

    /**
     * 获取文件类型
     * 
     * @return 文件类型
     */
    public String getWjlx() {
        return this.wjlx;
    }

    /**
     * 设置文件类型
     * 
     * @param wjlx
     *          文件类型
     */
    public void setWjlx(String wjlx) {
        this.wjlx = wjlx;
    }

    /**
     * 获取附件路径
     * 
     * @return 附件路径
     */
    public String getFjlj() {
        return this.fjlj;
    }

    /**
     * 设置附件路径
     * 
     * @param fjlj
     *          附件路径
     */
    public void setFjlj(String fjlj) {
        this.fjlj = fjlj;
    }

    /**
     * 获取C1
     * 
     * @return C1
     */
    public String getC1() {
        return this.c1;
    }

    /**
     * 设置C1
     * 
     * @param c1
     *          C1
     */
    public void setC1(String c1) {
        this.c1 = c1;
    }

    /**
     * 获取C2
     * 
     * @return C2
     */
    public String getC2() {
        return this.c2;
    }

    /**
     * 设置C2
     * 
     * @param c2
     *          C2
     */
    public void setC2(String c2) {
        this.c2 = c2;
    }

    /**
     * 获取C3
     * 
     * @return C3
     */
    public String getC3() {
        return this.c3;
    }

    /**
     * 设置C3
     * 
     * @param c3
     *          C3
     */
    public void setC3(String c3) {
        this.c3 = c3;
    }
}