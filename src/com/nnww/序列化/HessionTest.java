package com.nnww.序列化;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class HessionTest implements Serializable {

    private String id = "111";


    /**
     * java内置 序列化
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HessionTest h = new HessionTest();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(h);

        byte[] bytes = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        HessionTest o = (HessionTest) ois.readObject();
        System.out.println(o);

        ois.close();
        byteArrayInputStream.close();
        oos.close();
        byteArrayOutputStream.close();
    }
}
