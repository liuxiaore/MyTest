package com.nnww.test.oshi;

public class Cpu {
	/**
     * 核心数
     */
    private int cpuNum;
 
    /**
     * CPU总的使用率
     */

    private double total;
 
    /**
     * CPU系统使用率
     */

    private double sys;
 
    /**
     * CPU用户使用率
     */
    private double used;
 
    /**
     * CPU当前等待率
     */
    private double wait;
 
    /**
     * CPU当前空闲率
     */
    private double free;
 
 
    public double getTotal() {
        return Arith.round(Arith.mul(total, 100), 2);
    }
 
    public double getSys() {
        return Arith.round(Arith.mul(sys / total, 100), 2);
    }
    
    public double getUsed() {
        return Arith.round(Arith.mul(used / total, 100), 2);
    }
 
    public double getWait() {
        return Arith.round(Arith.mul(wait / total, 100), 2);
    }
 
    public double getFree() {
        return Arith.round(Arith.mul(free / total, 100), 2);
    }

    public int getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(int cpuNum) {
        this.cpuNum = cpuNum;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setSys(double sys) {
        this.sys = sys;
    }

    public void setUsed(double used) {
        this.used = used;
    }

    public void setWait(double wait) {
        this.wait = wait;
    }

    public void setFree(double free) {
        this.free = free;
    }
}
