package com.nnww.RPC.java_rmi;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class Consumer {


    public static void main(String[] args) throws Exception {
        //接口名称
        String interfaceName = Provider.class.getName();
        //方法
        Method sayHello = Provider.class.getMethod("sayHello", String.class);
        //参数
        Object[] params = new Object[] {"hello hello"};
        //发送到远程
        Socket socket = new Socket("localhost", 8088);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeUTF(interfaceName);
        oos.writeUTF(sayHello.getName());
        oos.writeObject(sayHello.getParameterTypes());
        oos.writeObject(params);

        //接收返回参数
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        SayHelloEntity o = (SayHelloEntity) ois.readObject();
        System.out.println("返回: " + o.getStr());
    }
}
