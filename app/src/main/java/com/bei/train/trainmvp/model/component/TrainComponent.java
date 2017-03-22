package com.bei.train.trainmvp.model.component;

import com.bei.train.trainmvp.MainActivity;
import com.bei.train.trainmvp.model.modules.TrainPresenterModule;

import dagger.Component;

/**
 * @author chenshengyu
 *         Created on 2017/3/18.
 */
@Component(modules = {TrainPresenterModule.class})

public interface TrainComponent {
    void inject(MainActivity mainActivity);
}
