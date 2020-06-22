package com.nnww.test.java8;// functional/ProduceFunction.java

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

interface FuncSS extends Function<String, String> {
} // [1]

public class ProduceFunction {

    static FuncSS produce() {
        return x -> x.toLowerCase();
    }

//    static FuncSS produce() {
//        return new FuncSS() {
//            @Override
//            public String apply(String s) {
//                return s.toLowerCase();
//            }
//        };
//    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));

    }
}
