package com.bei.train.trainmvp.model.bean;

/**
 * @author chenshengyu
 *         Created on 2017/3/18.
 */

public class TrainBean {



    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getResultcode() {
        return resultcode;
    }

    public String getReason() {
        return reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public int getError_code() {
        return error_code;
    }

}
