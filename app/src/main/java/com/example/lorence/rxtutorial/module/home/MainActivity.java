package com.example.lorence.rxtutorial.module.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.lorence.rxtutorial.R;
import com.example.lorence.rxtutorial.R.layout;
import com.example.lorence.rxtutorial.base.BaseActivity;
import com.example.lorence.rxtutorial.di.components.DaggerCakeComponent;
import com.example.lorence.rxtutorial.di.module.CakeModule;
import com.example.lorence.rxtutorial.data.model.Cake;
import com.example.lorence.rxtutorial.mvp.presenter.CakePresenter;
import com.example.lorence.rxtutorial.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 *
 * @link(https://www.youtube.com/watch?v=cW4GfV8emIE)
 */

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.rcvCakes)
    RecyclerView rcvCakes;

    @Inject
    protected CakePresenter mPresenter;

    @Override
    protected int getContentView() {
        return layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        mPresenter.getCakes();
    }

    private void initializeList() {
        rcvCakes.setHasFixedSize(true);
        rcvCakes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvCakes.setAdapter(null); // TODO
    }

    /**
     * We have CakeComponent => CakeComponent
     * <p>
     * Example 1:
     * CakeComponent DaggerCakeComponent.builder()
     * .applicationComponent(getApplicationContext())
     * .cakeModule(new CakeModule(this))
     * .build();
     * <p>
     * Example 2:
     * applicationComponent(). We will get from Application(). So implement newthod
     * to BaseActivity()
     */
    @Override
    protected void resolveDaggerDependency() {
        Log.i("TAG", getString(R.string.MainActivity));
        DaggerCakeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .cakeModule(new CakeModule(this))
                .build().inject(this); // inject(this) => inject CakeModule into MainActivity
    }

    @Override
    public void onCakeLoaded(List<Cake> cakes) {
        Log.i("TAG", "MainActivity: " + cakes.get(0).getDetailDescription());
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }
}
