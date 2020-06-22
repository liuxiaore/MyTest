package com.nnww.test.entity;


import java.util.Date;


//@Entity
//@Table(name = "JFZC_SSXXB")
public class SsxxbModel implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -582040848399055308L;

    /** 主键自增 */
    
    private Long id;

    /** 业务号 */
    
    private String ywh;

    /** 诉讼人姓名 */
    
    private String ssrxm;

    /** 诉讼人性别 */
    
    private String ssrxb;

    /** 诉讼人证件号码 */
    
    private String ssrzjhm;

    /** 诉讼人地址 */
    
    private String ssrdz;

    /** 被诉讼人姓名 */
    
    private String bssrxm;

    /** 被诉讼人性别 */
    
    private String bssrxb;

    /** 被诉讼人证件号码 */
    
    private String bssrzjhm;

    /** 被诉讼人地址 */
    
    private String bssrdz;

    /** 法院名称 */
    
    private String fymc;

    /** 诉讼时间 */
    private Date sssj;

    /** 诉讼内容 */
    
    private String ssnr;

    /** 判决结果 */
    
    private String pjjg;

    /** 附件路径 */
    
    private String fjlj;

    /** 诉讼状态 */
    
    private String status;

    /** 业务字段 */
    
    private String c1;

    /** 业务字段 */
    
    private String c2;

    /** 业务字段 */
    
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
     * 获取诉讼人姓名
     * 
     * @return 诉讼人姓名
     */
    public String getSsrxm() {
        return this.ssrxm;
    }

    /**
     * 设置诉讼人姓名
     * 
     * @param ssrxm
     *          诉讼人姓名
     */
    public void setSsrxm(String ssrxm) {
        this.ssrxm = ssrxm;
    }

    /**
     * 获取诉讼人性别
     * 
     * @return 诉讼人性别
     */
    public String getSsrxb() {
        return this.ssrxb;
    }

    /**
     * 设置诉讼人性别
     * 
     * @param ssrxb
     *          诉讼人性别
     */
    public void setSsrxb(String ssrxb) {
        this.ssrxb = ssrxb;
    }

    /**
     * 获取诉讼人证件号码
     * 
     * @return 诉讼人证件号码
     */
    public String getSsrzjhm() {
        return this.ssrzjhm;
    }

    /**
     * 设置诉讼人证件号码
     * 
     * @param ssrzjhm
     *          诉讼人证件号码
     */
    public void setSsrzjhm(String ssrzjhm) {
        this.ssrzjhm = ssrzjhm;
    }

    /**
     * 获取诉讼人地址
     * 
     * @return 诉讼人地址
     */
    public String getSsrdz() {
        return this.ssrdz;
    }

    /**
     * 设置诉讼人地址
     * 
     * @param ssrdz
     *          诉讼人地址
     */
    public void setSsrdz(String ssrdz) {
        this.ssrdz = ssrdz;
    }

    /**
     * 获取被诉讼人姓名
     * 
     * @return 被诉讼人姓名
     */
    public String getBssrxm() {
        return this.bssrxm;
    }

    /**
     * 设置被诉讼人姓名
     * 
     * @param bssrxm
     *          被诉讼人姓名
     */
    public void setBssrxm(String bssrxm) {
        this.bssrxm = bssrxm;
    }

    /**
     * 获取被诉讼人性别
     * 
     * @return 被诉讼人性别
     */
    public String getBssrxb() {
        return this.bssrxb;
    }

    /**
     * 设置被诉讼人性别
     * 
     * @param bssrxb
     *          被诉讼人性别
     */
    public void setBssrxb(String bssrxb) {
        this.bssrxb = bssrxb;
    }

    /**
     * 获取被诉讼人证件号码
     * 
     * @return 被诉讼人证件号码
     */
    public String getBssrzjhm() {
        return this.bssrzjhm;
    }

    /**
     * 设置被诉讼人证件号码
     * 
     * @param bssrzjhm
     *          被诉讼人证件号码
     */
    public void setBssrzjhm(String bssrzjhm) {
        this.bssrzjhm = bssrzjhm;
    }

    /**
     * 获取被诉讼人地址
     * 
     * @return 被诉讼人地址
     */
    public String getBssrdz() {
        return this.bssrdz;
    }

    /**
     * 设置被诉讼人地址
     * 
     * @param bssrdz
     *          被诉讼人地址
     */
    public void setBssrdz(String bssrdz) {
        this.bssrdz = bssrdz;
    }

    /**
     * 获取法院名称
     * 
     * @return 法院名称
     */
    public String getFymc() {
        return this.fymc;
    }

    /**
     * 设置法院名称
     * 
     * @param fymc
     *          法院名称
     */
    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    /**
     * 获取诉讼时间
     * 
     * @return 诉讼时间
     */
    public Date getSssj() {
        return this.sssj;
    }

    /**
     * 设置诉讼时间
     * 
     * @param sssj
     *          诉讼时间
     */
    public void setSssj(Date sssj) {
        this.sssj = sssj;
    }

    /**
     * 获取诉讼内容
     * 
     * @return 诉讼内容
     */
    public String getSsnr() {
        return this.ssnr;
    }

    /**
     * 设置诉讼内容
     * 
     * @param ssnr
     *          诉讼内容
     */
    public void setSsnr(String ssnr) {
        this.ssnr = ssnr;
    }

    /**
     * 获取判决结果
     * 
     * @return 判决结果
     */
    public String getPjjg() {
        return this.pjjg;
    }

    /**
     * 设置判决结果
     * 
     * @param pjjg
     *          判决结果
     */
    public void setPjjg(String pjjg) {
        this.pjjg = pjjg;
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
     * 获取诉讼状态
     * 
     * @return 诉讼状态
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * 设置诉讼状态
     * 
     * @param status
     *          诉讼状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取业务字段
     * 
     * @return 业务字段
     */
    public String getC1() {
        return this.c1;
    }

    /**
     * 设置业务字段
     * 
     * @param c1
     *          业务字段
     */
    public void setC1(String c1) {
        this.c1 = c1;
    }

    /**
     * 获取业务字段
     * 
     * @return 业务字段
     */
    public String getC2() {
        return this.c2;
    }

    /**
     * 设置业务字段
     * 
     * @param c2
     *          业务字段
     */
    public void setC2(String c2) {
        this.c2 = c2;
    }

    /**
     * 获取业务字段
     * 
     * @return 业务字段
     */
    public String getC3() {
        return this.c3;
    }

    /**
     * 设置业务字段
     * 
     * @param c3
     *          业务字段
     */
    public void setC3(String c3) {
        this.c3 = c3;
    }
}