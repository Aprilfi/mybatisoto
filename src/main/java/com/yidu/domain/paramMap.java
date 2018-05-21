package com.yidu.domain;

public class paramMap {

    private int rows;

    private int page;

    private float priceStart;

    private float priceEnd;

    private String timeStart;

    private String timeEnd;

    public paramMap() {
    }

    public paramMap(int rows, int page){
        this.rows = rows;
        this.page = page;
    }

    public paramMap(float priceStart, float priceEnd) {
        this.priceStart = priceStart;
        this.priceEnd = priceEnd;
    }

    public paramMap(String timeStart, String timeEnd) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public paramMap(int rows, int page, float priceStart, float priceEnd, String timeStart, String timeEnd) {
        this.rows = rows;
        this.page = page;
        this.priceStart = priceStart;
        this.priceEnd = priceEnd;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public float getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(float priceStart) {
        this.priceStart = priceStart;
    }

    public float getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(float priceEnd) {
        this.priceEnd = priceEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
