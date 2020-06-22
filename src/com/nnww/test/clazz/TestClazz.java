package com.nnww.test.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;

public class TestClazz {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException {
        ResultSet resultSet = null;
        Class<TestClazz> clazz = TestClazz.class;
        TestClazz testClazz = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
//        new HashMap<String, String>()
        for (Field field : fields) {
            System.out.println(field);
            Class<?> type = field.getType();
            String name = field.getName();
            String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1,name.length());
            Method setMethod = clazz.getMethod(methodName, type);
            setMethod.invoke(testClazz, "1");
        }
        System.out.println(testClazz);
    }
}
