package com.example.lorence.rxtutorial.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lorence.rxtutorial.R;
import com.example.lorence.rxtutorial.base.BaseActivity;
import com.example.lorence.rxtutorial.di.components.DaggerCakeComponent;
import com.example.lorence.rxtutorial.di.module.CakeModule;
import com.example.lorence.rxtutorial.mvp.presenter.CakePresenter;
import com.example.lorence.rxtutorial.mvp.view.MainView;

import javax.inject.Inject;

/**
 * Created by lorence on 25/12/2017.
 * @version version7
 * @since 12/25/2017
 */

public class MainActivity extends BaseActivity implements MainView {

    @Inject protected CakePresenter mPresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        mPresenter.getCakes();
        Log.i("TAG", "MainActivity -> onViewReady");
    }


    /**
     * We have CakeComponent => CakeComponent
     *
     * Example 1:
     *      CakeComponent DaggerCakeComponent.builder()
     *              .applicationComponent(getApplicationContext())
     *              .cakeModule(new CakeModule(this))
     *              .build();
     *
     * Example 2:
     *      applicationComponent(). We will get from Application(). So implement newthod
     *  to BaseActivity()
     */
    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .cakeModule(new CakeModule(this))
                .build().inject(this);
    }
}
