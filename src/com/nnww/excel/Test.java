package com.nnww.excel;



import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        ArrayList<Form> list = new ArrayList<>();
        list.add(new Form(1,"一哈", 1, 1));
        list.add(new Form(2,"二号", 2, 2));
        list.add(new Form(3,"三号", 3, 3));
        FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\zhangjinhao\\Desktop\\excle.xlsx"));
        ExportExcel<Form> poi = new ExportExcel<>();
        String[][] headers = new String[][]{
                {"","合肥“两区“高标准良田建设项目统计报表","","","","","","","","","","","","","","","","","","","","","","","","","","","",""},
                {"","年份","项目县名称","项目名称","项目法人单位","项目设计单位","项目建设单位","项目监理单位","建设地点","项目建设周期","",""
                        ,"项目投资(万元)","","","","","","项目完成投资情况(万元)","","","","","","批复建设内容","完成建设内容","变更原因及批文","项目上图情况"
                        ,"投资计划下达单位及文号","竣工验收批准单位及文号"},
                {"","","","","","","","","","计划下达","批复时间","竣工验收","小计","中央投资","省级投资","市级投资","县级投资","其他投资","小计"
                        ,"中央投资","省级投资","市级投资","县级投资","其他投资","","","","","",""}
        };
        //一共合并29个列,需要合并18个
        CellRangeAddress mergefield0 = new CellRangeAddress(0, 0, 1, 29);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield1 = new CellRangeAddress(1, 2, 1, 1);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield2 = new CellRangeAddress(1, 2, 2, 2);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield3 = new CellRangeAddress(1, 2, 3, 3);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield4 = new CellRangeAddress(1, 2, 4, 4);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield5 = new CellRangeAddress(1, 2, 5, 5);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield6 = new CellRangeAddress(1, 2, 6, 6);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield7 = new CellRangeAddress(1, 2, 7, 7);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield8 = new CellRangeAddress(1, 2, 8, 8);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield9 = new CellRangeAddress(1, 1, 9, 11);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield10 = new CellRangeAddress(1, 1, 12, 17);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield11 = new CellRangeAddress(1, 1, 18, 23);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield12 = new CellRangeAddress(1, 2, 24, 24);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield13 = new CellRangeAddress(1, 2, 25, 25);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield14 = new CellRangeAddress(1, 2, 26, 26);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield15 = new CellRangeAddress(1, 2, 27, 27);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield16 = new CellRangeAddress(1, 2, 28, 28);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        CellRangeAddress mergefield17 = new CellRangeAddress(1, 2, 29, 29);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
        List<CellRangeAddress> craList = new ArrayList<>();
        craList.add(mergefield0);
        craList.add(mergefield1);
        craList.add(mergefield2);
        craList.add(mergefield3);
        craList.add(mergefield4);
        craList.add(mergefield5);
        craList.add(mergefield6);
        craList.add(mergefield7);
        craList.add(mergefield8);
        craList.add(mergefield9);
        craList.add(mergefield10);
        craList.add(mergefield11);
        craList.add(mergefield12);
        craList.add(mergefield13);
        craList.add(mergefield14);
        craList.add(mergefield15);
        craList.add(mergefield16);
        craList.add(mergefield17);
        poi.exportExcel(headers,list,outputStream,"yyyy-MM-dd",craList);
        outputStream.close();


    }


}
