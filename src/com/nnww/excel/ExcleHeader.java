package com.nnww.excel;

//一个ExcleHeader对象表示一个标题行
public class ExcleHeader {

    //字段名称
    private String[] fiedName;

    //需要合并的单元格
    private MergeCell[] mergeCells;

    public ExcleHeader() {
    }

    public ExcleHeader(String[] fiedName, MergeCell[] mergeCells) {
        this.fiedName = fiedName;
        this.mergeCells = mergeCells;
    }

    public String[] getFiedName() {
        return fiedName;
    }

    public void setFiedName(String[] fiedName) {
        this.fiedName = fiedName;
    }

    public MergeCell[] getMergeCells() {
        return mergeCells;
    }

    public void setMergeCells(MergeCell[] mergeCells) {
        this.mergeCells = mergeCells;
    }
}

class MergeCell {
    //: 起始行号
    private int firstRow;

    //: 终止行号
    private int lastRow;

    //: 起始列号
    private int firstCol;

    //: 终止列号
    private int lastCol;

    public MergeCell() {
    }

    public MergeCell(int firstRow, int lastRow, int firstCol, int lastCol) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.firstCol = firstCol;
        this.lastCol = lastCol;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public int getFirstCol() {
        return firstCol;
    }

    public void setFirstCol(int firstCol) {
        this.firstCol = firstCol;
    }

    public int getLastCol() {
        return lastCol;
    }

    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }
}
