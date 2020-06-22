package com.nnww.设计模式.责任链模式;

import com.sun.glass.ui.Size;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Handler> handlers = new ArrayList<>();
        handlers.add(new HandlerA());
        handlers.add(new HandlerB());
        handlers.add(new ActualHandler());
        Handler first = serHandlers(handlers);
        first.excute(new MyRequest());
    }

    private static Handler serHandlers(ArrayList<Handler> handlers) {
        for (int i = 0; i < handlers.size() - 1; i++) {
            Handler handler = handlers.get(i);
            handler.setNextHandler(handlers.get(i + 1));
        }
        return handlers.get(0);
    }


}
