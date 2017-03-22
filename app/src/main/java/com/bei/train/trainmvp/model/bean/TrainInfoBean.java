package com.bei.train.trainmvp.model.bean;

/**
 * @author chenshengyu
 *         Created on 2017/3/18.
 */

public  class TrainInfoBean {
    /**
     * name : G656
     * start : 西安北
     * end : 北京西
     * starttime : 10:10
     * endtime : 16:27
     * mileage : 1212km
     */

    private String name;
    private String start;
    private String end;
    private String starttime;
    private String endtime;
    private String mileage;

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getName() {
        return name;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getMileage() {
        return mileage;
    }
}
