package com.nnww.test.My;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public enum TestEnum {

    haha,
    xixi;

    public static void main(String[] args) {
//        System.out.println(TestEnum.haha.equals(TestEnum.haha));

        TestEnum e = TestEnum.xixi;
        switch (e) {
            case haha:
                System.out.println("haha");
                break;
            case xixi:
                System.out.println("xixi");
                break;
        }
    }
}
