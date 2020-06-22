package com.nnww.test.entity;


import java.util.Date;

/**
 * Created by zhangbin on 2020/3/19.
 */

public class JftcFj {
    private String id;
    private String glid;
    private String path;
    private String mc;
    private String mime;
    private Date scsj;
    private String sjlx;
    private String sfbs;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getGlid() {
        return glid;
    }

    public void setGlid(String glid) {
        this.glid = glid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }


    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }


    public Date getScsj() {
        return scsj;
    }

    public void setScsj(Date scsj) {
        this.scsj = scsj;
    }



    public String getSjlx() {
        return sjlx;
    }

    public void setSjlx(String sjlx) {
        this.sjlx = sjlx;
    }


    public String getSfbs() {
        return sfbs;
    }

    public void setSfbs(String sfbs) {
        this.sfbs = sfbs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JftcFj jftcFj = (JftcFj) o;

        if (id != null ? !id.equals(jftcFj.id) : jftcFj.id != null) return false;
        if (glid != null ? !glid.equals(jftcFj.glid) : jftcFj.glid != null) return false;
        if (path != null ? !path.equals(jftcFj.path) : jftcFj.path != null) return false;
        if (mc != null ? !mc.equals(jftcFj.mc) : jftcFj.mc != null) return false;
        if (mime != null ? !mime.equals(jftcFj.mime) : jftcFj.mime != null) return false;
        if (scsj != null ? !scsj.equals(jftcFj.scsj) : jftcFj.scsj != null) return false;
        if (sjlx != null ? !sjlx.equals(jftcFj.sjlx) : jftcFj.sjlx != null) return false;
        if (sfbs != null ? !sfbs.equals(jftcFj.sfbs) : jftcFj.sfbs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (glid != null ? glid.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        result = 31 * result + (mime != null ? mime.hashCode() : 0);
        result = 31 * result + (scsj != null ? scsj.hashCode() : 0);
        result = 31 * result + (sjlx != null ? sjlx.hashCode() : 0);
        result = 31 * result + (sfbs != null ? sfbs.hashCode() : 0);
        return result;
    }
}
