package com.nnww.test.genericity;

public class Person<A,C,B> {

    public String name;

    private A phone;

    private C house;

    private B car;

    public <D> String getClassName(D clazz) {
        return clazz.getClass().getName();
    }

    public B getCar() {
        return car;
    }

    public void setCar(B car) {
        this.car = car;
    }

    public C getHouse() {
        return house;
    }

    public void setHouse(C house) {
        this.house = house;
    }

    public A getPhone() {
        return phone;
    }

    public void setPhone(A phone) {
        this.phone = phone;
    }
}
