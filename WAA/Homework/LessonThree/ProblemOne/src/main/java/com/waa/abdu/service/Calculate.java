package com.waa.abdu.service;

import com.waa.abdu.iService.ICalculate;

public class Calculate implements com.waa.abdu.iService.ICalculate {
    public int sum(int x, int y) {
        return x+y;
    }
}
