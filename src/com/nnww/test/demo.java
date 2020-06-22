package com.nnww.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ArrayUtil;
import com.nnww.excel.ExcleHeader;
import com.nnww.test.innerclass.StatticInnerClassTest;
import com.nnww.设计模式.strategy.CDPlayer;
import com.nnww.util.Arith;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import sun.java2d.pipe.SpanIterator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class demo {
    @Test
    public void test1() {
        double stockPrice = 3.43;
        System.out.println(stockPrice * 0.9);
    }

    @Test
    public void test2() {
        String avthumbMp3Fop = String.format("avthumb/mp3/ab/%s|saveas/%s", "111", "222");
        System.out.println(avthumbMp3Fop);
    }

    @Test
    public void test3() {
        int i = 3;
        switch (i) {
            case 1|3:
                System.out.println(i);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println(3);
        }
    }

    @Test
    public void test4() {
        String str1 = "1";
        String str3 = "1";
        String str2 = new String("1");
        String str5 = new String("1");

        System.out.println(str2.equals(str5));

    }

    @Test
    public void test5() {
        int i = 1000;
        int i4 = 1000;
        Integer i2 = new Integer(1000);
        Integer i3 = new Integer(1000);
        Integer i6 = 1000;
        Integer i5 = 1000;
        System.out.println(i == i2);
        System.out.println(i == i4);
        System.out.println(i2 == i3);
        System.out.println(i6 == i5);

    }

    @Test
    public void test6() {
        long l = 1000;
        long l2 = 1001;
//        Long l2 = new Long(1000);
        System.out.println(l == l2);
        System.out.println(l < l2);
    }

    @Test
    public void test7() {
        Long l = new Long(1000);
        Long l2 = new Long(1000);
        Long l3 = 100L;
        Long l4 = 100L;
        System.out.println(l == l2);
        System.out.println(l3 == l4);


    }

    @Test
    public void test8() {
        String marketingUserScenes = "22!";
        String[] scenes = marketingUserScenes.split(",");
        for (String scene : scenes) {
            System.out.println(scene);
        }

    }

    @Test
    public void test9() {
        int i = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        System.out.println(i);
    }

    @Test
    public void test10() {

        System.out.println(new Date().getHours());
    }

    @Test
    public void tes11() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove("1");
        for (String o : list)
        {
            System.out.println(o);
        }

    }

    @Test
    public void test12() {
        String[] str1 = {"1","1111"}; //权重为4
        String[] str2 = {"2","2222"}; //权重为7
        String[] str3 = {"4","4444"}; //权重为3
        String[] str4 = {"8","8888"}; //权重为4
        List<String[]> list = new ArrayList<String[]>();
        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);
        int len = list.size();
        int total = 0;//总权重
        //以权重区间段的后面的值作为key存当前信息
        TreeMap<Integer,String> map = new TreeMap<>();
        for(int i=0; i<len; i++){
            String[] array = list.get(i);
            total += Integer.parseInt(array[0]);
            map.put(total, array[1]);
        }

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (int i = 0; i < 1000000; i++)
        {
//            int random = (int)(Math.random()*total);
            int random = new Random().nextInt(total)+1;
            Integer key = map.ceilingKey(random);
            String s = map.get(key);
            if (s.equals("1111")) {
                count1++;
            }
            if (s.equals("2222")) {
                count2++;
            }
            if (s.equals("4444")) {
                count3++;
            }
            if (s.equals("8888")) {
                count4++;
            }

        }
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
        System.out.println(count4);
    }

    @Test
    public void test13() {
        String str = "http://www.mafengwo.cn/hotel/ajax.php?iMddId=10143&iAreaId=8751&iRegionId=-1&iPoiId=&position_name=&nLat=0&nLng=0&iDistance=10000&sCheckIn=2018-03-22&sCheckOut=2018-03-23&iAdultsNum=2&iChildrenNum=0&sChildrenAge=&iPriceMin=&iPriceMax=&sTags=&sSortType=comment&sSortFlag=DESC&has_booking_rooms=0&has_faved=0&sKeyWord=&iPage=1&sAction=getPoiList5";

    }

    @Test
    public void test14() {
        List<List<String>> flist = new ArrayList<>();
        ArrayList<String> cList = new ArrayList<>();
        cList.add("hahaha");
        flist.add(cList);
        cList.add("2222");
        for (List<String> strings : flist)
        {
            for (String string : strings)
            {
                System.out.println(string);
            }
        }

    }
    @Test
    public void test15() {
        for (int i = 0; i < 1000; i++)
        {
            double math = Math.random();
            double praiseRate = Arith.round(math, 2);
            System.out.println((int)Arith.mul(praiseRate, 100d));

        }

    }

    @Test
    public void test16() {
       String str = "{\"他要标\":56}";
        String replace = str.replace("\"", "");
        String replace2 = replace.replace("{", "");
        String replace3 = replace2.replace("}", "");
        String[] strings = replace3.split(",");
        LinkedList<String> strlist = new LinkedList<>();
        for (String string : strings)
        {
            String s = string.split(":")[0];
            strlist.add(s);
        }
        for (String s : strlist)
        {
            System.out.println(s);
        }
    }

    @Test
    public void test17() {
        String content = "这家店算是当地最有特色的酒店了，里面古色古香的建筑物，还有亭台楼阁，二楼可以打川麻，到此游玩的旅客都会在这里合影留念，停车场过去就是老街，非常方便，晚上传过小巷走过去就到了河边，在那里吃烧烤聊天，还有唱歌的，享受四川人的休闲，这里是不错的选择对";
        List<String> keyWordList = new ArrayList<>();
        keyWordList.add("四川");
        keyWordList.add("选择");
        ArrayList<String> contentList = new ArrayList<>();
        //将一条评论切分成几个小段
        if (content != "") {
            String[] splitUsePeriod = content.split("。");
            for (String str : splitUsePeriod)
            {
                String[] splitUseComma = str.split("，");
                for (String str2 : splitUseComma)
                {
                    contentList.add(str2);
                }
            }
        }
        //与云关键词对比
        for (String bitContent : contentList)
        {
            for (String keyWord : keyWordList)
            {
                if (bitContent.indexOf(keyWord) != -1 && bitContent.length() <= 11) {
                    System.out.println(bitContent);
                }
            }
        }
    }

    @Test
    public void test18() {
        String utfString = "http://www.mafengwo.cn/rest/hotel/hotels/?data_style=recommendation&page%5Bmode%5D=random_next&page%5Bno%5D=1&page%5Bnum%5D=10&filter%5Bpoi_id%5D=7841598&filter%5Blat%5D=29.594651&filter%5Blng%5D=103.501501&filter%5Bdistance%5D=2000&filter%5Bmddid%5D=10143&filter%5Bcheck_in%5D=2018-03-21&filter%5Bcheck_out%5D=2018-03-22&filter%5Bhas_booking_rooms%5D=1&filter%5Bsort_type%5D=comment&filter%5Bsort_flag%5D=DESC&filter%5Bcustom_img_1%5D=w240_h240";
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while((i=utfString.indexOf("\\u", pos)) != -1){
            sb.append(utfString.substring(pos, i));
            if(i+5 < utfString.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16));
            }
        }

        System.out.println(utfString);
    }
    @Test
    public void test19() {
        String a="love23next234csdn3423javaeye";
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(a);
        String ret = m.replaceAll("").trim();
        System.out.println(ret);
    }
    @Test
    public void test20() {
        String a="http://www.mafengwo.cn/hotel/5667.html";
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(a);
        String ret = m.replaceAll("").trim();
        System.out.println(ret);
    }
    @Test
    public void test21()
        throws ParseException
    {
        String a="2017-03-11";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(a);

        System.out.println(date.getTime());
    }
    @Test
    public void test22()
        throws ParseException
    {
        String a="http://www.mafengwo.cn/hotel/info/comment_list?poi_id=357&page=1";
        String id = a.split("poi_id=")[1].split("&")[0];
        System.out.println(id);
    }

    @Test
    public void test23() {
        String str1 = "第一次来成都 阆中古城这家店给我留下了深刻的印象，可能是因为住的第一个店的缘故吧。性价比一般吧！团了，我们早上没吃";
        String[] split = str1.split("[\\s，。！]+");
        for (String s : split)
        {
            System.out.println(s);
        }
    }

    @Test
    public void test24() {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < 10000; i++)
        {
            if (new Random().nextInt(3)%2 == 0) {
                even++;
            } else {
                odd++;
            }

        }
        System.out.println(even + "---" + odd);
    }
    @Test
    public void test25() {
        Long longSec = new Long(System.currentTimeMillis()/1000);
        GregorianCalendar currentCalendar = new GregorianCalendar();
        currentCalendar.setTimeInMillis(longSec * 1000);
        System.out.println(currentCalendar.get(Calendar.DAY_OF_MONTH));
    }
    @Test
    public void test26()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(System.currentTimeMillis());

        GregorianCalendar zeroCalendar = new GregorianCalendar(calendar.get(GregorianCalendar.YEAR), calendar.get(GregorianCalendar.MONTH),
            calendar.get(GregorianCalendar.DATE), 0, 0, 0);

        System.out.println(zeroCalendar.getTime());
    }
    @Test
    public void test27()
    {
        Date date = new Date(1520173189912l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

    }
    @Test
    public void test28()
    {
        String name = "07\\' Show Mi 演唱会纪念精装专辑";
        String name2 = "\\";

        String replace = name.replace("\\", "").replace("\'", "\\'");
        System.out.println(name);
    }

    @Test
    public void test29()
    {
        String name = "getName";
        StringBuilder result = new StringBuilder();
        result.append(name.substring(0, 1).toLowerCase());
        for (int i = 1; i < name.length(); ++i) {
            String s = name.substring(i, i + 1);
            String slc = s.toLowerCase();
            if (!(s.equals(slc))) {
                result.append("_").append(slc);
            } else {
                result.append(s);
            }
        }
        System.out.println(result.toString());
    }

    @Test
    public void test30() {
        String name = "get_name";
        StringBuilder result = new StringBuilder();
        result.append(name.substring(0, 1).toLowerCase());
        boolean underscore = false;
        for (int i = 1; i < name.length(); ++i) {
            String s = name.substring(i, i + 1);
            if ("_".equals(s)) {
                underscore = true;
                continue;
            } else {
                if (underscore) s = s.toUpperCase();
                underscore = false;
            }
            result.append(s);
        }
        System.out.println(result.toString());
    }

    @Test
    public void test31() {
        File csv = new File("G:\\round1\\round1\\1.csv");  // CSV文件路径
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try {
            List<String> allString = new ArrayList<>();
            while ((line = br.readLine()) != null)  //读取到的内容给line变量
            {
                everyLine = line;
                System.out.println(everyLine);
                allString.add(everyLine);
            }
            System.out.println("csv表格中所有行数："+allString.size());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test32() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 488; i++) {
            builder.append(i);
            builder.append(",");
        }
        System.out.println(builder.toString());
    }

    @Test
    public void test33() {
        String str = "swdfdsfsafdasd,dfsdf,sdfs,";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void test34() {
        Double num = 5.00200;
        BigDecimal bigDecimal = new BigDecimal(num.toString()).stripTrailingZeros();

        System.out.println(bigDecimal);
    }

    @Test
    public void test35() {
        String[] array = {"aa","aa","bb","cc","aa"};
        TreeSet<String> set = new TreeSet<>();
        for (String s : array) {
            set.add(s);
        }
        String[] strings = set.toArray(new String[set.size()]);
        System.out.println(Arrays.toString(strings));

    }
    @Test
    public void test36() {
        String[] array = {"aa","aa","bb","cc","aa"};
        TreeSet<String> set = new TreeSet<>();
        for (String s : array) {
            set.add(s);
        }
        String[] strings = set.toArray(new String[set.size()]);
        System.out.println(Arrays.toString(strings));

    }

    @Test
    public void test37() {
        String description="sad";
        description = description==null ? "":description;
        System.out.println(description);
    }

    @Test
    public void test38() {
        Collections.sort(new ArrayList<String>(), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }

    @Test
    public void test39() {
        String str1 = ",成都市,乐山市,峨眉山市,,,,峨眉山";
        String str2 = ",成都市,都江堰市,都江堰";
        String str3 = ",成都市,都江堰市,冠县";
        String str4 = ",成都市,成都";
        String substring = str1.substring(1, str1.length() - 1);
        String str5 = "231";
        System.out.println(str1.split(",").length);
    }

    @Test
    public void test40() {
        System.out.println("".matches("^[a-zA-Z]*"));
    }
    @Test
    public void test43() {
        String tag = "好吃,,,,shuang.,,,,,安逸";
        String tagRe = "";
        StringBuilder builder = new StringBuilder("");
        if (true) {//替换中文逗号
            tagRe = tag.replace("，", ",");
        }
        if (true) {
            builder = new StringBuilder();
            //将多余的逗号剔除
            String[] tags = tagRe.split(",");
            for (int i = 0; i < tags.length; i++) {
                String s = tags[i];
                if (!s.trim().equals("")) {
                    builder.append(s);
                    if (i != (tags.length - 1)) {
                        builder.append(",");
                    }
                }
            }
        }
        System.out.println(builder.toString());
    }

    @Test
    public void test41() {
        String s1="a1";
        String s2="a1";
        String s3 = "a"+"1";
        String s4 = "a"+1;
        String s5 = "a"+Integer.parseInt("1");
        int i = 1;
        String s6 = "a"+i;
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1==s4);
        System.out.println(s1==s5);
        System.out.println(s1==s6);
    }

    @Test
    public void test42() {
        Integer i1 = 1;
        Integer i2 = 2;
        System.out.println(i1 == (i1 = i2));//false
        System.out.println((i1 = i2) == i1);//true
    }

    @Test
    public void test44() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<CDPlayer> aClass = CDPlayer.class;
        CDPlayer cdPlayer = aClass.newInstance();
        Field bland = aClass.getField("bland");
        bland.set(cdPlayer, "sss");
        System.out.println(aClass.getName());
        System.out.println(Arrays.toString(aClass.getTypeParameters()));
        System.out.println(Arrays.toString(aClass.getAnnotations()));
        System.out.println(Arrays.toString(aClass.getMethods()));
        Method play = aClass.getMethod("play");
        play.invoke(cdPlayer, null);

    }

    @Test
    public void test() {
//        给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。/
//        你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
        int[] nums = {2, 4, 11, 15, 5,1};
        int target = 9;
        String re = "目标值是:";
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (flag) {
                break;
            }
            int num = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int num2 = nums[j];
                if (num + num2 == target) {
                    System.out.println(re + num + "与" + num2);
                    flag = true;
                }
            }
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    @Test
    public void test45() {
        String str = "school=(address=(city=cd,province=sc),scname=一中),name=小明,like=[饼干,小吃]";
        String skh ="(?<=\\()[^\\)]+";//用于匹配()里面的文本
        Pattern pattern=Pattern.compile(skh);
        Matcher matcher=pattern.matcher(str);
        boolean is=matcher.find();
        if(is)System.out.print(matcher.group());

    }

    @Test
    public void test55() {
        Integer[] nums = new Integer[]{0,0,1,1,1,2,2,3,3,4};
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (Integer num : nums) {
            set.add(num);
        }
        List<Integer> nums2 = new ArrayList<>();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            nums2.add(iterator.next());
        }
        nums = new Integer[]{};
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test56() {
        String str = "amap_poi_id=B0FFIMWDX1&average_price=50.0&cover=FnAaMqVpzqpZKy9TFzVgWmHyIy4P&description=%E5%93%A6%E6%B3%BC%E6%B4%92%E9%87%8C%E5%BE%AE%E4%BF%A1%E8%B0%A2%E8%B0%A2%E5%A4%AA%E5%BF%99%E5%AE%9A%E4%B9%9F%E6%98%AF%E6%88%91%E5%A4%9F%E4%B8%AA%E4%B8%80%E4%B8%A4%E5%8F%A5%E8%AF%9D%E6%8D%85%E7%A0%B4&destination_id=7275&images=FrKwBawpniNHY1RkBXqXsGm8OYHa%2CFnAaMqVpzqpZKy9TFzVgWmHyIy4P%2CFmm-gRAXJOFXwEqt-90HzpM0l7bJ&latitude=30.57638&longitude=104.195213&poi_name=%E4%B8%89%E7%89%A6%E8%AE%B0&recommend_title=%E9%BB%91%E7%8C%A9%E7%8C%A9&suitable_time_end=15%3A42&suitable_time_start=15%3A42&tags=%E5%91%BD%E4%B9%9F%20%E4%BD%A0%E5%95%8A&user_id=163";
        String[] split = str.split("&");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void test57() throws ParseException {
        String str = "15:00";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date = format.parse(str);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i1 = instance.get(Calendar.HOUR_OF_DAY);
        System.out.println(i1);
    }

    @Test
    public void test58() {
        String a="Aa";
        String b="BB";
        int aa =a.hashCode();
        int bb=b.hashCode();
        System.out.println(aa + "-" + bb);
    }

    @Test
    public void test59() {
        for (int i = 0; i < 100; i++) {
            int d = new Random().nextInt(2) % 2;
            System.out.println(d);
        }
    }

    @Test
    public void test60() {
        int num = 999999;//要找的数

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
             integerArrayList.add(i);
        }
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (Integer i : integerArrayList) {
            hashMap.put(i.toString(), i);
        }
        //第一种方法
        long start = System.currentTimeMillis();
        for (Integer i : integerArrayList) {
            if (i == num) {
                System.out.println("第一种找到了");
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("第一种耗时:----" + (end - start));
        //第二种
        long start2 = System.currentTimeMillis();

        Integer integer = hashMap.get(num + "");
        System.out.println("第二种找到了"+integer);
        System.out.println("第二种耗时:----" + (System.currentTimeMillis() - start2));

    }

    /**
     * 遍历list的坑
     */
    @Test
    public void test61() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("1");
        stringArrayList.add("2");
        stringArrayList.add("3");
        stringArrayList.add("4");
        stringArrayList.add("4");
        stringArrayList.add("6");

        for (int i = 0; i < stringArrayList.size(); i++) {
            if (stringArrayList.get(i).equals("4")) {
                stringArrayList.remove(i);
            }
        }
        System.out.println(stringArrayList.toString());

    }

    @Test
    public void test62() {
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(map.get("asdas"));

    }

    @Test
    public void test63() {
        Format f = new DecimalFormat("00");
        String re = "";
        int currentSec = 1539308498;
        int timeSec =  1539308497;
        int substarct = timeSec - currentSec;
        int minute = 0;
        int second = 0;
        if (substarct > 0) {
            minute = substarct / 60;
            second = substarct % 60;
        } else {

        }
        String s = f.format(minute) + ":" + f.format(second);
        System.out.println(s);
    }

    private String str = new String("str");

    private char[] cha = {'a', 'b', 'c'};

    @Test
    public void test64() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        Integer i = new Integer(1);
        change(str, cha, i, list);
        System.out.println(list.toArray());
    }



    private void change(String str, char[] cha, Integer i, ArrayList<Integer> list) {
        i = 10;
        str = "1";
        cha[0] = '1';
        list.add(2);
    }

    @Test
    public void test65() {
        Object str = "1";
        String Str = new String("1");
        System.out.println(Str.equals(str));
    }


    private boolean checkIdNumber(String IdNumber) {
        boolean flag = false;
        if (IdNumber != null) {
            IdNumber = IdNumber.trim();
            if (IdNumber.length() == 15 || IdNumber.length() == 18) {
                if (cardCodeVerifySimple(IdNumber)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean cardCodeVerifySimple(String cardcode) {
        //第一代身份证正则表达式(15位)
        String isIDCard1 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
        //第二代身份证正则表达式(18位)
        String isIDCard2 ="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[A-Z])$";

        //验证身份证
        if (cardcode.matches(isIDCard1) || cardcode.matches(isIDCard2)) {
            return true;
        }
        return false;
    }



    @Test
    public void test67() {
        // 获取随机数
        Random r = new Random();

        // 创建集合对象
        HashSet<Integer> set = new HashSet<>();

        // 生成随机数
        while (set.size() < 10) {
            int i = r.nextInt(20) + 1;
            set.add(i);
            System.out.println(i);
        }
        System.out.println("=====================================");
        // 遍历集合
        System.out.println(set);
        for (int integer : set) {
            System.out.println(integer);
        }


    }

    @Test
    public void test68() {
        int i= 2;
        System.out.println(i++);
        i= 2;
        System.out.println(++i);
    }

    @Test
    public void test69() {
        String str = "token:ams:903eec2aa318108e58a51bdfbad6d0730da7e9d1b4289196244426463435a95c:user";
        System.out.println(str.endsWith("admin"));
    }

    @Test
    public void test70() {
        String imgUrl = "http://photos.qiwei.com/Fv_NBItISqyo5T405zKHVyM6PmTl";
        String img = "";
        if (imgUrl.contains("http")) {
            String[] strs = imgUrl.split("\\?")[0].split("/");
            img = strs[strs.length - 1];
        }
        System.out.println(img);
    }

    @Test
    public void test71 () throws FileNotFoundException {
        boolean b = false;
        assert false == b;
    }

    @Test
    public void test72 () throws FileNotFoundException {
        String str = "1,2";
        if (str.lastIndexOf(",") == str.length() - 1) {
            str = str.substring(0,str.length() - 1);
        }
        System.out.println(str);
    }

    @Test
    public void test73() {

        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.forEach(o -> {o.hashCode();}); //forEach函数实现内部迭代

    }

    @Test
    public void test74 () throws FileNotFoundException {
        for (int j = 0; j < 100; j++) {
            String s = "1581688";
            int i = 1210;
            i = i + j;
            s = s + i;
            System.out.println(s);
        }
    }

    @Test
    public void test75() {
        String prefix = "cx四川".substring(0, 2).toUpperCase();
        System.out.println(prefix);
    }


    private int i = 0;
    @Test
    public void test76() {
        recursion("AsdAsdAsdQAAAddsA");
        System.out.println(i);
    }
    private void recursion(String str) {
        if (str.contains("A")) {
            int i = str.indexOf("A");
            String s = str.substring(i + 1, str.length());
            i++;
            recursion(s);
        }
    }

    @Test
    public void test78() {
        byte a = 127;
        byte b = 127;
        a = (byte) (a + b);
        a += b;
        double d  = 0;
        Long l = 1L;
        d = l;
        l = (long)d;
        System.out.println(0.3 == 0.3);
        System.out.println(0.3 == 3 * 0.1);
        ArrayList<Object> list = new ArrayList<>();
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            iterator.remove();
        }
    }

    @Test
    public void test79() {
        double f = 0121.000000000d;
        DecimalFormat format = new DecimalFormat("0000.00");
        String format1 = format.format(f);
        System.out.println(format1);
        System.out.println("1 2");
        System.out.println("\ufeff" + 2);
    }

    @Test
    public void test80() {
        LocalDate now = LocalDate.now();
        System.out.println(now.toString());
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time.toString());
        LocalDateTimeStringConverter converter = new LocalDateTimeStringConverter();
        String s = converter.toString(time);
        System.out.println(s);
    }

    //遍历类字段
    public static void reflect(Object o){
        //获取参数类
        Class cls = o.getClass();
        //将参数类转换为对应属性数量的Field类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
        Field[] fields = cls.getDeclaredFields();
        for(int i = 0;i < fields.length; i ++){
            Field f = fields[i];
            f.setAccessible(true);
            try {
                //f.getName()得到对应字段的属性名，f.get(o)得到对应字段属性值,f.getGenericType()得到对应字段的类型
                System.out.println("属性名："+f.getName()+"；属性值："+f.get(o)+";字段类型：" + f.getGenericType());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test81() {
        User user = new User();
        reflect(user);
    }

    class User {
        private String name= "11";
        private String age= "20";


    }

    @Test
    public void test82() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse("2010-11-01", df);
        System.out.println(parse);
    }

    @Test
    public void test83() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.sort(Integer::compareTo);
        System.out.println(list);
        List<String> strs = list.stream().map(l -> l + "5").collect(Collectors.toList());
        strs.stream().forEach(s -> System.out.println(s));
        final List<String> filstrs = strs.stream().filter(s -> !s.equals("15")).collect(Collectors.toList());
        System.out.println(filstrs);
    }


    @Test
    public void test84() {
        int a = 1;
        boolean b = true;
        char c = '2';
        char c2 = '2';
        byte by = '1';
        byte by2 = '1';
        int d = a + c;
        char m  = 98;

        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }


    @Test
    public void test85() throws InterruptedException, ParseException {
        long l = System.currentTimeMillis();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(l);
//        int i = calendar.get(Calendar.DATE);
//        System.out.println(i);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(new Date(l));
        long time = format.parse(format1).getTime() + 86400 * 1000;
        System.out.println(time);
    }

    @Test
    public void test86() {
        int clMax = 500;
        int clMin = 300;
        int czMax = 40;
        int czMin = 20;
        double[] clarray = new double[10];
        double[] czarray = new double[10];
        for (int j = 0; j < clarray.length; j++) {
            double v = new Random().nextInt(clMax - clMin) + clMin;
            clarray[j] = v;
        }
        for (int j = 0; j < czarray.length; j++) {
            double v = new Random().nextInt(czMax - czMin) + czMin;
            czarray[j] = v;
        }
        System.out.println(Arrays.toString(clarray));
        System.out.println(Arrays.toString(czarray));


    }

    @Test
    public void test87() {
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(2, 2);
        treeMap.put(3, 3);
        Set<Map.Entry<Object, Object>> entries = treeMap.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getValue());
        }
    }

    @Test
    public void test88() {
        User2 user2 = null;
        Optional<User2> user = Optional.of(new User2());
        User2 hello3 = user.orElse(new User2("hello3"));
        Integer integer = user.map(User2::getName).map(String::length).orElse(100);
        System.out.println(integer);


    }

    @Test
    public void test89() throws InterruptedException {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, -24);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(todayStart.getTime());
        System.out.println(format1);
    }

    @Test
    public void test90() {
        JczySqlEnum[] values = JczySqlEnum.values();
        for (JczySqlEnum value : values) {
            System.out.println(value.getSql());
        }
    }

    @Test
    public void test91() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };
//        runnable.run();

        new Thread(runnable).start();

    }


    @Test
    public void test92() {
        ThreadLocal<String> routeKey = new ThreadLocal<String>();
        routeKey.set("233");
        routeKey.set("111");
        System.out.println(routeKey.get());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void test93() {
        String rsSql = " SELECT sum(VALUE) VALUE,t1.ZONEID ZONEID \n" +
                " FROM \n" +
                " (select count(jftc.id) VALUE,xzqh.id ZONEID \n" +
                " from  xzqh_xzdy xzqh,JFTC_AJDJ jftc \n" +
                " where jftc.xzdy = xzqh.bm and to_char(jftc.SQSJ, 'yyyy/MM') = to_char(:var_date, 'yyyy/MM') \n" +
                " group by xzqh.id \n" +
                " UNION All \n" +
                " select count(zcsq.id) VALUE,xzqh.id ZONEID \n" +
                " FROM JFTC_ZCSQ zcsq,xzqh_xzdy xzqh \n" +
                " where zcsq.xzdy = xzqh.bm and to_char(zcsq.CREATE_TIME, 'yyyy/MM') = to_char(:var_date, 'yyyy/MM') \n" +
                " group by xzqh.id \n" +
                " ) t1 \n" +
                " GROUP BY t1.ZONEID ";
        String JflxValueSql = "select s.yzbm,s.fbfdz,s.fbfdcy,s.fbfdcrq,s.fbfdcjs,s.bz,s.id, s.fbfbm, s.fbfmc,s.fbffzrxm, s.fzrzjlx, s.fzrzjhm,s.lxdh, s.cretime"
                + " from (select fbf.id, fbf.fbfbm,fbf.fbfmc,fbf.yzbm,fbf.fbfdz,fbf.fbfdcy,fbf.fbfdcrq,fbf.fbfdcjs,fbf.bz,fbf.fbffzrxm, fbf.fzrzjlx, fbf.fzrzjhm, fbf.lxdh, fbf.cretime,\n" +
                "  row_number() over(partition by fbf.fbfbs order by fbf.cretime desc) as group_idx\n" +
                "  from fbf\n" +
                "  left join xzqh_xzdy_exp ze\n" +
                "  on ze.zjid = fbf.szdy\n" +
                "  where zt <> 0 ";
        System.out.println(JflxValueSql);
    }

    @Test
    public void test94() {
        SimpleDateFormat dateFormatmonth = new SimpleDateFormat("yyyy");
        Date now = new Date();

        SimpleDateFormat simpleDateFormatmonth = new SimpleDateFormat("MM");
        String month_1 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -5));
        String month_2 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -4));
        String month_3 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -3));
        String month_4 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -2));
        String month_5 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -1));
        String month_6 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -0));
        String month_7 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -6));
        String month_8 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -7));
        String month_9 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -8));
        String month_10 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -9));
        String month_11 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -10));
        String month_12 = simpleDateFormatmonth.format(DateUtils.addMonths(now, -11));
        String yearAndMonth_1 = dateFormatmonth.format(DateUtils.addMonths(now, -5))+"/"+Integer.parseInt(month_1);
        String yearAndMonth_2 = dateFormatmonth.format(DateUtils.addMonths(now, -4))+"/"+Integer.parseInt(month_2);
        String yearAndMonth_3 = dateFormatmonth.format(DateUtils.addMonths(now, -3))+"/"+Integer.parseInt(month_3);
        String yearAndMonth_4 = dateFormatmonth.format(DateUtils.addMonths(now, -2))+"/"+Integer.parseInt(month_4);
        String yearAndMonth_5 = dateFormatmonth.format(DateUtils.addMonths(now, -1))+"/"+Integer.parseInt(month_5);
        String yearAndMonth_6 = dateFormatmonth.format(DateUtils.addMonths(now, -0))+"/"+Integer.parseInt(month_6);
        String yearAndMonth_7 = dateFormatmonth.format(DateUtils.addMonths(now, -6))+"/"+Integer.parseInt(month_7);
        String yearAndMonth_8 = dateFormatmonth.format(DateUtils.addMonths(now, -7))+"/"+Integer.parseInt(month_8);
        String yearAndMonth_9 = dateFormatmonth.format(DateUtils.addMonths(now, -8))+"/"+Integer.parseInt(month_9);
        String yearAndMonth_10 = dateFormatmonth.format(DateUtils.addMonths(now, -9))+"/"+Integer.parseInt(month_10);
        String yearAndMonth_11 = dateFormatmonth.format(DateUtils.addMonths(now, -10))+"/"+Integer.parseInt(month_11);
        String yearAndMonth_12 = dateFormatmonth.format(DateUtils.addMonths(now, -11))+"/"+Integer.parseInt(month_12);
        System.out.println(yearAndMonth_1);
        System.out.println(yearAndMonth_2);
        System.out.println(yearAndMonth_3);
        System.out.println(yearAndMonth_4);
        System.out.println(yearAndMonth_5);
        System.out.println(yearAndMonth_6);
        System.out.println(yearAndMonth_7);
        System.out.println(yearAndMonth_8);
        System.out.println(yearAndMonth_9);
        System.out.println(yearAndMonth_10);
        System.out.println(yearAndMonth_11);
        System.out.println(yearAndMonth_12);
    }

    @Test
    public void test95() throws IOException {
        String text = "01010101";
        File file = new File("D:\\testbase64.data");
        FileOutputStream stream = new FileOutputStream(file);
        Base64.Encoder encoder = Base64.getEncoder();
        stream.write(encoder.encode(text.getBytes()));
    }


    @Test
    public void test96() throws IOException {
        File libs1 = new File("C:\\Users\\zhangjinhao\\Desktop\\lib1\\lib");
        File libs2 = new File("C:\\Users\\zhangjinhao\\Desktop\\lib2\\lib");
        File[] files1 = libs1.listFiles();
        File[] files2 = libs2.listFiles();
//        assert files1 != null;
//        List<String> names1 = Arrays.stream(files1).map(File::getName).collect(Collectors.toList());
//        assert files2 != null;
//        List<String> names2 = Arrays.stream(files2).map(File::getName).collect(Collectors.toList());
        HashMap<String, FileDemo> map = new HashMap<>();

        for (File file : files1) {
            map.put(file.getName(), new FileDemo(1, "lib1"));
        }
        for (File file : files2) {
            if (map.containsKey(file.getName())) {
                FileDemo fileDemo = map.get(file.getName());
                fileDemo.setCount(fileDemo.getCount() + 1);
                fileDemo.setLib("common");
                map.put(file.getName(), fileDemo);
            } else {
                map.put(file.getName(), new FileDemo(1, "lib2"));
            }
        }

        HashMap<String, String> reMap = new HashMap<>();
        Set<Map.Entry<String, FileDemo>> entries = map.entrySet();
        for (Map.Entry<String, FileDemo> entry : entries) {
            FileDemo fileDemo = entry.getValue();
            if (fileDemo.getCount() <= 1) {
                reMap.put(entry.getKey(), fileDemo.getLib());
            }
        }

        System.out.println(reMap);

        Supplier<String> supplier = () -> new String();

    }

    @Test
    public void test97() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 1);
        map.put(5, 5);
        map.put(3, 3);
        map.put(6, 6);
        map.put(8, 8);
        System.out.println(map);
        LinkedList<Object> list = new LinkedList<>();

    }

    class FileDemo {
        int count;

        String lib;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getLib() {
            return lib;
        }

        public void setLib(String lib) {
            this.lib = lib;
        }

        public FileDemo(int count, String lib) {
            this.count = count;
            this.lib = lib;
        }
    }



    class User2 {

        String name;

        public User2() {
        }

        public User2(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

