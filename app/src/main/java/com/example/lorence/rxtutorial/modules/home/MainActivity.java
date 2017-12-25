package com.example.lorence.rxtutorial.modules.home;

import android.content.Intent;
import android.os.Bundle;

import com.example.lorence.rxtutorial.R;
import com.example.lorence.rxtutorial.base.BaseActivity;
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
    }

    @Override
    protected void resolveDaggerDependency() {
        super.resolveDaggerDependency();

    }
}
