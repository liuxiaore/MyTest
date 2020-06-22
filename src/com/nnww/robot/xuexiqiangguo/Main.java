package com.nnww.robot.xuexiqiangguo;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.net.HttpCookie;

public class Main {

    //提交阅读进度url
    public static String readDurationUrl = "https://iflow-api.xuexi.cn/logflow/api/v1/pclog";

    public static void excuteReadDuration() {
        /**
         * String result2 = HttpRequest.post(url)
         .header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
         .form(paramMap)//表单内容
         .timeout(20000)//超时，毫秒
         .execute().body();
         Console.log(result2);
         */
        HttpRequest post = HttpUtil.createPost(readDurationUrl);
        HttpCookie c1 = new HttpCookie("__UID__", "b4e8d310-a6a6-11e9-8c4c-e91b67f97759");
        HttpCookie c2 = new HttpCookie("acw_tc", "3ccdc16815631570090725913e73e806c917ee10bd677b4efbae85b75f3728");
        HttpCookie c3 = new HttpCookie("aliyungf_tc", "AQAAAIJNuiNf8QAAb1udPY1yaroZ95Gg");
        HttpCookie c4 = new HttpCookie("tmzw", "1563262006854");
        HttpCookie c5 = new HttpCookie("token", "6341afec165f4e0c82a4c9f93ff41a29");
        HttpCookie c6 = new HttpCookie("uaToken", "115#1FZFQ51O1TN+oL4iMCA41Cso7X/yI2Aaogvu7IsbKzAsCYxgfwpFiiSokp/DQVF9132d9Pb8yu+Qi/WJwaU4AWNcaLpfyzrQvIAyetT816NQi/JJHff1OWNDZTBYTPZpOSAPf+/4ukNQi/JJhEzYAWNcaLpXyzEQASAyFtQ4uWN0agwqx1fC95TsMJaMSBWWnMA/wZssorHxEoGx3Yn60fiQWOJIpm441IRjAcHaEYpnqGgh5Gxl4b+w+Y7CYlsva/vsKZIuVi0BxV7sFpCZvn71QKAbDG92wn5pBSf7Z2O/jVLujIQHikXHCH3R76OWPVG7M97h13E5C7dd+zPsY36FK1B33JRxxuMBsJVUmw50D/BGRE0EEFSXle/FudWRgHZvwJ0blBzxwFF+oaPXuPxIZxwXyAXjC4NBpzD4Ze6qQQIW8MhsNkpzt/6aGUzfQNN9CAitru29M7bmT18NETqjET85QXRYGaXDZXMIPMEXY3YjruMVbI8GJN0P4vF/SsOVuyUe+9KEYpjG94vDuXrhMYb06hZDTPqmuUg7Np/OH4cDisqKVVC6MPCB39FHG/xqtUBEGjbAOmNf+nsVPNJtcUMj+WSvYkvliMZsGf==");
        HttpCookie c7 = new HttpCookie("webUmidToken", "TB505851560CD2070F36C49E224D6D950818DA0475D0339D04984B987AE");
        HttpCookie c8 = new HttpCookie("zwfigprt", "208f53923b96a438e1cb0ab2a90e3e19");
        HttpCookie[] httpCookies = {c1,c2,c3,c4,c5,c6,c7,c8};

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("logs", "{\"2706633505466826441_vm0irydwep_1563326269938\":" +
                "{\"url\":\"https://www.xuexi.cn/lgpage/detail/index.html?id=2706633505466826441\"," +
                "\"pt\":\"Graphic-article\"," +
                "\"tags\":\"中国经济_关税\"," +
                "\"item_id\":\"2706633505466826441\"," +
                "\"refer\":\"https://www.xuexi.cn/\"," +
                "\"read_id\":\"2706633505466826441_vm0irydwep_1563326269938\"," +
                "\"page_uuid\":\"2706633505466826441\"," +
                "\"duration\":30," +
                "\"et\":2," +
                "\"track_id\":\"4d596801-2668-4ad4-b6a3-a7c55543a4b2\"," +
                "\"tm\":1563262058238}}");
        jsonBody.put("uid", "b4e8d310-a6a6-11e9-8c4c-e91b67f97759");
        jsonBody.put("token", "8774a6141f5e44e487bf19c5d992b121");
        jsonBody.put("sid", "1be60d997d1ec757cc10af16e726100a");
        jsonBody.put("uaToken", "115#1RBjX51O1TazManpMCfS1Csom56FIyAaogvu7IsbKzAsCYxgfNkEiiSozY6hQNyZ132eTb/8zPHh+7WJhaUzWvb3aTpXyrrQArOSeK/8zkIQg/JRhEz8OWNDaTBfG1fpOSAyFKOhTyspiQJJv4U4OkNDaTBfurPIASAPet/4ykZQi/JRH6b4OWNHiaDu2W1Kv5NFZu2KwN7lTB0TSkj4Dpo19uHGZv9ywMKHk8Pk5ECTvHKCb1nkOXz0cjSpriFkgMum+Bp5Zn4KJESQZ32FhNgqJfUSQgVTCzef1/aFY3fNZuTtR3E2jFREvKfo8lbIEzTNkoQh0EwRGT4MCAwqoH37YKrtzQnV8VKFn7lV3m1RA3XBMJ5u5pYRrCZz2k+QpUkAX5hmY3sbWfq8rzrYW481c/HHR5uYFS8rWIg22H16e8PSBcAI6pPqr7J5wqHdyiXnglBfpK8XmQQPYQJXcMShiWk5BWd0C/QinEbZnjtcRDQwH2EQOMzsxNtQG2lp+29T50uyHlLB6Ytoj/UQDmQgux8hP/oQJBVRBXYKgsuCaynquWDHtwQeRBe3a38iXvLV0w5psy+7rqhRQT9YvNE+FfEHR2h8bp8I5r/2Cc8FnCSATBKVDvK0unyUu+RRbYyXq+SmYUYummoW5MMIZIqRMSaypRDfdT8IXOkFRv0rUXmBaRoTKnqvy267S30SSc5jA6QcST7TC5a+3brhMKwjd+5rZn3RrndsbDSMdvn0u5O2GDGinhGmbJMlyZBxEh9riWunwaxR28pJj6xdeKpSCwXvp+E7CnI4RVY2valZasUXagEBC9WWIyHq8ZWvdrVV0nQYkO7W1IT7pOB4v2peV9mChntCX3mGiYXq1cZzGEz863Y5DJxgKLZLrQKDiOBybpiM1zw+ukQTlKK9fnez6dI3oq3LH+95lHPLYbscjLmmHeyKDGMCNrb7InwKMECz0JAipBzfZs9wyYqa5ORMS1j7rjj36QLzeJGjCUlWzM5mH8rhPc0uQYb1jVi/aGC7HBIWOqepYQe6kI+ohciae687Lhaes4MbZKKnijsrlf4vilEdkPOMx1aSdx/ZAAKuOHCQE8B5R6WQKztM96uDd5Cw3wuraoEDLupQdVP=");
        jsonBody.put("webUmidToken", "T9AE54CAF9E7768793BFC5636421C709B3A67834BDA62C7C93BC442FD2C");
        String body = post.cookie(httpCookies)
                .body(jsonBody)
                .execute()
                .body();
        System.out.println(body);
    }

    public static void main(String[] args) {
        Main.excuteReadDuration();

    }
}
