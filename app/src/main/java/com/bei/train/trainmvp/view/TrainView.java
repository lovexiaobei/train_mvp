package com.bei.train.trainmvp.view;

import com.bei.train.trainmvp.model.bean.TrainBean;

/**
* Created by chenshengyu on 2017/03/18
*/

public interface TrainView {

    void initView();

    void showData(TrainBean trainBean);

    void loadDataFailure();
}