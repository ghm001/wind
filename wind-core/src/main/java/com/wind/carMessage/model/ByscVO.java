package com.wind.carMessage.model;

/**
 * Created by Administrator on 2016/8/10.
 */
public class ByscVO {
    private int byscNum;//编号
    private String byxmName;//保养项目名称
    private int byxmState;//保养项目状态

    public ByscVO() {

    }

    public ByscVO(String byxmName, int byxmState) {
        this.byxmName = byxmName;
        this.byxmState = byxmState;
    }

    public int getByscNum() {
        return byscNum;
    }

    public void setByscNum(int byscNum) {
        this.byscNum = byscNum;
    }

    public String getByxmName() {
        return byxmName;
    }

    public void setByxmName(String byxmName) {
        this.byxmName = byxmName;
    }

    public int getByxmState() {
        return byxmState;
    }

    public void setByxmState(int byxmState) {
        this.byxmState = byxmState;
    }

    @Override
    public String toString() {
        return "ByscVO{" +
                "byxmName='" + byxmName + '\'' +
                ", byxmState=" + byxmState +
                '}';
    }
}
