package com.bei.train.trainmvp.model.modules;

import com.bei.train.trainmvp.view.TrainView;

import dagger.Module;
import dagger.Provides;

/**
 * @author chenshengyu
 *         Created on 2017/3/18.
 */
@Module
public class TrainPresenterModule {
    private TrainView trainView;

    public TrainPresenterModule(TrainView trainView) {
        this.trainView = trainView;
    }
    @Provides
    public TrainView provideTrainView(){
        return  trainView;
    }
}
