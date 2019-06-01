package com.waa.abdu.domain;

public class InputValues {


    private int add1, add2,mult1, mult2;

    public int getAdd1() {
        return add1;
    }

    public int getAdd2() {
        return add2;
    }

    public int getMult1() {
        return mult1;
    }

    public int getMult2() {
        return mult2;
    }

    public void setAdd1(int add1) {
        this.add1 = add1;
    }

    public void setAdd2(int add2) {
        this.add2 = add2;
    }

    public void setMult1(int mult1) {
        this.mult1 = mult1;
    }

    public void setMult2(int mult2) {
        this.mult2 = mult2;
    }

    public int sum(){
        return add1+add2;
    }

    public int product(){
        return mult1*mult2;
    }
}
