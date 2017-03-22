package com.bei.train.trainmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bei.train.trainmvp.model.bean.TrainBean;
import com.bei.train.trainmvp.model.component.DaggerTrainComponent;
import com.bei.train.trainmvp.model.component.TrainComponent;
import com.bei.train.trainmvp.model.modules.TrainPresenterModule;
import com.bei.train.trainmvp.presenter.TrainPresenterImpl;
import com.bei.train.trainmvp.view.TrainView;

import javax.inject.Inject;
import javax.inject.Singleton;

public class MainActivity extends AppCompatActivity implements TrainView{
    private RecyclerView recycler;
    private Toolbar toolbar;
    private SearchView searchView;
    @Inject @Singleton public TrainPresenterImpl presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recycler = (RecyclerView) findViewById(R.id.recycler);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    @Override
    public void initView() {
        TrainComponent component = DaggerTrainComponent.builder()
                .trainPresenterModule(new TrainPresenterModule(this)).build();
        component.inject(this);
    }

    @Override
    public void showData(TrainBean trainBean) {

    }

    @Override
    public void loadDataFailure() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("请输入列车名称 如 G4");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.getData(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
