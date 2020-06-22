


package com.nnww.test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nnww.test.entity.*;

import java.util.UUID;


public class JsonTools {
    public JsonTools() {
    }

    public static String createJsonString(String key, Object value) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put(key, value);

        return jsonObject.toString();
    }

    public static void main(String[] args) {
        String s1 = JSON.toJSONString(new SqrxxbModel(), SerializerFeature.WriteMapNullValue);
        System.out.println(s1);

    }
}

