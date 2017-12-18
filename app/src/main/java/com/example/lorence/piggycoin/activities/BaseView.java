package com.example.lorence.piggycoin.activities;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.Unbinder;


@SuppressWarnings("ALL")
public abstract class BaseView extends AppCompatActivity {

    protected Context mContext;
    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutResId());
        mUnbinder = ButterKnife.bind(this);
        mContext = getApplicationContext();
        activityCreated();
    }

    public abstract int getLayoutResId();

    public abstract void activityCreated();

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    protected View getRootView() {
        return getWindow().getDecorView().findViewById(android.R.id.content);
    }

    protected Unbinder getBinder() {
        return mUnbinder;
    }
}
