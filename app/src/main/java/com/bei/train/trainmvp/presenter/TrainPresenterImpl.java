package com.bei.train.trainmvp.presenter;


import com.bei.train.trainmvp.model.TrainModel;
import com.bei.train.trainmvp.model.TrainModelImpl;
import com.bei.train.trainmvp.model.bean.TrainBean;
import com.bei.train.trainmvp.view.TrainView;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
* Created by chenshengyu on 2017/03/18
*/

public class TrainPresenterImpl implements TrainPresenter{

    private TrainView view;

    private TrainModel model;

    @Inject @Singleton
    public TrainPresenterImpl(TrainView view) {
        this.view = view;
        model = new TrainModelImpl(this);
    }

    @Override
    public void getData(String name) {
        model.loadData(name);
    }

    @Override
    public void loadDataSuccess(TrainBean trainBean) {
        view.showData(trainBean);
    }

    @Override
    public void loadDataFailure() {
        view.loadDataFailure();
    }
}