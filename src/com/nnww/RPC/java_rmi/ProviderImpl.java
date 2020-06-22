package com.nnww.RPC.java_rmi;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ProviderImpl implements Provider {

    @Override
    public SayHelloEntity sayHello(String arg) {
        SayHelloEntity sayHelloEntity = new SayHelloEntity(arg);
        return sayHelloEntity;
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, Object> contextMap = new HashMap<>();
        contextMap.put("com.nnww.RPC.java_rmi.Provider", new ProviderImpl());

        ServerSocket serverSocket = new ServerSocket(8088);
        while (true) {
            Socket accept = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
            String interfaceName = ois.readUTF();
            String methodName = ois.readUTF();
            Class<?>[] paramType = (Class<?>[]) ois.readObject();
            Object[] params = (Object[]) ois.readObject();

            Class<?> clazz = Class.forName(interfaceName);
            Method method = clazz.getMethod(methodName, paramType);
            Object o = method.invoke(contextMap.get(interfaceName),params);

            ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
            oos.writeObject(o);
        }
    }
}
