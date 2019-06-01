package com.waa.abdu.service;

import com.waa.abdu.service.impl.ICalculator;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements ICalculator {

    @Override
    public int sum(int x, int y) {
        return x+y;
    }

    @Override
    public int product(int x, int y) {
        return x*y;
    }
}
