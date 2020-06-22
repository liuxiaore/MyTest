package com.nnww.test;

public enum NcpSqlEnum {
    //------------农产品库---------------------------
    //本月价格最高的8种农产品
    BYJGZGNCP("382", "SELECT\n" +
            "HZ_NJ.NJ_TBLVARIETY.VARIETYNAME NAME,\n" +
            "AVG(HZ_NJ.NJ_TBLDATA.PRICE) PRICE,\n" +
            "TO_CHAR(NJ_TBLDATA.GATHERTIME,'yyyy-mm') DATESTR,\n" +
            "HZ_NJ.NJ_TBLCOUNTY.COUNTYNAME COUNTY\n" +
            "FROM\n" +
            "HZ_NJ.NJ_TBLVARIETY ,\n" +
            "HZ_NJ.NJ_TBLDATA ,\n" +
            "HZ_NJ.NJ_TBLMARKET ,\n" +
            "HZ_NJ.NJ_TBLCOUNTY ,\n" +
            "HZ_NJ.NJ_TBLMARKETCATEGORY ,\n" +
            "HZ_NJ.NJ_TBLSALETYPE\n" +
            "WHERE\n" +
            "HZ_NJ.NJ_TBLVARIETY.VARIETYID = HZ_NJ.NJ_TBLDATA.VARIETYID AND\n" +
            "HZ_NJ.NJ_TBLDATA.MARKETID = HZ_NJ.NJ_TBLMARKET.MARKETID AND\n" +
            "HZ_NJ.NJ_TBLMARKET.COUNTYID = HZ_NJ.NJ_TBLCOUNTY.COUNTYID AND\n" +
            "HZ_NJ.NJ_TBLMARKET.MARKETCATEGORYID = HZ_NJ.NJ_TBLMARKETCATEGORY.MARKETCATEGORYID AND\n" +
            "HZ_NJ.NJ_TBLMARKETCATEGORY.SALETYPE = HZ_NJ.NJ_TBLSALETYPE.SALETYPEID\n" +
            "AND HZ_NJ.NJ_TBLSALETYPE.SALETYPEID = 1\n" +
            "AND TO_CHAR(NJ_TBLDATA.GATHERTIME,'yyyy-mm') = (SELECT MAX(TO_CHAR(GATHERTIME,'yyyy-mm')) FROM NJ_TBLDATA)\n" +
            "AND HZ_NJ.NJ_TBLDATA.VARIETYID IN (71,226,227,205,290,5,4,15)\n" +
            "GROUP BY NJ_TBLVARIETY.VARIETYNAME,HZ_NJ.NJ_TBLCOUNTY.COUNTYNAME,TO_CHAR(NJ_TBLDATA.GATHERTIME,'yyyy-mm')"),

    //农产品价格月变化(前6个月)
    NCPJGYBH("132", "SELECT\n" +
            "HZ_NJ.NJ_TBLVARIETY.VARIETYNAME NAME,\n" +
            "AVG(HZ_NJ.NJ_TBLDATA.PRICE) PRICE,\n" +
            "TO_CHAR(NJ_TBLDATA.GATHERTIME,'yyyy-mm') DATESTR,\n" +
            "HZ_NJ.NJ_TBLCOUNTY.COUNTYNAME COUNTY\n" +
            "FROM\n" +
            "HZ_NJ.NJ_TBLVARIETY ,\n" +
            "HZ_NJ.NJ_TBLDATA ,\n" +
            "HZ_NJ.NJ_TBLMARKET ,\n" +
            "HZ_NJ.NJ_TBLCOUNTY ,\n" +
            "HZ_NJ.NJ_TBLMARKETCATEGORY ,\n" +
            "HZ_NJ.NJ_TBLSALETYPE\n" +
            "WHERE\n" +
            "HZ_NJ.NJ_TBLVARIETY.VARIETYID = HZ_NJ.NJ_TBLDATA.VARIETYID AND\n" +
            "HZ_NJ.NJ_TBLDATA.MARKETID = HZ_NJ.NJ_TBLMARKET.MARKETID AND\n" +
            "HZ_NJ.NJ_TBLMARKET.COUNTYID = HZ_NJ.NJ_TBLCOUNTY.COUNTYID AND\n" +
            "HZ_NJ.NJ_TBLMARKET.MARKETCATEGORYID = HZ_NJ.NJ_TBLMARKETCATEGORY.MARKETCATEGORYID AND\n" +
            "HZ_NJ.NJ_TBLMARKETCATEGORY.SALETYPE = HZ_NJ.NJ_TBLSALETYPE.SALETYPEID\n" +
            "AND HZ_NJ.NJ_TBLSALETYPE.SALETYPEID = 1\n" +
            "AND NJ_TBLDATA.GATHERTIME > (SELECT SYSDATE - interval '5' month FROM dual)\n" +
            "AND HZ_NJ.NJ_TBLDATA.VARIETYID IN (4,5,226,227,310,519,493,195,296,674,205,290,15,71)\n" +
            "GROUP BY NJ_TBLVARIETY.VARIETYNAME,HZ_NJ.NJ_TBLCOUNTY.COUNTYNAME,TO_CHAR(NJ_TBLDATA.GATHERTIME,'yyyy-mm')\n" +
            "ORDER BY TO_CHAR(NJ_TBLDATA.GATHERTIME,'yyyy-mm') DESC"),

    //农产品价格同比数据
    NCPJGTBSJ("361", "SELECT\n" +
            "HZ_NJ.NJ_TBLVARIETY.VARIETYNAME NAME,\n" +
            "AVG(HZ_NJ.NJ_TBLDATA.PRICE) PRICE,\n" +
            "TO_CHAR(NJ_TBLDATA.GATHERTIME,'yyyy-mm') DATESTR,\n" +
            "HZ_NJ.NJ_TBLCOUNTY.COUNTYNAME COUNTY\n" +
            "FROM\n" +
            "HZ_NJ.NJ_TBLVARIETY ,\n" +
            "HZ_NJ.NJ_TBLDATA ,\n" +
            "HZ_NJ.NJ_TBLMARKET ,\n" +
            "HZ_NJ.NJ_TBLCOUNTY ,\n" +
            "HZ_NJ.NJ_TBLMARKETCATEGORY ,\n" +
            "HZ_NJ.NJ_TBLSALETYPE\n" +
            "WHERE\n" +
            "HZ_NJ.NJ_TBLVARIETY.VARIETYID = HZ_NJ.NJ_TBLDATA.VARIETYID AND\n" +
            "HZ_NJ.NJ_TBLDATA.MARKETID = HZ_NJ.NJ_TBLMARKET.MARKETID AND\n" +
            "HZ_NJ.NJ_TBLMARKET.COUNTYID = HZ_NJ.NJ_TBLCOUNTY.COUNTYID AND\n" +
            "HZ_NJ.NJ_TBLMARKET.MARKETCATEGORYID = HZ_NJ.NJ_TBLMARKETCATEGORY.MARKETCATEGORYID AND\n" +
            "HZ_NJ.NJ_TBLMARKETCATEGORY.SALETYPE = HZ_NJ.NJ_TBLSALETYPE.SALETYPEID\n" +
            "AND HZ_NJ.NJ_TBLSALETYPE.SALETYPEID = 1\n" +
            "AND NJ_TBLDATA.GATHERTIME < (SELECT SYSDATE - interval '12' month FROM dual) AND NJ_TBLDATA.GATHERTIME > (SELECT SYSDATE - interval '17' month FROM dual)\n" +
            "AND HZ_NJ.NJ_TBLDATA.VARIETYID IN (519,493,195,226,5,205,15,71,4,227)\n" +
            "GROUP BY NJ_TBLVARIETY.VARIETYNAME,HZ_NJ.NJ_TBLCOUNTY.COUNTYNAME,TO_CHAR(NJ_TBLDATA.GATHERTIME,'yyyy-mm')\n" +
            "ORDER BY TO_CHAR(NJ_TBLDATA.GATHERTIME,'yyyy-mm') DESC");

    //字典id
    private String dicId;

    //SQL
    private String sql;

    NcpSqlEnum(String dicId, String sql) {
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
