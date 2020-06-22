package com.nnww.test;

/**
 * 基础资源sql
 */
public enum JczySqlEnum {


    //农林牧渔总产值
    NLMYZCZ("393", "SELECT * FROM (\n" +
            "SELECT ZB_MC NAME,ZB_SL VALUE,ZB_UNIT DW,NY ND,XZQH_MC QX \n" +
            "FROM HZ_JCZY.TJNJ_NYNC_QX WHERE ZB_DM = '01') t \n" +
            "WHERE t.ND >= ((SELECT MAX(NY) FROM HZ_JCZY.TJNJ_NYNC_QX WHERE ZB_DM = '01') - 4)"),

    //近五年专项投入情况
    JWNZXTRQK("354", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '310301'\n"),

    //近五年农业技术推广情况（开发新技术及新工艺、推广新技术、园区自主开发和引进项目、推广应用新技术、新品种）
    JWNNYJSTGQK("349", "SELECT\n" +
            "\tZB_MC NAME,\n" +
            "\tZB_VALUE\n" +
            "VALUE\n" +
            "\t,\n" +
            "\tZB_UNIT DW,\n" +
            "\tZB_ND ND\n" +
            "FROM\n" +
            "\tHZ_JCZY.TJNJ_SNHB\n" +
            "WHERE\n" +
            "\tZB_DM IN ('3104', '311207', '3117', '3118', '3119')"),

    //近五年农业科技园区情况分析（在建农业科技园区、国家级、市级）
    JWNNYKJYQQKFX("346", "SELECT\n" +
            "\tZB_MC NAME,\n" +
            "\tZB_VALUE\n" +
            "VALUE\n" +
            "\t,\n" +
            "\tZB_UNIT DW,\n" +
            "\tZB_ND ND\n" +
            "FROM\n" +
            "\tHZ_JCZY.TJNJ_SNHB\n" +
            "WHERE\n" +
            "\tZB_DM IN ('3113', '311301', '311302')"),

    //近五年新型职业农民情况分析（培训新型职业农民、调训农村实用人才、 培训创业者、带动农民）
    JWNXXZYNMQKFX("342", "SELECT\n" +
            "\tZB_MC NAME,\n" +
            "\tZB_VALUE\n" +
            "VALUE\n" +
            "\t,\n" +
            "\tZB_UNIT DW,\n" +
            "\tZB_ND ND\n" +
            "FROM\n" +
            "\tHZ_JCZY.TJNJ_SNHB\n" +
            "WHERE\n" +
            "\tZB_DM IN ('3108', '3109', '3110', '311210', '311211')\n" +
            "AND ZB_ND = (\n" +
            "\tSELECT\n" +
            "\t\tMAX (ZB_ND)\n" +
            "\tFROM\n" +
            "\t\tHZ_JCZY.TJNJ_SNHB\n" +
            "\tWHERE\n" +
            "\t\tZB_DM = '3108'\n" +
            ")"),

    //支持企业和科研单位实施重点项目、实施涉农科技计划项目 分部占比
    ZCYY_SSSN_FBZB("340", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM IN ('3102', '3103') AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '3102')\n"),

    //农业科技园区入驻企业
    NYKJYQRZQY("339", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '3114' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '3114')\n"),

    //新型职业农民
    XXZYNM("335", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1807' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1807')\n"),

    //主题专项
    ZTZX("334", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '3101' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '3101')\n"),

    //生态渔业-渔业总产值1307、渔业总产量1301、交易量、增加值1310、存塘量、稻渔共生面积、渔业企业数、进出口
    STYY_ZB("263", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND \n" +
            "FROM HZ_JCZY.TJNJ_SNHB \n" +
            "WHERE ZB_DM = '1307' OR ZB_DM = '1301' OR ZB_DM = '1310'"),

    //农产品网络零售额近5年情况
    NCPWLLSE("247", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '570304'\n"),

    //纳税总额近5年变化情况
    NSZEJWNBHQK("240", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1815'\n"),

    //经营收入近5年变化情况
    JYSRJWNBHQK("239", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1812'\n"),

    //注册资金近5年变化情况
    ZCZJJWNBHQK("238", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1811'"),

    //产业化龙头企业
    CYHLTQY("237", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '0512' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '0512')\n"),

    //十大特色产业发展规划
    SDTSCYFZGH("232", "SELECT ND,CYMC NAME,CYCZ VALUE,'亿元' DW FROM HZ_JCZY.JGTZ_TSCY\n"),

    //粮食作物调整规划-经济作物占比
    JJZWZBQK("231", "SELECT QXNAME QX,'经济作物占比' NAME,'%' DW,JJZW VALUE,ND FROM HZ_JCZY.JGTZ_LJJGTZ\n"),

    //粮食作物调整规划-粮食作物占比
    LSZWZBQK("230", "SELECT QXNAME QX,'粮食作物占比' NAME,'%' DW,LSZW VALUE,ND FROM HZ_JCZY.JGTZ_LJJGTZ\n"),

    //农业总产值
    NYZCZ("111", "SELECT ZB_MC NAME,ZB_SL VALUE,ZB_UNIT DW,NY ND,XZQH_MC QX \n" +
            "FROM HZ_JCZY.TJNJ_NYNC_QX WHERE ZB_DM = '0101' AND NY = (SELECT MAX(NY) FROM HZ_JCZY.TJNJ_NYNC_QX WHERE ZB_DM = '0101')"),

    //农产品网络零售额。水果、蔬菜、茶饮历年变化量
    NCPWLLSE_SG_SC_CY("413", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND \n" +
            "FROM HZ_JCZY.TJNJ_SNHB \n" +
            "WHERE ZB_DM IN ('57030403','57030402','57030401')"),

    //农业气象_平均年降水量
    NYQX_PJNJSL("401", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND \n" +
            "FROM HZ_JCZY.TJNJ_SNHB \n" +
            "WHERE ZB_DM IN ('54010201','54010202','54010203','54010204')  AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '540102')"),

    //农业气象_全年平均气温
    NYQX_QNPJQW("401", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND \n" +
            "FROM HZ_JCZY.TJNJ_SNHB \n" +
            "WHERE ZB_DM IN ('54010101','54010102','54010103','54010104')  AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '540101')"),

    //近五年农业保险金额
    JWNNYBXJE("56", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '2902'\n"),

    //近五年土地流转面积
    JWNTDLZMJ("54", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '2503'\n"),

    //农产品产业加工总产值
    NCPCYJGZCZ("28", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1903' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1903')\n"),

    //农产品电子商务成交金额
    NCPDZSWCJJE("29", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '4108' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '4108')\n"),

    //学校分布情况
    XXFBQK("136", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND \n" +
            "FROM HZ_JCZY.TJNJ_SNHB\n" +
            "WHERE ZB_DM LIKE '490101%' AND ZB_DM != '490101' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '490101')\n"),

    //推广新技术
    TGXJS("350", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '311207' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '311207')\n"),

    //农业科技园区
    NYKJYQ("134", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '391008' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '391008')\n"),

    //专项投入
    ZXTR("133", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '310301' AND ZB_ND = (SELECT MAX(ZB_ND) FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '310301')"),

    //渔业产值
    YYCZ("117", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1307'\n"),

    //畜牧业产值
    XMYCZ("116", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '0901'"),

    //柑橘产值
    GJCZ("115", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1103'"),

    //药材种植业产值
    YCZZYCZ("114", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1501'"),

    //榨菜产值
    ZCCZ("113", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1403'"),

    //蔬菜总产值
    SCZCZ("112", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '1007'"),

    //蔬菜总产量
    SCZCL("103","SELECT ZB_MC NAME,ZB_SL VALUE,ZB_UNIT DW,NY ND,XZQH_MC QX FROM HZ_JCZY.TJNJ_NYNC_QX WHERE ZB_DM = '16' AND NY = (SELECT MAX(NY) FROM HZ_JCZY.TJNJ_NYNC_QX WHERE ZB_DM = '16')"),

    //粮食总产量
    LSZCL("102", "SELECT ZB_MC NAME,ZB_SL VALUE,ZB_UNIT DW,NY ND,XZQH_MC QX FROM HZ_JCZY.TJNJ_NYNC_QX WHERE ZB_DM = '10' AND NY = (SELECT MAX(NY) FROM HZ_JCZY.TJNJ_NYNC_QX WHERE ZB_DM = '10')"),

    //高标准农田面积
    GBZNTMJ("21", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '2408' ORDER BY ZB_ND DESC"),

    //区县个数
    QXGS("10", "SELECT DW, SL VALUE, '区县个数' NAME FROM HZ_JCZY.CYZL_XZS WHERE XZSLB = '行政区划'"),

    //乡镇个数
    XZGS("12", "SELECT '个' DW, sum(SL) VALUE, '乡镇个数' NAME FROM HZ_JCZY.CYZL_XZS WHERE XZSLB = '乡' OR XZSLB = '镇'"),

    //村组个数
    CZGS("13", "SELECT DW, SL VALUE, '村组个数' NAME FROM HZ_JCZY.CYZL_XZS WHERE XZSLB = '行政村'"),

    //农村户籍人口
    NCHJRK("14", "SELECT DW, RKSJ VALUE, '农村户籍人口' NAME from HZ_JCZY.CYZL_SJTJ WHERE RKLB = '户籍乡村人口'"),

    //农村常住人口
    NCCZRK("15", "SELECT DW, RKSJ VALUE, '农村常住人口' NAME from HZ_JCZY.CYZL_SJTJ WHERE RKLB = '常住乡村人口'"),

    //农村劳动力人口
    NCLDLRK("16", "SELECT DW, RKSJ VALUE, '农村劳动力人口' NAME from HZ_JCZY.CYZL_SJTJ WHERE RKLB = '农村劳动力非农就业'"),

    //农村常住居民人均可支配收入
    NCCZJMRZKZPSR("17", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '0120'"),

    //农村常住居民人均消费支出
    NCCZJMRZXFZC("18", "SELECT ZB_MC NAME, ZB_VALUE VALUE, ZB_UNIT DW, ZB_ND ND FROM HZ_JCZY.TJNJ_SNHB WHERE ZB_DM = '01200401'");

    //字典id
    private String dicId;

    //SQL
    private String sql;

    JczySqlEnum(String dicId, String sql) {
        this.dicId = dicId;
        this.sql = sql;
    }

    public String getDicId() {
        return dicId;
    }

    public void setDicId(String dicId) {
        this.dicId = dicId;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

}
