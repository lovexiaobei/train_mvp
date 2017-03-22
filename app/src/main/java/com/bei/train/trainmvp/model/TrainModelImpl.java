package com.bei.train.trainmvp.model;


import com.bei.train.trainmvp.model.bean.TrainBean;
import com.bei.train.trainmvp.presenter.TrainPresenter;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
* Created by chenshengyu on 2017/03/18
*/

public class TrainModelImpl implements TrainModel{


    private String trainUrl = "http://apis.juhe.cn/train/";

    private String key = "123029365dd3029223cc62d0a65d2461";

    private TrainPresenter presenter;

    public TrainModelImpl(TrainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadData(String name) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(trainUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        TrainService service = retrofit.create(TrainService.class);
        service.getModelBean(name, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber());
    }
    interface TrainService{
        @GET("s")
        Observable<TrainBean> getModelBean(@Query("name") String name, @Query("key") String key);
    }

    private class MySubscriber extends Subscriber<TrainBean>{

        private TrainBean trainBean;
        /**
         * Notifies the Observer that the {@link Observable} has finished sending push-based notifications.
         * <p>
         * The {@link Observable} will not call this method if it calls {@link #onError}.
         */
        @Override
        public void onCompleted() {

            presenter.loadDataSuccess(trainBean);
        }
        @Override
        public void onError(Throwable e) {
            e.getCause();
        }

        /**
         * Provides the Observer with a new item to observe.
         * <p>
         * The {@link Observable} may call this method 0 or more times.
         * <p>
         * The {@code Observable} will not call this method again after it calls either {@link #onCompleted} or
         * {@link #onError}.
         *
         * @param trainBean the item emitted by the Observable
         */
        @Override
        public void onNext(TrainBean trainBean) {
            this.trainBean = trainBean;
        }
    }
}