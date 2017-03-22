package com.bei.train.trainmvp.presenter;

import com.bei.train.trainmvp.model.bean.TrainBean;

/**
 * @author chenshengyu
 *         Created on 2017/3/18.
 */

public interface TrainPresenter {

    void getData(String name);

    void loadDataSuccess(TrainBean trainBean);

    void loadDataFailure();
}
